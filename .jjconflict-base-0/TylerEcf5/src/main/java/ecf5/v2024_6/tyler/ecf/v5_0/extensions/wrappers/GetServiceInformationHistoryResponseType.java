
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.serviceinformationhistoryresponse.GetServiceInformationHistoryResponseMessageType;


/**
 * <p>Java class for GetServiceInformationHistoryResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceInformationHistoryResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:serviceinformationhistoryresponse}GetServiceInformationHistoryResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceInformationHistoryResponseType", propOrder = {
    "getServiceInformationHistoryResponseMessage"
})
public class GetServiceInformationHistoryResponseType {

    @XmlElement(name = "GetServiceInformationHistoryResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:serviceinformationhistoryresponse", required = true)
    protected GetServiceInformationHistoryResponseMessageType getServiceInformationHistoryResponseMessage;

    /**
     * Gets the value of the getServiceInformationHistoryResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetServiceInformationHistoryResponseMessageType }
     *     
     */
    public GetServiceInformationHistoryResponseMessageType getGetServiceInformationHistoryResponseMessage() {
        return getServiceInformationHistoryResponseMessage;
    }

    /**
     * Sets the value of the getServiceInformationHistoryResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetServiceInformationHistoryResponseMessageType }
     *     
     */
    public void setGetServiceInformationHistoryResponseMessage(GetServiceInformationHistoryResponseMessageType value) {
        this.getServiceInformationHistoryResponseMessage = value;
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
