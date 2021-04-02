
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType;


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
 *         &amp;lt;element name="ResetPasswordResponse" type="{urn:tyler:efm:services:schema:ResetPasswordResponse}ResetPasswordResponseType" minOccurs="0"/&amp;gt;
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
    "resetPasswordResponse"
})
@XmlRootElement(name = "ResetUserPasswordResponse")
public class ResetUserPasswordResponse {

    @XmlElement(name = "ResetPasswordResponse")
    protected ResetPasswordResponseType resetPasswordResponse;

    /**
     * Gets the value of the resetPasswordResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ResetPasswordResponseType }
     *     
     */
    public ResetPasswordResponseType getResetPasswordResponse() {
        return resetPasswordResponse;
    }

    /**
     * Sets the value of the resetPasswordResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResetPasswordResponseType }
     *     
     */
    public void setResetPasswordResponse(ResetPasswordResponseType value) {
        this.resetPasswordResponse = value;
    }

}
