
package gov.niem.niem.domains.jxdm._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.JurisdictionType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for StatuteType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="StatuteType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}StatuteCodeIdentification" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}StatuteCodeSectionIdentification" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}StatuteDescriptionText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}StatuteJurisdiction" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}StatuteLevelText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}StatuteOffenseIdentification" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
@XmlSeeAlso({
    tyler.ecf.extensions.criminal.StatuteType.class
})
public class StatuteType
    extends ComplexObjectType
{

    @XmlElement(name = "StatuteCodeIdentification", nillable = true)
    protected IdentificationType statuteCodeIdentification;
    @XmlElement(name = "StatuteCodeSectionIdentification", nillable = true)
    protected IdentificationType statuteCodeSectionIdentification;
    @XmlElement(name = "StatuteDescriptionText", nillable = true)
    protected TextType statuteDescriptionText;
    @XmlElement(name = "StatuteJurisdiction", nillable = true)
    protected JurisdictionType statuteJurisdiction;
    @XmlElement(name = "StatuteLevelText", nillable = true)
    protected TextType statuteLevelText;
    @XmlElement(name = "StatuteOffenseIdentification", nillable = true)
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
