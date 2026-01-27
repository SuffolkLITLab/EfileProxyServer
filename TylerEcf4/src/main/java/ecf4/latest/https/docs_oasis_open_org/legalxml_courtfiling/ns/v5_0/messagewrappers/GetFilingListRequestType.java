
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistrequest.GetFilingListRequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetFilingListRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilingListRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filinglistrequest}GetFilingListRequestMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFilingListRequestType", propOrder = {
    "getFilingListRequestMessage"
})
public class GetFilingListRequestType {

    @XmlElement(name = "GetFilingListRequestMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filinglistrequest", required = true)
    protected GetFilingListRequestMessageType getFilingListRequestMessage;

    /**
     * Gets the value of the getFilingListRequestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetFilingListRequestMessageType }
     *     
     */
    public GetFilingListRequestMessageType getGetFilingListRequestMessage() {
        return getFilingListRequestMessage;
    }

    /**
     * Sets the value of the getFilingListRequestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFilingListRequestMessageType }
     *     
     */
    public void setGetFilingListRequestMessage(GetFilingListRequestMessageType value) {
        this.getFilingListRequestMessage = value;
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
