package edu.suffolk.litlab.efsp.server.utils;

public sealed class ProxyServerException extends RuntimeException {

  public static final class AuthenticationNeeded extends ProxyServerException {}
}
