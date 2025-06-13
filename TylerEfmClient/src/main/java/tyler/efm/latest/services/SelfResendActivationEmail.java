
package tyler.efm.latest.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.latest.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


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
 *         &lt;element name="SelfResendActivationEmailRequest" type="{urn:tyler:efm:services:schema:SelfResendActivationEmailRequest}SelfResendActivationEmailRequestType" minOccurs="0"/&gt;
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
    "selfResendActivationEmailRequest"
})
@XmlRootElement(name = "SelfResendActivationEmail")
public class SelfResendActivationEmail {

    @XmlElement(name = "SelfResendActivationEmailRequest")
    protected SelfResendActivationEmailRequestType selfResendActivationEmailRequest;

    /**
     * Gets the value of the selfResendActivationEmailRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SelfResendActivationEmailRequestType }
     *     
     */
    public SelfResendActivationEmailRequestType getSelfResendActivationEmailRequest() {
        return selfResendActivationEmailRequest;
    }

    /**
     * Sets the value of the selfResendActivationEmailRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelfResendActivationEmailRequestType }
     *     
     */
    public void setSelfResendActivationEmailRequest(SelfResendActivationEmailRequestType value) {
        this.selfResendActivationEmailRequest = value;
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
