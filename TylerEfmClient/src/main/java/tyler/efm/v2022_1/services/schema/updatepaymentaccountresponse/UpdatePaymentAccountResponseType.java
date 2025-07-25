
package tyler.efm.v2022_1.services.schema.updatepaymentaccountresponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.baseresponse.BaseResponseType;
import tyler.efm.v2022_1.services.schema.common.PaymentAccountLocationDetails;


/**
 * <p>Java class for UpdatePaymentAccountResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdatePaymentAccountResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentAccountID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:efm:services:schema:Common}PaymentAccountLocationDetails" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdatePaymentAccountResponseType", propOrder = {
    "paymentAccountID",
    "paymentAccountLocationDetails"
})
public class UpdatePaymentAccountResponseType
    extends BaseResponseType
{

    @XmlElement(name = "PaymentAccountID")
    protected String paymentAccountID;
    @XmlElement(name = "PaymentAccountLocationDetails", namespace = "urn:tyler:efm:services:schema:Common")
    protected PaymentAccountLocationDetails paymentAccountLocationDetails;

    /**
     * Gets the value of the paymentAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccountID() {
        return paymentAccountID;
    }

    /**
     * Sets the value of the paymentAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccountID(String value) {
        this.paymentAccountID = value;
    }

    /**
     * Gets the value of the paymentAccountLocationDetails property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentAccountLocationDetails }
     *     
     */
    public PaymentAccountLocationDetails getPaymentAccountLocationDetails() {
        return paymentAccountLocationDetails;
    }

    /**
     * Sets the value of the paymentAccountLocationDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentAccountLocationDetails }
     *     
     */
    public void setPaymentAccountLocationDetails(PaymentAccountLocationDetails value) {
        this.paymentAccountLocationDetails = value;
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
