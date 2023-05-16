
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.domestic;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.domains.humanservices._4.ChildSupportEnforcementCaseType;
import gov.niem.release.niem.domains.humanservices._4.ParentChildAssociationType;
import gov.niem.release.niem.domains.humanservices._4.PersonCaseAssociationType;
import gov.niem.release.niem.niem_core._4.PersonUnionAssociationType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}CaseContestedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}DomesticCaseOrder" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}DomesticViolencePetition" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseCauseOfActionCode"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}ChildSupportEnforcementCase" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}ParentChildAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}PersonCaseAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonUnionAssociation" minOccurs="0"/&gt;
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
@XmlType(name = "CaseAugmentationType", propOrder = {
    "caseContestedIndicator",
    "domesticCaseOrder",
    "domesticViolencePetition",
    "caseCauseOfActionCode",
    "childSupportEnforcementCase",
    "parentChildAssociation",
    "personCaseAssociation",
    "personUnionAssociation"
})
public class CaseAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "CaseContestedIndicator")
    protected Boolean caseContestedIndicator;
    @XmlElement(name = "DomesticCaseOrder")
    protected List<DomesticCaseOrderType> domesticCaseOrder;
    @XmlElement(name = "DomesticViolencePetition")
    protected DomesticViolencePetitionType domesticViolencePetition;
    @XmlElement(name = "CaseCauseOfActionCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected TextType caseCauseOfActionCode;
    @XmlElement(name = "ChildSupportEnforcementCase", namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/")
    protected List<ChildSupportEnforcementCaseType> childSupportEnforcementCase;
    @XmlElement(name = "ParentChildAssociation", namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/")
    protected List<ParentChildAssociationType> parentChildAssociation;
    @XmlElement(name = "PersonCaseAssociation", namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/")
    protected List<PersonCaseAssociationType> personCaseAssociation;
    @XmlElement(name = "PersonUnionAssociation", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected PersonUnionAssociationType personUnionAssociation;

    /**
     * Gets the value of the caseContestedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCaseContestedIndicator() {
        return caseContestedIndicator;
    }

    /**
     * Sets the value of the caseContestedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCaseContestedIndicator(Boolean value) {
        this.caseContestedIndicator = value;
    }

    /**
     * Gets the value of the domesticCaseOrder property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the domesticCaseOrder property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDomesticCaseOrder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomesticCaseOrderType }
     * 
     * 
     */
    public List<DomesticCaseOrderType> getDomesticCaseOrder() {
        if (domesticCaseOrder == null) {
            domesticCaseOrder = new ArrayList<DomesticCaseOrderType>();
        }
        return this.domesticCaseOrder;
    }

    /**
     * Gets the value of the domesticViolencePetition property.
     * 
     * @return
     *     possible object is
     *     {@link DomesticViolencePetitionType }
     *     
     */
    public DomesticViolencePetitionType getDomesticViolencePetition() {
        return domesticViolencePetition;
    }

    /**
     * Sets the value of the domesticViolencePetition property.
     * 
     * @param value
     *     allowed object is
     *     {@link DomesticViolencePetitionType }
     *     
     */
    public void setDomesticViolencePetition(DomesticViolencePetitionType value) {
        this.domesticViolencePetition = value;
    }

    /**
     * Gets the value of the caseCauseOfActionCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseCauseOfActionCode() {
        return caseCauseOfActionCode;
    }

    /**
     * Sets the value of the caseCauseOfActionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseCauseOfActionCode(TextType value) {
        this.caseCauseOfActionCode = value;
    }

    /**
     * Gets the value of the childSupportEnforcementCase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the childSupportEnforcementCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildSupportEnforcementCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChildSupportEnforcementCaseType }
     * 
     * 
     */
    public List<ChildSupportEnforcementCaseType> getChildSupportEnforcementCase() {
        if (childSupportEnforcementCase == null) {
            childSupportEnforcementCase = new ArrayList<ChildSupportEnforcementCaseType>();
        }
        return this.childSupportEnforcementCase;
    }

    /**
     * Gets the value of the parentChildAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the parentChildAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParentChildAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParentChildAssociationType }
     * 
     * 
     */
    public List<ParentChildAssociationType> getParentChildAssociation() {
        if (parentChildAssociation == null) {
            parentChildAssociation = new ArrayList<ParentChildAssociationType>();
        }
        return this.parentChildAssociation;
    }

    /**
     * Gets the value of the personCaseAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personCaseAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonCaseAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonCaseAssociationType }
     * 
     * 
     */
    public List<PersonCaseAssociationType> getPersonCaseAssociation() {
        if (personCaseAssociation == null) {
            personCaseAssociation = new ArrayList<PersonCaseAssociationType>();
        }
        return this.personCaseAssociation;
    }

    /**
     * Gets the value of the personUnionAssociation property.
     * 
     * @return
     *     possible object is
     *     {@link PersonUnionAssociationType }
     *     
     */
    public PersonUnionAssociationType getPersonUnionAssociation() {
        return personUnionAssociation;
    }

    /**
     * Sets the value of the personUnionAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonUnionAssociationType }
     *     
     */
    public void setPersonUnionAssociation(PersonUnionAssociationType value) {
        this.personUnionAssociation = value;
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
