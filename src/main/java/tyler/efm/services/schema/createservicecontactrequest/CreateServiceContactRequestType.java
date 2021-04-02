
package tyler.efm.services.schema.createservicecontactrequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.baserequest.BaseRequestType;
import tyler.efm.services.schema.common.ServiceContactType;


/**
 * &lt;p&gt;Java class for CreateServiceContactRequestType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CreateServiceContactRequestType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:efm:services:schema:BaseRequest}BaseRequestType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:efm:services:schema:Common}ServiceContact" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateServiceContactRequestType", propOrder = {
    "serviceContact"
})
public class CreateServiceContactRequestType
    extends BaseRequestType
{

    @XmlElement(name = "ServiceContact", namespace = "urn:tyler:efm:services:schema:Common")
    protected ServiceContactType serviceContact;

    /**
     * Gets the value of the serviceContact property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceContactType }
     *     
     */
    public ServiceContactType getServiceContact() {
        return serviceContact;
    }

    /**
     * Sets the value of the serviceContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceContactType }
     *     
     */
    public void setServiceContact(ServiceContactType value) {
        this.serviceContact = value;
    }

}
