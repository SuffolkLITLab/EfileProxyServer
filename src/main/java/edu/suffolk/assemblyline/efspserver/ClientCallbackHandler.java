package edu.suffolk.assemblyline.efspserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.wss4j.common.ext.WSPasswordCallback;

public class ClientCallbackHandler implements CallbackHandler {

  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

    for (int i = 0; i < callbacks.length; i++) {
      if (callbacks[i] instanceof TextOutputCallback) {

        // display the message according to the specified type
        TextOutputCallback toc = (TextOutputCallback) callbacks[i];
        switch (toc.getMessageType()) {
        case TextOutputCallback.INFORMATION:
          System.out.println(toc.getMessage());
          break;
        case TextOutputCallback.ERROR:
          System.out.println("ERROR: " + toc.getMessage());
          break;
        case TextOutputCallback.WARNING:
          System.out.println("WARNING: " + toc.getMessage());
          break;
        default:
          throw new IOException("Unsupported message type: " + toc.getMessageType());
        }

      } else if (callbacks[i] instanceof NameCallback) {

        // prompt the user for a username
        NameCallback nc = (NameCallback) callbacks[i];

        // ignore the provided defaultName
        System.err.print(nc.getPrompt());
        System.err.flush();
        nc.setName((new BufferedReader(new InputStreamReader(System.in))).readLine());
      } else if (callbacks[i] instanceof WSPasswordCallback) {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        String x509Password = System.getenv("X509_PASSWORD");
        if (x509Password == null || x509Password.equals("")) {
          throw new RuntimeException("x509Password can't be null. Did you forget to source .env?");
        }
        pc.setPassword(x509Password);
      } else {
        throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
      }
    }
  }
}
