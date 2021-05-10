package com.example.backend.taskhandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.taskhandling.dataaccess.api.dao.TaskDao;
import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import com.example.backend.taskhandling.logic.api.mapper.TaskMapper;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.usecase.UcFindTask;
import com.example.backend.userhandling.dataaccess.api.entity.UserEntity;
import com.example.backend.userhandling.logic.api.mapper.AccountMapper;
import com.example.backend.userhandling.logic.api.mapper.PermissionsMapper;
import com.example.backend.userhandling.logic.api.mapper.RoleMapper;
import com.example.backend.userhandling.logic.api.mapper.UserMapper;
import com.example.backend.userhandling.logic.api.to.RoleEto;
import com.example.backend.userhandling.logic.api.to.SimpleUserTo;
import com.example.backend.userhandling.logic.api.to.UserEto;
import com.example.backend.userhandling.logic.api.to.UserTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Validated
@Named
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

    @Inject
    private UserMapper userMapper;

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private RoleMapper roleMapper;

    @Inject
    private PermissionsMapper permissionsMapper;

    @Override
    public Optional<TaskEto> findTask(Long id) throws EntityDoesNotExistException {
        Objects.requireNonNull(id, ID_CANNOT_BE_NULL);

        LOG.debug(GET_TASK_LOG, id);
        Optional<TaskEntity> taskEntity = taskDao.findById(id);

        if(!taskEntity.isPresent()){
            throw new EntityDoesNotExistException("Task with id " + id + " does not exist.");
        }

        return Optional.of(toTaskEto(taskEntity.get()));
    }

    @Override
    public Optional<List<TaskEto>> findAllTasks() {
        LOG.debug(GET_ALL_TASKS_LOG);
        return Optional.of(taskDao.findAll().stream()
        .map(taskEntity -> toTaskEto(taskEntity))
        .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<TaskEto>> findAllTasksByUserId(Long userId) {
        Objects.requireNonNull(userId, ID_CANNOT_BE_NULL);
        LOG.debug(GET_TASKS_USER_LOG, userId);

        return Optional.of(taskDao.findAllByUser_Id(userId).stream()
        .map(taskEntity -> toTaskEto(taskEntity)).collect(Collectors.toList()));
    }


    private TaskEto toTaskEto(TaskEntity taskEntity){
        TaskEto taskEto = taskMapper.toTaskEto(taskEntity);
        taskEto.setUserTo(toUserTo(taskEntity.getUser()));
        return taskEto;
    }

    private SimpleUserTo toUserTo(UserEntity userEntity) {
        SimpleUserTo userTo = new SimpleUserTo();
        userTo.setName(userEntity.getName());
        userTo.setSurname(userEntity.getSurname());
        userTo.setAccountId(userEntity.getAccount().getId());
        userTo.setRoleId(userEntity.getAccount().getId());
        return userTo;
    }
}
