package com.github.siwonpawel.similarity.api.controller;

import com.github.siwonpawel.similarity.api.mappers.TaskApiMapper;
import com.github.siwonpawel.similarity.api.v1.TasksApi;
import com.github.siwonpawel.similarity.api.v1.model.NewTask;
import com.github.siwonpawel.similarity.api.v1.model.Task;
import com.github.siwonpawel.similarity.api.v1.model.TaskCreated;
import com.github.siwonpawel.similarity.api.v1.model.TaskPage;
import com.github.siwonpawel.similarity.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TaskController implements TasksApi {

    private final TaskService taskService;
    private final TaskApiMapper mapper;

    @Override
    public ResponseEntity<TaskPage> v1TasksGet(Integer page, Integer pageSize) {
        return null;
    }

    @Override
    public ResponseEntity<TaskCreated> v1TasksPost(NewTask newTask) {
        return ResponseEntity.ok(mapper.mapToCreated(taskService.create(mapper.mapToModel(newTask))));
    }

    @Override
    public ResponseEntity<Task> v1TasksTaskIdGet(String taskId) {
        return null;
    }
}
