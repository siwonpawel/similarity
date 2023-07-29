package com.github.siwonpawel.similarity.data.repository;

import com.github.siwonpawel.similarity.data.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends LimitedRepository<Task, String> {

}
