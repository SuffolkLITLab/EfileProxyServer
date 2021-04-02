
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.changepasswordresponse.ChangePasswordResponseType;


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
 *         &amp;lt;element name="ChangePasswordResponse" type="{urn:tyler:efm:services:schema:ChangePasswordResponse}ChangePasswordResponseType" minOccurs="0"/&amp;gt;
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
    "changePasswordResponse"
})
@XmlRootElement(name = "ChangePasswordResponse")
public class ChangePasswordResponse {

    @XmlElement(name = "ChangePasswordResponse")
    protected ChangePasswordResponseType changePasswordResponse;

    /**
     * Gets the value of the changePasswordResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ChangePasswordResponseType }
     *     
     */
    public ChangePasswordResponseType getChangePasswordResponse() {
        return changePasswordResponse;
    }

    /**
     * Sets the value of the changePasswordResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangePasswordResponseType }
     *     
     */
    public void setChangePasswordResponse(ChangePasswordResponseType value) {
        this.changePasswordResponse = value;
    }

}
