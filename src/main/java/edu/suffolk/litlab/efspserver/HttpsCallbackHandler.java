package edu.suffolk.litlab.efspserver;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/** When the server is using TLS (HTTPS), incoming connections will use
 * this object to decrypt the incoming data.
 *
 * See the <a href="file:../../../../../config/ServerConfig.xml">ServerConfig.xml</a> for more details.
 */
public class HttpsCallbackHandler implements CallbackHandler {

  private static String certPassword;

  public static void setCertPassword(String newPassword) {
    certPassword = newPassword;
  }

  @Override
  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    for (int i = 0; i < callbacks.length; i++) {
      if (callbacks[i] instanceof PasswordCallback) {
        PasswordCallback pc = (PasswordCallback)callbacks[i];
        pc.setPassword(certPassword.toCharArray());
      }
    }
  }

}
