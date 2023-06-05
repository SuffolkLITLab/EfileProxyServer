
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.servicetypesrequest.GetServiceTypesMessageType;


/**
 * <p>Java class for GetServiceTypesRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceTypesRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:servicetypesrequest}GetServiceTypesMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceTypesRequestType", propOrder = {
    "getServiceTypesMessage"
})
public class GetServiceTypesRequestType {

    @XmlElement(name = "GetServiceTypesMessage", namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesrequest", required = true)
    protected GetServiceTypesMessageType getServiceTypesMessage;

    /**
     * Gets the value of the getServiceTypesMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetServiceTypesMessageType }
     *     
     */
    public GetServiceTypesMessageType getGetServiceTypesMessage() {
        return getServiceTypesMessage;
    }

    /**
     * Sets the value of the getServiceTypesMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetServiceTypesMessageType }
     *     
     */
    public void setGetServiceTypesMessage(GetServiceTypesMessageType value) {
        this.getServiceTypesMessage = value;
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
