package edu.suffolk.litlab.efsp.server.auth;

import java.security.Principal;

public record TylerUserFromServer(UserCreds creds) implements Principal {
  // Principals can only have one name, so stick with the user name (email).
  @Override
  public String getName() {
    return creds.getUserName();
  }
}
