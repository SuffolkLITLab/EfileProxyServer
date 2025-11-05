
package ecf5.v2024_6.gov.niem.release.niem.domains.cbrn._4;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type that provides information about the point in the xml payload content of a message where an error occurred in processing the message.
 * 
 * <p>Java class for MessageContentErrorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageContentErrorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.1/}ErrorNodeName"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.1/}ErrorDescription"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageContentErrorType", propOrder = {
    "errorNodeName",
    "errorDescription"
})
public class MessageContentErrorType
    extends ObjectType
{

    @XmlElement(name = "ErrorNodeName", required = true)
    protected TextType errorNodeName;
    @XmlElement(name = "ErrorDescription", required = true)
    protected MessageErrorType errorDescription;

    /**
     * Gets the value of the errorNodeName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getErrorNodeName() {
        return errorNodeName;
    }

    /**
     * Sets the value of the errorNodeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setErrorNodeName(TextType value) {
        this.errorNodeName = value;
    }

    /**
     * Gets the value of the errorDescription property.
     * 
     * @return
     *     possible object is
     *     {@link MessageErrorType }
     *     
     */
    public MessageErrorType getErrorDescription() {
        return errorDescription;
    }

    /**
     * Sets the value of the errorDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageErrorType }
     *     
     */
    public void setErrorDescription(MessageErrorType value) {
        this.errorDescription = value;
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
