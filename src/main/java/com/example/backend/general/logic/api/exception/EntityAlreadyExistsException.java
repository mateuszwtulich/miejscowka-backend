package com.example.backend.general.logic.api.exception;

public class EntityAlreadyExistsException extends Exception{
  public EntityAlreadyExistsException(String message) {
    super(message);
  }
}