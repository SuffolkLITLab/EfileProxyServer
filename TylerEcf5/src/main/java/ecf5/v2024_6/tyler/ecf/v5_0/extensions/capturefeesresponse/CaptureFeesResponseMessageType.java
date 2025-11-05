
package tyler.ecf.v5_0.extensions.capturefeesresponse;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The response to a CaptureFeesMessage, which may either be 0 indicating no fee is due, a currency amount indicating the fee due upon filing, or unknown indicating that the court case management information system is unable to calculate the fee for the proposed filing.
 * 
 * <p>Java class for CaptureFeesResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaptureFeesResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Payment" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:capturefeesresponse}CaptureFeesResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaptureFeesResponseMessageType", propOrder = {
    "payment",
    "captureFeesResponseMessageAugmentationPoint"
})
public class CaptureFeesResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(name = "Payment", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    protected List<PaymentType> payment;
    @XmlElement(name = "CaptureFeesResponseMessageAugmentationPoint")
    protected List<Object> captureFeesResponseMessageAugmentationPoint;

    /**
     * Gets the value of the payment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the payment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentType }
     * 
     * 
     */
    public List<PaymentType> getPayment() {
        if (payment == null) {
            payment = new ArrayList<PaymentType>();
        }
        return this.payment;
    }

    /**
     * Gets the value of the captureFeesResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the captureFeesResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaptureFeesResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getCaptureFeesResponseMessageAugmentationPoint() {
        if (captureFeesResponseMessageAugmentationPoint == null) {
            captureFeesResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.captureFeesResponseMessageAugmentationPoint;
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
