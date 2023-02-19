package com.faqcodes.challengue.entities;

import java.time.LocalDateTime;
import java.util.List;

public class UserEntity implements User {

  private final String id;
  private final LocalDateTime created;
  private final LocalDateTime modified;
  private final LocalDateTime lastlogin;
  private final String token;
  private final String name;
  private final String email;
  private final String password;
  private final List<Phone> phones;
  private final boolean isactive;

  public UserEntity(String id, LocalDateTime created, LocalDateTime modified, LocalDateTime lastlogin, String token,
      String name, String email, String password, List<Phone> phones, boolean isactive) {
    this.id = id;
    this.created = created;
    this.modified = modified;
    this.lastlogin = lastlogin;
    this.token = token;
    this.name = name;
    this.email = email;
    this.password = password;
    this.phones = phones;
    this.isactive = isactive;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public LocalDateTime getCreated() {
    return created;
  }

  @Override
  public LocalDateTime getModified() {
    return modified;
  }

  @Override
  public LocalDateTime getLastlogin() {
    return lastlogin;
  }

  @Override
  public String getToken() {
    return token;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public List<Phone> getPhones() {
    return phones;
  }

  @Override
  public boolean isIsactive() {
    return isactive;
  }

  @Override
  public boolean isPasswordValid() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isEmailValid() {
    // TODO Auto-generated method stub
    return false;
  }

}
