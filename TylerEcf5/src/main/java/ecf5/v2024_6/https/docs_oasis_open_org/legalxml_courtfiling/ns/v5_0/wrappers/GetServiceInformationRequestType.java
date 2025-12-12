
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationrequest.GetServiceInformationRequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetServiceInformationRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceInformationRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationrequest}GetServiceInformationRequestMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceInformationRequestType", propOrder = {
    "getServiceInformationRequestMessage"
})
public class GetServiceInformationRequestType {

    @XmlElement(name = "GetServiceInformationRequestMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationrequest", required = true)
    protected GetServiceInformationRequestMessageType getServiceInformationRequestMessage;

    /**
     * Gets the value of the getServiceInformationRequestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetServiceInformationRequestMessageType }
     *     
     */
    public GetServiceInformationRequestMessageType getGetServiceInformationRequestMessage() {
        return getServiceInformationRequestMessage;
    }

    /**
     * Sets the value of the getServiceInformationRequestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetServiceInformationRequestMessageType }
     *     
     */
    public void setGetServiceInformationRequestMessage(GetServiceInformationRequestMessageType value) {
        this.getServiceInformationRequestMessage = value;
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
