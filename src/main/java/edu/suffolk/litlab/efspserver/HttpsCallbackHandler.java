package edu.suffolk.litlab.efspserver;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class HttpsCallbackHandler implements CallbackHandler {
  
  private static String certPassword;

  public static void setCertPassword(String newPassword) {
	 System.out.println("Setting cert password to " + newPassword);
    certPassword = newPassword;
  }

  @Override
  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
	  System.out.println("Passing the cert password through to the handler");
    for (int i = 0; i < callbacks.length; i++) {
      PasswordCallback pc = (PasswordCallback)callbacks[i];
      pc.setPassword(certPassword.toCharArray()); 
    }
  }

}
