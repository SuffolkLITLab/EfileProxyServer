
package tyler.efm.latest.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.latest.services.schema.notificationpreferenceslistresponse.NotificationPreferencesListResponseType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetNotificationPreferencesListResponse" type="{urn:tyler:efm:services:schema:NotificationPreferencesListResponse}NotificationPreferencesListResponseType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getNotificationPreferencesListResponse"
})
@XmlRootElement(name = "GetNotificationPreferencesListResponse")
public class GetNotificationPreferencesListResponse {

    @XmlElement(name = "GetNotificationPreferencesListResponse")
    protected NotificationPreferencesListResponseType getNotificationPreferencesListResponse;

    /**
     * Gets the value of the getNotificationPreferencesListResponse property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationPreferencesListResponseType }
     *     
     */
    public NotificationPreferencesListResponseType getGetNotificationPreferencesListResponse() {
        return getNotificationPreferencesListResponse;
    }

    /**
     * Sets the value of the getNotificationPreferencesListResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationPreferencesListResponseType }
     *     
     */
    public void setGetNotificationPreferencesListResponse(NotificationPreferencesListResponseType value) {
        this.getNotificationPreferencesListResponse = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
