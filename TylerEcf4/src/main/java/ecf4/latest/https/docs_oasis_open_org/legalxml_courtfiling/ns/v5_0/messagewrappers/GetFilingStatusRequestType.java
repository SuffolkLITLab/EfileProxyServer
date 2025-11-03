
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest.GetFilingStatusRequestMessageType;


/**
 * <p>Java class for GetFilingStatusRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilingStatusRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest}GetFilingStatusRequestMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilingStatusRequestType", propOrder = {
    "getFilingStatusRequestMessage"
})
public class GetFilingStatusRequestType {

    @XmlElement(name = "GetFilingStatusRequestMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest", required = true)
    protected GetFilingStatusRequestMessageType getFilingStatusRequestMessage;

    /**
     * Gets the value of the getFilingStatusRequestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilingStatusRequestMessageType }
     *     
     */
    public GetFilingStatusRequestMessageType getGetFilingStatusRequestMessage() {
        return getFilingStatusRequestMessage;
    }

    /**
     * Sets the value of the getFilingStatusRequestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilingStatusRequestMessageType }
     *     
     */
    public void setGetFilingStatusRequestMessage(GetFilingStatusRequestMessageType value) {
        this.getFilingStatusRequestMessage = value;
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
