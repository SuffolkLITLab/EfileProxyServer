package edu.suffolk.litlab.efspserver.services;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserAuth")
public class UserAuth {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
