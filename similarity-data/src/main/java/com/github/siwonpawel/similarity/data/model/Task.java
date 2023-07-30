package com.github.siwonpawel.similarity.data.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String input;
    private String pattern;

    @CreationTimestamp
    private OffsetDateTime createdAt;
    @UpdateTimestamp
    private OffsetDateTime modifiedAt;

    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.SCHEDULED;

    private Integer progress;
    private Integer position;
    private Integer matches;
}
