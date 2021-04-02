
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getattorneyresponse.GetAttorneyResponseType;


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
 *         &amp;lt;element name="GetAttorneyResponse" type="{urn:tyler:efm:services:schema:GetAttorneyResponse}GetAttorneyResponseType" minOccurs="0"/&amp;gt;
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
    "getAttorneyResponse"
})
@XmlRootElement(name = "GetAttorneyResponse")
public class GetAttorneyResponse {

    @XmlElement(name = "GetAttorneyResponse")
    protected GetAttorneyResponseType getAttorneyResponse;

    /**
     * Gets the value of the getAttorneyResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetAttorneyResponseType }
     *     
     */
    public GetAttorneyResponseType getGetAttorneyResponse() {
        return getAttorneyResponse;
    }

    /**
     * Sets the value of the getAttorneyResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAttorneyResponseType }
     *     
     */
    public void setGetAttorneyResponse(GetAttorneyResponseType value) {
        this.getAttorneyResponse = value;
    }

}
