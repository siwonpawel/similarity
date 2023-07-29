package com.github.siwonpawel.similarity.services;

import com.github.siwonpawel.similarity.data.repository.TaskRepository;
import com.github.siwonpawel.similarity.mappers.TaskMapper;
import com.github.siwonpawel.similarity.model.TaskDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private final TaskMapper mapper;

    @Autowired
    private final TaskRepository taskRepository;

    public TaskDto create(TaskDto task) {
        return mapper.mapToModel(taskRepository.save(mapper.mapToEntity(task)));
    }

}
