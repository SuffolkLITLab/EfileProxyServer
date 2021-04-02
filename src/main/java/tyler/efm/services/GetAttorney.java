
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getattorneyrequest.GetAttorneyRequestType;


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
 *         &amp;lt;element name="GetAttorneyRequest" type="{urn:tyler:efm:services:schema:GetAttorneyRequest}GetAttorneyRequestType" minOccurs="0"/&amp;gt;
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
    "getAttorneyRequest"
})
@XmlRootElement(name = "GetAttorney")
public class GetAttorney {

    @XmlElement(name = "GetAttorneyRequest")
    protected GetAttorneyRequestType getAttorneyRequest;

    /**
     * Gets the value of the getAttorneyRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetAttorneyRequestType }
     *     
     */
    public GetAttorneyRequestType getGetAttorneyRequest() {
        return getAttorneyRequest;
    }

    /**
     * Sets the value of the getAttorneyRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetAttorneyRequestType }
     *     
     */
    public void setGetAttorneyRequest(GetAttorneyRequestType value) {
        this.getAttorneyRequest = value;
    }

}
