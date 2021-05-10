package com.example.backend.taskhandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.taskhandling.dataaccess.api.dao.TaskDao;
import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import com.example.backend.taskhandling.logic.api.usecase.UcDeleteTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;

@Validated
@Named
public class UcDeleteTaskImpl implements UcDeleteTask {
    private static final Logger LOG = LoggerFactory.getLogger(UcDeleteTaskImpl.class);
    private static final String DELETE_TASK_LOG = "Delete Task with id {} in database.";

    @Inject
    private TaskDao taskDao;


    @Override
    public void deleteTask(Long taskId) throws EntityDoesNotExistException {
        TaskEntity taskEntity = taskDao.findById(taskId).orElseThrow(() ->
                new EntityDoesNotExistException("Task with id " + taskId + " does not exist."));

        LOG.debug(DELETE_TASK_LOG, taskEntity.getId());
        taskDao.deleteById(taskEntity.getId());
    }
}
