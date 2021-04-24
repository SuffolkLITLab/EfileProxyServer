
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AcceptedVariantsDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardingMethodTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EconomicOperatorRegistryURIType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FundingProgramCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FundingProgramType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumAdvertisementAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumVariantQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentFrequencyCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PenaltyClausesType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceEvaluationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriceRevisionFormulaDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredCurriculaIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.VariantConstraintIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for TenderingTermsType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TenderingTermsType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AwardingMethodTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceEvaluationCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumVariantQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}VariantConstraintIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AcceptedVariantsDescription" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PriceRevisionFormulaDescription" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FundingProgramCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FundingProgram" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumAdvertisementAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PaymentFrequencyCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EconomicOperatorRegistryURI" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PenaltyClauses" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequiredCurriculaIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequiredFinancialGuarantee" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ProcurementLegislationDocumentReference" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FiscalLegislationDocumentReference" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnvironmentalLegislationDocumentReference" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EmploymentLegislationDocumentReference" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractualDocumentReference" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CallForTenderDocumentReference" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WarrantyValidityPeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PaymentTerms" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TendererQualificationRequest" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AllowedSubcontractTerms" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderPreparation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractExecutionRequirement" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AwardingTerms" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalInformationParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentProviderParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderRecipientParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractResponsibleParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderEvaluationParty" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TenderValidityPeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractAcceptancePeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AppealTerms" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Language" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BudgetAccountLine" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TenderingTermsType", propOrder = {
    "awardingMethodTypeCode",
    "priceEvaluationCode",
    "maximumVariantQuantity",
    "variantConstraintIndicator",
    "acceptedVariantsDescription",
    "priceRevisionFormulaDescription",
    "fundingProgramCode",
    "fundingProgram",
    "maximumAdvertisementAmount",
    "note",
    "paymentFrequencyCode",
    "economicOperatorRegistryURI",
    "penaltyClauses",
    "requiredCurriculaIndicator",
    "requiredFinancialGuarantee",
    "procurementLegislationDocumentReference",
    "fiscalLegislationDocumentReference",
    "environmentalLegislationDocumentReference",
    "employmentLegislationDocumentReference",
    "contractualDocumentReference",
    "callForTenderDocumentReference",
    "warrantyValidityPeriod",
    "paymentTerms",
    "tendererQualificationRequest",
    "allowedSubcontractTerms",
    "tenderPreparation",
    "contractExecutionRequirement",
    "awardingTerms",
    "additionalInformationParty",
    "documentProviderParty",
    "tenderRecipientParty",
    "contractResponsibleParty",
    "tenderEvaluationParty",
    "tenderValidityPeriod",
    "contractAcceptancePeriod",
    "appealTerms",
    "language",
    "budgetAccountLine"
})
public class TenderingTermsType {

