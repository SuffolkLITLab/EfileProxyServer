
package ecf4.latest.gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.fbi._2.EYECodeType;
import ecf4.latest.gov.niem.niem.fbi._2.EthnicityCodeType;
import ecf4.latest.gov.niem.niem.fbi._2.HAICodeType;
import ecf4.latest.gov.niem.niem.fbi._2.RACCodeType;
import ecf4.latest.gov.niem.niem.fbi._2.SEXCodeType;
import ecf4.latest.gov.niem.niem.fips_10_4._2.CountryCodeType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import ecf4.latest.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonBirthDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonCapability" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonCitizenship" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonDNA" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonEthnicity" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonEyeColor" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonFingerprintSet" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonHairColor" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonHeightMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonLanguageEnglishIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonOtherIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonPhysicalFeature" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonPrimaryLanguage" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonRace" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonSex" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonStateIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonTaxIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonWeightMeasure" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonType", propOrder = {
    "personBirthDate",
    "personCapability",
    "personCitizenship",
    "personDNA",
    "personEthnicity",
    "personEyeColor",
    "personFingerprintSet",
    "personHairColor",
    "personHeightMeasure",
    "personLanguageEnglishIndicator",
    "personName",
    "personOtherIdentification",
    "personPhysicalFeature",
    "personPrimaryLanguage",
    "personRace",
    "personSex",
    "personStateIdentification",
    "personTaxIdentification",
    "personWeightMeasure"
})
@XmlSeeAlso({
    ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType.class
})
public class PersonType
    extends ComplexObjectType
{

    @XmlElement(name = "PersonBirthDate", nillable = true)
    protected DateType personBirthDate;
    @XmlElementRef(name = "PersonCapability", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends ecf4.latest.gov.niem.niem.niem_core._2.CapabilityType> personCapability;
    @XmlElementRef(name = "PersonCitizenship", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> personCitizenship;
    @XmlElement(name = "PersonDNA", nillable = true)
    protected DNAType personDNA;
    @XmlElementRef(name = "PersonEthnicity", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personEthnicity;
    @XmlElementRef(name = "PersonEyeColor", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personEyeColor;
    @XmlElement(name = "PersonFingerprintSet", nillable = true)
    protected List<FingerprintSetType> personFingerprintSet;
    @XmlElementRef(name = "PersonHairColor", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personHairColor;
    @XmlElement(name = "PersonHeightMeasure", nillable = true)
    protected LengthMeasureType personHeightMeasure;
    @XmlElement(name = "PersonLanguageEnglishIndicator", nillable = true)
    protected Boolean personLanguageEnglishIndicator;
    @XmlElement(name = "PersonName", nillable = true)
    protected PersonNameType personName;
    @XmlElement(name = "PersonOtherIdentification", nillable = true)
    protected List<IdentificationType> personOtherIdentification;
    @XmlElement(name = "PersonPhysicalFeature", nillable = true)
    protected List<PhysicalFeatureType> personPhysicalFeature;
    @XmlElement(name = "PersonPrimaryLanguage", nillable = true)
    protected PersonLanguageType personPrimaryLanguage;
    @XmlElementRef(name = "PersonRace", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personRace;
    @XmlElementRef(name = "PersonSex", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personSex;
    @XmlElement(name = "PersonStateIdentification", nillable = true)
    protected IdentificationType personStateIdentification;
    @XmlElement(name = "PersonTaxIdentification", nillable = true)
    protected IdentificationType personTaxIdentification;
    @XmlElement(name = "PersonWeightMeasure", nillable = true)
    protected WeightMeasureType personWeightMeasure;

    /**
     * Gets the value of the personBirthDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getPersonBirthDate() {
        return personBirthDate;
    }

    /**
     * Sets the value of the personBirthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setPersonBirthDate(DateType value) {
        this.personBirthDate = value;
    }

    /**
     * Gets the value of the personCapability property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ecf4.latest.gov.niem.niem.niem_core._2.CapabilityType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ecf4.latest.tyler.ecf.extensions.common.CapabilityType }{@code >}
     *     
     */
    public JAXBElement<? extends ecf4.latest.gov.niem.niem.niem_core._2.CapabilityType> getPersonCapability() {
        return personCapability;
    }

    /**
     * Sets the value of the personCapability property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ecf4.latest.gov.niem.niem.niem_core._2.CapabilityType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ecf4.latest.tyler.ecf.extensions.common.CapabilityType }{@code >}
     *     
     */
    public void setPersonCapability(JAXBElement<? extends ecf4.latest.gov.niem.niem.niem_core._2.CapabilityType> value) {
        this.personCapability = value;
    }

    /**
     * Gets the value of the personCitizenship property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personCitizenship property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonCitizenship().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getPersonCitizenship() {
        if (personCitizenship == null) {
            personCitizenship = new ArrayList<JAXBElement<?>>();
        }
        return this.personCitizenship;
    }

    /**
     * Gets the value of the personDNA property.
     * 
     * @return
     *     possible object is
     *     {@link DNAType }
     *     
     */
    public DNAType getPersonDNA() {
        return personDNA;
    }

    /**
     * Sets the value of the personDNA property.
     * 
     * @param value
     *     allowed object is
     *     {@link DNAType }
     *     
     */
    public void setPersonDNA(DNAType value) {
        this.personDNA = value;
    }

    /**
     * Gets the value of the personEthnicity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonEthnicity() {
        return personEthnicity;
    }

    /**
     * Sets the value of the personEthnicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonEthnicity(JAXBElement<?> value) {
        this.personEthnicity = value;
    }

    /**
     * Gets the value of the personEyeColor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EYECodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonEyeColor() {
        return personEyeColor;
    }

    /**
     * Sets the value of the personEyeColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EYECodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonEyeColor(JAXBElement<?> value) {
        this.personEyeColor = value;
    }

    /**
     * Gets the value of the personFingerprintSet property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personFingerprintSet property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonFingerprintSet().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FingerprintSetType }
     * 
     * 
     */
    public List<FingerprintSetType> getPersonFingerprintSet() {
        if (personFingerprintSet == null) {
            personFingerprintSet = new ArrayList<FingerprintSetType>();
        }
        return this.personFingerprintSet;
    }

    /**
     * Gets the value of the personHairColor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HAICodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonHairColor() {
        return personHairColor;
    }

    /**
     * Sets the value of the personHairColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HAICodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonHairColor(JAXBElement<?> value) {
        this.personHairColor = value;
    }

    /**
     * Gets the value of the personHeightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link LengthMeasureType }
     *     
     */
    public LengthMeasureType getPersonHeightMeasure() {
        return personHeightMeasure;
    }

    /**
     * Sets the value of the personHeightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link LengthMeasureType }
     *     
     */
    public void setPersonHeightMeasure(LengthMeasureType value) {
        this.personHeightMeasure = value;
    }

    /**
     * Gets the value of the personLanguageEnglishIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getPersonLanguageEnglishIndicator() {
        return personLanguageEnglishIndicator;
    }

    /**
     * Sets the value of the personLanguageEnglishIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPersonLanguageEnglishIndicator(Boolean value) {
        this.personLanguageEnglishIndicator = value;
    }

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameType }
     *     
     */
    public PersonNameType getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameType }
     *     
     */
    public void setPersonName(PersonNameType value) {
        this.personName = value;
    }

    /**
     * Gets the value of the personOtherIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personOtherIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonOtherIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getPersonOtherIdentification() {
        if (personOtherIdentification == null) {
            personOtherIdentification = new ArrayList<IdentificationType>();
        }
        return this.personOtherIdentification;
    }

    /**
     * Gets the value of the personPhysicalFeature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personPhysicalFeature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonPhysicalFeature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalFeatureType }
     * 
     * 
     */
    public List<PhysicalFeatureType> getPersonPhysicalFeature() {
        if (personPhysicalFeature == null) {
            personPhysicalFeature = new ArrayList<PhysicalFeatureType>();
        }
        return this.personPhysicalFeature;
    }

    /**
     * Gets the value of the personPrimaryLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link PersonLanguageType }
     *     
     */
    public PersonLanguageType getPersonPrimaryLanguage() {
        return personPrimaryLanguage;
    }

    /**
     * Sets the value of the personPrimaryLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonLanguageType }
     *     
     */
    public void setPersonPrimaryLanguage(PersonLanguageType value) {
        this.personPrimaryLanguage = value;
    }

    /**
     * Gets the value of the personRace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RACCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonRace() {
        return personRace;
    }

    /**
     * Sets the value of the personRace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RACCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonRace(JAXBElement<?> value) {
        this.personRace = value;
    }

    /**
     * Gets the value of the personSex property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonSex() {
        return personSex;
    }

    /**
     * Sets the value of the personSex property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonSex(JAXBElement<?> value) {
        this.personSex = value;
    }

    /**
     * Gets the value of the personStateIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPersonStateIdentification() {
        return personStateIdentification;
    }

    /**
     * Sets the value of the personStateIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPersonStateIdentification(IdentificationType value) {
        this.personStateIdentification = value;
    }

    /**
     * Gets the value of the personTaxIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPersonTaxIdentification() {
        return personTaxIdentification;
    }

    /**
     * Sets the value of the personTaxIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPersonTaxIdentification(IdentificationType value) {
        this.personTaxIdentification = value;
    }

    /**
     * Gets the value of the personWeightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link WeightMeasureType }
     *     
     */
    public WeightMeasureType getPersonWeightMeasure() {
        return personWeightMeasure;
    }

    /**
     * Sets the value of the personWeightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeightMeasureType }
     *     
     */
    public void setPersonWeightMeasure(WeightMeasureType value) {
        this.personWeightMeasure = value;
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
