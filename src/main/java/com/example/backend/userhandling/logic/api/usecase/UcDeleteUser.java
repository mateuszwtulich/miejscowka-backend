package com.example.backend.userhandling.logic.api.usecase;

import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;

public interface UcDeleteUser {

  void deleteUserAndAllRelatedEntities(Long userId) throws EntityDoesNotExistException;
}
