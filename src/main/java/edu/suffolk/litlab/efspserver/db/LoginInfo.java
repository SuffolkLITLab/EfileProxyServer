package edu.suffolk.litlab.efspserver.db;

import java.util.UUID;

public class LoginInfo {
  public UUID serverId;
  public String usableToken;
  
  public LoginInfo(UUID serverId, String usableToken) {
    this.serverId = serverId;
    this.usableToken = usableToken;
  }
}
