
package ecf4.latest.gov.niem.release.niem.domains.jxdm._6;

import ecf4.latest.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.JurisdictionType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.latest.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a law, rule, or ordinance within a jurisdiction.
 * 
 * <p>Java class for StatuteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatuteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}StatuteCodeIdentification"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}StatuteCodeSectionIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}StatuteDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}StatuteJurisdiction" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}StatuteLevelText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}StatuteOffenseIdentification"/&gt;
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
@XmlType(name = "StatuteType", propOrder = {
    "statuteCodeIdentification",
    "statuteCodeSectionIdentification",
    "statuteDescriptionText",
    "statuteJurisdiction",
    "statuteLevelText",
    "statuteOffenseIdentification"
})
public class StatuteType
    extends ObjectType
{

    @XmlElement(name = "StatuteCodeIdentification", required = true)
    protected IdentificationType statuteCodeIdentification;
    @XmlElement(name = "StatuteCodeSectionIdentification")
    protected IdentificationType statuteCodeSectionIdentification;
    @XmlElement(name = "StatuteDescriptionText")
    protected TextType statuteDescriptionText;
    @XmlElement(name = "StatuteJurisdiction")
    protected JurisdictionType statuteJurisdiction;
    @XmlElement(name = "StatuteLevelText")
    protected TextType statuteLevelText;
    @XmlElement(name = "StatuteOffenseIdentification", required = true)
    protected IdentificationType statuteOffenseIdentification;

    /**
     * Gets the value of the statuteCodeIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getStatuteCodeIdentification() {
        return statuteCodeIdentification;
    }

    /**
     * Sets the value of the statuteCodeIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setStatuteCodeIdentification(IdentificationType value) {
        this.statuteCodeIdentification = value;
    }

    /**
     * Gets the value of the statuteCodeSectionIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getStatuteCodeSectionIdentification() {
        return statuteCodeSectionIdentification;
    }

    /**
     * Sets the value of the statuteCodeSectionIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setStatuteCodeSectionIdentification(IdentificationType value) {
        this.statuteCodeSectionIdentification = value;
    }

    /**
     * Gets the value of the statuteDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStatuteDescriptionText() {
        return statuteDescriptionText;
    }

    /**
     * Sets the value of the statuteDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStatuteDescriptionText(TextType value) {
        this.statuteDescriptionText = value;
    }

    /**
     * Gets the value of the statuteJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link JurisdictionType }
     *     
     */
    public JurisdictionType getStatuteJurisdiction() {
        return statuteJurisdiction;
    }

    /**
     * Sets the value of the statuteJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JurisdictionType }
     *     
     */
    public void setStatuteJurisdiction(JurisdictionType value) {
        this.statuteJurisdiction = value;
    }

    /**
     * Gets the value of the statuteLevelText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStatuteLevelText() {
        return statuteLevelText;
    }

    /**
     * Sets the value of the statuteLevelText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStatuteLevelText(TextType value) {
        this.statuteLevelText = value;
    }

    /**
     * Gets the value of the statuteOffenseIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getStatuteOffenseIdentification() {
        return statuteOffenseIdentification;
    }

    /**
     * Sets the value of the statuteOffenseIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setStatuteOffenseIdentification(IdentificationType value) {
        this.statuteOffenseIdentification = value;
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
