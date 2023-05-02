
package tyler.efm.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType;


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
 *         &lt;element name="ResetPasswordResponse" type="{urn:tyler:efm:services:schema:ResetPasswordResponse}ResetPasswordResponseType" minOccurs="0"/&gt;
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
    "resetPasswordResponse"
})
@XmlRootElement(name = "ResetPasswordResponse")
public class ResetPasswordResponse {

    @XmlElement(name = "ResetPasswordResponse")
    protected ResetPasswordResponseType resetPasswordResponse;

    /**
     * Gets the value of the resetPasswordResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ResetPasswordResponseType }
     *     
     */
    public ResetPasswordResponseType getResetPasswordResponse() {
        return resetPasswordResponse;
    }

    /**
     * Sets the value of the resetPasswordResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResetPasswordResponseType }
     *     
     */
    public void setResetPasswordResponse(ResetPasswordResponseType value) {
        this.resetPasswordResponse = value;
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
