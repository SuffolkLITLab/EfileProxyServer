
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;


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
 *         &lt;element name="ResetUserPasswordRequest" type="{urn:tyler:efm:services:schema:ResetUserPasswordRequest}ResetUserPasswordRequestType" minOccurs="0"/&gt;
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
    "resetUserPasswordRequest"
})
@XmlRootElement(name = "ResetUserPassword")
public class ResetUserPassword {

    @XmlElement(name = "ResetUserPasswordRequest")
    protected ResetUserPasswordRequestType resetUserPasswordRequest;

    /**
     * Gets the value of the resetUserPasswordRequest property.
     * 
     * @return
     *     possible object is
     *     {@link ResetUserPasswordRequestType }
     *     
     */
    public ResetUserPasswordRequestType getResetUserPasswordRequest() {
        return resetUserPasswordRequest;
    }

    /**
     * Sets the value of the resetUserPasswordRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResetUserPasswordRequestType }
     *     
     */
    public void setResetUserPasswordRequest(ResetUserPasswordRequestType value) {
        this.resetUserPasswordRequest = value;
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
