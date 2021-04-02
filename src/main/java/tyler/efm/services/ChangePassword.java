
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.changepasswordrequest.ChangePasswordRequestType;


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
 *         &amp;lt;element name="ChangePasswordRequest" type="{urn:tyler:efm:services:schema:ChangePasswordRequest}ChangePasswordRequestType" minOccurs="0"/&amp;gt;
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
    "changePasswordRequest"
})
@XmlRootElement(name = "ChangePassword")
public class ChangePassword {

    @XmlElement(name = "ChangePasswordRequest")
    protected ChangePasswordRequestType changePasswordRequest;

    /**
     * Gets the value of the changePasswordRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ChangePasswordRequestType }
     *     
     */
    public ChangePasswordRequestType getChangePasswordRequest() {
        return changePasswordRequest;
    }

    /**
     * Sets the value of the changePasswordRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangePasswordRequestType }
     *     
     */
    public void setChangePasswordRequest(ChangePasswordRequestType value) {
        this.changePasswordRequest = value;
    }

}
