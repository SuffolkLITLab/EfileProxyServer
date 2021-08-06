package edu.suffolk.litlab.efspserver;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class HttpsCallbackHandler implements CallbackHandler {
  
  private static String certPassword;

  public static void setCertPassword(String newPassword) {
    certPassword = newPassword;
  }

  @Override
  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    for (int i = 0; i < callbacks.length; i++) {
      PasswordCallback pc = (PasswordCallback)callbacks[i];
      pc.setPassword(certPassword.toCharArray()); 
    }
  }

}