    @XmlElement(name = "AwardingMethodTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AwardingMethodTypeCodeType awardingMethodTypeCode;
    @XmlElement(name = "PriceEvaluationCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriceEvaluationCodeType priceEvaluationCode;
    @XmlElement(name = "MaximumVariantQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumVariantQuantityType maximumVariantQuantity;
    @XmlElement(name = "VariantConstraintIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected VariantConstraintIndicatorType variantConstraintIndicator;
    @XmlElement(name = "AcceptedVariantsDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<AcceptedVariantsDescriptionType> acceptedVariantsDescription;
    @XmlElement(name = "PriceRevisionFormulaDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PriceRevisionFormulaDescriptionType> priceRevisionFormulaDescription;
    @XmlElement(name = "FundingProgramCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FundingProgramCodeType fundingProgramCode;
    @XmlElement(name = "FundingProgram", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<FundingProgramType> fundingProgram;
    @XmlElement(name = "MaximumAdvertisementAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumAdvertisementAmountType maximumAdvertisementAmount;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "PaymentFrequencyCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PaymentFrequencyCodeType paymentFrequencyCode;
    @XmlElement(name = "EconomicOperatorRegistryURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EconomicOperatorRegistryURIType economicOperatorRegistryURI;
    @XmlElement(name = "PenaltyClauses", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<PenaltyClausesType> penaltyClauses;
    @XmlElement(name = "RequiredCurriculaIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequiredCurriculaIndicatorType requiredCurriculaIndicator;
    @XmlElement(name = "RequiredFinancialGuarantee")
    protected List<FinancialGuaranteeType> requiredFinancialGuarantee;
    @XmlElement(name = "ProcurementLegislationDocumentReference")
    protected DocumentReferenceType procurementLegislationDocumentReference;
    @XmlElement(name = "FiscalLegislationDocumentReference")
    protected DocumentReferenceType fiscalLegislationDocumentReference;
    @XmlElement(name = "EnvironmentalLegislationDocumentReference")
    protected DocumentReferenceType environmentalLegislationDocumentReference;
    @XmlElement(name = "EmploymentLegislationDocumentReference")
    protected DocumentReferenceType employmentLegislationDocumentReference;
    @XmlElement(name = "ContractualDocumentReference")
    protected List<DocumentReferenceType> contractualDocumentReference;
    @XmlElement(name = "CallForTenderDocumentReference")
    protected DocumentReferenceType callForTenderDocumentReference;
    @XmlElement(name = "WarrantyValidityPeriod")
    protected PeriodType warrantyValidityPeriod;
    @XmlElement(name = "PaymentTerms")
    protected List<PaymentTermsType> paymentTerms;
    @XmlElement(name = "TendererQualificationRequest")
    protected TendererQualificationRequestType tendererQualificationRequest;
    @XmlElement(name = "AllowedSubcontractTerms")
    protected List<SubcontractTermsType> allowedSubcontractTerms;
    @XmlElement(name = "TenderPreparation")
    protected List<TenderPreparationType> tenderPreparation;
    @XmlElement(name = "ContractExecutionRequirement")
    protected List<ContractExecutionRequirementType> contractExecutionRequirement;
    @XmlElement(name = "AwardingTerms")
    protected AwardingTermsType awardingTerms;
    @XmlElement(name = "AdditionalInformationParty")
    protected PartyType additionalInformationParty;
    @XmlElement(name = "DocumentProviderParty")
    protected PartyType documentProviderParty;
    @XmlElement(name = "TenderRecipientParty")
    protected PartyType tenderRecipientParty;
    @XmlElement(name = "ContractResponsibleParty")
    protected PartyType contractResponsibleParty;
    @XmlElement(name = "TenderEvaluationParty")
    protected List<PartyType> tenderEvaluationParty;
    @XmlElement(name = "TenderValidityPeriod")
    protected PeriodType tenderValidityPeriod;
    @XmlElement(name = "ContractAcceptancePeriod")
    protected PeriodType contractAcceptancePeriod;
    @XmlElement(name = "AppealTerms")
    protected AppealTermsType appealTerms;
    @XmlElement(name = "Language")
    protected List<LanguageType> language;
    @XmlElement(name = "BudgetAccountLine")
    protected List<BudgetAccountLineType> budgetAccountLine;

    /**
     * Gets the value of the awardingMethodTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link AwardingMethodTypeCodeType }
     *     
     */
    public AwardingMethodTypeCodeType getAwardingMethodTypeCode() {
        return awardingMethodTypeCode;
    }

    /**
     * Sets the value of the awardingMethodTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AwardingMethodTypeCodeType }
     *     
     */
    public void setAwardingMethodTypeCode(AwardingMethodTypeCodeType value) {
        this.awardingMethodTypeCode = value;
    }

    /**
     * Gets the value of the priceEvaluationCode property.
     * 
     * @return
     *     possible object is
     *     {@link PriceEvaluationCodeType }
     *     
     */
    public PriceEvaluationCodeType getPriceEvaluationCode() {
        return priceEvaluationCode;
    }

    /**
     * Sets the value of the priceEvaluationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceEvaluationCodeType }
     *     
     */
    public void setPriceEvaluationCode(PriceEvaluationCodeType value) {
        this.priceEvaluationCode = value;
    }

    /**
     * Gets the value of the maximumVariantQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link MaximumVariantQuantityType }
     *     
     */
    public MaximumVariantQuantityType getMaximumVariantQuantity() {
        return maximumVariantQuantity;
    }

    /**
     * Sets the value of the maximumVariantQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumVariantQuantityType }
     *     
     */
    public void setMaximumVariantQuantity(MaximumVariantQuantityType value) {
        this.maximumVariantQuantity = value;
    }

    /**
     * Gets the value of the variantConstraintIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link VariantConstraintIndicatorType }
     *     
     */
    public VariantConstraintIndicatorType getVariantConstraintIndicator() {
        return variantConstraintIndicator;
    }

    /**
     * Sets the value of the variantConstraintIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariantConstraintIndicatorType }
     *     
     */
    public void setVariantConstraintIndicator(VariantConstraintIndicatorType value) {
        this.variantConstraintIndicator = value;
    }

    /**
     * Gets the value of the acceptedVariantsDescription property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the acceptedVariantsDescription property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAcceptedVariantsDescription().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link AcceptedVariantsDescriptionType }
     * 
     * 
     */
    public List<AcceptedVariantsDescriptionType> getAcceptedVariantsDescription() {
        if (acceptedVariantsDescription == null) {
            acceptedVariantsDescription = new ArrayList<AcceptedVariantsDescriptionType>();
        }
        return this.acceptedVariantsDescription;
    }

    /**
     * Gets the value of the priceRevisionFormulaDescription property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the priceRevisionFormulaDescription property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPriceRevisionFormulaDescription().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PriceRevisionFormulaDescriptionType }
     * 
     * 
     */
    public List<PriceRevisionFormulaDescriptionType> getPriceRevisionFormulaDescription() {
        if (priceRevisionFormulaDescription == null) {
            priceRevisionFormulaDescription = new ArrayList<PriceRevisionFormulaDescriptionType>();
        }
        return this.priceRevisionFormulaDescription;
    }

    /**
     * Gets the value of the fundingProgramCode property.
     * 
     * @return
     *     possible object is
     *     {@link FundingProgramCodeType }
     *     
     */
    public FundingProgramCodeType getFundingProgramCode() {
        return fundingProgramCode;
    }

    /**
     * Sets the value of the fundingProgramCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundingProgramCodeType }
     *     
     */
    public void setFundingProgramCode(FundingProgramCodeType value) {
        this.fundingProgramCode = value;
    }

    /**
     * Gets the value of the fundingProgram property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the fundingProgram property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFundingProgram().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link FundingProgramType }
     * 
     * 
     */
    public List<FundingProgramType> getFundingProgram() {
        if (fundingProgram == null) {
            fundingProgram = new ArrayList<FundingProgramType>();
        }
        return this.fundingProgram;
    }

    /**
     * Gets the value of the maximumAdvertisementAmount property.
     * 
     * @return
     *     possible object is
     *     {@link MaximumAdvertisementAmountType }
     *     
     */
    public MaximumAdvertisementAmountType getMaximumAdvertisementAmount() {
        return maximumAdvertisementAmount;
    }

    /**
     * Sets the value of the maximumAdvertisementAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumAdvertisementAmountType }
     *     
     */
    public void setMaximumAdvertisementAmount(MaximumAdvertisementAmountType value) {
        this.maximumAdvertisementAmount = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the note property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getNote().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * Gets the value of the paymentFrequencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentFrequencyCodeType }
     *     
     */
    public PaymentFrequencyCodeType getPaymentFrequencyCode() {
        return paymentFrequencyCode;
    }

    /**
     * Sets the value of the paymentFrequencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentFrequencyCodeType }
     *     
     */
    public void setPaymentFrequencyCode(PaymentFrequencyCodeType value) {
        this.paymentFrequencyCode = value;
    }

    /**
     * Gets the value of the economicOperatorRegistryURI property.
     * 
     * @return
     *     possible object is
     *     {@link EconomicOperatorRegistryURIType }
     *     
     */
    public EconomicOperatorRegistryURIType getEconomicOperatorRegistryURI() {
        return economicOperatorRegistryURI;
    }

    /**
     * Sets the value of the economicOperatorRegistryURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link EconomicOperatorRegistryURIType }
     *     
     */
    public void setEconomicOperatorRegistryURI(EconomicOperatorRegistryURIType value) {
        this.economicOperatorRegistryURI = value;
    }

    /**
     * Gets the value of the penaltyClauses property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the penaltyClauses property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPenaltyClauses().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PenaltyClausesType }
     * 
     * 
     */
    public List<PenaltyClausesType> getPenaltyClauses() {
        if (penaltyClauses == null) {
            penaltyClauses = new ArrayList<PenaltyClausesType>();
        }
        return this.penaltyClauses;
    }

    /**
     * Gets the value of the requiredCurriculaIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link RequiredCurriculaIndicatorType }
     *     
     */
    public RequiredCurriculaIndicatorType getRequiredCurriculaIndicator() {
        return requiredCurriculaIndicator;
    }

    /**
     * Sets the value of the requiredCurriculaIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiredCurriculaIndicatorType }
     *     
     */
    public void setRequiredCurriculaIndicator(RequiredCurriculaIndicatorType value) {
        this.requiredCurriculaIndicator = value;
    }

    /**
     * Gets the value of the requiredFinancialGuarantee property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the requiredFinancialGuarantee property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRequiredFinancialGuarantee().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link FinancialGuaranteeType }
     * 
     * 
     */
    public List<FinancialGuaranteeType> getRequiredFinancialGuarantee() {
        if (requiredFinancialGuarantee == null) {
            requiredFinancialGuarantee = new ArrayList<FinancialGuaranteeType>();
        }
        return this.requiredFinancialGuarantee;
    }

    /**
     * Gets the value of the procurementLegislationDocumentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getProcurementLegislationDocumentReference() {
        return procurementLegislationDocumentReference;
    }

    /**
     * Sets the value of the procurementLegislationDocumentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setProcurementLegislationDocumentReference(DocumentReferenceType value) {
        this.procurementLegislationDocumentReference = value;
    }

    /**
     * Gets the value of the fiscalLegislationDocumentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getFiscalLegislationDocumentReference() {
        return fiscalLegislationDocumentReference;
    }

    /**
     * Sets the value of the fiscalLegislationDocumentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setFiscalLegislationDocumentReference(DocumentReferenceType value) {
        this.fiscalLegislationDocumentReference = value;
    }

    /**
     * Gets the value of the environmentalLegislationDocumentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getEnvironmentalLegislationDocumentReference() {
        return environmentalLegislationDocumentReference;
    }

    /**
     * Sets the value of the environmentalLegislationDocumentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setEnvironmentalLegislationDocumentReference(DocumentReferenceType value) {
        this.environmentalLegislationDocumentReference = value;
    }

    /**
     * Gets the value of the employmentLegislationDocumentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getEmploymentLegislationDocumentReference() {
        return employmentLegislationDocumentReference;
    }

    /**
     * Sets the value of the employmentLegislationDocumentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setEmploymentLegislationDocumentReference(DocumentReferenceType value) {
        this.employmentLegislationDocumentReference = value;
    }

    /**
     * Gets the value of the contractualDocumentReference property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the contractualDocumentReference property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getContractualDocumentReference().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getContractualDocumentReference() {
        if (contractualDocumentReference == null) {
            contractualDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.contractualDocumentReference;
    }

    /**
     * Gets the value of the callForTenderDocumentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReferenceType }
     *     
     */
    public DocumentReferenceType getCallForTenderDocumentReference() {
        return callForTenderDocumentReference;
    }

    /**
     * Sets the value of the callForTenderDocumentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReferenceType }
     *     
     */
    public void setCallForTenderDocumentReference(DocumentReferenceType value) {
        this.callForTenderDocumentReference = value;
    }

    /**
     * Gets the value of the warrantyValidityPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getWarrantyValidityPeriod() {
        return warrantyValidityPeriod;
    }

    /**
     * Sets the value of the warrantyValidityPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setWarrantyValidityPeriod(PeriodType value) {
        this.warrantyValidityPeriod = value;
    }

    /**
     * Gets the value of the paymentTerms property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the paymentTerms property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPaymentTerms().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTermsType }
     * 
     * 
     */
    public List<PaymentTermsType> getPaymentTerms() {
        if (paymentTerms == null) {
            paymentTerms = new ArrayList<PaymentTermsType>();
        }
        return this.paymentTerms;
    }

    /**
     * Gets the value of the tendererQualificationRequest property.
     * 
     * @return
     *     possible object is
     *     {@link TendererQualificationRequestType }
     *     
     */
    public TendererQualificationRequestType getTendererQualificationRequest() {
        return tendererQualificationRequest;
    }

    /**
     * Sets the value of the tendererQualificationRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link TendererQualificationRequestType }
     *     
     */
    public void setTendererQualificationRequest(TendererQualificationRequestType value) {
        this.tendererQualificationRequest = value;
    }

    /**
     * Gets the value of the allowedSubcontractTerms property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the allowedSubcontractTerms property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAllowedSubcontractTerms().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link SubcontractTermsType }
     * 
     * 
     */
    public List<SubcontractTermsType> getAllowedSubcontractTerms() {
        if (allowedSubcontractTerms == null) {
            allowedSubcontractTerms = new ArrayList<SubcontractTermsType>();
        }
        return this.allowedSubcontractTerms;
    }

    /**
     * Gets the value of the tenderPreparation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the tenderPreparation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTenderPreparation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TenderPreparationType }
     * 
     * 
     */
    public List<TenderPreparationType> getTenderPreparation() {
        if (tenderPreparation == null) {
            tenderPreparation = new ArrayList<TenderPreparationType>();
        }
        return this.tenderPreparation;
    }

    /**
     * Gets the value of the contractExecutionRequirement property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the contractExecutionRequirement property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getContractExecutionRequirement().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ContractExecutionRequirementType }
     * 
     * 
     */
    public List<ContractExecutionRequirementType> getContractExecutionRequirement() {
        if (contractExecutionRequirement == null) {
            contractExecutionRequirement = new ArrayList<ContractExecutionRequirementType>();
        }
        return this.contractExecutionRequirement;
    }

    /**
     * Gets the value of the awardingTerms property.
     * 
     * @return
     *     possible object is
     *     {@link AwardingTermsType }
     *     
     */
    public AwardingTermsType getAwardingTerms() {
        return awardingTerms;
    }

    /**
     * Sets the value of the awardingTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link AwardingTermsType }
     *     
     */
    public void setAwardingTerms(AwardingTermsType value) {
        this.awardingTerms = value;
    }

    /**
     * Gets the value of the additionalInformationParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getAdditionalInformationParty() {
        return additionalInformationParty;
    }

    /**
     * Sets the value of the additionalInformationParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setAdditionalInformationParty(PartyType value) {
        this.additionalInformationParty = value;
    }

    /**
     * Gets the value of the documentProviderParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getDocumentProviderParty() {
        return documentProviderParty;
    }

    /**
     * Sets the value of the documentProviderParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setDocumentProviderParty(PartyType value) {
        this.documentProviderParty = value;
    }

    /**
     * Gets the value of the tenderRecipientParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getTenderRecipientParty() {
        return tenderRecipientParty;
    }

    /**
     * Sets the value of the tenderRecipientParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setTenderRecipientParty(PartyType value) {
        this.tenderRecipientParty = value;
    }

    /**
     * Gets the value of the contractResponsibleParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getContractResponsibleParty() {
        return contractResponsibleParty;
    }

    /**
     * Sets the value of the contractResponsibleParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setContractResponsibleParty(PartyType value) {
        this.contractResponsibleParty = value;
    }

    /**
     * Gets the value of the tenderEvaluationParty property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the tenderEvaluationParty property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getTenderEvaluationParty().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PartyType }
     * 
     * 
     */
    public List<PartyType> getTenderEvaluationParty() {
        if (tenderEvaluationParty == null) {
            tenderEvaluationParty = new ArrayList<PartyType>();
        }
        return this.tenderEvaluationParty;
    }

    /**
     * Gets the value of the tenderValidityPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getTenderValidityPeriod() {
        return tenderValidityPeriod;
    }

    /**
     * Sets the value of the tenderValidityPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setTenderValidityPeriod(PeriodType value) {
        this.tenderValidityPeriod = value;
    }

    /**
     * Gets the value of the contractAcceptancePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getContractAcceptancePeriod() {
        return contractAcceptancePeriod;
    }

    /**
     * Sets the value of the contractAcceptancePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setContractAcceptancePeriod(PeriodType value) {
        this.contractAcceptancePeriod = value;
    }

    /**
     * Gets the value of the appealTerms property.
     * 
     * @return
     *     possible object is
     *     {@link AppealTermsType }
     *     
     */
    public AppealTermsType getAppealTerms() {
        return appealTerms;
    }

    /**
     * Sets the value of the appealTerms property.
     * 
     * @param value
     *     allowed object is
     *     {@link AppealTermsType }
     *     
     */
    public void setAppealTerms(AppealTermsType value) {
        this.appealTerms = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the language property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getLanguage().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link LanguageType }
     * 
     * 
     */
    public List<LanguageType> getLanguage() {
        if (language == null) {
            language = new ArrayList<LanguageType>();
        }
        return this.language;
    }

    /**
     * Gets the value of the budgetAccountLine property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the budgetAccountLine property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getBudgetAccountLine().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link BudgetAccountLineType }
     * 
     * 
     */
    public List<BudgetAccountLineType> getBudgetAccountLine() {
        if (budgetAccountLine == null) {
            budgetAccountLine = new ArrayList<BudgetAccountLineType>();
        }
        return this.budgetAccountLine;
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
