
package tyler.efm.v2022_1.services.schema.getservicecontactresponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.baseresponse.BaseResponseType;
import tyler.efm.v2022_1.services.schema.common.ServiceContactType;


/**
 * <p>Java class for GetServiceContactResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceContactResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:efm:services:schema:Common}ServiceContact" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceContactResponseType", propOrder = {
    "serviceContact"
})
public class GetServiceContactResponseType
    extends BaseResponseType
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
