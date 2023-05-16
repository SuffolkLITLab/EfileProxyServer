
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RefundVoidChargeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RefundVoidChargeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RefundDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Amount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ReasonCodeID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Comment" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RefundVoidChargeType", propOrder = {
    "refundDate",
    "amount",
    "reasonCodeID",
    "comment"
})
public class RefundVoidChargeType {

    @XmlElement(name = "RefundDate")
    protected DateType refundDate;
    @XmlElement(name = "Amount")
    protected AmountType amount;
    @XmlElement(name = "ReasonCodeID")
    protected TextType reasonCodeID;
    @XmlElement(name = "Comment")
    protected TextType comment;

    /**
     * Gets the value of the refundDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getRefundDate() {
        return refundDate;
    }

    /**
     * Sets the value of the refundDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setRefundDate(DateType value) {
        this.refundDate = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmount(AmountType value) {
        this.amount = value;
    }

    /**
     * Gets the value of the reasonCodeID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getReasonCodeID() {
        return reasonCodeID;
    }

    /**
     * Sets the value of the reasonCodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setReasonCodeID(TextType value) {
        this.reasonCodeID = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setComment(TextType value) {
        this.comment = value;
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
