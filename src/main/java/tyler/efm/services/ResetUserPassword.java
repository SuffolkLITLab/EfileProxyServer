
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;


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
 *         &amp;lt;element name="ResetUserPasswordRequest" type="{urn:tyler:efm:services:schema:ResetUserPasswordRequest}ResetUserPasswordRequestType" minOccurs="0"/&amp;gt;
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
    "resetUserPasswordRequest"
})
@XmlRootElement(name = "ResetUserPassword")
public class ResetUserPassword {

    @XmlElement(name = "ResetUserPasswordRequest")
    protected ResetUserPasswordRequestType resetUserPasswordRequest;

    /**
     * Gets the value of the resetUserPasswordRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ResetUserPasswordRequestType }
     *     
     */
    public ResetUserPasswordRequestType getResetUserPasswordRequest() {
        return resetUserPasswordRequest;
    }

    /**
     * Sets the value of the resetUserPasswordRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResetUserPasswordRequestType }
     *     
     */
    public void setResetUserPasswordRequest(ResetUserPasswordRequestType value) {
        this.resetUserPasswordRequest = value;
    }

}
