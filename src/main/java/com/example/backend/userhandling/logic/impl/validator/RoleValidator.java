package com.example.backend.userhandling.logic.impl.validator;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.userhandling.dataaccess.api.dao.PermissionDao;
import com.example.backend.userhandling.dataaccess.api.dao.RoleDao;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class RoleValidator {

  @Inject
  private RoleDao roleDao;

  @Inject
  private PermissionDao permissionDao;

  public void verifyIfRoleNameAlreadyExists(String name) throws EntityAlreadyExistsException {
    if (roleDao.existsByName(name)) {
      throw new EntityAlreadyExistsException("Role with name " + name + " already exists");
    }
  }
}