
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.createservicecontactrequest.CreateServiceContactRequestType;


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
 *         &amp;lt;element name="CreateServiceContactRequest" type="{urn:tyler:efm:services:schema:CreateServiceContactRequest}CreateServiceContactRequestType" minOccurs="0"/&amp;gt;
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
    "createServiceContactRequest"
})
@XmlRootElement(name = "CreateServiceContact")
public class CreateServiceContact {

    @XmlElement(name = "CreateServiceContactRequest")
    protected CreateServiceContactRequestType createServiceContactRequest;

    /**
     * Gets the value of the createServiceContactRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CreateServiceContactRequestType }
     *     
     */
    public CreateServiceContactRequestType getCreateServiceContactRequest() {
        return createServiceContactRequest;
    }

    /**
     * Sets the value of the createServiceContactRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateServiceContactRequestType }
     *     
     */
    public void setCreateServiceContactRequest(CreateServiceContactRequestType value) {
        this.createServiceContactRequest = value;
    }

}
