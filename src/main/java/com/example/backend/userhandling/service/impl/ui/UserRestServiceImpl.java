package com.example.backend.userhandling.service.impl.ui;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.general.security.enums.ApplicationPermissions;
import com.example.backend.general.utils.annotations.PermissionRestrict;
import com.example.backend.userhandling.logic.api.exception.AccountAlreadyExistsException;
import com.example.backend.userhandling.logic.api.exception.RoleHasAssignedUsersException;
import com.example.backend.userhandling.logic.api.to.AccountEto;
import com.example.backend.userhandling.logic.api.to.AccountTo;
import com.example.backend.userhandling.logic.api.to.PermissionEto;
import com.example.backend.userhandling.logic.api.to.RoleEto;
import com.example.backend.userhandling.logic.api.to.RoleTo;
import com.example.backend.userhandling.logic.api.to.SignUpUserTo;
import com.example.backend.userhandling.logic.api.to.UserEto;
import com.example.backend.userhandling.logic.api.to.UserTo;
import com.example.backend.userhandling.logic.impl.UserHandlingImpl;
import com.example.backend.userhandling.service.api.ui.UserRestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class UserRestServiceImpl implements UserRestService {
  private static String USERS_NOT_EXIST = "Users do not exist.";
  private static String ACCOUNTS_NOT_EXIST = "Accounts do not exist.";
  private static String ROLES_NOT_EXIST = "Roles do not exist.";
  private static final String BASE_URL = "user/v1/";

  @Inject
  private UserHandlingImpl userHandling;

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.GET_USERS})
  public ResponseEntity<UserEto> getUser(Long id) {
    try {
      return ResponseEntity
          .ok()
          .body(userHandling.findUser(id).orElseThrow(() ->
              new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.GET_USERS})
  public List<UserEto> getAllUsers() {
    return userHandling.findAllUsers().map( userEtos -> {
      if(userEtos.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, USERS_NOT_EXIST);
      }
      return userEtos;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.GET_USERS})
  public List<AccountEto> getAllAccounts() {
    return userHandling.findAllAccounts().map( accountEtos -> {
      if(accountEtos.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, ACCOUNTS_NOT_EXIST);
      }
      return accountEtos;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.GET_USERS})
  public List<UserEto> getAllUsersByRoleId(Long roleId) {
    return userHandling.findAllUsersByRoleId(roleId).map( userEtos -> {
      if(userEtos.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Users with role id " + roleId + " do not exist.");
      }
      return userEtos;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.ADD_USER})
  public ResponseEntity<UserEto> createUser(UserTo userTo, HttpServletRequest request, Errors errors) {
    try {
      return ResponseEntity
          .created(new URI(BASE_URL + "user"))
          .body(userHandling.createUserAndAccountEntities(userTo, request, errors).orElseThrow(() ->
              new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
    } catch (AccountAlreadyExistsException | AddressException | URISyntaxException e) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  public ResponseEntity<UserEto> signUpUser(SignUpUserTo userTo, HttpServletRequest request, Errors errors) {
    try {
      return ResponseEntity
          .created(new URI(BASE_URL + "user/singup"))
          .body(userHandling.createUserAndAccountEntitiesViaSignUp(userTo, request, errors).orElseThrow(() ->
              new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
    } catch (AccountAlreadyExistsException | AddressException | URISyntaxException e) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.ADD_USER})
  public RedirectView confirmRegistration(String token) {
    try {
      return userHandling.confirmRegistration(token).orElseThrow(() ->
          new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.EDIT_USER})
  public ResponseEntity<UserEto> updateUser(Long id, UserTo userTo) {
    try {
      return ResponseEntity
          .ok()
          .body(userHandling.updateUser(userTo, id).orElseThrow(() ->
              new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.EDIT_USER})
  public ResponseEntity<AccountEto> updateUserAccount(Long userId, AccountTo accountTo) {
    try {
      return ResponseEntity
          .ok()
          .body(userHandling.updateUserAccount(accountTo, userId).orElseThrow(() ->
              new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
    } catch (AccountAlreadyExistsException | AddressException e) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.EDIT_USER})
  public ResponseEntity<?> updateAccountPassword(AccountTo accountTo) {
    try {
      userHandling.updatePassword(accountTo);
      return ResponseEntity.ok().build();
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.DELETE_USER})
  public ResponseEntity<?> deleteUser(Long id) {
    try {
      userHandling.deleteUserAndAllRelatedEntities(id);
      return ResponseEntity.ok().build();
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.GET_ROLES})
  public ResponseEntity<RoleEto> getRole(Long id) {
    try {
      return ResponseEntity
          .ok()
          .body(userHandling.findRole(id).orElseThrow(() ->
              new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.GET_ROLES})
  public List<RoleEto> getAllRoles() {
    return userHandling.findAllRoles().map(roleEtos -> {
      if (roleEtos.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, ROLES_NOT_EXIST);
      }
      return roleEtos;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.GET_ROLES})
  public List<PermissionEto> getAllPermissions() {
    return userHandling.findAllPermissions().map(permissionEtos -> {
      if (permissionEtos.isEmpty()) {
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, ROLES_NOT_EXIST);
      }
      return permissionEtos;
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));    }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.ADD_ROLE})
  public ResponseEntity<RoleEto> createRole(RoleTo roleTo) {
    try {
      return ResponseEntity
          .created(new URI(BASE_URL + "/role"))
          .body(userHandling.createRole(roleTo).orElseThrow(() ->
              new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
    } catch (EntityAlreadyExistsException | URISyntaxException e) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.EDIT_ROLE})
  public ResponseEntity<RoleEto> updateRole(Long id, RoleTo roleTo) {
    try {
      return ResponseEntity
          .ok()
          .body(userHandling.updateRole(roleTo, id).orElseThrow(() ->
              new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)));
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (EntityAlreadyExistsException e) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }
  }

  @Override
  @PermissionRestrict(permissions = {ApplicationPermissions.DELETE_ROLE})
  public ResponseEntity<?> deleteRole(Long id) {
    try {
      userHandling.deleteRole(id);
      return ResponseEntity.ok().build();
    } catch (EntityDoesNotExistException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    } catch (RoleHasAssignedUsersException e) {
      throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
    }
  }
}