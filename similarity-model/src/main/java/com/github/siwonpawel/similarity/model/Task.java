package com.github.siwonpawel.similarity.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {

    private String id;

    private String input;
    private String pattern;

    private LocalDateTime createdAt;
    private TaskStatus taskStatus;

    private TaskResult result;
}
