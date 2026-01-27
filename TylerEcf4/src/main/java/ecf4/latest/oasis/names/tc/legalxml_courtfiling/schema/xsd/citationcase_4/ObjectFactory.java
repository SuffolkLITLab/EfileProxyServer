
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.niem_core._2.NumericType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.InsuranceType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4 package. 
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

    private final static QName _CitationCaseAugmentation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "CitationCaseAugmentation");
    private final static QName _CitationCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "CitationCase");
    private final static QName _CitationSubject_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "CitationSubject");
    private final static QName _Vehicle_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "Vehicle");
    private final static QName _DrivingIncident_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "DrivingIncident");
    private final static QName _PersonBloodAlcoholNumber_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "PersonBloodAlcoholNumber");
    private final static QName _ParkingFacilityName_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "ParkingFacilityName");
    private final static QName _ParkingMeterSpaceNumber_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "ParkingMeterSpaceNumber");
    private final static QName _ParkingViolation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "ParkingViolation");
    private final static QName _RedLightCameraIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "RedLightCameraIndicator");
    private final static QName _VehicleOwnerInsuranceCoverage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "VehicleOwnerInsuranceCoverage");
    private final static QName _VehicleOperatorInsuranceCoverage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", "VehicleOperatorInsuranceCoverage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CitationCaseAugmentationType }
     * 
     */
    public CitationCaseAugmentationType createCitationCaseAugmentationType() {
        return new CitationCaseAugmentationType();
    }

    /**
     * Create an instance of {@link CitationCaseType }
     * 
     */
    public CitationCaseType createCitationCaseType() {
        return new CitationCaseType();
    }

    /**
     * Create an instance of {@link SubjectType }
     * 
     */
    public SubjectType createSubjectType() {
        return new SubjectType();
    }

    /**
     * Create an instance of {@link VehicleType }
     * 
     */
    public VehicleType createVehicleType() {
        return new VehicleType();
    }

    /**
     * Create an instance of {@link DrivingIncidentType }
     * 
     */
    public DrivingIncidentType createDrivingIncidentType() {
        return new DrivingIncidentType();
    }

    /**
     * Create an instance of {@link ParkingViolationType }
     * 
     */
    public ParkingViolationType createParkingViolationType() {
        return new ParkingViolationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CitationCaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CitationCaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "CitationCaseAugmentation")
    public JAXBElement<CitationCaseAugmentationType> createCitationCaseAugmentation(CitationCaseAugmentationType value) {
        return new JAXBElement<CitationCaseAugmentationType>(_CitationCaseAugmentation_QNAME, CitationCaseAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "CitationCase", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Case")
    public JAXBElement<CitationCaseType> createCitationCase(CitationCaseType value) {
        return new JAXBElement<CitationCaseType>(_CitationCase_QNAME, CitationCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "CitationSubject")
    public JAXBElement<SubjectType> createCitationSubject(SubjectType value) {
        return new JAXBElement<SubjectType>(_CitationSubject_QNAME, SubjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VehicleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VehicleType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "Vehicle")
    public JAXBElement<VehicleType> createVehicle(VehicleType value) {
        return new JAXBElement<VehicleType>(_Vehicle_QNAME, VehicleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrivingIncidentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DrivingIncidentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "DrivingIncident")
    public JAXBElement<DrivingIncidentType> createDrivingIncident(DrivingIncidentType value) {
        return new JAXBElement<DrivingIncidentType>(_DrivingIncident_QNAME, DrivingIncidentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "PersonBloodAlcoholNumber")
    public JAXBElement<TextType> createPersonBloodAlcoholNumber(TextType value) {
        return new JAXBElement<TextType>(_PersonBloodAlcoholNumber_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "ParkingFacilityName")
    public JAXBElement<TextType> createParkingFacilityName(TextType value) {
        return new JAXBElement<TextType>(_ParkingFacilityName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumericType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NumericType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "ParkingMeterSpaceNumber")
    public JAXBElement<NumericType> createParkingMeterSpaceNumber(NumericType value) {
        return new JAXBElement<NumericType>(_ParkingMeterSpaceNumber_QNAME, NumericType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParkingViolationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParkingViolationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "ParkingViolation")
    public JAXBElement<ParkingViolationType> createParkingViolation(ParkingViolationType value) {
        return new JAXBElement<ParkingViolationType>(_ParkingViolation_QNAME, ParkingViolationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "RedLightCameraIndicator")
    public JAXBElement<Boolean> createRedLightCameraIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_RedLightCameraIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "VehicleOwnerInsuranceCoverage")
    public JAXBElement<InsuranceType> createVehicleOwnerInsuranceCoverage(InsuranceType value) {
        return new JAXBElement<InsuranceType>(_VehicleOwnerInsuranceCoverage_QNAME, InsuranceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", name = "VehicleOperatorInsuranceCoverage")
    public JAXBElement<InsuranceType> createVehicleOperatorInsuranceCoverage(InsuranceType value) {
        return new JAXBElement<InsuranceType>(_VehicleOperatorInsuranceCoverage_QNAME, InsuranceType.class, null, value);
    }

}
