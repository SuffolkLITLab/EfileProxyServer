package edu.suffolk.litlab.efsp.server.auth;

import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.stdlib.NonEmptyString;
import jakarta.annotation.Nullable;
import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

public class EfspSecurityContext implements SecurityContext {

  private final Optional<TylerUserFromServer> principal;
  @Nullable private final Optional<NonEmptyString> userIdFromHeader;
  private final AtRest serverInfo;
  private final String role; // TODO: make this the Tyler role? idk how to do that every query

  public EfspSecurityContext(
      Optional<TylerUserFromServer> principal,
      Optional<NonEmptyString> userIdFromHeader,
      AtRest serverInfo,
      String role) {
    this.principal = principal;
    this.userIdFromHeader = userIdFromHeader;
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

  public UserCreds getUserCreds() {
    if (principal.isPresent()) {
      return principal.get().creds();
    } else {
      return new NullUserCreds();
    }
  }

  public Optional<NonEmptyString> getUserId() {
    return userIdFromHeader;
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
