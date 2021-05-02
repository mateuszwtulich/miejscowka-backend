package com.example.backend.taskhandling.dataaccess.api.dao;

import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskDao extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findAllByUser_Id(Long userId);

    Optional<TaskEntity> findByName(String name);
}
