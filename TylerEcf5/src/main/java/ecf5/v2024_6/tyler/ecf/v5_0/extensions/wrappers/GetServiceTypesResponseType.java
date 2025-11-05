
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.servicetypesresponse.GetServiceTypesResponseMessageType;


/**
 * <p>Java class for GetServiceTypesResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceTypesResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:servicetypesresponse}GetServiceTypesResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceTypesResponseType", propOrder = {
    "getServiceTypesResponseMessage"
})
public class GetServiceTypesResponseType {

    @XmlElement(name = "GetServiceTypesResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesresponse", required = true)
    protected GetServiceTypesResponseMessageType getServiceTypesResponseMessage;

    /**
     * Gets the value of the getServiceTypesResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetServiceTypesResponseMessageType }
     *     
     */
    public GetServiceTypesResponseMessageType getGetServiceTypesResponseMessage() {
        return getServiceTypesResponseMessage;
    }

    /**
     * Sets the value of the getServiceTypesResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetServiceTypesResponseMessageType }
     *     
     */
    public void setGetServiceTypesResponseMessage(GetServiceTypesResponseMessageType value) {
        this.getServiceTypesResponseMessage = value;
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
