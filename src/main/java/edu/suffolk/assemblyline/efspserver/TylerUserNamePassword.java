package edu.suffolk.assemblyline.efspserver;

import java.util.Arrays;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
  
  public Header toHeader() throws JAXBException {
    return new Header(new QName("urn:tyler:efm:services", "UserNameHeader"),
        this, new JAXBDataBinding(TylerUserNamePassword.class));
  }

  /**
   * Convenience method to make the Tyler specific SOAP Header.
   *
   * @param  userName      the email of the user that is sending this request
   * @param  passwordHash  the auth token (gotten from the AuthenticateUser
   *                       call).
   * @return               the Header object to the request context's
   *                       Header.HEADER_LIST
   * @throws JAXBException if the Data binding fails for any reason
   */
  public static Header makeHeader(String userName, String passwordHash) throws JAXBException {
    return (new TylerUserNamePassword(userName, passwordHash)).toHeader(); 
  }

  public static List<Header> makeHeaderList(AuthenticateResponseType authRes) throws JAXBException {
    return Arrays.asList(makeHeader(authRes.getEmail(), authRes.getPasswordHash()));
  }
}
