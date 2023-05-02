
package gov.niem.niem.domains.jxdm._4;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.fbi._2.OFFCodeType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ChargeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChargeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeApplicabilityText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeDegreeText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeDisposition" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeEnhancingAllegationCharge" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeNCICCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeSequenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeSeverityLevel" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeSpecialAllegationText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeStatute" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargeType", propOrder = {
    "chargeApplicabilityText",
    "chargeDegreeText",
    "chargeDescriptionText",
    "chargeDisposition",
    "chargeEnhancingAllegationCharge",
    "chargeNCICCode",
    "chargeSequenceID",
    "chargeSeverityLevel",
    "chargeSpecialAllegationText",
    "chargeStatute"
})
@XmlSeeAlso({
    oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.ChargeType.class
})
public class ChargeType
    extends ComplexObjectType
{

    @XmlElement(name = "ChargeApplicabilityText", nillable = true)
    protected TextType chargeApplicabilityText;
    @XmlElement(name = "ChargeDegreeText", nillable = true)
    protected TextType chargeDegreeText;
    @XmlElement(name = "ChargeDescriptionText", nillable = true)
    protected TextType chargeDescriptionText;
    @XmlElement(name = "ChargeDisposition", nillable = true)
    protected ChargeDispositionType chargeDisposition;
    @XmlElement(name = "ChargeEnhancingAllegationCharge", nillable = true)
    protected ChargeType chargeEnhancingAllegationCharge;
    @XmlElement(name = "ChargeNCICCode", nillable = true)
    protected OFFCodeType chargeNCICCode;
    @XmlElement(name = "ChargeSequenceID", nillable = true)
    protected IdentificationType chargeSequenceID;
    @XmlElement(name = "ChargeSeverityLevel", nillable = true)
    protected SeverityLevelType chargeSeverityLevel;
    @XmlElement(name = "ChargeSpecialAllegationText", nillable = true)
    protected TextType chargeSpecialAllegationText;
    @XmlElementRef(name = "ChargeStatute", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends gov.niem.niem.domains.jxdm._4.StatuteType> chargeStatute;

    /**
     * Gets the value of the chargeApplicabilityText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getChargeApplicabilityText() {
        return chargeApplicabilityText;
    }

    /**
     * Sets the value of the chargeApplicabilityText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setChargeApplicabilityText(TextType value) {
        this.chargeApplicabilityText = value;
    }

    /**
     * Gets the value of the chargeDegreeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getChargeDegreeText() {
        return chargeDegreeText;
    }

    /**
     * Sets the value of the chargeDegreeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setChargeDegreeText(TextType value) {
        this.chargeDegreeText = value;
    }

    /**
     * Gets the value of the chargeDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getChargeDescriptionText() {
        return chargeDescriptionText;
    }

    /**
     * Sets the value of the chargeDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setChargeDescriptionText(TextType value) {
        this.chargeDescriptionText = value;
    }

    /**
     * Gets the value of the chargeDisposition property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeDispositionType }
     *     
     */
    public ChargeDispositionType getChargeDisposition() {
        return chargeDisposition;
    }

    /**
     * Sets the value of the chargeDisposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeDispositionType }
     *     
     */
    public void setChargeDisposition(ChargeDispositionType value) {
        this.chargeDisposition = value;
    }

    /**
     * Gets the value of the chargeEnhancingAllegationCharge property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeType }
     *     
     */
    public ChargeType getChargeEnhancingAllegationCharge() {
        return chargeEnhancingAllegationCharge;
    }

    /**
     * Sets the value of the chargeEnhancingAllegationCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeType }
     *     
     */
    public void setChargeEnhancingAllegationCharge(ChargeType value) {
        this.chargeEnhancingAllegationCharge = value;
    }

    /**
     * Gets the value of the chargeNCICCode property.
     * 
     * @return
     *     possible object is
     *     {@link OFFCodeType }
     *     
     */
    public OFFCodeType getChargeNCICCode() {
        return chargeNCICCode;
    }

    /**
     * Sets the value of the chargeNCICCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link OFFCodeType }
     *     
     */
    public void setChargeNCICCode(OFFCodeType value) {
        this.chargeNCICCode = value;
    }

    /**
     * Gets the value of the chargeSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getChargeSequenceID() {
        return chargeSequenceID;
    }

    /**
     * Sets the value of the chargeSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setChargeSequenceID(IdentificationType value) {
        this.chargeSequenceID = value;
    }

    /**
     * Gets the value of the chargeSeverityLevel property.
     * 
     * @return
     *     possible object is
     *     {@link SeverityLevelType }
     *     
     */
    public SeverityLevelType getChargeSeverityLevel() {
        return chargeSeverityLevel;
    }

    /**
     * Sets the value of the chargeSeverityLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link SeverityLevelType }
     *     
     */
    public void setChargeSeverityLevel(SeverityLevelType value) {
        this.chargeSeverityLevel = value;
    }

    /**
     * Gets the value of the chargeSpecialAllegationText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getChargeSpecialAllegationText() {
        return chargeSpecialAllegationText;
    }

    /**
     * Sets the value of the chargeSpecialAllegationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setChargeSpecialAllegationText(TextType value) {
        this.chargeSpecialAllegationText = value;
    }

    /**
     * Gets the value of the chargeStatute property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.domains.jxdm._4.StatuteType }{@code >}
     *     {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.criminal.StatuteType }{@code >}
     *     
     */
    public JAXBElement<? extends gov.niem.niem.domains.jxdm._4.StatuteType> getChargeStatute() {
        return chargeStatute;
    }

    /**
     * Sets the value of the chargeStatute property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.domains.jxdm._4.StatuteType }{@code >}
     *     {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.criminal.StatuteType }{@code >}
     *     
     */
    public void setChargeStatute(JAXBElement<? extends gov.niem.niem.domains.jxdm._4.StatuteType> value) {
        this.chargeStatute = value;
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
