
package tyler.efm.services.schema.resetpasswordrequest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.baserequest.BaseRequestType;


/**
 * <p>Java class for ResetPasswordRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResetPasswordRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseRequest}BaseRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PasswordAnswer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResetPasswordRequestType", propOrder = {
    "email",
    "passwordAnswer"
})
public class ResetPasswordRequestType
    extends BaseRequestType
{

    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "PasswordAnswer")
    protected String passwordAnswer;

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the passwordAnswer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPasswordAnswer() {
        return passwordAnswer;
    }

    /**
     * Sets the value of the passwordAnswer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPasswordAnswer(String value) {
        this.passwordAnswer = value;
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
