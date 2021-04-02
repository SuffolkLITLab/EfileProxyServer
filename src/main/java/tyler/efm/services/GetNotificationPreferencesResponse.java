
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;


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
 *         &amp;lt;element name="GetNotificationPreferencesResponse" type="{urn:tyler:efm:services:schema:NotificationPreferencesResponse}NotificationPreferencesResponseType" minOccurs="0"/&amp;gt;
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
    "getNotificationPreferencesResponse"
})
@XmlRootElement(name = "GetNotificationPreferencesResponse")
public class GetNotificationPreferencesResponse {

    @XmlElement(name = "GetNotificationPreferencesResponse")
    protected NotificationPreferencesResponseType getNotificationPreferencesResponse;

    /**
     * Gets the value of the getNotificationPreferencesResponse property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationPreferencesResponseType }
     *     
     */
    public NotificationPreferencesResponseType getGetNotificationPreferencesResponse() {
        return getNotificationPreferencesResponse;
    }

    /**
     * Sets the value of the getNotificationPreferencesResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationPreferencesResponseType }
     *     
     */
    public void setGetNotificationPreferencesResponse(NotificationPreferencesResponseType value) {
        this.getNotificationPreferencesResponse = value;
    }

}
