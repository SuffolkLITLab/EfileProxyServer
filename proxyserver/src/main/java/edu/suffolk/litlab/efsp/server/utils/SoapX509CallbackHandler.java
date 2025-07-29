package edu.suffolk.litlab.efsp.server.utils;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class SoapX509CallbackHandler implements CallbackHandler {

  private static String x509Password = "";

  public static void setX509Password(String newPassword) {
    x509Password = newPassword;
    if (x509Password == null || x509Password.isBlank()) {
      throw new RuntimeException("x509Password can't be null: " + x509Password);
    }
  }

  /** Handles setting the password for Webservices accessing the x509 certificates. */
  public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
    for (int i = 0; i < callbacks.length; i++) {
      if (callbacks[i] instanceof WSPasswordCallback) {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        if (x509Password == null || x509Password.isBlank()) {
          throw new RuntimeException("x509Password can't be null: " + x509Password);
        }
        pc.setPassword(x509Password);
      } else {
        throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
      }
    }
  }
}
