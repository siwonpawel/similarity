package com.github.siwonpawel.similarity.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {

    private String id;

    private String input;
    private String pattern;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private TaskStatus status;
    private Integer progress;

    private TaskResult result;
}
