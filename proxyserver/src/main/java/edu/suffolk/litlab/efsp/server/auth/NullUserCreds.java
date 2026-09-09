package edu.suffolk.litlab.efsp.server.auth;

import java.util.List;
import org.apache.cxf.headers.Header;

public class NullUserCreds implements UserCreds {

  public String getUserName() {
    return "";
  }

  public List<Header> toHeaders() {
    return List.of();
  }
}
