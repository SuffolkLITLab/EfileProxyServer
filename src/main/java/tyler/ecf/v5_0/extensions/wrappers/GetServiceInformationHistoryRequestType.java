
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.serviceinformationhistory.GetServiceInformationHistoryMessageType;


/**
 * <p>Java class for GetServiceInformationHistoryRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceInformationHistoryRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:serviceinformationhistory}GetServiceInformationHistoryMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceInformationHistoryRequestType", propOrder = {
    "getServiceInformationHistoryMessage"
})
public class GetServiceInformationHistoryRequestType {

    @XmlElement(name = "GetServiceInformationHistoryMessage", namespace = "urn:tyler:ecf:v5.0:extensions:serviceinformationhistory", required = true)
    protected GetServiceInformationHistoryMessageType getServiceInformationHistoryMessage;

    /**
     * Gets the value of the getServiceInformationHistoryMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetServiceInformationHistoryMessageType }
     *     
     */
    public GetServiceInformationHistoryMessageType getGetServiceInformationHistoryMessage() {
        return getServiceInformationHistoryMessage;
    }

    /**
     * Sets the value of the getServiceInformationHistoryMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetServiceInformationHistoryMessageType }
     *     
     */
    public void setGetServiceInformationHistoryMessage(GetServiceInformationHistoryMessageType value) {
        this.getServiceInformationHistoryMessage = value;
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
