
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusresponse.GetFilingStatusResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetFilingStatusResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilingStatusResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusresponse}GetFilingStatusResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilingStatusResponseType", propOrder = {
    "getFilingStatusResponseMessage"
})
public class GetFilingStatusResponseType {

    @XmlElement(name = "GetFilingStatusResponseMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusresponse", required = true)
    protected GetFilingStatusResponseMessageType getFilingStatusResponseMessage;

    /**
     * Gets the value of the getFilingStatusResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilingStatusResponseMessageType }
     *     
     */
    public GetFilingStatusResponseMessageType getGetFilingStatusResponseMessage() {
        return getFilingStatusResponseMessage;
    }

    /**
     * Sets the value of the getFilingStatusResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilingStatusResponseMessageType }
     *     
     */
    public void setGetFilingStatusResponseMessage(GetFilingStatusResponseMessageType value) {
        this.getFilingStatusResponseMessage = value;
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
