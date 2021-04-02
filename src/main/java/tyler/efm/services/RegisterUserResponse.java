
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.registrationresponse.RegistrationResponseType;


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
 *         &amp;lt;element name="RegisterUserResponse" type="{urn:tyler:efm:services:schema:RegistrationResponse}RegistrationResponseType" minOccurs="0"/&amp;gt;
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
    "registerUserResponse"
})
@XmlRootElement(name = "RegisterUserResponse")
public class RegisterUserResponse {

    @XmlElement(name = "RegisterUserResponse")
    protected RegistrationResponseType registerUserResponse;

    /**
     * Gets the value of the registerUserResponse property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationResponseType }
     *     
     */
    public RegistrationResponseType getRegisterUserResponse() {
        return registerUserResponse;
    }

    /**
     * Sets the value of the registerUserResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationResponseType }
     *     
     */
    public void setRegisterUserResponse(RegistrationResponseType value) {
        this.registerUserResponse = value;
    }

}
