package edu.suffolk.litlab.efspserver.db;

import java.util.Optional;
import java.util.UUID;

public class LoginInfo {
  public UUID serverId;
  // Tyler makes us send them our user id when we call the function that only gives us info 
  // about ourselves. Jeez.
  public Optional<String> userId;
  public String usableToken;
  
  public LoginInfo(UUID serverId, String usableToken) {
    this.serverId = serverId;
    this.userId = Optional.empty();
    this.usableToken = usableToken;
  }

  public LoginInfo(UUID serverId, String userId, String usableToken) {
    this.serverId = serverId;
    this.userId = Optional.of(userId);
    this.usableToken = usableToken;
  }
}
