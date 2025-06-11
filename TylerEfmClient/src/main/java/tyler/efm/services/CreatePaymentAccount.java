
package tyler.efm.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;


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
 *         &lt;element name="CreatePaymentAccountRequest" type="{urn:tyler:efm:services:schema:CreatePaymentAccountRequest}CreatePaymentAccountRequestType" minOccurs="0"/&gt;
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
    "createPaymentAccountRequest"
})
@XmlRootElement(name = "CreatePaymentAccount")
public class CreatePaymentAccount {

    @XmlElement(name = "CreatePaymentAccountRequest")
    protected CreatePaymentAccountRequestType createPaymentAccountRequest;

    /**
     * Gets the value of the createPaymentAccountRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CreatePaymentAccountRequestType }
     *     
     */
    public CreatePaymentAccountRequestType getCreatePaymentAccountRequest() {
        return createPaymentAccountRequest;
    }

    /**
     * Sets the value of the createPaymentAccountRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreatePaymentAccountRequestType }
     *     
     */
    public void setCreatePaymentAccountRequest(CreatePaymentAccountRequestType value) {
        this.createPaymentAccountRequest = value;
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
