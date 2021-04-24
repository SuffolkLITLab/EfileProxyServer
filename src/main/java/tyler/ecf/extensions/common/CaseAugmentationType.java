
package tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * &lt;p&gt;Java class for CaseAugmentationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseAugmentationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseAugmentationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CaseTypeText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FilerTypeText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}LowerCourtText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}LowerCourtJudgeText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}AttachServiceContactIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ProcedureRemedy" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ProviderCharge" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PropertyAccountNumber" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CivilClaimAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ProbateEstateAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FilingAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PartyService" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ExtendedData" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}MaxFeeAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CaseSecurity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CaseSubTypeText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PhysicalFeature" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ReturnDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}HearingSchedule" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}OutOfStateIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CitationAugmentation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}WillFiledDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}DecedentPartyAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}QuestionAnswer" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
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
    "caseTypeText",
    "filerTypeText",
    "lowerCourtText",
    "lowerCourtJudgeText",
    "attachServiceContactIndicator",
    "procedureRemedy",
    "providerCharge",
    "propertyAccountNumber",
    "civilClaimAmount",
    "probateEstateAmount",
    "filingAssociation",
    "partyService",
    "extendedData",
    "maxFeeAmount",
    "caseSecurity",
    "caseSubTypeText",
    "physicalFeature",
    "returnDate",
    "hearingSchedule",
    "outOfStateIndicator",
    "citationAugmentation",
    "willFiledDate",
    "decedentPartyAssociation",
    "questionAnswer"
})
public class CaseAugmentationType
    extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType
{

    @XmlElement(name = "CaseTypeText")
    protected TextType caseTypeText;
    @XmlElement(name = "FilerTypeText")
    protected TextType filerTypeText;
    @XmlElement(name = "LowerCourtText")
    protected TextType lowerCourtText;
    @XmlElement(name = "LowerCourtJudgeText")
    protected TextType lowerCourtJudgeText;
    @XmlElement(name = "AttachServiceContactIndicator")
    protected Boolean attachServiceContactIndicator;
    @XmlElement(name = "ProcedureRemedy")
    protected ProcedureRemedyType procedureRemedy;
    @XmlElement(name = "ProviderCharge")
    protected ProviderChargeType providerCharge;
    @XmlElement(name = "PropertyAccountNumber")
    protected List<TextType> propertyAccountNumber;
    @XmlElement(name = "CivilClaimAmount")
    protected AmountType civilClaimAmount;
    @XmlElement(name = "ProbateEstateAmount")
    protected AmountType probateEstateAmount;
    @XmlElement(name = "FilingAssociation")
    protected List<FilingAssociationType> filingAssociation;
    @XmlElement(name = "PartyService")
    protected List<PartyServiceType> partyService;
    @XmlElementRef(name = "ExtendedData", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends ExtendedDataType>> extendedData;
    @XmlElement(name = "MaxFeeAmount")
    protected AmountType maxFeeAmount;
    @XmlElement(name = "CaseSecurity")
    @XmlSchemaType(name = "token")
    protected CaseSecurityType caseSecurity;
    @XmlElement(name = "CaseSubTypeText")
    protected TextType caseSubTypeText;
    @XmlElement(name = "PhysicalFeature")
    protected List<PhysicalFeatureType> physicalFeature;
    @XmlElement(name = "ReturnDate")
    protected DateType returnDate;
    @XmlElement(name = "HearingSchedule")
    protected HearingScheduleType hearingSchedule;
    @XmlElement(name = "OutOfStateIndicator")
    protected Boolean outOfStateIndicator;
    @XmlElement(name = "CitationAugmentation")
    protected List<CitationAugmentationType> citationAugmentation;
    @XmlElement(name = "WillFiledDate")
    protected DateType willFiledDate;
    @XmlElement(name = "DecedentPartyAssociation")
    protected List<DecedentPartyAssociationType> decedentPartyAssociation;
    @XmlElement(name = "QuestionAnswer")
    protected List<QuestionAnswerType> questionAnswer;

    /**
     * Gets the value of the caseTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseTypeText() {
        return caseTypeText;
    }

    /**
     * Sets the value of the caseTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseTypeText(TextType value) {
        this.caseTypeText = value;
    }

    /**
     * Gets the value of the filerTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilerTypeText() {
        return filerTypeText;
    }

    /**
     * Sets the value of the filerTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilerTypeText(TextType value) {
        this.filerTypeText = value;
    }

    /**
     * Gets the value of the lowerCourtText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getLowerCourtText() {
        return lowerCourtText;
    }

    /**
     * Sets the value of the lowerCourtText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setLowerCourtText(TextType value) {
        this.lowerCourtText = value;
    }

    /**
     * Gets the value of the lowerCourtJudgeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getLowerCourtJudgeText() {
        return lowerCourtJudgeText;
    }

    /**
     * Sets the value of the lowerCourtJudgeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setLowerCourtJudgeText(TextType value) {
        this.lowerCourtJudgeText = value;
    }

    /**
     * Gets the value of the attachServiceContactIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getAttachServiceContactIndicator() {
        return attachServiceContactIndicator;
    }

    /**
     * Sets the value of the attachServiceContactIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAttachServiceContactIndicator(Boolean value) {
        this.attachServiceContactIndicator = value;
    }

    /**
     * Gets the value of the procedureRemedy property.
     * 
     * @return
     *     possible object is
     *     {@link ProcedureRemedyType }
     *     
     */
    public ProcedureRemedyType getProcedureRemedy() {
        return procedureRemedy;
    }

    /**
     * Sets the value of the procedureRemedy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcedureRemedyType }
     *     
     */
    public void setProcedureRemedy(ProcedureRemedyType value) {
        this.procedureRemedy = value;
    }

    /**
     * Gets the value of the providerCharge property.
     * 
     * @return
     *     possible object is
     *     {@link ProviderChargeType }
     *     
     */
    public ProviderChargeType getProviderCharge() {
        return providerCharge;
    }

    /**
     * Sets the value of the providerCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProviderChargeType }
     *     
     */
    public void setProviderCharge(ProviderChargeType value) {
        this.providerCharge = value;
    }

    /**
     * Gets the value of the propertyAccountNumber property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the propertyAccountNumber property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPropertyAccountNumber().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getPropertyAccountNumber() {
        if (propertyAccountNumber == null) {
            propertyAccountNumber = new ArrayList<TextType>();
        }
        return this.propertyAccountNumber;
    }

    /**
     * Gets the value of the civilClaimAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getCivilClaimAmount() {
        return civilClaimAmount;
    }

    /**
     * Sets the value of the civilClaimAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setCivilClaimAmount(AmountType value) {
        this.civilClaimAmount = value;
    }

    /**
     * Gets the value of the probateEstateAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getProbateEstateAmount() {
        return probateEstateAmount;
    }

    /**
     * Sets the value of the probateEstateAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setProbateEstateAmount(AmountType value) {
        this.probateEstateAmount = value;
    }

    /**
     * Gets the value of the filingAssociation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the filingAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFilingAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link FilingAssociationType }
     * 
     * 
     */
    public List<FilingAssociationType> getFilingAssociation() {
        if (filingAssociation == null) {
            filingAssociation = new ArrayList<FilingAssociationType>();
        }
        return this.filingAssociation;
    }

    /**
     * Gets the value of the partyService property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the partyService property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPartyService().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PartyServiceType }
     * 
     * 
     */
    public List<PartyServiceType> getPartyService() {
        if (partyService == null) {
            partyService = new ArrayList<PartyServiceType>();
        }
        return this.partyService;
    }

    /**
     * Gets the value of the extendedData property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the extendedData property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getExtendedData().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ServicePartyDataType }{@code >}
     * {@link JAXBElement }{@code <}{@link CaseEventType }{@code >}
     * {@link JAXBElement }{@code <}{@link ExtendedDataType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends ExtendedDataType>> getExtendedData() {
        if (extendedData == null) {
            extendedData = new ArrayList<JAXBElement<? extends ExtendedDataType>>();
        }
        return this.extendedData;
    }

    /**
     * Gets the value of the maxFeeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getMaxFeeAmount() {
        return maxFeeAmount;
    }

    /**
     * Sets the value of the maxFeeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setMaxFeeAmount(AmountType value) {
        this.maxFeeAmount = value;
    }

    /**
     * Gets the value of the caseSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link CaseSecurityType }
     *     
     */
    public CaseSecurityType getCaseSecurity() {
        return caseSecurity;
    }

    /**
     * Sets the value of the caseSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseSecurityType }
     *     
     */
    public void setCaseSecurity(CaseSecurityType value) {
        this.caseSecurity = value;
    }

    /**
     * Gets the value of the caseSubTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseSubTypeText() {
        return caseSubTypeText;
    }

    /**
     * Sets the value of the caseSubTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseSubTypeText(TextType value) {
        this.caseSubTypeText = value;
    }

    /**
     * Gets the value of the physicalFeature property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the physicalFeature property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPhysicalFeature().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PhysicalFeatureType }
     * 
     * 
     */
    public List<PhysicalFeatureType> getPhysicalFeature() {
        if (physicalFeature == null) {
            physicalFeature = new ArrayList<PhysicalFeatureType>();
        }
        return this.physicalFeature;
    }

    /**
     * Gets the value of the returnDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getReturnDate() {
        return returnDate;
    }

    /**
     * Sets the value of the returnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setReturnDate(DateType value) {
        this.returnDate = value;
    }

    /**
     * Gets the value of the hearingSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link HearingScheduleType }
     *     
     */
    public HearingScheduleType getHearingSchedule() {
        return hearingSchedule;
    }

    /**
     * Sets the value of the hearingSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link HearingScheduleType }
     *     
     */
    public void setHearingSchedule(HearingScheduleType value) {
        this.hearingSchedule = value;
    }

    /**
     * Gets the value of the outOfStateIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getOutOfStateIndicator() {
        return outOfStateIndicator;
    }

    /**
     * Sets the value of the outOfStateIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOutOfStateIndicator(Boolean value) {
        this.outOfStateIndicator = value;
    }

    /**
     * Gets the value of the citationAugmentation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the citationAugmentation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCitationAugmentation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CitationAugmentationType }
     * 
     * 
     */
    public List<CitationAugmentationType> getCitationAugmentation() {
        if (citationAugmentation == null) {
            citationAugmentation = new ArrayList<CitationAugmentationType>();
        }
        return this.citationAugmentation;
    }

    /**
     * Gets the value of the willFiledDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getWillFiledDate() {
        return willFiledDate;
    }

    /**
     * Sets the value of the willFiledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setWillFiledDate(DateType value) {
        this.willFiledDate = value;
    }

    /**
     * Gets the value of the decedentPartyAssociation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the decedentPartyAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDecedentPartyAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DecedentPartyAssociationType }
     * 
     * 
     */
    public List<DecedentPartyAssociationType> getDecedentPartyAssociation() {
        if (decedentPartyAssociation == null) {
            decedentPartyAssociation = new ArrayList<DecedentPartyAssociationType>();
        }
        return this.decedentPartyAssociation;
    }

    /**
     * Gets the value of the questionAnswer property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the questionAnswer property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getQuestionAnswer().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link QuestionAnswerType }
     * 
     * 
     */
    public List<QuestionAnswerType> getQuestionAnswer() {
        if (questionAnswer == null) {
            questionAnswer = new ArrayList<QuestionAnswerType>();
        }
        return this.questionAnswer;
    }

}
