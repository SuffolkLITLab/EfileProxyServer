
package ecf4.latest.gov.niem.release.niem.domains.cbrn._4;

import ecf4.latest.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.latest.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type that describes a message error.
 * 
 * <p>Java class for MessageErrorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageErrorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}ErrorCodeText"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}ErrorCodeDescriptionText" minOccurs="0"/&gt;
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
@XmlType(name = "MessageErrorType", propOrder = {
    "errorCodeText",
    "errorCodeDescriptionText"
})
public class MessageErrorType
    extends ObjectType
{

    @XmlElement(name = "ErrorCodeText", required = true)
    protected TextType errorCodeText;
    @XmlElement(name = "ErrorCodeDescriptionText")
    protected TextType errorCodeDescriptionText;

    /**
     * Gets the value of the errorCodeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getErrorCodeText() {
        return errorCodeText;
    }

    /**
     * Sets the value of the errorCodeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setErrorCodeText(TextType value) {
        this.errorCodeText = value;
    }

    /**
     * Gets the value of the errorCodeDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getErrorCodeDescriptionText() {
        return errorCodeDescriptionText;
    }

    /**
     * Sets the value of the errorCodeDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setErrorCodeDescriptionText(TextType value) {
        this.errorCodeDescriptionText = value;
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
