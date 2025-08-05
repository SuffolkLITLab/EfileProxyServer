package edu.suffolk.litlab.efsp.server.utils;

import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;

public class EfspSecurityContext implements SecurityContext {

  private final Principal principal;
  private final String role; // TODO: make this the Tyler role? idk how to do that every query

  public EfspSecurityContext(Principal principal, String role) {
    this.principal = principal;
    this.role = role;
  }

  @Override
  public Principal getUserPrincipal() {
    return principal;
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
