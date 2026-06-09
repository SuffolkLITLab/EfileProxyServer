package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import java.security.Principal;

public record TylerUserFromServer(TylerUserNamePassword creds) implements Principal {
  // Principals can only have one name, so stick with the user name (email).
  @Override
  public String getName() {
    return creds.getUserName();
  }
}
