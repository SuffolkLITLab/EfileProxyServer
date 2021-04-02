
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;


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
 *         &amp;lt;element name="UpdateNotificationPreferencesRequest" type="{urn:tyler:efm:services:schema:UpdateNotificationPreferencesRequest}UpdateNotificationPreferencesRequestType" minOccurs="0"/&amp;gt;
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
    "updateNotificationPreferencesRequest"
})
@XmlRootElement(name = "UpdateNotificationPreferences")
public class UpdateNotificationPreferences {

    @XmlElement(name = "UpdateNotificationPreferencesRequest")
    protected UpdateNotificationPreferencesRequestType updateNotificationPreferencesRequest;

    /**
     * Gets the value of the updateNotificationPreferencesRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateNotificationPreferencesRequestType }
     *     
     */
    public UpdateNotificationPreferencesRequestType getUpdateNotificationPreferencesRequest() {
        return updateNotificationPreferencesRequest;
    }

    /**
     * Sets the value of the updateNotificationPreferencesRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateNotificationPreferencesRequestType }
     *     
     */
    public void setUpdateNotificationPreferencesRequest(UpdateNotificationPreferencesRequestType value) {
        this.updateNotificationPreferencesRequest = value;
    }

}
