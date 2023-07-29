package com.github.siwonpawel.similarity.data.repository;

import com.github.siwonpawel.similarity.data.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TaskRepository extends JpaRepository<Task, Long> {

}
