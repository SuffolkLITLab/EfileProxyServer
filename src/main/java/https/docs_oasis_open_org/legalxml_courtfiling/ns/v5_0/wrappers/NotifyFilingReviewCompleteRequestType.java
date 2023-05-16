
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reviewfilingcallback.NotifyFilingReviewCompleteMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for NotifyFilingReviewCompleteRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyFilingReviewCompleteRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reviewfilingcallback}NotifyFilingReviewCompleteMessage" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "NotifyFilingReviewCompleteRequestType", propOrder = {
    "notifyFilingReviewCompleteMessage",
    "paymentMessage"
})
public class NotifyFilingReviewCompleteRequestType {

    @XmlElement(name = "NotifyFilingReviewCompleteMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reviewfilingcallback", required = true)
    protected List<NotifyFilingReviewCompleteMessageType> notifyFilingReviewCompleteMessage;
    @XmlElement(name = "PaymentMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment")
    protected PaymentMessageType paymentMessage;

    /**
     * Gets the value of the notifyFilingReviewCompleteMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the notifyFilingReviewCompleteMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotifyFilingReviewCompleteMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NotifyFilingReviewCompleteMessageType }
     * 
     * 
     */
    public List<NotifyFilingReviewCompleteMessageType> getNotifyFilingReviewCompleteMessage() {
        if (notifyFilingReviewCompleteMessage == null) {
            notifyFilingReviewCompleteMessage = new ArrayList<NotifyFilingReviewCompleteMessageType>();
        }
        return this.notifyFilingReviewCompleteMessage;
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
