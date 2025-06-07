
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.filingservicerequest.GetFilingServiceMessageType;


/**
 * <p>Java class for GetFilingServiceRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilingServiceRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:filingservicerequest}GetFilingServiceMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilingServiceRequestType", propOrder = {
    "getFilingServiceMessage"
})
public class GetFilingServiceRequestType {

    @XmlElement(name = "GetFilingServiceMessage", namespace = "urn:tyler:ecf:v5.0:extensions:filingservicerequest", required = true)
    protected GetFilingServiceMessageType getFilingServiceMessage;

    /**
     * Gets the value of the getFilingServiceMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilingServiceMessageType }
     *     
     */
    public GetFilingServiceMessageType getGetFilingServiceMessage() {
        return getFilingServiceMessage;
    }

    /**
     * Sets the value of the getFilingServiceMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilingServiceMessageType }
     *     
     */
    public void setGetFilingServiceMessage(GetFilingServiceMessageType value) {
        this.getFilingServiceMessage = value;
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
