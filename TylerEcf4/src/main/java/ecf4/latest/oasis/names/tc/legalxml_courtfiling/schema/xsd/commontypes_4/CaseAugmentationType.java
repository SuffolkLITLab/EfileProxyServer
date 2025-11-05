
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.iso_639_3._2.LanguageCodeType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
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

import ecf4.latest.tyler.ecf.extensions.common.CaseAbstractorType;


/**
 * Additional information needed to initiate a court case.
 * 
 * <p>Java class for CaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}Language" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}Alias" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseOfficial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseOtherEntityAttorney" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseParticipant" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseShortTitleText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}OrganizationAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PersonAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PersonOrganizationAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}RelatedCaseAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseAugmentationType", propOrder = {
    "language",
    "alias",
    "caseOfficial",
    "caseOtherEntityAttorney",
    "caseParticipant",
    "caseShortTitleText",
    "organizationAssociation",
    "personAssociation",
    "personOrganizationAssociation",
    "relatedCaseAssociation"
})
@XmlSeeAlso({
   ecf4.latest.tyler.ecf.extensions.common.CaseAugmentationType.class
})
public class CaseAugmentationType
    extends ComplexObjectType
{

    @XmlElementRef(name = "Language", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> language;
    @XmlElement(name = "Alias")
    protected List<AliasType> alias;
    @XmlElement(name = "CaseOfficial")
    protected List<CaseOfficialType> caseOfficial;
    @XmlElement(name = "CaseOtherEntityAttorney")
    protected List<CaseOfficialType> caseOtherEntityAttorney;
    @XmlElementRef(name = "CaseParticipant", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends CaseParticipantType>> caseParticipant;
    @XmlElement(name = "CaseShortTitleText")
    protected TextType caseShortTitleText;
    @XmlElement(name = "OrganizationAssociation")
    protected List<OrganizationAssociationType> organizationAssociation;
    @XmlElement(name = "PersonAssociation")
    protected List<PersonAssociationType> personAssociation;
    @XmlElement(name = "PersonOrganizationAssociation")
    protected List<PersonOrganizationAssociationType> personOrganizationAssociation;
    @XmlElement(name = "RelatedCaseAssociation")
    protected List<RelatedCaseAssociationType> relatedCaseAssociation;

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLanguage(JAXBElement<?> value) {
        this.language = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the alias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlias().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AliasType }
     * 
     * 
     */
    public List<AliasType> getAlias() {
        if (alias == null) {
            alias = new ArrayList<AliasType>();
        }
        return this.alias;
    }

    /**
     * Gets the value of the caseOfficial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseOfficial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseOfficial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseOfficial() {
        if (caseOfficial == null) {
            caseOfficial = new ArrayList<CaseOfficialType>();
        }
        return this.caseOfficial;
    }

    /**
     * Gets the value of the caseOtherEntityAttorney property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseOtherEntityAttorney property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseOtherEntityAttorney().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseOtherEntityAttorney() {
        if (caseOtherEntityAttorney == null) {
            caseOtherEntityAttorney = new ArrayList<CaseOfficialType>();
        }
        return this.caseOtherEntityAttorney;
    }

    /**
     * Gets the value of the caseParticipant property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseParticipant property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseParticipant().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CaseParticipantType }{@code >}
     * {@link JAXBElement }{@code <}{@link CaseAbstractorType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends CaseParticipantType>> getCaseParticipant() {
        if (caseParticipant == null) {
            caseParticipant = new ArrayList<JAXBElement<? extends CaseParticipantType>>();
        }
        return this.caseParticipant;
    }

    /**
     * Gets the value of the caseShortTitleText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseShortTitleText() {
        return caseShortTitleText;
    }

    /**
     * Sets the value of the caseShortTitleText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseShortTitleText(TextType value) {
        this.caseShortTitleText = value;
    }

    /**
     * Gets the value of the organizationAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the organizationAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizationAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganizationAssociationType }
     * 
     * 
     */
    public List<OrganizationAssociationType> getOrganizationAssociation() {
        if (organizationAssociation == null) {
            organizationAssociation = new ArrayList<OrganizationAssociationType>();
        }
        return this.organizationAssociation;
    }

    /**
     * Gets the value of the personAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonAssociationType }
     * 
     * 
     */
    public List<PersonAssociationType> getPersonAssociation() {
        if (personAssociation == null) {
            personAssociation = new ArrayList<PersonAssociationType>();
        }
        return this.personAssociation;
    }

    /**
     * Gets the value of the personOrganizationAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personOrganizationAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonOrganizationAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonOrganizationAssociationType }
     * 
     * 
     */
    public List<PersonOrganizationAssociationType> getPersonOrganizationAssociation() {
        if (personOrganizationAssociation == null) {
            personOrganizationAssociation = new ArrayList<PersonOrganizationAssociationType>();
        }
        return this.personOrganizationAssociation;
    }

    /**
     * Gets the value of the relatedCaseAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the relatedCaseAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelatedCaseAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedCaseAssociationType }
     * 
     * 
     */
    public List<RelatedCaseAssociationType> getRelatedCaseAssociation() {
        if (relatedCaseAssociation == null) {
            relatedCaseAssociation = new ArrayList<RelatedCaseAssociationType>();
        }
        return this.relatedCaseAssociation;
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
