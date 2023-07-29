package com.github.siwonpawel.similarity.api.controller;

import com.github.siwonpawel.similarity.model.TaskDto;
import com.github.siwonpawel.similarity.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public Object getAllTasks() {
        taskService.create(new TaskDto());

        return taskService.findAll();
    }

}
