
package gov.niem.release.niem.niem_core._4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.codes.fbi_ncic._4.EYECodeType;
import gov.niem.release.niem.codes.fbi_ncic._4.HAIRCodeType;
import gov.niem.release.niem.codes.fbi_ncic._4.RACECodeType;
import gov.niem.release.niem.codes.fbi_ncic._4.SEXCodeType;
import gov.niem.release.niem.codes.fbi_ucr._4.EthnicityCodeType;
import gov.niem.release.niem.codes.iso_3166_1._4.CountryAlpha2CodeType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.common.FilerAugmentationType;


/**
 * A data type for a human being.
 * 
 * <p>Java class for PersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonBirthDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonCapability" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonCitizenshipAbstract" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonEthnicityAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonEyeColorAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonHairColorAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonHeightMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonLanguageEnglishIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonOtherIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonPhysicalFeature" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonPrimaryLanguage" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonRaceAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonSexAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonStateIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonTaxIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonWeightMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "PersonType", propOrder = {
    "personBirthDate",
    "personCapability",
    "personCitizenshipAbstract",
    "personEthnicityAbstract",
    "personEyeColorAbstract",
    "personHairColorAbstract",
    "personHeightMeasure",
    "personLanguageEnglishIndicator",
    "personName",
    "personOtherIdentification",
    "personPhysicalFeature",
    "personPrimaryLanguage",
    "personRaceAbstract",
    "personSexAbstract",
    "personStateIdentification",
    "personTaxIdentification",
    "personWeightMeasure",
    "personAugmentationPoint"
})
public class PersonType
    extends ObjectType
{

    @XmlElement(name = "PersonBirthDate")
    protected DateType personBirthDate;
    @XmlElement(name = "PersonCapability")
    protected List<CapabilityType> personCapability;
    @XmlElementRef(name = "PersonCitizenshipAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> personCitizenshipAbstract;
    @XmlElementRef(name = "PersonEthnicityAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personEthnicityAbstract;
    @XmlElementRef(name = "PersonEyeColorAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personEyeColorAbstract;
    @XmlElementRef(name = "PersonHairColorAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personHairColorAbstract;
    @XmlElement(name = "PersonHeightMeasure")
    protected LengthMeasureType personHeightMeasure;
    @XmlElement(name = "PersonLanguageEnglishIndicator")
    protected Boolean personLanguageEnglishIndicator;
    @XmlElement(name = "PersonName")
    protected PersonNameType personName;
    @XmlElement(name = "PersonOtherIdentification")
    protected List<IdentificationType> personOtherIdentification;
    @XmlElement(name = "PersonPhysicalFeature")
    protected List<PhysicalFeatureType> personPhysicalFeature;
    @XmlElement(name = "PersonPrimaryLanguage")
    protected PersonLanguageType personPrimaryLanguage;
    @XmlElementRef(name = "PersonRaceAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personRaceAbstract;
    @XmlElementRef(name = "PersonSexAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personSexAbstract;
    @XmlElement(name = "PersonStateIdentification")
    protected IdentificationType personStateIdentification;
    @XmlElement(name = "PersonTaxIdentification")
    protected IdentificationType personTaxIdentification;
    @XmlElement(name = "PersonWeightMeasure")
    protected WeightMeasureType personWeightMeasure;
    @XmlElementRef(name = "PersonAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> personAugmentationPoint;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personCapability property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonCapability().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CapabilityType }
     * 
     * 
     */
    public List<CapabilityType> getPersonCapability() {
        if (personCapability == null) {
            personCapability = new ArrayList<CapabilityType>();
        }
        return this.personCapability;
    }

    /**
     * Gets the value of the personCitizenshipAbstract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personCitizenshipAbstract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonCitizenshipAbstract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CountryAlpha2CodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getPersonCitizenshipAbstract() {
        if (personCitizenshipAbstract == null) {
            personCitizenshipAbstract = new ArrayList<JAXBElement<?>>();
        }
        return this.personCitizenshipAbstract;
    }

    /**
     * Gets the value of the personEthnicityAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonEthnicityAbstract() {
        return personEthnicityAbstract;
    }

    /**
     * Sets the value of the personEthnicityAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonEthnicityAbstract(JAXBElement<?> value) {
        this.personEthnicityAbstract = value;
    }

    /**
     * Gets the value of the personEyeColorAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EYECodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonEyeColorAbstract() {
        return personEyeColorAbstract;
    }

    /**
     * Sets the value of the personEyeColorAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EYECodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonEyeColorAbstract(JAXBElement<?> value) {
        this.personEyeColorAbstract = value;
    }

    /**
     * Gets the value of the personHairColorAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HAIRCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonHairColorAbstract() {
        return personHairColorAbstract;
    }

    /**
     * Sets the value of the personHairColorAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HAIRCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonHairColorAbstract(JAXBElement<?> value) {
        this.personHairColorAbstract = value;
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
     * Gets the value of the personRaceAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link RACECodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonRaceAbstract() {
        return personRaceAbstract;
    }

    /**
     * Sets the value of the personRaceAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link RACECodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonRaceAbstract(JAXBElement<?> value) {
        this.personRaceAbstract = value;
    }

    /**
     * Gets the value of the personSexAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonSexAbstract() {
        return personSexAbstract;
    }

    /**
     * Sets the value of the personSexAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonSexAbstract(JAXBElement<?> value) {
        this.personSexAbstract = value;
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
     * Gets the value of the personAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link gov.niem.release.niem.domains.jxdm._6.PersonAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.PersonAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link FilerAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link tyler.ecf.v5_0.extensions.common.PersonAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getPersonAugmentationPoint() {
        if (personAugmentationPoint == null) {
            personAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.personAugmentationPoint;
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
