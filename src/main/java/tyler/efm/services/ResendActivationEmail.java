
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;


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
 *         &amp;lt;element name="ResendActivationEmailRequest" type="{urn:tyler:efm:services:schema:ResendActivationEmailRequest}ResendActivationEmailRequestType" minOccurs="0"/&amp;gt;
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
    "resendActivationEmailRequest"
})
@XmlRootElement(name = "ResendActivationEmail")
public class ResendActivationEmail {

    @XmlElement(name = "ResendActivationEmailRequest")
    protected ResendActivationEmailRequestType resendActivationEmailRequest;

    /**
     * Gets the value of the resendActivationEmailRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ResendActivationEmailRequestType }
     *     
     */
    public ResendActivationEmailRequestType getResendActivationEmailRequest() {
        return resendActivationEmailRequest;
    }

    /**
     * Sets the value of the resendActivationEmailRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResendActivationEmailRequestType }
     *     
     */
    public void setResendActivationEmailRequest(ResendActivationEmailRequestType value) {
        this.resendActivationEmailRequest = value;
    }

}
