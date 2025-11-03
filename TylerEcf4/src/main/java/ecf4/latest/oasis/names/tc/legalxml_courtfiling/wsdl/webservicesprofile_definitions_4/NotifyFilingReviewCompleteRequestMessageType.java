
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicFilingMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ReviewFilingCallbackMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Multi-part message type (required for conformance with WS-I Basic Profile 1.1
 * 
 * <p>Java class for NotifyFilingReviewCompleteRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyFilingReviewCompleteRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ElectronicFilingMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ReviewFilingCallbackMessage-4.0}ReviewFilingCallbackMessage"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentReceiptMessage-4.0}PaymentReceiptMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifyFilingReviewCompleteRequestMessageType", propOrder = {
    "reviewFilingCallbackMessage",
    "paymentReceiptMessage"
})
public class NotifyFilingReviewCompleteRequestMessageType
    extends ElectronicFilingMessageType
{

    @XmlElement(name = "ReviewFilingCallbackMessage", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ReviewFilingCallbackMessage-4.0", required = true)
    protected ReviewFilingCallbackMessageType reviewFilingCallbackMessage;
    @XmlElement(name = "PaymentReceiptMessage", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentReceiptMessage-4.0", required = true)
    protected PaymentMessageType paymentReceiptMessage;

    /**
     * Gets the value of the reviewFilingCallbackMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewFilingCallbackMessageType }
     *     
     */
    public ReviewFilingCallbackMessageType getReviewFilingCallbackMessage() {
        return reviewFilingCallbackMessage;
    }

    /**
     * Sets the value of the reviewFilingCallbackMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewFilingCallbackMessageType }
     *     
     */
    public void setReviewFilingCallbackMessage(ReviewFilingCallbackMessageType value) {
        this.reviewFilingCallbackMessage = value;
    }

    /**
     * Gets the value of the paymentReceiptMessage property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMessageType }
     *     
     */
    public PaymentMessageType getPaymentReceiptMessage() {
        return paymentReceiptMessage;
    }

    /**
     * Sets the value of the paymentReceiptMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMessageType }
     *     
     */
    public void setPaymentReceiptMessage(PaymentMessageType value) {
        this.paymentReceiptMessage = value;
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
