
package ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6;

import ecf4.v2025_0.gov.niem.release.niem.codes.fbi_ncic._4.PCOCodeType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.PersonType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a civil order protecting one individual from another.
 * 
 * <p>Java class for ProtectionOrderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProtectionOrderType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/6.0/}CourtOrderType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ProtectionOrderRestrictedPerson"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ProtectionOrderConditionText"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ProtectionOrderConditionAbstract"/&gt;
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
@XmlType(name = "ProtectionOrderType", propOrder = {
    "protectionOrderRestrictedPerson",
    "protectionOrderConditionText",
    "protectionOrderConditionAbstract"
})
public class ProtectionOrderType
    extends CourtOrderType
{

    @XmlElement(name = "ProtectionOrderRestrictedPerson", required = true)
    protected PersonType protectionOrderRestrictedPerson;
    @XmlElement(name = "ProtectionOrderConditionText", required = true)
    protected TextType protectionOrderConditionText;
    @XmlElementRef(name = "ProtectionOrderConditionAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", type = JAXBElement.class)
    protected JAXBElement<?> protectionOrderConditionAbstract;

    /**
     * Gets the value of the protectionOrderRestrictedPerson property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getProtectionOrderRestrictedPerson() {
        return protectionOrderRestrictedPerson;
    }

    /**
     * Sets the value of the protectionOrderRestrictedPerson property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setProtectionOrderRestrictedPerson(PersonType value) {
        this.protectionOrderRestrictedPerson = value;
    }

    /**
     * Gets the value of the protectionOrderConditionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getProtectionOrderConditionText() {
        return protectionOrderConditionText;
    }

    /**
     * Sets the value of the protectionOrderConditionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setProtectionOrderConditionText(TextType value) {
        this.protectionOrderConditionText = value;
    }

    /**
     * Gets the value of the protectionOrderConditionAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PCOCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getProtectionOrderConditionAbstract() {
        return protectionOrderConditionAbstract;
    }

    /**
     * Sets the value of the protectionOrderConditionAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PCOCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setProtectionOrderConditionAbstract(JAXBElement<?> value) {
        this.protectionOrderConditionAbstract = value;
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
