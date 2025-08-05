package edu.suffolk.litlab.efsp.server.utils;

import java.security.Principal;
import java.util.UUID;

public record ServerUser(UUID uuid) implements Principal {
  // Principals can only have one name, so stick with UUID.
  @Override
  public String getName() {
    return uuid.toString();
  }
}
