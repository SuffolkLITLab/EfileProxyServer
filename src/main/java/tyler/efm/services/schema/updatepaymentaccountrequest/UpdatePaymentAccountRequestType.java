
package tyler.efm.services.schema.updatepaymentaccountrequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.baserequest.BaseRequestType;
import tyler.efm.services.schema.common.PaymentAccountType;


/**
 * <p>Java class for UpdatePaymentAccountRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdatePaymentAccountRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseRequest}BaseRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:efm:services:schema:Common}PaymentAccount" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdatePaymentAccountRequestType", propOrder = {
    "paymentAccount"
})
public class UpdatePaymentAccountRequestType
    extends BaseRequestType
{

    @XmlElement(name = "PaymentAccount", namespace = "urn:tyler:efm:services:schema:Common")
    protected PaymentAccountType paymentAccount;

    /**
     * Gets the value of the paymentAccount property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentAccountType }
     *     
     */
    public PaymentAccountType getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * Sets the value of the paymentAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentAccountType }
     *     
     */
    public void setPaymentAccount(PaymentAccountType value) {
        this.paymentAccount = value;
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
