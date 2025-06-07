
package ecf4.latest.gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.niem_core._2.CaseType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.structures._2.AugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
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
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseCourt"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseCourtEvent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseDefendantParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseDefenseAttorney" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseInitiatingParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseJudge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseLineageCase" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseOfficial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseOtherEntity" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseProsecutionAttorney" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseRespondentAttorney" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseRespondentParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseInitiatingAttorney" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "caseCharge",
    "caseCourt",
    "caseCourtEvent",
    "caseDefendantParty",
    "caseDefenseAttorney",
    "caseInitiatingParty",
    "caseJudge",
    "caseLineageCase",
    "caseOfficial",
    "caseOtherEntity",
    "caseProsecutionAttorney",
    "caseRespondentAttorney",
    "caseRespondentParty",
    "caseInitiatingAttorney"
})
public class CaseAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "CaseCharge", nillable = true)
    protected List<ChargeType> caseCharge;
    @XmlElement(name = "CaseCourt", required = true, nillable = true)
    protected CourtType caseCourt;
    @XmlElementRef(name = "CaseCourtEvent", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends ecf4.latest.gov.niem.niem.domains.jxdm._4.CourtEventType>> caseCourtEvent;
    @XmlElement(name = "CaseDefendantParty", nillable = true)
    protected List<EntityType> caseDefendantParty;
    @XmlElement(name = "CaseDefenseAttorney", nillable = true)
    protected List<CaseOfficialType> caseDefenseAttorney;
    @XmlElement(name = "CaseInitiatingParty", nillable = true)
    protected List<EntityType> caseInitiatingParty;
    @XmlElement(name = "CaseJudge", nillable = true)
    protected List<CaseOfficialType> caseJudge;
    @XmlElement(name = "CaseLineageCase", nillable = true)
    protected List<CaseType> caseLineageCase;
    @XmlElement(name = "CaseOfficial", nillable = true)
    protected List<CaseOfficialType> caseOfficial;
    @XmlElement(name = "CaseOtherEntity", nillable = true)
    protected List<EntityType> caseOtherEntity;
    @XmlElement(name = "CaseProsecutionAttorney", nillable = true)
    protected List<CaseOfficialType> caseProsecutionAttorney;
    @XmlElement(name = "CaseRespondentAttorney", nillable = true)
    protected List<CaseOfficialType> caseRespondentAttorney;
    @XmlElement(name = "CaseRespondentParty", nillable = true)
    protected List<EntityType> caseRespondentParty;
    @XmlElement(name = "CaseInitiatingAttorney", nillable = true)
    protected List<CaseOfficialType> caseInitiatingAttorney;

    /**
     * Gets the value of the caseCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeType }
     * 
     * 
     */
    public List<ChargeType> getCaseCharge() {
        if (caseCharge == null) {
            caseCharge = new ArrayList<ChargeType>();
        }
        return this.caseCharge;
    }

    /**
     * Gets the value of the caseCourt property.
     * 
     * @return
     *     possible object is
     *     {@link CourtType }
     *     
     */
    public CourtType getCaseCourt() {
        return caseCourt;
    }

    /**
     * Sets the value of the caseCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtType }
     *     
     */
    public void setCaseCourt(CourtType value) {
        this.caseCourt = value;
    }

    /**
     * Gets the value of the caseCourtEvent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseCourtEvent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseCourtEvent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ecf4.latest.gov.niem.niem.domains.jxdm._4.CourtEventType }{@code >}
     * {@link JAXBElement }{@code <}{@link ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CourtEventType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends ecf4.latest.gov.niem.niem.domains.jxdm._4.CourtEventType>> getCaseCourtEvent() {
        if (caseCourtEvent == null) {
            caseCourtEvent = new ArrayList<JAXBElement<? extends ecf4.latest.gov.niem.niem.domains.jxdm._4.CourtEventType>>();
        }
        return this.caseCourtEvent;
    }

    /**
     * Gets the value of the caseDefendantParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseDefendantParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseDefendantParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityType }
     * 
     * 
     */
    public List<EntityType> getCaseDefendantParty() {
        if (caseDefendantParty == null) {
            caseDefendantParty = new ArrayList<EntityType>();
        }
        return this.caseDefendantParty;
    }

    /**
     * Gets the value of the caseDefenseAttorney property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseDefenseAttorney property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseDefenseAttorney().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseDefenseAttorney() {
        if (caseDefenseAttorney == null) {
            caseDefenseAttorney = new ArrayList<CaseOfficialType>();
        }
        return this.caseDefenseAttorney;
    }

    /**
     * Gets the value of the caseInitiatingParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseInitiatingParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseInitiatingParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityType }
     * 
     * 
     */
    public List<EntityType> getCaseInitiatingParty() {
        if (caseInitiatingParty == null) {
            caseInitiatingParty = new ArrayList<EntityType>();
        }
        return this.caseInitiatingParty;
    }

    /**
     * Gets the value of the caseJudge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseJudge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseJudge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseJudge() {
        if (caseJudge == null) {
            caseJudge = new ArrayList<CaseOfficialType>();
        }
        return this.caseJudge;
    }

    /**
     * Gets the value of the caseLineageCase property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseLineageCase property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseLineageCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseType }
     * 
     * 
     */
    public List<CaseType> getCaseLineageCase() {
        if (caseLineageCase == null) {
            caseLineageCase = new ArrayList<CaseType>();
        }
        return this.caseLineageCase;
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
     * Gets the value of the caseOtherEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseOtherEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseOtherEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityType }
     * 
     * 
     */
    public List<EntityType> getCaseOtherEntity() {
        if (caseOtherEntity == null) {
            caseOtherEntity = new ArrayList<EntityType>();
        }
        return this.caseOtherEntity;
    }

    /**
     * Gets the value of the caseProsecutionAttorney property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseProsecutionAttorney property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseProsecutionAttorney().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseProsecutionAttorney() {
        if (caseProsecutionAttorney == null) {
            caseProsecutionAttorney = new ArrayList<CaseOfficialType>();
        }
        return this.caseProsecutionAttorney;
    }

    /**
     * Gets the value of the caseRespondentAttorney property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseRespondentAttorney property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseRespondentAttorney().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseRespondentAttorney() {
        if (caseRespondentAttorney == null) {
            caseRespondentAttorney = new ArrayList<CaseOfficialType>();
        }
        return this.caseRespondentAttorney;
    }

    /**
     * Gets the value of the caseRespondentParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseRespondentParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseRespondentParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityType }
     * 
     * 
     */
    public List<EntityType> getCaseRespondentParty() {
        if (caseRespondentParty == null) {
            caseRespondentParty = new ArrayList<EntityType>();
        }
        return this.caseRespondentParty;
    }

    /**
     * Gets the value of the caseInitiatingAttorney property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseInitiatingAttorney property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseInitiatingAttorney().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseOfficialType }
     * 
     * 
     */
    public List<CaseOfficialType> getCaseInitiatingAttorney() {
        if (caseInitiatingAttorney == null) {
            caseInitiatingAttorney = new ArrayList<CaseOfficialType>();
        }
        return this.caseInitiatingAttorney;
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
