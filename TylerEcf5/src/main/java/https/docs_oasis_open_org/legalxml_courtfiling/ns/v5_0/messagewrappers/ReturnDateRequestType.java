
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.returndate.ReturnDateMessageType;


/**
 * <p>Java class for ReturnDateRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReturnDateRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:returndate}ReturnDateMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReturnDateRequestType", propOrder = {
    "returnDateMessage"
})
public class ReturnDateRequestType {

    @XmlElement(name = "ReturnDateMessage", namespace = "urn:tyler:ecf:v5.0:extensions:returndate", required = true)
    protected ReturnDateMessageType returnDateMessage;

    /**
     * Gets the value of the returnDateMessage property.
     * 
     * @return
     *     possible object is
     *     {@link ReturnDateMessageType }
     *     
     */
    public ReturnDateMessageType getReturnDateMessage() {
        return returnDateMessage;
    }

    /**
     * Sets the value of the returnDateMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReturnDateMessageType }
     *     
     */
    public void setReturnDateMessage(ReturnDateMessageType value) {
        this.returnDateMessage = value;
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
