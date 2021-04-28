package com.example.backend.userhandling.logic.api.exception;

public class RoleHasAssignedUsersException extends Exception{
  public RoleHasAssignedUsersException(String message) {
    super(message);
  }
}