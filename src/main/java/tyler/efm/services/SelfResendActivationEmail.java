
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="SelfResendActivationEmailRequest" type="{urn:tyler:efm:services:schema:SelfResendActivationEmailRequest}SelfResendActivationEmailRequestType" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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

}
