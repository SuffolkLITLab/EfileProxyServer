
package tyler.efm.v2024_6.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2024_6.services.schema.createservicecontactresponse.CreateServiceContactResponseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CreateServiceContactResponse" type="{urn:tyler:efm:services:schema:CreateServiceContactResponse}CreateServiceContactResponseType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
