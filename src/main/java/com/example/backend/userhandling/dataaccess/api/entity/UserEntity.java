package com.example.backend.userhandling.dataaccess.api.entity;

import com.example.backend.general.dataaccess.api.entity.AbstractApplicationPersistenceEntity;
import com.example.backend.taskhandling.dataaccess.api.entity.TaskEntity;
import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "BACKEND_USER")
public class UserEntity extends AbstractApplicationPersistenceEntity {
  private static final long serialVersionUID = 1L;

  public UserEntity() {
  }

  public UserEntity(String name, String surname, RoleEntity role, AccountEntity account) {
    this.name = name;
    this.surname = surname;
    this.role = role;
    this.account = account;
  }

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "SURNAME", nullable = false)
  private String surname;

  @NotNull
  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinColumn(name = "ROLE_ID", nullable = false, referencedColumnName = "id")
  private RoleEntity role;

  @NotNull
  @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
  @JoinColumn(name = "ACCOUNT_ID", nullable = false, referencedColumnName = "id", unique = true)
  private AccountEntity account;

  @OneToMany(fetch = FetchType.LAZY, mappedBy ="user", cascade = CascadeType.MERGE, orphanRemoval = true)
  private List<TaskEntity> tasks;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public RoleEntity getRole() {
    return role;
  }

  public void setRole(RoleEntity role) {
    this.role = role;
  }

  public AccountEntity getAccount() {
    return account;
  }

  public void setAccount(AccountEntity account) {
    this.account = account;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof UserEntity)) return false;
    UserEntity that = (UserEntity) o;
    return name.equals(that.name) &&
        role.equals(that.role) &&
        surname.equals(that.surname) &&
        account.equals(that.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, role, surname, account);
  }
}
