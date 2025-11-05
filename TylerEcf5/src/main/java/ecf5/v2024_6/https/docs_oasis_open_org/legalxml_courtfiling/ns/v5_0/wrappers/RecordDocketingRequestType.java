
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.docket.RecordDocketingMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RecordDocketingRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordDocketingRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket}RecordDocketingMessage" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment}PaymentMessage" maxOccurs="2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordDocketingRequestType", propOrder = {
    "recordDocketingMessage",
    "paymentMessage"
})
public class RecordDocketingRequestType {

    @XmlElement(name = "RecordDocketingMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", required = true)
    protected List<RecordDocketingMessageType> recordDocketingMessage;
    @XmlElement(name = "PaymentMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/payment")
    protected List<PaymentMessageType> paymentMessage;

    /**
     * Gets the value of the recordDocketingMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the recordDocketingMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordDocketingMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordDocketingMessageType }
     * 
     * 
     */
    public List<RecordDocketingMessageType> getRecordDocketingMessage() {
        if (recordDocketingMessage == null) {
            recordDocketingMessage = new ArrayList<RecordDocketingMessageType>();
        }
        return this.recordDocketingMessage;
    }

    /**
     * Gets the value of the paymentMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the paymentMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentMessageType }
     * 
     * 
     */
    public List<PaymentMessageType> getPaymentMessage() {
        if (paymentMessage == null) {
            paymentMessage = new ArrayList<PaymentMessageType>();
        }
        return this.paymentMessage;
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
