package com.example.backend.general.logic.api.exception;

public class EntityDoesNotExistException extends Exception{
  public EntityDoesNotExistException(String message) {
    super(message);
  }
}
