
package tyler.efm.v2022_1.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentAccountTypeListResponse" type="{urn:tyler:efm:services:schema:PaymentAccountTypeListResponse}PaymentAccountTypeListResponseType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "paymentAccountTypeListResponse"
})
@XmlRootElement(name = "GetPaymentAccountTypeListResponse")
public class GetPaymentAccountTypeListResponse {

    @XmlElement(name = "PaymentAccountTypeListResponse")
    protected PaymentAccountTypeListResponseType paymentAccountTypeListResponse;

    /**
     * Gets the value of the paymentAccountTypeListResponse property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentAccountTypeListResponseType }
     *     
     */
    public PaymentAccountTypeListResponseType getPaymentAccountTypeListResponse() {
        return paymentAccountTypeListResponse;
    }

    /**
     * Sets the value of the paymentAccountTypeListResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentAccountTypeListResponseType }
     *     
     */
    public void setPaymentAccountTypeListResponse(PaymentAccountTypeListResponseType value) {
        this.paymentAccountTypeListResponse = value;
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
