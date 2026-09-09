package edu.suffolk.litlab.efsp.server.auth;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Optional;
import javax.xml.namespace.QName;
import org.apache.cxf.headers.Header;
import org.apache.cxf.jaxb.JAXBDataBinding;
import tyler.efm.latest.services.schema.authenticateresponse.AuthenticateResponseType;

/**
 * A class that handles authentication to an external server by simply accepting a user's username
 * and password, separated by a colon in a header.
 *
 * <p>Only Tyler is silly enough to do this though, so practically this is just theirs.
 */
@XmlRootElement(name = "UserNameHeader")
public class UserNamePassword implements UserCreds {
  @XmlElement(name = "UserName")
  private String userName;

  @XmlElement(name = "Password")
  private String password;

  public UserNamePassword() {}

  public UserNamePassword(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public static Optional<UserCreds> userCredsFromAuthorization(String userColonPassword) {
    if (userColonPassword == null) {
      return Optional.empty();
    }
    if (!userColonPassword.contains(":")) {
      return Optional.empty();
    }
    String email = userColonPassword.split(":")[0];
    String password = userColonPassword.split(":")[1];
    return Optional.of(new UserNamePassword(email, password));
  }

  public String getUserName() {
    return userName;
  }

  @Override
  public List<Header> toHeaders() {
    try {
      return List.of(
          new Header(
              new QName("urn:tyler:efm:services", "UserNameHeader"),
              this,
              new JAXBDataBinding(UserNamePassword.class)));
    } catch (JAXBException ex) {
      // We are always passing this class to JAXB. If at any point it would fail,
      // it should be a compile time thing tbh. We don't need the extra overhead
      // of trying to catch the exception everywhere, so just crash.
      throw new RuntimeException(ex);
    }
  }

  /**
   * Convenience method to make the Tyler specific SOAP Header.
   *
   * @param AuthenticateResponseType authRes the response from the server if the user is
   *     authenticated.
   * @return the Header object to the request context's Header.HEADER_LIST
   */
  public static List<Header> makeHeaderList(AuthenticateResponseType authRes) {
    return (new UserNamePassword(authRes.getEmail(), authRes.getPasswordHash())).toHeaders();
  }
}
