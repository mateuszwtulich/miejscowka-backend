package com.example.backend.taskhandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.taskhandling.dataaccess.api.dao.TaskDao;
import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import com.example.backend.taskhandling.logic.api.mapper.TaskMapper;
import com.example.backend.taskhandling.logic.api.to.TaskEto;
import com.example.backend.taskhandling.logic.api.to.TaskTo;
import com.example.backend.taskhandling.logic.api.usecase.UcManageTask;
import com.example.backend.userhandling.dataaccess.api.dao.AccountDao;
import com.example.backend.userhandling.dataaccess.api.dao.RoleDao;
import com.example.backend.userhandling.dataaccess.api.dao.UserDao;
import com.example.backend.userhandling.dataaccess.api.entity.UserEntity;
import com.example.backend.userhandling.logic.api.mapper.AccountMapper;
import com.example.backend.userhandling.logic.api.mapper.PermissionsMapper;
import com.example.backend.userhandling.logic.api.mapper.RoleMapper;
import com.example.backend.userhandling.logic.api.mapper.UserMapper;
import com.example.backend.userhandling.logic.api.to.RoleEto;
import com.example.backend.userhandling.logic.api.to.SimpleUserTo;
import com.example.backend.userhandling.logic.api.to.UserEto;
import com.example.backend.userhandling.logic.impl.usecase.UcManageUserImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Validated
@Named
public class UcManageTaskImpl implements UcManageTask {

    private static final Logger LOG = LoggerFactory.getLogger(UcManageTaskImpl.class);
    private static final String ID_CANNOT_BE_NULL = "id cannot be a null value";
    private static final String CREATE_TASK_LOG = "Create Task with name {} in database.";
    private static final String UPDATE_TASK_LOG = "Update Task with id {} in database.";


    @Inject
    private TaskDao taskDao;

    @Inject
    private TaskMapper taskMapper;

    @Inject
    private UserDao userDao;

    @Inject
    private UserMapper userMapper;

    @Inject
    private AccountMapper accountMapper;

    @Inject
    private RoleMapper roleMapper;

    @Inject
    private PermissionsMapper permissionsMapper;

    @Override
    public Optional<TaskEto> createTask(TaskTo taskTo) throws EntityAlreadyExistsException, EntityDoesNotExistException {
        LOG.debug(CREATE_TASK_LOG, taskTo.getName());
        TaskEntity taskEntity = taskMapper.toTaskEntity(taskTo);
        taskEntity.setUser(getUserById(taskTo.getUserId()));

        TaskEntity taskSaved = taskDao.save(taskEntity);

        return toTaskEto(taskSaved);
    }

    @Override
    public Optional<TaskEto> updateTask(TaskTo taskTo, Long taskId) throws EntityDoesNotExistException {
        LOG.debug(UPDATE_TASK_LOG, taskId);

        TaskEntity taskEntity = getTaskById(taskId);
        taskEntity.setName(taskTo.getName());
        taskEntity.setUser(getUserById(taskTo.getUserId()));
        taskEntity.setFinalDate(LocalDate.parse(taskTo.getFinalDate()));

        return toTaskEto(taskEntity);
    }

    private UserEntity getUserById(Long userId) throws EntityDoesNotExistException{
        Objects.requireNonNull(userId, ID_CANNOT_BE_NULL);

        return userDao.findById(userId).orElseThrow(() ->
                new EntityDoesNotExistException("User with id " + userId + " does not exist."));
    }

    private TaskEntity getTaskById(Long taskId) throws EntityDoesNotExistException{
        Objects.requireNonNull(taskId, ID_CANNOT_BE_NULL);

        return taskDao.findById(taskId).orElseThrow(() ->
                new EntityDoesNotExistException("Task with it " + taskId + " does not exists"));
    }

    private Optional<TaskEto> toTaskEto(TaskEntity taskEntity){
        TaskEto taskEto = taskMapper.toTaskEto(taskEntity);
        taskEto.setUserTo(toUserTo(taskEntity.getUser()));
        return Optional.of(taskEto);
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
