package com.rocketseat.service.tasks.Repositories;

import com.rocketseat.service.tasks.Enums.NotifiedEnum;
import com.rocketseat.service.tasks.entities.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TasksEntity, Long> {
    @Query(value = "SELECT * FROM task t WHERE due_date <= :now AND notified_enum <> :notifiedEnum", nativeQuery = true)
    List<TasksEntity> findDueDate(LocalDateTime now, NotifiedEnum notifiedEnum);
}
