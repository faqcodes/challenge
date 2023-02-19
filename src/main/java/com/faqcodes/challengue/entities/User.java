package com.faqcodes.challengue.entities;

import java.time.LocalDateTime;
import java.util.List;

public interface User {

  public String getId();

  public LocalDateTime getCreated();

  public LocalDateTime getModified();

  public LocalDateTime getLastlogin();

  public String getToken();

  public String getName();

  public String getEmail();

  public String getPassword();

  public List<Phone> getPhones();

  public boolean isIsactive();

  boolean isPasswordValid();

  boolean isEmailValid();
}
