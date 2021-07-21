
package oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Multi-part message type (required for conformance with WS-I Basic Profile 1.1
 * 
 * <p>Java class for ReviewFilingRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviewFilingRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ElectronicFilingMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0}CoreFilingMessage"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0}PaymentMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReviewFilingRequestMessageType", propOrder = {
    "coreFilingMessage",
    "paymentMessage"
})
public class ReviewFilingRequestMessageType
    extends ElectronicFilingMessageType
{

    @XmlElement(name = "CoreFilingMessage", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", required = true)
    protected CoreFilingMessageType coreFilingMessage;
    @XmlElement(name = "PaymentMessage", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:PaymentMessage-4.0", required = true)
    protected PaymentMessageType paymentMessage;

    /**
     * Gets the value of the coreFilingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link CoreFilingMessageType }
     *     
     */
    public CoreFilingMessageType getCoreFilingMessage() {
        return coreFilingMessage;
    }

    /**
     * Sets the value of the coreFilingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoreFilingMessageType }
     *     
     */
    public void setCoreFilingMessage(CoreFilingMessageType value) {
        this.coreFilingMessage = value;
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
