
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.registrationrequest.RegistrationRequestType;


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
 *         &amp;lt;element name="RegisterUserRequest" type="{urn:tyler:efm:services:schema:RegistrationRequest}RegistrationRequestType" minOccurs="0"/&amp;gt;
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
    "registerUserRequest"
})
@XmlRootElement(name = "RegisterUser")
public class RegisterUser {

    @XmlElement(name = "RegisterUserRequest")
    protected RegistrationRequestType registerUserRequest;

    /**
     * Gets the value of the registerUserRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationRequestType }
     *     
     */
    public RegistrationRequestType getRegisterUserRequest() {
        return registerUserRequest;
    }

    /**
     * Sets the value of the registerUserRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationRequestType }
     *     
     */
    public void setRegisterUserRequest(RegistrationRequestType value) {
        this.registerUserRequest = value;
    }

}
