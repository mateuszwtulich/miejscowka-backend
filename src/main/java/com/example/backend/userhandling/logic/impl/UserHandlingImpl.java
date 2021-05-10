package com.example.backend.userhandling.logic.impl;

import com.example.backend.general.logic.api.exception.EntityAlreadyExistsException;
import com.example.backend.general.logic.api.exception.EntityDoesNotExistException;
import com.example.backend.userhandling.logic.api.UserHandling;
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
import com.example.backend.userhandling.logic.api.usecase.UcDeleteRole;
import com.example.backend.userhandling.logic.api.usecase.UcDeleteUser;
import com.example.backend.userhandling.logic.api.usecase.UcFindAccount;
import com.example.backend.userhandling.logic.api.usecase.UcFindRole;
import com.example.backend.userhandling.logic.api.usecase.UcFindUser;
import com.example.backend.userhandling.logic.api.usecase.UcManageRegistration;
import com.example.backend.userhandling.logic.api.usecase.UcManageRole;
import com.example.backend.userhandling.logic.api.usecase.UcManageUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserHandlingImpl implements UserHandling {
  private static final Logger LOG = LoggerFactory.getLogger(UserHandlingImpl.class);
  //For pagination of users

  @Inject
  private UcDeleteRole ucDeleteRole;

  @Inject
  private UcDeleteUser ucDeleteUser;

  @Inject
  private UcFindAccount ucFindAccount;

  @Inject
  private UcFindRole ucFindRole;

  @Inject
  private UcFindUser ucFindUser;

  @Inject
  private UcManageRegistration ucManageRegistration;

  @Inject
  private UcManageRole ucManageRole;

  @Inject
  private UcManageUser ucManageUser;

  @Override
  public void deleteRole(Long id) throws EntityDoesNotExistException, RoleHasAssignedUsersException {
    ucDeleteRole.deleteRole(id);
  }

  @Override
  public void deleteUserAndAllRelatedEntities(Long userId) throws EntityDoesNotExistException {
    ucDeleteUser.deleteUserAndAllRelatedEntities(userId);
  }

  @Override
  public Optional<List<AccountEto>> findAllAccounts() {
    return ucFindAccount.findAllAccounts();
  }

  @Override
  public Optional<RoleEto> findRole(Long id) throws EntityDoesNotExistException {
    return ucFindRole.findRole(id);
  }

  @Override
  public Optional<List<RoleEto>> findAllRoles() {
    return ucFindRole.findAllRoles();
  }

  @Override
  public Optional<List<PermissionEto>> findAllPermissions() {
    return ucFindRole.findAllPermissions();
  }

  @Override
  public Optional<UserEto> findUser(Long id) throws EntityDoesNotExistException {
    return ucFindUser.findUser(id);
  }

  @Override
  public Optional<List<UserEto>> findAllUsers() {
    return ucFindUser.findAllUsers();
  }

  @Override
  public Optional<List<UserEto>> findAllUsersByRoleId(Long roleId) {
    return ucFindUser.findAllUsersByRoleId(roleId);
  }

  @Override
  public Optional<RoleEto> createRole(RoleTo roleTo) throws EntityAlreadyExistsException, EntityDoesNotExistException {
    return ucManageRole.createRole(roleTo);
  }

  @Override
  public Optional<RoleEto> updateRole(RoleTo roleTo, Long id) throws EntityAlreadyExistsException, EntityDoesNotExistException {
    return ucManageRole.updateRole(roleTo, id);
  }

  @Override
  public Optional<UserEto> createUserAndAccountEntities(UserTo userTo, HttpServletRequest request, Errors errors)
      throws AccountAlreadyExistsException, AddressException, EntityDoesNotExistException {
    return ucManageUser.createUserAndAccountEntities(userTo, request, errors);
  }

  @Override
  public Optional<UserEto> createUserAndAccountEntitiesViaSignUp(SignUpUserTo userTo, HttpServletRequest request, Errors errors) throws AccountAlreadyExistsException, AddressException, EntityDoesNotExistException {
    return ucManageUser.createUserAndAccountEntitiesViaSignUp(userTo, request, errors);
  }

  @Override
  public Optional<UserEto> updateUser(UserTo userTo, Long userId) throws EntityDoesNotExistException {
    return ucManageUser.updateUser(userTo, userId);
  }

  @Override
  public Optional<AccountEto> updateUserAccount(AccountTo accountTo, Long userId)
      throws AccountAlreadyExistsException, AddressException, EntityDoesNotExistException {
    return ucManageUser.updateUserAccount(accountTo, userId);
  }

  @Override
  public void updatePassword(AccountTo accountTo) throws EntityDoesNotExistException {
    ucManageUser.updatePassword(accountTo);
  }

  @Override
  public Optional<RedirectView> confirmRegistration(String token) throws EntityDoesNotExistException {
    return ucManageRegistration.confirmRegistration(token);
  }
}
