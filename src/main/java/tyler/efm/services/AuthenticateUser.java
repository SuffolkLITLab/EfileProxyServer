
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuthenticateRequest" type="{urn:tyler:efm:services:schema:AuthenticateRequest}AuthenticateRequestType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
