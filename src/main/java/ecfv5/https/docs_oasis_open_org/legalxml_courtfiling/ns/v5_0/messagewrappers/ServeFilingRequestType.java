
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.FilingMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ServeFilingRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServeFilingRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing}FilingMessage"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment}PaymentMessage" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServeFilingRequestType", propOrder = {
    "filingMessage",
    "paymentMessage"
})
public class ServeFilingRequestType {

    @XmlElement(name = "FilingMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", required = true)
    protected FilingMessageType filingMessage;
    @XmlElement(name = "PaymentMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment")
    protected PaymentMessageType paymentMessage;

    /**
     * Gets the value of the filingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link FilingMessageType }
     *     
     */
    public FilingMessageType getFilingMessage() {
        return filingMessage;
    }

    /**
     * Sets the value of the filingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingMessageType }
     *     
     */
    public void setFilingMessage(FilingMessageType value) {
        this.filingMessage = value;
    }

    /**
     * Gets the value of the paymentMessage property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMessageType }
     *     
     */
    public PaymentMessageType getPaymentMessage() {
        return paymentMessage;
    }

    /**
     * Sets the value of the paymentMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMessageType }
     *     
     */
    public void setPaymentMessage(PaymentMessageType value) {
        this.paymentMessage = value;
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
