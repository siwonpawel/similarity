package com.github.siwonpawel.similarity.services;

import com.github.siwonpawel.similarity.data.model.Task;
import com.github.siwonpawel.similarity.data.repository.TaskRepository;
import com.github.siwonpawel.similarity.mappers.TaskMapper;
import com.github.siwonpawel.similarity.model.TaskDto;
import com.github.siwonpawel.similarity.model.TaskResult;
import com.github.siwonpawel.similarity.model.TaskStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @Spy
    private TaskMapper mapper = Mappers.getMapper(TaskMapper.class);

    @Captor
    private ArgumentCaptor<Task> taskCaptor;

    @Test
    void shouldMapResultToNulls() {
        // given
        when(taskRepository.save(any(Task.class)))
                .thenReturn(new Task());

        TaskDto task = new TaskDto();

        // when
        TaskDto result = taskService.create(task);

        // then
        assertThat(result)
                .isNotEqualTo(task)
                .returns(null, TaskDto::getResult);
    }

    @Test
    void shouldCorrectlyMapToEntity() {
        // given
        UUID id = UUID.randomUUID();
        String input = "input";
        String pattern = "pattern";
        LocalDateTime modifiedAt = LocalDateTime.now();
        LocalDateTime createdAt = modifiedAt.minus(10, ChronoUnit.MINUTES);
        TaskStatus status = TaskStatus.IN_PROGRESS;
        int progress = 99;
        int matches = 10;
        int position = 1;

        TaskResult taskResult = new TaskResult();
        taskResult.setMatches(matches);
        taskResult.setPosition(position);

        TaskDto task = new TaskDto();
        task.setId(id.toString());
        task.setInput(input);
        task.setPattern(pattern);
        task.setCreatedAt(createdAt);
        task.setModifiedAt(modifiedAt);
        task.setStatus(status);
        task.setProgress(progress);
        task.setResult(taskResult);

        // when
        taskService.create(task);

        // then
        verify(taskRepository).save(taskCaptor.capture());

        assertThat(taskCaptor.getValue())
                .returns(id, Task::getId)
                .returns(input, Task::getInput)
                .returns(pattern, Task::getPattern)
                .returns(createdAt, Task::getCreatedAt)
                .returns(modifiedAt, Task::getModifiedAt)
                .returns(com.github.siwonpawel.similarity.data.model.TaskStatus.IN_PROGRESS, Task::getStatus)
                .returns(progress, Task::getProgress)
                .returns(position, Task::getPosition)
                .returns(matches, Task::getMatches);
    }

    @Test
    void shouldCorrectlyMapFromEntity() {
        // given
        UUID id = UUID.randomUUID();
        String input = "input";
        String pattern = "pattern";
        LocalDateTime modifiedAt = LocalDateTime.now();
        LocalDateTime createdAt = modifiedAt.minus(10, ChronoUnit.MINUTES);
        com.github.siwonpawel.similarity.data.model.TaskStatus status = com.github.siwonpawel.similarity.data.model.TaskStatus.IN_PROGRESS;
        int progress = 99;
        int matches = 10;
        int position = 1;

        Task task = new Task();
        task.setId(id);
        task.setInput(input);
        task.setPattern(pattern);
        task.setModifiedAt(modifiedAt);
        task.setCreatedAt(createdAt);
        task.setStatus(status);
        task.setProgress(progress);
        task.setMatches(matches);
        task.setPosition(position);

        when(taskRepository.save(any()))
                .thenReturn(task);

        // when
        TaskDto result = taskService.create(new TaskDto());

        // then
        assertThat(result)
                .returns(id.toString(), TaskDto::getId)
                .returns(input, TaskDto::getInput)
                .returns(pattern, TaskDto::getPattern)
                .returns(createdAt, TaskDto::getCreatedAt)
                .returns(modifiedAt, TaskDto::getModifiedAt)
                .returns(com.github.siwonpawel.similarity.model.TaskStatus.IN_PROGRESS, TaskDto::getStatus)
                .returns(progress, TaskDto::getProgress)
                .returns(position, t -> t.getResult().getPosition())
                .returns(matches, t -> t.getResult().getMatches());
    }

}