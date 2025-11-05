
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.ArrestType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.StatuteType;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4 package. 
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

    private final static QName _CaseArrest_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "CaseArrest");
    private final static QName _DelinquentAct_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DelinquentAct");
    private final static QName _DelinquentActStatute_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DelinquentActStatute");
    private final static QName _DelinquentActSeverityCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DelinquentActSeverityCode");
    private final static QName _DelinquentActDegreeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DelinquentActDegreeCode");
    private final static QName _DelinquentActApplicabilityCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DelinquentActApplicabilityCode");
    private final static QName _DelinquentActSpecialAllegationCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DelinquentActSpecialAllegationCode");
    private final static QName _DependencyAllegation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DependencyAllegation");
    private final static QName _DependencyAllegationCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DependencyAllegationCode");
    private final static QName _DependencyAllegationText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "DependencyAllegationText");
    private final static QName _GuardianAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "GuardianAssociation");
    private final static QName _GuardianAssociationTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "GuardianAssociationTypeCode");
    private final static QName _JuvenileCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "JuvenileCase");
    private final static QName _JuvenileCaseJuvenile_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "JuvenileCaseJuvenile");
    private final static QName _PersonEmancipatedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "PersonEmancipatedIndicator");
    private final static QName _PlacementAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "PlacementAssociation");
    private final static QName _PlacementEntity_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "PlacementEntity");
    private final static QName _PlacementTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "PlacementTypeCode");
    private final static QName _PlacementStartDate_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "PlacementStartDate");
    private final static QName _StatusOffenseAct_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "StatusOffenseAct");
    private final static QName _StatusOffenseActStatute_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "StatusOffenseActStatute");
    private final static QName _SubjectICEIdentification_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", "SubjectICEIdentification");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DelinquentActType }
     * 
     */
    public DelinquentActType createDelinquentActType() {
        return new DelinquentActType();
    }

    /**
     * Create an instance of {@link DependencyAllegationType }
     * 
     */
    public DependencyAllegationType createDependencyAllegationType() {
        return new DependencyAllegationType();
    }

    /**
     * Create an instance of {@link GuardianAssociationType }
     * 
     */
    public GuardianAssociationType createGuardianAssociationType() {
        return new GuardianAssociationType();
    }

    /**
     * Create an instance of {@link JuvenileCaseType }
     * 
     */
    public JuvenileCaseType createJuvenileCaseType() {
        return new JuvenileCaseType();
    }

    /**
     * Create an instance of {@link JuvenileType }
     * 
     */
    public JuvenileType createJuvenileType() {
        return new JuvenileType();
    }

    /**
     * Create an instance of {@link StatusOffenseActType }
     * 
     */
    public StatusOffenseActType createStatusOffenseActType() {
        return new StatusOffenseActType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrestType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "CaseArrest")
    public JAXBElement<ArrestType> createCaseArrest(ArrestType value) {
        return new JAXBElement<ArrestType>(_CaseArrest_QNAME, ArrestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DelinquentActType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DelinquentActType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DelinquentAct")
    public JAXBElement<DelinquentActType> createDelinquentAct(DelinquentActType value) {
        return new JAXBElement<DelinquentActType>(_DelinquentAct_QNAME, DelinquentActType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DelinquentActStatute")
    public JAXBElement<StatuteType> createDelinquentActStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_DelinquentActStatute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DelinquentActSeverityCode")
    public JAXBElement<TextType> createDelinquentActSeverityCode(TextType value) {
        return new JAXBElement<TextType>(_DelinquentActSeverityCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DelinquentActDegreeCode")
    public JAXBElement<TextType> createDelinquentActDegreeCode(TextType value) {
        return new JAXBElement<TextType>(_DelinquentActDegreeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DelinquentActApplicabilityCode")
    public JAXBElement<TextType> createDelinquentActApplicabilityCode(TextType value) {
        return new JAXBElement<TextType>(_DelinquentActApplicabilityCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DelinquentActSpecialAllegationCode")
    public JAXBElement<TextType> createDelinquentActSpecialAllegationCode(TextType value) {
        return new JAXBElement<TextType>(_DelinquentActSpecialAllegationCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DependencyAllegationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DependencyAllegationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DependencyAllegation")
    public JAXBElement<DependencyAllegationType> createDependencyAllegation(DependencyAllegationType value) {
        return new JAXBElement<DependencyAllegationType>(_DependencyAllegation_QNAME, DependencyAllegationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DependencyAllegationCode")
    public JAXBElement<TextType> createDependencyAllegationCode(TextType value) {
        return new JAXBElement<TextType>(_DependencyAllegationCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "DependencyAllegationText")
    public JAXBElement<TextType> createDependencyAllegationText(TextType value) {
        return new JAXBElement<TextType>(_DependencyAllegationText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardianAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GuardianAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "GuardianAssociation")
    public JAXBElement<GuardianAssociationType> createGuardianAssociation(GuardianAssociationType value) {
        return new JAXBElement<GuardianAssociationType>(_GuardianAssociation_QNAME, GuardianAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "GuardianAssociationTypeCode")
    public JAXBElement<TextType> createGuardianAssociationTypeCode(TextType value) {
        return new JAXBElement<TextType>(_GuardianAssociationTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "JuvenileCase", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Case")
    public JAXBElement<JuvenileCaseType> createJuvenileCase(JuvenileCaseType value) {
        return new JAXBElement<JuvenileCaseType>(_JuvenileCase_QNAME, JuvenileCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenileType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenileType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "JuvenileCaseJuvenile")
    public JAXBElement<JuvenileType> createJuvenileCaseJuvenile(JuvenileType value) {
        return new JAXBElement<JuvenileType>(_JuvenileCaseJuvenile_QNAME, JuvenileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "PersonEmancipatedIndicator")
    public JAXBElement<Boolean> createPersonEmancipatedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_PersonEmancipatedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlacementAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PlacementAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "PlacementAssociation")
    public JAXBElement<PlacementAssociationType> createPlacementAssociation(PlacementAssociationType value) {
        return new JAXBElement<PlacementAssociationType>(_PlacementAssociation_QNAME, PlacementAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "PlacementEntity")
    public JAXBElement<EntityType> createPlacementEntity(EntityType value) {
        return new JAXBElement<EntityType>(_PlacementEntity_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "PlacementTypeCode")
    public JAXBElement<TextType> createPlacementTypeCode(TextType value) {
        return new JAXBElement<TextType>(_PlacementTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "PlacementStartDate")
    public JAXBElement<DateType> createPlacementStartDate(DateType value) {
        return new JAXBElement<DateType>(_PlacementStartDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusOffenseActType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusOffenseActType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "StatusOffenseAct")
    public JAXBElement<StatusOffenseActType> createStatusOffenseAct(StatusOffenseActType value) {
        return new JAXBElement<StatusOffenseActType>(_StatusOffenseAct_QNAME, StatusOffenseActType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "StatusOffenseActStatute")
    public JAXBElement<StatuteType> createStatusOffenseActStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_StatusOffenseActStatute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0", name = "SubjectICEIdentification")
    public JAXBElement<IdentificationType> createSubjectICEIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_SubjectICEIdentification_QNAME, IdentificationType.class, null, value);
    }

}
