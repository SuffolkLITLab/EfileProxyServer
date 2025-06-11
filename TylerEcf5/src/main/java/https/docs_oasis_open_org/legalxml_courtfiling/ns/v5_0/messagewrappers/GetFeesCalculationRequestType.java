
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesrequest.GetFeesCalculationRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetFeesCalculationRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFeesCalculationRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesrequest}GetFeesCalculationRequestMessage"/&gt;
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
@XmlType(name = "GetFeesCalculationRequestType", propOrder = {
    "getFeesCalculationRequestMessage",
    "paymentMessage"
})
public class GetFeesCalculationRequestType {

    @XmlElement(name = "GetFeesCalculationRequestMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesrequest", required = true)
    protected GetFeesCalculationRequestMessageType getFeesCalculationRequestMessage;
    @XmlElement(name = "PaymentMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment")
    protected PaymentMessageType paymentMessage;

    /**
     * Gets the value of the getFeesCalculationRequestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetFeesCalculationRequestMessageType }
     *     
     */
    public GetFeesCalculationRequestMessageType getGetFeesCalculationRequestMessage() {
        return getFeesCalculationRequestMessage;
    }

    /**
     * Sets the value of the getFeesCalculationRequestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFeesCalculationRequestMessageType }
     *     
     */
    public void setGetFeesCalculationRequestMessage(GetFeesCalculationRequestMessageType value) {
        this.getFeesCalculationRequestMessage = value;
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
