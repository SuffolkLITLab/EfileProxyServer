
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.attachservicecontactrequest.AttachServiceContactRequestType;


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
 *         &amp;lt;element name="AttachServiceContactRequest" type="{urn:tyler:efm:services:schema:AttachServiceContactRequest}AttachServiceContactRequestType" minOccurs="0"/&amp;gt;
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
    "attachServiceContactRequest"
})
@XmlRootElement(name = "AttachServiceContact")
public class AttachServiceContact {

    @XmlElement(name = "AttachServiceContactRequest")
    protected AttachServiceContactRequestType attachServiceContactRequest;

    /**
     * Gets the value of the attachServiceContactRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AttachServiceContactRequestType }
     *     
     */
    public AttachServiceContactRequestType getAttachServiceContactRequest() {
        return attachServiceContactRequest;
    }

    /**
     * Sets the value of the attachServiceContactRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AttachServiceContactRequestType }
     *     
     */
    public void setAttachServiceContactRequest(AttachServiceContactRequestType value) {
        this.attachServiceContactRequest = value;
    }

}
