
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.iso_639_3._2.LanguageCodeType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.CaseAbstractorType;


/**
 * Additional information needed to initiate a court case.
 * 
 * &lt;p&gt;Java class for CaseAugmentationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseAugmentationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}Language" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}Alias" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseOfficial" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseOtherEntityAttorney" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseParticipant" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseShortTitleText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}OrganizationAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PersonAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PersonOrganizationAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}RelatedCaseAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    tyler.ecf.extensions.common.CaseAugmentationType.class
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the alias property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAlias().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the caseOfficial property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCaseOfficial().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the caseOtherEntityAttorney property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCaseOtherEntityAttorney().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the caseParticipant property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCaseParticipant().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CaseAbstractorType }{@code >}
     * {@link JAXBElement }{@code <}{@link CaseParticipantType }{@code >}
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the organizationAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getOrganizationAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the personAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPersonAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the personOrganizationAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPersonOrganizationAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the relatedCaseAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRelatedCaseAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
