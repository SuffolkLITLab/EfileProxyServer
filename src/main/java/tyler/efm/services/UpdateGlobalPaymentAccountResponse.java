
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType;


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
 *         &lt;element name="UpdateGlobalPaymentAccountResponse" type="{urn:tyler:efm:services:schema:UpdatePaymentAccountResponse}UpdatePaymentAccountResponseType" minOccurs="0"/&gt;
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
    "updateGlobalPaymentAccountResponse"
})
@XmlRootElement(name = "UpdateGlobalPaymentAccountResponse")
public class UpdateGlobalPaymentAccountResponse {

    @XmlElement(name = "UpdateGlobalPaymentAccountResponse")
    protected UpdatePaymentAccountResponseType updateGlobalPaymentAccountResponse;

    /**
     * Gets the value of the updateGlobalPaymentAccountResponse property.
     * 
     * @return
     *     possible object is
     *     {@link UpdatePaymentAccountResponseType }
     *     
     */
    public UpdatePaymentAccountResponseType getUpdateGlobalPaymentAccountResponse() {
        return updateGlobalPaymentAccountResponse;
    }

    /**
     * Sets the value of the updateGlobalPaymentAccountResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatePaymentAccountResponseType }
     *     
     */
    public void setUpdateGlobalPaymentAccountResponse(UpdatePaymentAccountResponseType value) {
        this.updateGlobalPaymentAccountResponse = value;
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
