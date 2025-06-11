
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.CancelFilingMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CancelFilingRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CancelFilingRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/cancel}CancelFilingMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelFilingRequestType", propOrder = {
    "cancelFilingMessage"
})
public class CancelFilingRequestType {

    @XmlElement(name = "CancelFilingMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/cancel", required = true)
    protected CancelFilingMessageType cancelFilingMessage;

    /**
     * Gets the value of the cancelFilingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link CancelFilingMessageType }
     *     
     */
    public CancelFilingMessageType getCancelFilingMessage() {
        return cancelFilingMessage;
    }

    /**
     * Sets the value of the cancelFilingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelFilingMessageType }
     *     
     */
    public void setCancelFilingMessage(CancelFilingMessageType value) {
        this.cancelFilingMessage = value;
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
