package com.github.siwonpawel.similarity.data.repository;

import com.github.siwonpawel.similarity.data.model.Task;
import com.github.siwonpawel.similarity.data.model.TaskStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

@Testcontainers
@SpringBootTest(classes = TaskRepository.class)
@EnableAutoConfiguration
@EntityScan(basePackageClasses = Task.class)
class TaskRepositoryTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void shouldFillIdOnSave() {
        // given
        Task task = new Task();


        // when
        Task result = taskRepository.save(task);

        // then
        assertThat(result.getId()).isNotNull();
    }

    @Test
    void shouldFillCreatedAtOnSave() {
        // given
        Task task = new Task();


        // when
        Task result = taskRepository.save(task);

        // then
        assertThat(result.getCreatedAt())
                .isCloseTo(OffsetDateTime.now(), within(500, ChronoUnit.MILLIS));
    }

    @Test
    void shouldFillModifiedAtOnSave() {
        // given
        Task task = new Task();


        // when
        Task result = taskRepository.save(task);

        // then
        assertThat(result.getModifiedAt())
                .isCloseTo(OffsetDateTime.now(), within(500, ChronoUnit.MILLIS));
    }

    @Test
    void shouldUpdateLastModifiedAtOnSave() {
        // given
        Task task = new Task();
        Task saved = taskRepository.save(task);

        // when
        saved.setPattern("test");
        Task result = taskRepository.save(saved);

        // then
        assertThat(result.getModifiedAt())
                .isNotEqualTo(saved.getModifiedAt());
    }

    @Test
    void shouldPersistTask() {
        // given
        String input = "input";
        String pattern = "pattern";

        Task task = new Task();
        task.setInput(input);
        task.setPattern(pattern);

        // when
        Task result = taskRepository.save(task);

        // then
        assertThat(result)
                .doesNotReturn(null, Task::getId)
                .doesNotReturn(null, Task::getCreatedAt)
                .doesNotReturn(null, Task::getModifiedAt)
                .returns(TaskStatus.SCHEDULED, Task::getStatus)
                .returns(input, Task::getInput)
                .returns(pattern, Task::getPattern)
                .returns(null, Task::getPosition)
                .returns(null, Task::getMatches)
                .returns(null, Task::getProgress);
    }
}