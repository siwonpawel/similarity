package com.github.siwonpawel.similarity.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class TaskDto {

    private String id;

    private String input;
    private String pattern;

    private OffsetDateTime createdAt;
    private OffsetDateTime modifiedAt;
    private TaskStatus status;
    private Integer progress;

    private TaskResult result;
}
