
package ecf4.latest.tyler.ecf.v5_0.extensions.common;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DateType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.tyler.ecf.v5_0.extensions.common package. 
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

    private final static QName _MotionTypeCode_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "MotionTypeCode");
    private final static QName _CourtRoom_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "CourtRoom");
    private final static QName _CourtStreet_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "CourtStreet");
    private final static QName _CourtCityStateZip_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "CourtCityStateZip");
    private final static QName _CourtEventAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "CourtEventAugmentation");
    private final static QName _CaseAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "CaseAugmentation");
    private final static QName _PartyReference_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "PartyReference");
    private final static QName _AttorneyReference_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "AttorneyReference");
    private final static QName _PartyIdentification_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "PartyIdentification");
    private final static QName _FilingParty_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "FilingParty");
    private final static QName _FilingAttorney_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "FilingAttorney");
    private final static QName _AttorneyIdentification_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "AttorneyIdentification");
    private final static QName _OutOfStateIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "OutOfStateIndicator");
    private final static QName _ReserveDateAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "ReserveDateAugmentation");
    private final static QName _AllocateCourtDateAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "AllocateCourtDateAugmentation");
    private final static QName _CrossReferenceNumber_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "CrossReferenceNumber");
    private final static QName _ScheduleDayStartTime_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "ScheduleDayStartTime");
    private final static QName _ScheduleDayEndTime_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "ScheduleDayEndTime");
    private final static QName _CourtSchedule_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "CourtSchedule");
    private final static QName _HearingIdentification_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:common", "HearingIdentification");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.tyler.ecf.v5_0.extensions.common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CourtEventAugmentationType }
     * 
     */
    public CourtEventAugmentationType createCourtEventAugmentationType() {
        return new CourtEventAugmentationType();
    }

    /**
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link FilingReferenceType }
     * 
     */
    public FilingReferenceType createFilingReferenceType() {
        return new FilingReferenceType();
    }

    /**
     * Create an instance of {@link FilingPartyEntityType }
     * 
     */
    public FilingPartyEntityType createFilingPartyEntityType() {
        return new FilingPartyEntityType();
    }

    /**
     * Create an instance of {@link FilingAttorneyEntityType }
     * 
     */
    public FilingAttorneyEntityType createFilingAttorneyEntityType() {
        return new FilingAttorneyEntityType();
    }

    /**
     * Create an instance of {@link ReserveDateAugmentationType }
     * 
     */
    public ReserveDateAugmentationType createReserveDateAugmentationType() {
        return new ReserveDateAugmentationType();
    }

    /**
     * Create an instance of {@link AllocateCourtDateAugmentationType }
     * 
     */
    public AllocateCourtDateAugmentationType createAllocateCourtDateAugmentationType() {
        return new AllocateCourtDateAugmentationType();
    }

    /**
     * Create an instance of {@link CourtScheduleType }
     * 
     */
    public CourtScheduleType createCourtScheduleType() {
        return new CourtScheduleType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "MotionTypeCode", substitutionHeadNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", substitutionHeadName = "CourtLocationCode")
    public JAXBElement<TextType> createMotionTypeCode(TextType value) {
        return new JAXBElement<TextType>(_MotionTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "CourtRoom")
    public JAXBElement<TextType> createCourtRoom(TextType value) {
        return new JAXBElement<TextType>(_CourtRoom_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "CourtStreet")
    public JAXBElement<TextType> createCourtStreet(TextType value) {
        return new JAXBElement<TextType>(_CourtStreet_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "CourtCityStateZip")
    public JAXBElement<TextType> createCourtCityStateZip(TextType value) {
        return new JAXBElement<TextType>(_CourtCityStateZip_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "CourtEventAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "CourtEventAugmentationPoint")
    public JAXBElement<CourtEventAugmentationType> createCourtEventAugmentation(CourtEventAugmentationType value) {
        return new JAXBElement<CourtEventAugmentationType>(_CourtEventAugmentation_QNAME, CourtEventAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "CaseAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CaseAugmentationPoint")
    public JAXBElement<CaseAugmentationType> createCaseAugmentation(CaseAugmentationType value) {
        return new JAXBElement<CaseAugmentationType>(_CaseAugmentation_QNAME, CaseAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "PartyReference")
    public JAXBElement<FilingReferenceType> createPartyReference(FilingReferenceType value) {
        return new JAXBElement<FilingReferenceType>(_PartyReference_QNAME, FilingReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "AttorneyReference")
    public JAXBElement<FilingReferenceType> createAttorneyReference(FilingReferenceType value) {
        return new JAXBElement<FilingReferenceType>(_AttorneyReference_QNAME, FilingReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "PartyIdentification")
    public JAXBElement<IdentificationType> createPartyIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PartyIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingPartyEntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingPartyEntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "FilingParty")
    public JAXBElement<FilingPartyEntityType> createFilingParty(FilingPartyEntityType value) {
        return new JAXBElement<FilingPartyEntityType>(_FilingParty_QNAME, FilingPartyEntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingAttorneyEntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingAttorneyEntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "FilingAttorney")
    public JAXBElement<FilingAttorneyEntityType> createFilingAttorney(FilingAttorneyEntityType value) {
        return new JAXBElement<FilingAttorneyEntityType>(_FilingAttorney_QNAME, FilingAttorneyEntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "AttorneyIdentification")
    public JAXBElement<IdentificationType> createAttorneyIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_AttorneyIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "OutOfStateIndicator")
    public JAXBElement<Boolean> createOutOfStateIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_OutOfStateIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveDateAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReserveDateAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "ReserveDateAugmentation", substitutionHeadNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", substitutionHeadName = "ReserveCourtDateMessageAugmentationPoint")
    public JAXBElement<ReserveDateAugmentationType> createReserveDateAugmentation(ReserveDateAugmentationType value) {
        return new JAXBElement<ReserveDateAugmentationType>(_ReserveDateAugmentation_QNAME, ReserveDateAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllocateCourtDateAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AllocateCourtDateAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "AllocateCourtDateAugmentation", substitutionHeadNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate", substitutionHeadName = "AllocateCourtDateMessageAugmentationPoint")
    public JAXBElement<AllocateCourtDateAugmentationType> createAllocateCourtDateAugmentation(AllocateCourtDateAugmentationType value) {
        return new JAXBElement<AllocateCourtDateAugmentationType>(_AllocateCourtDateAugmentation_QNAME, AllocateCourtDateAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "CrossReferenceNumber")
    public JAXBElement<IdentificationType> createCrossReferenceNumber(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_CrossReferenceNumber_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "ScheduleDayStartTime")
    public JAXBElement<DateType> createScheduleDayStartTime(DateType value) {
        return new JAXBElement<DateType>(_ScheduleDayStartTime_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "ScheduleDayEndTime")
    public JAXBElement<DateType> createScheduleDayEndTime(DateType value) {
        return new JAXBElement<DateType>(_ScheduleDayEndTime_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtScheduleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtScheduleType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "CourtSchedule")
    public JAXBElement<CourtScheduleType> createCourtSchedule(CourtScheduleType value) {
        return new JAXBElement<CourtScheduleType>(_CourtSchedule_QNAME, CourtScheduleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:common", name = "HearingIdentification")
    public JAXBElement<IdentificationType> createHearingIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_HearingIdentification_QNAME, IdentificationType.class, null, value);
    }

}
