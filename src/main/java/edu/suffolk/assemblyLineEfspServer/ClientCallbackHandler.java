package edu.suffolk.assemblyLineEfspServer;

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientCallbackHandler implements CallbackHandler {
	
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    	
    	   for (int i = 0; i < callbacks.length; i++) {
    		      if (callbacks[i] instanceof TextOutputCallback) {

    		          // display the message according to the specified type
    		          TextOutputCallback toc = (TextOutputCallback)callbacks[i];
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
    		              throw new IOException("Unsupported message type: " +
    		                                  toc.getMessageType());
    		          }

    		      } else if (callbacks[i] instanceof NameCallback) {

    		          // prompt the user for a username
    		          NameCallback nc = (NameCallback)callbacks[i];

    		          // ignore the provided defaultName
    		          System.err.print(nc.getPrompt());
    		          System.err.flush();
    		          nc.setName((new BufferedReader
    		                  (new InputStreamReader(System.in))).readLine());
    		      } else if (callbacks[i] instanceof WSPasswordCallback) {
    		    	  WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
    		    	  pc.setPassword(System.getenv("X509_PASSWORD"));
    		      } else {
    		          throw new UnsupportedCallbackException
    		                  (callbacks[i], "Unrecognized Callback");
    		      }
    		   }
    	
    }
}
