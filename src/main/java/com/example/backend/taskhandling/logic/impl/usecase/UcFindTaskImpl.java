package com.example.backend.taskhandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.taskhandling.dataaccess.api.dao.TaskDao;
import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import com.example.backend.taskhandling.logic.api.mapper.TaskMapper;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.usecase.UcFindTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class UcFindTaskImpl implements UcFindTask {

    private static final Logger LOG = LoggerFactory.getLogger(UcFindTaskImpl.class);
    private static final String ID_CANNOT_BE_NULL = "Id cannot be a null value";
    private static final String GET_TASK_LOG = "Get Task with id {} from database.";
    private static final String GET_ALL_TASKS_LOG = "Get all Tasks from database.";
    private static final String GET_TASKS_USER_LOG = "Get Tasks with User id {} from database.";

    @Inject
    private TaskDao taskDao;

    @Inject
    private TaskMapper taskMapper;

    @Override
    public Optional<TaskEto> findTask(Long id) throws EntityDoesNotExistException {
        Objects.requireNonNull(id, ID_CANNOT_BE_NULL);

        LOG.debug(GET_TASK_LOG, id);
        Optional<TaskEntity> taskEntity = taskDao.findById(id);

        if(!taskEntity.isPresent()){
            throw new EntityDoesNotExistException("Task with id " + id + " does not exist.");
        }

        return Optional.of(taskMapper.toTaskEto(taskEntity.get()));
    }

    @Override
    public Optional<List<TaskEto>> findAllTasks() {
        LOG.debug(GET_ALL_TASKS_LOG);
        return Optional.of(taskDao.findAll().stream()
        .map(taskEntity -> taskMapper.toTaskEto(taskEntity))
        .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskEto>> findAllTasksByUserId(Long userId) {
        Objects.requireNonNull(userId, ID_CANNOT_BE_NULL);
        LOG.debug(GET_TASKS_USER_LOG, userId);

        return Optional.of(taskDao.findAllByUser_Id(userId).stream()
        .map(taskEntity -> taskMapper.toTaskEto(taskEntity)).collect(Collectors.toList()));
    }


}
