package com.example.backend.taskhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.taskhandling.logic.api.to.TaskEto;

import java.util.List;
import java.util.Optional;

public interface UcFindTask {

    Optional<TaskEto> findTask(Long id) throws EntityDoesNotExistException;

    Optional<List<TaskEto>> findAllTasks();

    Optional<List<TaskEto>> findAllTasksByUserId(Long userId);

}
