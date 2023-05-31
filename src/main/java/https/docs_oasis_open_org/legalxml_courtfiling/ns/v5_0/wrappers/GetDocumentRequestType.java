
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentrequest.GetDocumentRequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetDocumentRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDocumentRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest}GetDocumentRequestMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetDocumentRequestType", propOrder = {
    "getDocumentRequestMessage"
})
public class GetDocumentRequestType {

    @XmlElement(name = "GetDocumentRequestMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest", required = true)
    protected GetDocumentRequestMessageType getDocumentRequestMessage;

    /**
     * Gets the value of the getDocumentRequestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetDocumentRequestMessageType }
     *     
     */
    public GetDocumentRequestMessageType getGetDocumentRequestMessage() {
        return getDocumentRequestMessage;
    }

    /**
     * Sets the value of the getDocumentRequestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetDocumentRequestMessageType }
     *     
     */
    public void setGetDocumentRequestMessage(GetDocumentRequestMessageType value) {
        this.getDocumentRequestMessage = value;
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
