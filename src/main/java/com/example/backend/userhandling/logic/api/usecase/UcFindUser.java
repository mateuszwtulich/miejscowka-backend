package com.example.backend.userhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.userhandling.logic.api.to.UserEto;

import java.util.List;
import java.util.Optional;

public interface UcFindUser {

  Optional<UserEto> findUser(Long id) throws EntityDoesNotExistException;

  Optional<List<UserEto>> findAllUsers();

  Optional<List<UserEto>> findAllUsersByRoleId(Long roleId);
}
