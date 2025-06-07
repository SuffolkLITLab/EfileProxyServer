
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.niem_core._2.AmountType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CaseContestedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "CaseContestedIndicator");
    private final static QName _ChildSupportText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "ChildSupportText");
    private final static QName _CourtFindingsText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "CourtFindingsText");
    private final static QName _CustodyDescriptionText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "CustodyDescriptionText");
    private final static QName _DivorcePendingIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "DivorcePendingIndicator");
    private final static QName _DomesticCaseChildSupportPetition_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "DomesticCaseChildSupportPetition");
    private final static QName _DomesticCaseOrder_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "DomesticCaseOrder");
    private final static QName _DomesticCaseOrderTypeText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "DomesticCaseOrderTypeText");
    private final static QName _DomesticCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "DomesticCase");
    private final static QName _DomesticCasePerson_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "DomesticCasePerson");
    private final static QName _DomesticCaseViolencePetition_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "DomesticCaseViolencePetition");
    private final static QName _DomesticCaseObligation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "DomesticCaseObligation");
    private final static QName _FinancialObligation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "FinancialObligation");
    private final static QName _JurisdictionReasonText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "JurisdictionReasonText");
    private final static QName _MarriageAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "MarriageAssociation");
    private final static QName _NoContactCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "NoContactCode");
    private final static QName _ObligationIncomeAttachedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "ObligationIncomeAttachedIndicator");
    private final static QName _ObligationPaymentAmount_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "ObligationPaymentAmount");
    private final static QName _ObligationStateDisbursementIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "ObligationStateDisbursementIndicator");
    private final static QName _RequestToVacateCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "RequestToVacateCode");
    private final static QName _RequestToVacateText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "RequestToVacateText");
    private final static QName _RespondentDangerAlertIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "RespondentDangerAlertIndicator");
    private final static QName _StayawayDistanceText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", "StayawayDistanceText");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DomesticCaseChildSupportPetitionType }
     * 
     */
    public DomesticCaseChildSupportPetitionType createDomesticCaseChildSupportPetitionType() {
        return new DomesticCaseChildSupportPetitionType();
    }

    /**
     * Create an instance of {@link DomesticCaseOrderType }
     * 
     */
    public DomesticCaseOrderType createDomesticCaseOrderType() {
        return new DomesticCaseOrderType();
    }

    /**
     * Create an instance of {@link DomesticCaseType }
     * 
     */
    public DomesticCaseType createDomesticCaseType() {
        return new DomesticCaseType();
    }

    /**
     * Create an instance of {@link DomesticCaseViolencePetitionType }
     * 
     */
    public DomesticCaseViolencePetitionType createDomesticCaseViolencePetitionType() {
        return new DomesticCaseViolencePetitionType();
    }

    /**
     * Create an instance of {@link DomesticCaseObligationType }
     * 
     */
    public DomesticCaseObligationType createDomesticCaseObligationType() {
        return new DomesticCaseObligationType();
    }

    /**
     * Create an instance of {@link FinancialObligationType }
     * 
     */
    public FinancialObligationType createFinancialObligationType() {
        return new FinancialObligationType();
    }

    /**
     * Create an instance of {@link MarriageAssociationType }
     * 
     */
    public MarriageAssociationType createMarriageAssociationType() {
        return new MarriageAssociationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "CaseContestedIndicator")
    public JAXBElement<Boolean> createCaseContestedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CaseContestedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "ChildSupportText")
    public JAXBElement<TextType> createChildSupportText(TextType value) {
        return new JAXBElement<TextType>(_ChildSupportText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "CourtFindingsText")
    public JAXBElement<TextType> createCourtFindingsText(TextType value) {
        return new JAXBElement<TextType>(_CourtFindingsText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "CustodyDescriptionText")
    public JAXBElement<TextType> createCustodyDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_CustodyDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "DivorcePendingIndicator")
    public JAXBElement<Boolean> createDivorcePendingIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DivorcePendingIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomesticCaseChildSupportPetitionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DomesticCaseChildSupportPetitionType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "DomesticCaseChildSupportPetition")
    public JAXBElement<DomesticCaseChildSupportPetitionType> createDomesticCaseChildSupportPetition(DomesticCaseChildSupportPetitionType value) {
        return new JAXBElement<DomesticCaseChildSupportPetitionType>(_DomesticCaseChildSupportPetition_QNAME, DomesticCaseChildSupportPetitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomesticCaseOrderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DomesticCaseOrderType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "DomesticCaseOrder")
    public JAXBElement<DomesticCaseOrderType> createDomesticCaseOrder(DomesticCaseOrderType value) {
        return new JAXBElement<DomesticCaseOrderType>(_DomesticCaseOrder_QNAME, DomesticCaseOrderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "DomesticCaseOrderTypeText")
    public JAXBElement<TextType> createDomesticCaseOrderTypeText(TextType value) {
        return new JAXBElement<TextType>(_DomesticCaseOrderTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "DomesticCase", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Case")
    public JAXBElement<DomesticCaseType> createDomesticCase(DomesticCaseType value) {
        return new JAXBElement<DomesticCaseType>(_DomesticCase_QNAME, DomesticCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "DomesticCasePerson")
    public JAXBElement<PersonType> createDomesticCasePerson(PersonType value) {
        return new JAXBElement<PersonType>(_DomesticCasePerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomesticCaseViolencePetitionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DomesticCaseViolencePetitionType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "DomesticCaseViolencePetition")
    public JAXBElement<DomesticCaseViolencePetitionType> createDomesticCaseViolencePetition(DomesticCaseViolencePetitionType value) {
        return new JAXBElement<DomesticCaseViolencePetitionType>(_DomesticCaseViolencePetition_QNAME, DomesticCaseViolencePetitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomesticCaseObligationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DomesticCaseObligationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "DomesticCaseObligation")
    public JAXBElement<DomesticCaseObligationType> createDomesticCaseObligation(DomesticCaseObligationType value) {
        return new JAXBElement<DomesticCaseObligationType>(_DomesticCaseObligation_QNAME, DomesticCaseObligationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinancialObligationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FinancialObligationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "FinancialObligation")
    public JAXBElement<FinancialObligationType> createFinancialObligation(FinancialObligationType value) {
        return new JAXBElement<FinancialObligationType>(_FinancialObligation_QNAME, FinancialObligationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "JurisdictionReasonText")
    public JAXBElement<TextType> createJurisdictionReasonText(TextType value) {
        return new JAXBElement<TextType>(_JurisdictionReasonText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarriageAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MarriageAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "MarriageAssociation")
    public JAXBElement<MarriageAssociationType> createMarriageAssociation(MarriageAssociationType value) {
        return new JAXBElement<MarriageAssociationType>(_MarriageAssociation_QNAME, MarriageAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "NoContactCode")
    public JAXBElement<TextType> createNoContactCode(TextType value) {
        return new JAXBElement<TextType>(_NoContactCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "ObligationIncomeAttachedIndicator")
    public JAXBElement<Boolean> createObligationIncomeAttachedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ObligationIncomeAttachedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "ObligationPaymentAmount")
    public JAXBElement<AmountType> createObligationPaymentAmount(AmountType value) {
        return new JAXBElement<AmountType>(_ObligationPaymentAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "ObligationStateDisbursementIndicator")
    public JAXBElement<Boolean> createObligationStateDisbursementIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ObligationStateDisbursementIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "RequestToVacateCode")
    public JAXBElement<TextType> createRequestToVacateCode(TextType value) {
        return new JAXBElement<TextType>(_RequestToVacateCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "RequestToVacateText")
    public JAXBElement<TextType> createRequestToVacateText(TextType value) {
        return new JAXBElement<TextType>(_RequestToVacateText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "RespondentDangerAlertIndicator")
    public JAXBElement<Boolean> createRespondentDangerAlertIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_RespondentDangerAlertIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0", name = "StayawayDistanceText")
    public JAXBElement<TextType> createStayawayDistanceText(TextType value) {
        return new JAXBElement<TextType>(_StayawayDistanceText_QNAME, TextType.class, null, value);
    }

}
