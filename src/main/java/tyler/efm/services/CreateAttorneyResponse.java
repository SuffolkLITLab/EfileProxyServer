
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.createattorneyresponse.CreateAttorneyResponseType;


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
 *         &amp;lt;element name="CreateAttorneyResponse" type="{urn:tyler:efm:services:schema:CreateAttorneyResponse}CreateAttorneyResponseType" minOccurs="0"/&amp;gt;
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
    "createAttorneyResponse"
})
@XmlRootElement(name = "CreateAttorneyResponse")
public class CreateAttorneyResponse {

    @XmlElement(name = "CreateAttorneyResponse")
    protected CreateAttorneyResponseType createAttorneyResponse;

    /**
     * Gets the value of the createAttorneyResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CreateAttorneyResponseType }
     *     
     */
    public CreateAttorneyResponseType getCreateAttorneyResponse() {
        return createAttorneyResponse;
    }

    /**
     * Sets the value of the createAttorneyResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateAttorneyResponseType }
     *     
     */
    public void setCreateAttorneyResponse(CreateAttorneyResponseType value) {
        this.createAttorneyResponse = value;
    }

}
