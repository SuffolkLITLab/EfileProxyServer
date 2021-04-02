
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.updatefirmrequest.UpdateFirmRequestType;


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
 *         &amp;lt;element name="UpdateFirmRequest" type="{urn:tyler:efm:services:schema:UpdateFirmRequest}UpdateFirmRequestType" minOccurs="0"/&amp;gt;
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
    "updateFirmRequest"
})
@XmlRootElement(name = "UpdateFirm")
public class UpdateFirm {

    @XmlElement(name = "UpdateFirmRequest")
    protected UpdateFirmRequestType updateFirmRequest;

    /**
     * Gets the value of the updateFirmRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFirmRequestType }
     *     
     */
    public UpdateFirmRequestType getUpdateFirmRequest() {
        return updateFirmRequest;
    }

    /**
     * Sets the value of the updateFirmRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFirmRequestType }
     *     
     */
    public void setUpdateFirmRequest(UpdateFirmRequestType value) {
        this.updateFirmRequest = value;
    }

}
