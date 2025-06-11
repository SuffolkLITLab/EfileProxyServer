
package oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4;

import javax.xml.namespace.QName;
import gov.niem.niem.domains.jxdm._4.ArrestType;
import gov.niem.niem.domains.jxdm._4.StatuteType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.ImageType;
import gov.niem.niem.niem_core._2.IncidentType;
import gov.niem.niem.niem_core._2.RelatedActivityAssociationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.proxy.xsd._2.Duration;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4 package. 
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

    private final static QName _ArrestAgency_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "ArrestAgency");
    private final static QName _CaseArrest_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "CaseArrest");
    private final static QName _CaseCharge_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "CaseCharge");
    private final static QName _ChargeAmendedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "ChargeAmendedIndicator");
    private final static QName _ChargeChargingAgencyJurisdictionStatute_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "ChargeChargingAgencyJurisdictionStatute");
    private final static QName _ChargeOffense_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "ChargeOffense");
    private final static QName _CriminalCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "CriminalCase");
    private final static QName _Fingerprint_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "Fingerprint");
    private final static QName _FingerprintImage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "FingerprintImage");
    private final static QName _PersonInCustodyIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "PersonInCustodyIndicator");
    private final static QName _PreliminaryHearingEstimatedDuration_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "PreliminaryHearingEstimatedDuration");
    private final static QName _ProsecutionRecommendedBailText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "ProsecutionRecommendedBailText");
    private final static QName _Sentence_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "Sentence");
    private final static QName _SentenceConcurrentAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "SentenceConcurrentAssociation");
    private final static QName _SentenceFineAmount_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "SentenceFineAmount");
    private final static QName _Subject_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "Subject");
    private final static QName _WarrantIssuedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", "WarrantIssuedIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChargeType }
     * 
     */
    public ChargeType createChargeType() {
        return new ChargeType();
    }

    /**
     * Create an instance of {@link CriminalCaseType }
     * 
     */
    public CriminalCaseType createCriminalCaseType() {
        return new CriminalCaseType();
    }

    /**
     * Create an instance of {@link FingerprintType }
     * 
     */
    public FingerprintType createFingerprintType() {
        return new FingerprintType();
    }

    /**
     * Create an instance of {@link SentenceType }
     * 
     */
    public SentenceType createSentenceType() {
        return new SentenceType();
    }

    /**
     * Create an instance of {@link SubjectType }
     * 
     */
    public SubjectType createSubjectType() {
        return new SubjectType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "ArrestAgency", substitutionHeadNamespace = "http://niem.gov/niem/domains/jxdm/4.0", substitutionHeadName = "ArrestAgency")
    public JAXBElement<OrganizationType> createArrestAgency(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_ArrestAgency_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrestType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "CaseArrest")
    public JAXBElement<ArrestType> createCaseArrest(ArrestType value) {
        return new JAXBElement<ArrestType>(_CaseArrest_QNAME, ArrestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "CaseCharge")
    public JAXBElement<ChargeType> createCaseCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_CaseCharge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "ChargeAmendedIndicator")
    public JAXBElement<Boolean> createChargeAmendedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ChargeAmendedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "ChargeChargingAgencyJurisdictionStatute")
    public JAXBElement<StatuteType> createChargeChargingAgencyJurisdictionStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_ChargeChargingAgencyJurisdictionStatute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "ChargeOffense")
    public JAXBElement<IncidentType> createChargeOffense(IncidentType value) {
        return new JAXBElement<IncidentType>(_ChargeOffense_QNAME, IncidentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "CriminalCase", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Case")
    public JAXBElement<CriminalCaseType> createCriminalCase(CriminalCaseType value) {
        return new JAXBElement<CriminalCaseType>(_CriminalCase_QNAME, CriminalCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FingerprintType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FingerprintType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "Fingerprint", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Fingerprint")
    public JAXBElement<FingerprintType> createFingerprint(FingerprintType value) {
        return new JAXBElement<FingerprintType>(_Fingerprint_QNAME, FingerprintType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "FingerprintImage")
    public JAXBElement<ImageType> createFingerprintImage(ImageType value) {
        return new JAXBElement<ImageType>(_FingerprintImage_QNAME, ImageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "PersonInCustodyIndicator")
    public JAXBElement<Boolean> createPersonInCustodyIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_PersonInCustodyIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "PreliminaryHearingEstimatedDuration")
    public JAXBElement<Duration> createPreliminaryHearingEstimatedDuration(Duration value) {
        return new JAXBElement<Duration>(_PreliminaryHearingEstimatedDuration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "ProsecutionRecommendedBailText")
    public JAXBElement<TextType> createProsecutionRecommendedBailText(TextType value) {
        return new JAXBElement<TextType>(_ProsecutionRecommendedBailText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SentenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SentenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "Sentence")
    public JAXBElement<SentenceType> createSentence(SentenceType value) {
        return new JAXBElement<SentenceType>(_Sentence_QNAME, SentenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedActivityAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelatedActivityAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "SentenceConcurrentAssociation")
    public JAXBElement<RelatedActivityAssociationType> createSentenceConcurrentAssociation(RelatedActivityAssociationType value) {
        return new JAXBElement<RelatedActivityAssociationType>(_SentenceConcurrentAssociation_QNAME, RelatedActivityAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "SentenceFineAmount")
    public JAXBElement<AmountType> createSentenceFineAmount(AmountType value) {
        return new JAXBElement<AmountType>(_SentenceFineAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "Subject", substitutionHeadNamespace = "http://niem.gov/niem/domains/jxdm/4.0", substitutionHeadName = "ArrestSubject")
    public JAXBElement<SubjectType> createSubject(SubjectType value) {
        return new JAXBElement<SubjectType>(_Subject_QNAME, SubjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", name = "WarrantIssuedIndicator")
    public JAXBElement<Boolean> createWarrantIssuedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_WarrantIssuedIndicator_QNAME, Boolean.class, null, value);
    }

}
