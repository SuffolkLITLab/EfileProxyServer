
package tyler.efm.services.schema.updateservicecontactresponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.baseresponse.BaseResponseType;


/**
 * <p>Java class for UpdateServiceContactResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateServiceContactResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceContactID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateServiceContactResponseType", propOrder = {
    "serviceContactID"
})
public class UpdateServiceContactResponseType
    extends BaseResponseType
{

    @XmlElement(name = "ServiceContactID")
    protected String serviceContactID;

    /**
     * Gets the value of the serviceContactID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceContactID() {
        return serviceContactID;
    }

    /**
     * Sets the value of the serviceContactID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceContactID(String value) {
        this.serviceContactID = value;
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
