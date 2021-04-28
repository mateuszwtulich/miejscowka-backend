package com.example.backend.userhandling.logic.impl.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.userhandling.dataaccess.api.dao.RoleDao;
import com.example.backend.userhandling.dataaccess.api.dao.UserDao;
import com.example.backend.userhandling.dataaccess.api.entity.RoleEntity;
import com.example.backend.userhandling.logic.api.exception.RoleHasAssignedUsersException;
import com.example.backend.userhandling.logic.api.usecase.UcDeleteRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import javax.inject.Inject;
import javax.inject.Named;

@Validated
@Named
public class UcDeleteRoleImpl implements UcDeleteRole {

  private static final Logger LOG = LoggerFactory.getLogger(UcDeleteRoleImpl.class);
  private static final String DELETE_ROLE_LOG = "Delete Role with id {} in database.";

  @Inject
  private RoleDao roleDao;

  @Inject
  private UserDao userDao;

  @Override
  public void deleteRole(Long id) throws EntityDoesNotExistException, RoleHasAssignedUsersException {
    RoleEntity roleEntity = roleDao.findById(id).orElseThrow(() ->
        new EntityDoesNotExistException("Role with id " + id + " does not exist."));

    if(userDao.findAllByRole_Id(id).isEmpty()){
      LOG.debug(DELETE_ROLE_LOG, roleEntity.getId());

      roleDao.deleteById(roleEntity.getId());
    } else {
      throw new RoleHasAssignedUsersException("Role with id " + id + " has assigned users.");
    }
  }
}
