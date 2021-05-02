package com.example.backend.taskhandling.logic.impl;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.taskhandling.logic.api.TaskHandling;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.usecase.UcDeleteTask;
import com.example.backend.taskhandling.logic.api.usecase.UcFindTask;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class TaskHandlingImpl implements TaskHandling {

    @Inject
    private UcFindTask ucFindTask;

    @Inject
    private UcDeleteTask ucDeleteTask;


    @Override
    public void deleteTask(Long taskId) throws EntityDoesNotExistException {
        ucDeleteTask.deleteTask(taskId);
    }

    @Override
    public Optional<TaskEto> findTask(Long id) throws EntityDoesNotExistException {
        return ucFindTask.findTask(id);
    }

    @Override
    public Optional<List<TaskEto>> findAllTasks() {
        return ucFindTask.findAllTasks();
    }

    @Override
    public Optional<List<TaskEto>> findAllTasksByUserId(Long userId) {
        return ucFindTask.findAllTasksByUserId(userId);
    }
}
