
package tyler.efm.v2022_1.services.schema.paymentaccountlistresponse;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.baseresponse.BaseResponseType;
import tyler.efm.v2022_1.services.schema.common.PaymentAccountType;


/**
 * <p>Java class for PaymentAccountListResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentAccountListResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentAccount" type="{urn:tyler:efm:services:schema:Common}PaymentAccountType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAccountListResponseType", propOrder = {
    "paymentAccount"
})
public class PaymentAccountListResponseType
    extends BaseResponseType
{

    @XmlElement(name = "PaymentAccount")
    protected List<PaymentAccountType> paymentAccount;

    /**
     * Gets the value of the paymentAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the paymentAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentAccountType }
     * 
     * 
     */
    public List<PaymentAccountType> getPaymentAccount() {
        if (paymentAccount == null) {
            paymentAccount = new ArrayList<PaymentAccountType>();
        }
        return this.paymentAccount;
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
