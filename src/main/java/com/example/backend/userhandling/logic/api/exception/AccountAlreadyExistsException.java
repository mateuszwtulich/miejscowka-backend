package com.example.backend.userhandling.logic.api.exception;

public class AccountAlreadyExistsException extends Exception{
  public AccountAlreadyExistsException(String message) {
    super(message);
  }
}
