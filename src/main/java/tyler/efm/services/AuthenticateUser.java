
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="AuthenticateRequest" type="{urn:tyler:efm:services:schema:AuthenticateRequest}AuthenticateRequestType" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "authenticateRequest"
})
@XmlRootElement(name = "AuthenticateUser")
public class AuthenticateUser {

    @XmlElement(name = "AuthenticateRequest")
    protected AuthenticateRequestType authenticateRequest;

    /**
     * Gets the value of the authenticateRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticateRequestType }
     *     
     */
    public AuthenticateRequestType getAuthenticateRequest() {
        return authenticateRequest;
    }

    /**
     * Sets the value of the authenticateRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticateRequestType }
     *     
     */
    public void setAuthenticateRequest(AuthenticateRequestType value) {
        this.authenticateRequest = value;
    }

}
