
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationresponse.GetServiceInformationResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetServiceInformationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceInformationResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse}GetServiceInformationResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetServiceInformationResponseType", propOrder = {
    "getServiceInformationResponseMessage"
})
public class GetServiceInformationResponseType {

    @XmlElement(name = "GetServiceInformationResponseMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse", required = true)
    protected GetServiceInformationResponseMessageType getServiceInformationResponseMessage;

    /**
     * Gets the value of the getServiceInformationResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetServiceInformationResponseMessageType }
     *     
     */
    public GetServiceInformationResponseMessageType getGetServiceInformationResponseMessage() {
        return getServiceInformationResponseMessage;
    }

    /**
     * Sets the value of the getServiceInformationResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetServiceInformationResponseMessageType }
     *     
     */
    public void setGetServiceInformationResponseMessage(GetServiceInformationResponseMessageType value) {
        this.getServiceInformationResponseMessage = value;
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
