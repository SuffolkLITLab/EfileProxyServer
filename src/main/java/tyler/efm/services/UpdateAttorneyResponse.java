
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.updateattorneyresponse.UpdateAttorneyResponseType;


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
 *         &amp;lt;element name="UpdateAttorneyResponse" type="{urn:tyler:efm:services:schema:UpdateAttorneyResponse}UpdateAttorneyResponseType" minOccurs="0"/&amp;gt;
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
    "updateAttorneyResponse"
})
@XmlRootElement(name = "UpdateAttorneyResponse")
public class UpdateAttorneyResponse {

    @XmlElement(name = "UpdateAttorneyResponse")
    protected UpdateAttorneyResponseType updateAttorneyResponse;

    /**
     * Gets the value of the updateAttorneyResponse property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateAttorneyResponseType }
     *     
     */
    public UpdateAttorneyResponseType getUpdateAttorneyResponse() {
        return updateAttorneyResponse;
    }

    /**
     * Sets the value of the updateAttorneyResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateAttorneyResponseType }
     *     
     */
    public void setUpdateAttorneyResponse(UpdateAttorneyResponseType value) {
        this.updateAttorneyResponse = value;
    }

}
