package com.example.backend.userhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.userhandling.logic.api.exception.RoleHasAssignedUsersException;

public interface UcDeleteRole {

  void deleteRole(Long id) throws EntityDoesNotExistException, RoleHasAssignedUsersException;
}
