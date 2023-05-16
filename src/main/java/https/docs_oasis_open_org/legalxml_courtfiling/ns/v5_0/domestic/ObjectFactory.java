
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.domestic;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.domestic package. 
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

    private final static QName _CaseAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "CaseAugmentation");
    private final static QName _CaseContestedIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "CaseContestedIndicator");
    private final static QName _ChildSuportText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "ChildSuportText");
    private final static QName _CourtFindingsText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "CourtFindingsText");
    private final static QName _CustodyDescriptionText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "CustodyDescriptionText");
    private final static QName _DomesticCaseOrder_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "DomesticCaseOrder");
    private final static QName _DomesticCaseOrderTypeText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "DomesticCaseOrderTypeText");
    private final static QName _DomesticViolencePetition_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "DomesticViolencePetition");
    private final static QName _FinancialObligation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "FinancialObligation");
    private final static QName _IncomeAttachedIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "IncomeAttachedIndicator");
    private final static QName _ObligationPaymentAmount_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "ObligationPaymentAmount");
    private final static QName _RespondentDangerAlertindicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", "RespondentDangerAlertindicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.domestic
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link DomesticCaseOrderType }
     * 
     */
    public DomesticCaseOrderType createDomesticCaseOrderType() {
        return new DomesticCaseOrderType();
    }

    /**
     * Create an instance of {@link DomesticViolencePetitionType }
     * 
     */
    public DomesticViolencePetitionType createDomesticViolencePetitionType() {
        return new DomesticViolencePetitionType();
    }

    /**
     * Create an instance of {@link FinancialObligationType }
     * 
     */
    public FinancialObligationType createFinancialObligationType() {
        return new FinancialObligationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "CaseAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CaseAugmentationPoint")
    public JAXBElement<CaseAugmentationType> createCaseAugmentation(CaseAugmentationType value) {
        return new JAXBElement<CaseAugmentationType>(_CaseAugmentation_QNAME, CaseAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "CaseContestedIndicator")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "ChildSuportText")
    public JAXBElement<TextType> createChildSuportText(TextType value) {
        return new JAXBElement<TextType>(_ChildSuportText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "CourtFindingsText")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "CustodyDescriptionText")
    public JAXBElement<TextType> createCustodyDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_CustodyDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomesticCaseOrderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DomesticCaseOrderType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "DomesticCaseOrder")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "DomesticCaseOrderTypeText")
    public JAXBElement<TextType> createDomesticCaseOrderTypeText(TextType value) {
        return new JAXBElement<TextType>(_DomesticCaseOrderTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DomesticViolencePetitionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DomesticViolencePetitionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "DomesticViolencePetition")
    public JAXBElement<DomesticViolencePetitionType> createDomesticViolencePetition(DomesticViolencePetitionType value) {
        return new JAXBElement<DomesticViolencePetitionType>(_DomesticViolencePetition_QNAME, DomesticViolencePetitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FinancialObligationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FinancialObligationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "FinancialObligation")
    public JAXBElement<FinancialObligationType> createFinancialObligation(FinancialObligationType value) {
        return new JAXBElement<FinancialObligationType>(_FinancialObligation_QNAME, FinancialObligationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "IncomeAttachedIndicator")
    public JAXBElement<Boolean> createIncomeAttachedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncomeAttachedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "ObligationPaymentAmount")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic", name = "RespondentDangerAlertindicator")
    public JAXBElement<Boolean> createRespondentDangerAlertindicator(Boolean value) {
        return new JAXBElement<Boolean>(_RespondentDangerAlertindicator_QNAME, Boolean.class, null, value);
    }

}
