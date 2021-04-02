
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.createservicecontactresponse.CreateServiceContactResponseType;


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
 *         &amp;lt;element name="CreateServiceContactResponse" type="{urn:tyler:efm:services:schema:CreateServiceContactResponse}CreateServiceContactResponseType" minOccurs="0"/&amp;gt;
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
    "createServiceContactResponse"
})
@XmlRootElement(name = "CreateServiceContactResponse")
public class CreateServiceContactResponse {

    @XmlElement(name = "CreateServiceContactResponse")
    protected CreateServiceContactResponseType createServiceContactResponse;

    /**
     * Gets the value of the createServiceContactResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CreateServiceContactResponseType }
     *     
     */
    public CreateServiceContactResponseType getCreateServiceContactResponse() {
        return createServiceContactResponse;
    }

    /**
     * Sets the value of the createServiceContactResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateServiceContactResponseType }
     *     
     */
    public void setCreateServiceContactResponse(CreateServiceContactResponseType value) {
        this.createServiceContactResponse = value;
    }

}
