
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getservicecontactrequest.GetServiceContactRequestType;


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
 *         &amp;lt;element name="GetServiceContactRequest" type="{urn:tyler:efm:services:schema:GetServiceContactRequest}GetServiceContactRequestType" minOccurs="0"/&amp;gt;
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
    "getServiceContactRequest"
})
@XmlRootElement(name = "GetServiceContact")
public class GetServiceContact {

    @XmlElement(name = "GetServiceContactRequest")
    protected GetServiceContactRequestType getServiceContactRequest;

    /**
     * Gets the value of the getServiceContactRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetServiceContactRequestType }
     *     
     */
    public GetServiceContactRequestType getGetServiceContactRequest() {
        return getServiceContactRequest;
    }

    /**
     * Sets the value of the getServiceContactRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetServiceContactRequestType }
     *     
     */
    public void setGetServiceContactRequest(GetServiceContactRequestType value) {
        this.getServiceContactRequest = value;
    }

}
