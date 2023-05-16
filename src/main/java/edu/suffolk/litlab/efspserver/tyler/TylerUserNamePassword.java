package edu.suffolk.litlab.efspserver.tyler;

import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.xml.namespace.QName;
import org.apache.cxf.headers.Header;
import org.apache.cxf.jaxb.JAXBDataBinding;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;

@XmlRootElement(name = "UserNameHeader")
public class TylerUserNamePassword {
  @XmlElement(name = "UserName")
  private String userName;

  @XmlElement(name = "Password")
  private String password;

  public TylerUserNamePassword() {}

  public TylerUserNamePassword(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public String getUserName() {
    return userName;
  }

  public Header toHeader() {
    try {
      return new Header(
          new QName("urn:tyler:efm:services", "UserNameHeader"),
          this,
          new JAXBDataBinding(TylerUserNamePassword.class));
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
   * @param userName the email of the user that is sending this request
   * @param passwordHash the auth token (gotten from the AuthenticateUser call).
   * @return the Header object to the request context's Header.HEADER_LIST
   */
  public static Header makeHeader(String userName, String passwordHash) {
    return (new TylerUserNamePassword(userName, passwordHash)).toHeader();
  }

  public static List<Header> makeHeaderList(AuthenticateResponseType authRes) {
    return Arrays.asList(makeHeader(authRes.getEmail(), authRes.getPasswordHash()));
  }

  public static Optional<TylerUserNamePassword> userCredsFromAuthorization(
      String userColonPassword) {
    if (userColonPassword == null) {
      return Optional.empty();
    }
    if (!userColonPassword.contains(":")) {
      return Optional.empty();
    }
    String email = userColonPassword.split(":")[0];
    String password = userColonPassword.split(":")[1];
    return Optional.of(new TylerUserNamePassword(email, password));
  }
}
