package com.example.backend.taskhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.to.TaskTo;

import java.util.Optional;

public interface UcManageTask {

    Optional<TaskEto> createTask(TaskTo taskTo) throws EntityAlreadyExistsException, EntityDoesNotExistException;
    Optional<TaskEto> updateTask(TaskTo taskTo, Long taskId) throws EntityDoesNotExistException;
}
