
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesresponse.GetFeesCalculationResponseMessageType;


/**
 * <p>Java class for GetFeesCalculationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFeesCalculationResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesresponse}GetFeesCalculationResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFeesCalculationResponseType", propOrder = {
    "getFeesCalculationResponseMessage"
})
public class GetFeesCalculationResponseType {

    @XmlElement(name = "GetFeesCalculationResponseMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesresponse", required = true)
    protected GetFeesCalculationResponseMessageType getFeesCalculationResponseMessage;

    /**
     * Gets the value of the getFeesCalculationResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetFeesCalculationResponseMessageType }
     *     
     */
    public GetFeesCalculationResponseMessageType getGetFeesCalculationResponseMessage() {
        return getFeesCalculationResponseMessage;
    }

    /**
     * Sets the value of the getFeesCalculationResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFeesCalculationResponseMessageType }
     *     
     */
    public void setGetFeesCalculationResponseMessage(GetFeesCalculationResponseMessageType value) {
        this.getFeesCalculationResponseMessage = value;
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
