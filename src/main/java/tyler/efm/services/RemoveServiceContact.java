
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType;


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
 *         &amp;lt;element name="RemoveServiceContactRequest" type="{urn:tyler:efm:services:schema:RemoveServiceContactRequest}RemoveServiceContactRequestType" minOccurs="0"/&amp;gt;
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
    "removeServiceContactRequest"
})
@XmlRootElement(name = "RemoveServiceContact")
public class RemoveServiceContact {

    @XmlElement(name = "RemoveServiceContactRequest")
    protected RemoveServiceContactRequestType removeServiceContactRequest;

    /**
     * Gets the value of the removeServiceContactRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RemoveServiceContactRequestType }
     *     
     */
    public RemoveServiceContactRequestType getRemoveServiceContactRequest() {
        return removeServiceContactRequest;
    }

    /**
     * Sets the value of the removeServiceContactRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemoveServiceContactRequestType }
     *     
     */
    public void setRemoveServiceContactRequest(RemoveServiceContactRequestType value) {
        this.removeServiceContactRequest = value;
    }

}
