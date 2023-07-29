package com.github.siwonpawel.similarity.data;

import com.github.siwonpawel.similarity.data.model.Task;
import com.github.siwonpawel.similarity.data.repository.TaskRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = Task.class)
@EnableJpaRepositories(basePackageClasses = TaskRepository.class)
public class DataConfiguration {
}
