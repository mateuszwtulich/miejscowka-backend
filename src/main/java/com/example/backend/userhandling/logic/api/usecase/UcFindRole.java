package com.example.backend.userhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.userhandling.logic.api.to.PermissionEto;
import com.example.backend.userhandling.logic.api.to.RoleEto;

import java.util.List;
import java.util.Optional;

public interface UcFindRole {

  Optional<RoleEto> findRole(Long id) throws EntityDoesNotExistException;

  Optional<List<RoleEto>> findAllRoles();

  Optional<List<PermissionEto>> findAllPermissions();
}
