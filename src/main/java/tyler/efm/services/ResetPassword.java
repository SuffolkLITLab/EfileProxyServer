
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.resetpasswordrequest.ResetPasswordRequestType;


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
 *         &amp;lt;element name="ResetPasswordRequest" type="{urn:tyler:efm:services:schema:ResetPasswordRequest}ResetPasswordRequestType" minOccurs="0"/&amp;gt;
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
    "resetPasswordRequest"
})
@XmlRootElement(name = "ResetPassword")
public class ResetPassword {

    @XmlElement(name = "ResetPasswordRequest")
    protected ResetPasswordRequestType resetPasswordRequest;

    /**
     * Gets the value of the resetPasswordRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ResetPasswordRequestType }
     *     
     */
    public ResetPasswordRequestType getResetPasswordRequest() {
        return resetPasswordRequest;
    }

    /**
     * Sets the value of the resetPasswordRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResetPasswordRequestType }
     *     
     */
    public void setResetPasswordRequest(ResetPasswordRequestType value) {
        this.resetPasswordRequest = value;
    }

}
