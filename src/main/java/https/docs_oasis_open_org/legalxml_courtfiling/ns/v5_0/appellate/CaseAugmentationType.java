
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.appellate;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.domains.jxdm._6.AppellateCaseType;
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
 * An augmentation type
 * 
 * <p>Java class for CaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate}AppellantInCustodyIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate}AppellateCaseAddedParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate}AppellateCaseJurisdictionBasisText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate}AppellateCaseRemovedParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate}AppellateCaseSettlementRequestText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate}AppellateCourtRuleCase" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate}FeesWaivedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}AppellateCase"/&gt;
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
    "appellantInCustodyIndicator",
    "appellateCaseAddedParty",
    "appellateCaseJurisdictionBasisText",
    "appellateCaseRemovedParty",
    "appellateCaseSettlementRequestText",
    "appellateCourtRuleCase",
    "feesWaivedIndicator",
    "appellateCase"
})
public class CaseAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "AppellantInCustodyIndicator")
    protected Boolean appellantInCustodyIndicator;
    @XmlElement(name = "AppellateCaseAddedParty")
    protected List<AppellateCaseAddedPartyType> appellateCaseAddedParty;
    @XmlElement(name = "AppellateCaseJurisdictionBasisText")
    protected TextType appellateCaseJurisdictionBasisText;
    @XmlElement(name = "AppellateCaseRemovedParty")
    protected List<AppellateCaseRemovedPartyType> appellateCaseRemovedParty;
    @XmlElement(name = "AppellateCaseSettlementRequestText")
    protected TextType appellateCaseSettlementRequestText;
    @XmlElement(name = "AppellateCourtRuleCase")
    protected AppellateCourtRuleCaseType appellateCourtRuleCase;
    @XmlElement(name = "FeesWaivedIndicator")
    protected Boolean feesWaivedIndicator;
    @XmlElement(name = "AppellateCase", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", required = true)
    protected AppellateCaseType appellateCase;

    /**
     * Gets the value of the appellantInCustodyIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getAppellantInCustodyIndicator() {
        return appellantInCustodyIndicator;
    }

    /**
     * Sets the value of the appellantInCustodyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAppellantInCustodyIndicator(Boolean value) {
        this.appellantInCustodyIndicator = value;
    }

    /**
     * Gets the value of the appellateCaseAddedParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the appellateCaseAddedParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppellateCaseAddedParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppellateCaseAddedPartyType }
     * 
     * 
     */
    public List<AppellateCaseAddedPartyType> getAppellateCaseAddedParty() {
        if (appellateCaseAddedParty == null) {
            appellateCaseAddedParty = new ArrayList<AppellateCaseAddedPartyType>();
        }
        return this.appellateCaseAddedParty;
    }

    /**
     * Gets the value of the appellateCaseJurisdictionBasisText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAppellateCaseJurisdictionBasisText() {
        return appellateCaseJurisdictionBasisText;
    }

    /**
     * Sets the value of the appellateCaseJurisdictionBasisText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAppellateCaseJurisdictionBasisText(TextType value) {
        this.appellateCaseJurisdictionBasisText = value;
    }

    /**
     * Gets the value of the appellateCaseRemovedParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the appellateCaseRemovedParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppellateCaseRemovedParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppellateCaseRemovedPartyType }
     * 
     * 
     */
    public List<AppellateCaseRemovedPartyType> getAppellateCaseRemovedParty() {
        if (appellateCaseRemovedParty == null) {
            appellateCaseRemovedParty = new ArrayList<AppellateCaseRemovedPartyType>();
        }
        return this.appellateCaseRemovedParty;
    }

    /**
     * Gets the value of the appellateCaseSettlementRequestText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAppellateCaseSettlementRequestText() {
        return appellateCaseSettlementRequestText;
    }

    /**
     * Sets the value of the appellateCaseSettlementRequestText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAppellateCaseSettlementRequestText(TextType value) {
        this.appellateCaseSettlementRequestText = value;
    }

    /**
     * Gets the value of the appellateCourtRuleCase property.
     * 
     * @return
     *     possible object is
     *     {@link AppellateCourtRuleCaseType }
     *     
     */
    public AppellateCourtRuleCaseType getAppellateCourtRuleCase() {
        return appellateCourtRuleCase;
    }

    /**
     * Sets the value of the appellateCourtRuleCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppellateCourtRuleCaseType }
     *     
     */
    public void setAppellateCourtRuleCase(AppellateCourtRuleCaseType value) {
        this.appellateCourtRuleCase = value;
    }

    /**
     * Gets the value of the feesWaivedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getFeesWaivedIndicator() {
        return feesWaivedIndicator;
    }

    /**
     * Sets the value of the feesWaivedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFeesWaivedIndicator(Boolean value) {
        this.feesWaivedIndicator = value;
    }

    /**
     * Gets the value of the appellateCase property.
     * 
     * @return
     *     possible object is
     *     {@link AppellateCaseType }
     *     
     */
    public AppellateCaseType getAppellateCase() {
        return appellateCase;
    }

    /**
     * Sets the value of the appellateCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppellateCaseType }
     *     
     */
    public void setAppellateCase(AppellateCaseType value) {
        this.appellateCase = value;
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
