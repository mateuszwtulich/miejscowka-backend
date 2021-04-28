package com.example.backend.userhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.userhandling.logic.api.to.RoleEto;
import com.example.backend.userhandling.logic.api.to.RoleTo;

import java.util.Optional;

public interface UcManageRole {

  Optional<RoleEto> createRole(RoleTo roleTo) throws EntityAlreadyExistsException, EntityDoesNotExistException;

  Optional<RoleEto> updateRole(RoleTo roleTo, Long id) throws EntityAlreadyExistsException, EntityDoesNotExistException;
}

