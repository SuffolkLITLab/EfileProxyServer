package edu.suffolk.litlab.efsp.server.auth;

import java.util.List;
import org.apache.cxf.headers.Header;

public interface UserCreds {

  /** The user's identifiable name (in Tyler this is an email). */
  String getUserName();

  /**
   * @return the user's credentials in the form of a SOAP header.
   */
  List<Header> toHeaders();
}
