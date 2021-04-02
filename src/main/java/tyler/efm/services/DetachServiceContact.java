
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.detachservicecontactrequest.DetachServiceContactRequestType;


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
 *         &amp;lt;element name="DetachServiceContactRequest" type="{urn:tyler:efm:services:schema:DetachServiceContactRequest}DetachServiceContactRequestType" minOccurs="0"/&amp;gt;
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
    "detachServiceContactRequest"
})
@XmlRootElement(name = "DetachServiceContact")
public class DetachServiceContact {

    @XmlElement(name = "DetachServiceContactRequest")
    protected DetachServiceContactRequestType detachServiceContactRequest;

    /**
     * Gets the value of the detachServiceContactRequest property.
     * 
     * @return
     *     possible object is
     *     {@link DetachServiceContactRequestType }
     *     
     */
    public DetachServiceContactRequestType getDetachServiceContactRequest() {
        return detachServiceContactRequest;
    }

    /**
     * Sets the value of the detachServiceContactRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link DetachServiceContactRequestType }
     *     
     */
    public void setDetachServiceContactRequest(DetachServiceContactRequestType value) {
        this.detachServiceContactRequest = value;
    }

}
