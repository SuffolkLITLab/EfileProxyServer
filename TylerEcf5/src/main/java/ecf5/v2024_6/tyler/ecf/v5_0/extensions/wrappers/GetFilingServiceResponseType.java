
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.filingserviceresponse.GetFilingServiceResponseMessageType;


/**
 * <p>Java class for GetFilingServiceResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilingServiceResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:filingserviceresponse}GetFilingServiceResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilingServiceResponseType", propOrder = {
    "getFilingServiceResponseMessage"
})
public class GetFilingServiceResponseType {

    @XmlElement(name = "GetFilingServiceResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:filingserviceresponse", required = true)
    protected GetFilingServiceResponseMessageType getFilingServiceResponseMessage;

    /**
     * Gets the value of the getFilingServiceResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilingServiceResponseMessageType }
     *     
     */
    public GetFilingServiceResponseMessageType getGetFilingServiceResponseMessage() {
        return getFilingServiceResponseMessage;
    }

    /**
     * Sets the value of the getFilingServiceResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilingServiceResponseMessageType }
     *     
     */
    public void setGetFilingServiceResponseMessage(GetFilingServiceResponseMessageType value) {
        this.getFilingServiceResponseMessage = value;
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
