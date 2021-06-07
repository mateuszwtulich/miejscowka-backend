package com.example.backend.userhandling.logic.api.to;

import com.sun.istack.NotNull;

import java.util.Objects;

public class SignUpUserTo {

  public SignUpUserTo() {
  }

  public SignUpUserTo(String name, String surname, String password, String email) {
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.email = email;
  }

  @NotNull
  private String name;

  @NotNull
  private String surname;

  @NotNull
  private String password;

  @NotNull
  private String email;

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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SignUpUserTo)) return false;
    SignUpUserTo userTo = (SignUpUserTo) o;
    return name.equals(userTo.name) &&
        surname.equals(userTo.surname) &&
        password.equals(userTo.password) &&
        email.equals(userTo.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, email, password);
  }
}
