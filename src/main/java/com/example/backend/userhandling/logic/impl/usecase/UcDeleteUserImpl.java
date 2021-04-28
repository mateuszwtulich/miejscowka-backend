package com.example.backend.userhandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.userhandling.dataaccess.api.dao.UserDao;
import com.example.backend.userhandling.dataaccess.api.entity.UserEntity;
import com.example.backend.userhandling.logic.api.usecase.UcDeleteUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;

@Validated
@Named
public class UcDeleteUserImpl implements UcDeleteUser {

  private static final Logger LOG = LoggerFactory.getLogger(UcDeleteUserImpl.class);
  private static final String DELETE_USER_LOG = "Delete User with id {} in database.";
  private static final String DELETE_ACCOUNT_LOG = "Delete Account with id {} in database.";

  @Inject
  private UserDao userDao;

  @Override
  public void deleteUserAndAllRelatedEntities(Long userId) throws EntityDoesNotExistException {
    UserEntity userEntity = userDao.findById(userId).orElseThrow(() ->
        new EntityDoesNotExistException("User with id " + userId + " does not exist."));

    LOG.debug(DELETE_USER_LOG, userId);
    LOG.debug(DELETE_ACCOUNT_LOG, userEntity.getAccount().getId());

    userDao.deleteById(userId);
  }
}