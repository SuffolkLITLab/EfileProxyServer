package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.db.model.AtRest;
import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

public class EfspSecurityContext implements SecurityContext {

  private final Optional<TylerUserFromServer> principal;
  private final AtRest serverInfo;
  private final String role; // TODO: make this the Tyler role? idk how to do that every query

  public EfspSecurityContext(
      Optional<TylerUserFromServer> principal, AtRest serverInfo, String role) {
    this.principal = principal;
    this.serverInfo = serverInfo;
    this.role = role;
  }

  @Override
  public Principal getUserPrincipal() {
    return principal.orElse(null);
  }

  public Optional<TylerUserFromServer> getTylerUser() {
    return principal;
  }

  public UUID getServerId() {
    return serverInfo.serverId;
  }

  public String getServerName() {
    return serverInfo.serverName;
  }

  @Override
  public boolean isUserInRole(String role) {
    return this.role.equals(role);
  }

  @Override
  public boolean isSecure() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isSecure'");
  }

  @Override
  public String getAuthenticationScheme() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAuthenticationScheme'");
  }
}
