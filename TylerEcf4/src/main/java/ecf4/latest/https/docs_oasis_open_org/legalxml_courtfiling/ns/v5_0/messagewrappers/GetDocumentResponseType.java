
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentresponse.GetDocumentResponseMessageType;


/**
 * <p>Java class for GetDocumentResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDocumentResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentresponse}GetDocumentResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDocumentResponseType", propOrder = {
    "getDocumentResponseMessage"
})
public class GetDocumentResponseType {

    @XmlElement(name = "GetDocumentResponseMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentresponse", required = true)
    protected GetDocumentResponseMessageType getDocumentResponseMessage;

    /**
     * Gets the value of the getDocumentResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetDocumentResponseMessageType }
     *     
     */
    public GetDocumentResponseMessageType getGetDocumentResponseMessage() {
        return getDocumentResponseMessage;
    }

    /**
     * Sets the value of the getDocumentResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetDocumentResponseMessageType }
     *     
     */
    public void setGetDocumentResponseMessage(GetDocumentResponseMessageType value) {
        this.getDocumentResponseMessage = value;
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
