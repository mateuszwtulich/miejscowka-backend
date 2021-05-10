package com.example.backend.taskhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;

public interface UcDeleteTask {

    void deleteTask(Long taskId) throws EntityDoesNotExistException;
}
