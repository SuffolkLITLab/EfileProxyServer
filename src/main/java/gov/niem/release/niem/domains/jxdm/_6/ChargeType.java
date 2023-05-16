
package gov.niem.release.niem.domains.jxdm._6;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.domains.humanservices._4.JuvenileAbuseNeglectAllegationType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.criminal.ChargeAugmentationType;
import tyler.ecf.v5_0.extensions.criminal.ChargeHistoryType;


/**
 * A data type for a formal allegation that a specific person has committed a specific offense.
 * 
 * <p>Java class for ChargeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChargeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeDegreeText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeDisposition" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeEnhancingAllegationCharge" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeEnhancingFactor" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeQualifierText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeSequenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeSeverityLevel" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeSpecialAllegationText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeStatute" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ChargeType", propOrder = {
    "chargeDegreeText",
    "chargeDescriptionText",
    "chargeDisposition",
    "chargeEnhancingAllegationCharge",
    "chargeEnhancingFactor",
    "chargeQualifierText",
    "chargeSequenceID",
    "chargeSeverityLevel",
    "chargeSpecialAllegationText",
    "chargeStatute",
    "chargeAugmentationPoint"
})
@XmlSeeAlso({
    JuvenileAbuseNeglectAllegationType.class,
    ChargeHistoryType.class
})
public class ChargeType
    extends ObjectType
{

    @XmlElement(name = "ChargeDegreeText")
    protected TextType chargeDegreeText;
    @XmlElement(name = "ChargeDescriptionText")
    protected TextType chargeDescriptionText;
    @XmlElement(name = "ChargeDisposition")
    protected ChargeDispositionType chargeDisposition;
    @XmlElement(name = "ChargeEnhancingAllegationCharge", nillable = true)
    protected ChargeType chargeEnhancingAllegationCharge;
    @XmlElement(name = "ChargeEnhancingFactor")
    protected ChargeEnhancingFactorType chargeEnhancingFactor;
    @XmlElement(name = "ChargeQualifierText")
    protected TextType chargeQualifierText;
    @XmlElement(name = "ChargeSequenceID")
    protected gov.niem.release.niem.proxy.xsd._4.String chargeSequenceID;
    @XmlElement(name = "ChargeSeverityLevel")
    protected SeverityLevelType chargeSeverityLevel;
    @XmlElement(name = "ChargeSpecialAllegationText")
    protected TextType chargeSpecialAllegationText;
    @XmlElement(name = "ChargeStatute", nillable = true)
    protected StatuteType chargeStatute;
    @XmlElementRef(name = "ChargeAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> chargeAugmentationPoint;

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
     * Gets the value of the chargeEnhancingFactor property.
     * 
     * @return
     *     possible object is
     *     {@link ChargeEnhancingFactorType }
     *     
     */
    public ChargeEnhancingFactorType getChargeEnhancingFactor() {
        return chargeEnhancingFactor;
    }

    /**
     * Sets the value of the chargeEnhancingFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeEnhancingFactorType }
     *     
     */
    public void setChargeEnhancingFactor(ChargeEnhancingFactorType value) {
        this.chargeEnhancingFactor = value;
    }

    /**
     * Gets the value of the chargeQualifierText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getChargeQualifierText() {
        return chargeQualifierText;
    }

    /**
     * Sets the value of the chargeQualifierText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setChargeQualifierText(TextType value) {
        this.chargeQualifierText = value;
    }

    /**
     * Gets the value of the chargeSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public gov.niem.release.niem.proxy.xsd._4.String getChargeSequenceID() {
        return chargeSequenceID;
    }

    /**
     * Sets the value of the chargeSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setChargeSequenceID(gov.niem.release.niem.proxy.xsd._4.String value) {
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
     *     {@link StatuteType }
     *     
     */
    public StatuteType getChargeStatute() {
        return chargeStatute;
    }

    /**
     * Sets the value of the chargeStatute property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatuteType }
     *     
     */
    public void setChargeStatute(StatuteType value) {
        this.chargeStatute = value;
    }

    /**
     * Gets the value of the chargeAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the chargeAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link ChargeAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getChargeAugmentationPoint() {
        if (chargeAugmentationPoint == null) {
            chargeAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.chargeAugmentationPoint;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
