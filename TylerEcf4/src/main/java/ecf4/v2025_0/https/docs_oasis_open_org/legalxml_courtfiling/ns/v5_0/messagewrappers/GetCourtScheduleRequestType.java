
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.schedulerequest.GetCourtScheduleRequestMessageType;


/**
 * <p>Java class for GetCourtScheduleRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCourtScheduleRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/schedulerequest}GetCourtScheduleRequestMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCourtScheduleRequestType", propOrder = {
    "getCourtScheduleRequestMessage"
})
public class GetCourtScheduleRequestType {

    @XmlElement(name = "GetCourtScheduleRequestMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/schedulerequest", required = true)
    protected GetCourtScheduleRequestMessageType getCourtScheduleRequestMessage;

    /**
     * Gets the value of the getCourtScheduleRequestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetCourtScheduleRequestMessageType }
     *     
     */
    public GetCourtScheduleRequestMessageType getGetCourtScheduleRequestMessage() {
        return getCourtScheduleRequestMessage;
    }

    /**
     * Sets the value of the getCourtScheduleRequestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCourtScheduleRequestMessageType }
     *     
     */
    public void setGetCourtScheduleRequestMessage(GetCourtScheduleRequestMessageType value) {
        this.getCourtScheduleRequestMessage = value;
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
