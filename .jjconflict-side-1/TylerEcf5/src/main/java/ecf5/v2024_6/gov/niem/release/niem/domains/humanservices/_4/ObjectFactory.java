
package ecf5.v2024_6.gov.niem.release.niem.domains.humanservices._4;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.FacilityType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IncidentType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.OrganizationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.PersonType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.gov.niem.release.niem.domains.humanservices._4 package. 
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

    private final static QName _AbuseNeglectAllegationCategoryText_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "AbuseNeglectAllegationCategoryText");
    private final static QName _BiologicalParentDeterminationDescriptionText_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "BiologicalParentDeterminationDescriptionText");
    private final static QName _Child_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "Child");
    private final static QName _ChildSupportEnforcementCase_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "ChildSupportEnforcementCase");
    private final static QName _DelinquentAct_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "DelinquentAct");
    private final static QName _DependencyPetition_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "DependencyPetition");
    private final static QName _GangOrganization_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "GangOrganization");
    private final static QName _Juvenile_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "Juvenile");
    private final static QName _JuvenileAbuseNeglectAllegation_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "JuvenileAbuseNeglectAllegation");
    private final static QName _JuvenileAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "JuvenileAugmentationPoint");
    private final static QName _JuvenileCase_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "JuvenileCase");
    private final static QName _JuvenilePlacement_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "JuvenilePlacement");
    private final static QName _JuvenilePlacementFacilityAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "JuvenilePlacementFacilityAssociation");
    private final static QName _JuvenilePlacementPersonAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "JuvenilePlacementPersonAssociation");
    private final static QName _Parent_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "Parent");
    private final static QName _ParentChildAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "ParentChildAssociation");
    private final static QName _ParentChildKinshipCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "ParentChildKinshipCategoryAbstract");
    private final static QName _ParentChildKinshipCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "ParentChildKinshipCategoryCode");
    private final static QName _PersonCaseAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "PersonCaseAssociation");
    private final static QName _PersonCaseAssociationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "PersonCaseAssociationAugmentationPoint");
    private final static QName _PlacementAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "PlacementAugmentationPoint");
    private final static QName _PlacementCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "PlacementCategoryAbstract");
    private final static QName _PlacementCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "PlacementCategoryCode");
    private final static QName _PlacementFacility_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "PlacementFacility");
    private final static QName _PlacementPerson_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "PlacementPerson");
    private final static QName _StateDisbursementIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "StateDisbursementIndicator");
    private final static QName _SupportingGroundsDescriptionText_QNAME = new QName("http://release.niem.gov/niem/domains/humanServices/4.1/", "SupportingGroundsDescriptionText");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.gov.niem.release.niem.domains.humanservices._4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ChildType }
     * 
     */
    public ChildType createChildType() {
        return new ChildType();
    }

    /**
     * Create an instance of {@link ChildSupportEnforcementCaseType }
     * 
     */
    public ChildSupportEnforcementCaseType createChildSupportEnforcementCaseType() {
        return new ChildSupportEnforcementCaseType();
    }

    /**
     * Create an instance of {@link DependencyPetitionType }
     * 
     */
    public DependencyPetitionType createDependencyPetitionType() {
        return new DependencyPetitionType();
    }

    /**
     * Create an instance of {@link JuvenileType }
     * 
     */
    public JuvenileType createJuvenileType() {
        return new JuvenileType();
    }

    /**
     * Create an instance of {@link JuvenileAbuseNeglectAllegationType }
     * 
     */
    public JuvenileAbuseNeglectAllegationType createJuvenileAbuseNeglectAllegationType() {
        return new JuvenileAbuseNeglectAllegationType();
    }

    /**
     * Create an instance of {@link JuvenileCaseType }
     * 
     */
    public JuvenileCaseType createJuvenileCaseType() {
        return new JuvenileCaseType();
    }

    /**
     * Create an instance of {@link JuvenilePlacementType }
     * 
     */
    public JuvenilePlacementType createJuvenilePlacementType() {
        return new JuvenilePlacementType();
    }

    /**
     * Create an instance of {@link JuvenilePlacementFacilityAssociationType }
     * 
     */
    public JuvenilePlacementFacilityAssociationType createJuvenilePlacementFacilityAssociationType() {
        return new JuvenilePlacementFacilityAssociationType();
    }

    /**
     * Create an instance of {@link JuvenilePlacementPersonAssociationType }
     * 
     */
    public JuvenilePlacementPersonAssociationType createJuvenilePlacementPersonAssociationType() {
        return new JuvenilePlacementPersonAssociationType();
    }

    /**
     * Create an instance of {@link ParentChildAssociationType }
     * 
     */
    public ParentChildAssociationType createParentChildAssociationType() {
        return new ParentChildAssociationType();
    }

    /**
     * Create an instance of {@link ParentChildKinshipCategoryCodeType }
     * 
     */
    public ParentChildKinshipCategoryCodeType createParentChildKinshipCategoryCodeType() {
        return new ParentChildKinshipCategoryCodeType();
    }

    /**
     * Create an instance of {@link PersonCaseAssociationType }
     * 
     */
    public PersonCaseAssociationType createPersonCaseAssociationType() {
        return new PersonCaseAssociationType();
    }

    /**
     * Create an instance of {@link PlacementLocationCodeType }
     * 
     */
    public PlacementLocationCodeType createPlacementLocationCodeType() {
        return new PlacementLocationCodeType();
    }

    /**
     * Create an instance of {@link JuvenileGangAssociationType }
     * 
     */
    public JuvenileGangAssociationType createJuvenileGangAssociationType() {
        return new JuvenileGangAssociationType();
    }

    /**
     * Create an instance of {@link PlacementType }
     * 
     */
    public PlacementType createPlacementType() {
        return new PlacementType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "AbuseNeglectAllegationCategoryText")
    public JAXBElement<TextType> createAbuseNeglectAllegationCategoryText(TextType value) {
        return new JAXBElement<TextType>(_AbuseNeglectAllegationCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "BiologicalParentDeterminationDescriptionText")
    public JAXBElement<TextType> createBiologicalParentDeterminationDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_BiologicalParentDeterminationDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChildType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChildType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "Child")
    public JAXBElement<ChildType> createChild(ChildType value) {
        return new JAXBElement<ChildType>(_Child_QNAME, ChildType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChildSupportEnforcementCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChildSupportEnforcementCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "ChildSupportEnforcementCase", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "Case")
    public JAXBElement<ChildSupportEnforcementCaseType> createChildSupportEnforcementCase(ChildSupportEnforcementCaseType value) {
        return new JAXBElement<ChildSupportEnforcementCaseType>(_ChildSupportEnforcementCase_QNAME, ChildSupportEnforcementCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "DelinquentAct")
    public JAXBElement<IncidentType> createDelinquentAct(IncidentType value) {
        return new JAXBElement<IncidentType>(_DelinquentAct_QNAME, IncidentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DependencyPetitionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DependencyPetitionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "DependencyPetition")
    public JAXBElement<DependencyPetitionType> createDependencyPetition(DependencyPetitionType value) {
        return new JAXBElement<DependencyPetitionType>(_DependencyPetition_QNAME, DependencyPetitionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "GangOrganization")
    public JAXBElement<OrganizationType> createGangOrganization(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_GangOrganization_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenileType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenileType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "Juvenile")
    public JAXBElement<JuvenileType> createJuvenile(JuvenileType value) {
        return new JAXBElement<JuvenileType>(_Juvenile_QNAME, JuvenileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenileAbuseNeglectAllegationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenileAbuseNeglectAllegationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "JuvenileAbuseNeglectAllegation")
    public JAXBElement<JuvenileAbuseNeglectAllegationType> createJuvenileAbuseNeglectAllegation(JuvenileAbuseNeglectAllegationType value) {
        return new JAXBElement<JuvenileAbuseNeglectAllegationType>(_JuvenileAbuseNeglectAllegation_QNAME, JuvenileAbuseNeglectAllegationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "JuvenileAugmentationPoint")
    public JAXBElement<Object> createJuvenileAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_JuvenileAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "JuvenileCase")
    public JAXBElement<JuvenileCaseType> createJuvenileCase(JuvenileCaseType value) {
        return new JAXBElement<JuvenileCaseType>(_JuvenileCase_QNAME, JuvenileCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenilePlacementType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenilePlacementType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "JuvenilePlacement")
    public JAXBElement<JuvenilePlacementType> createJuvenilePlacement(JuvenilePlacementType value) {
        return new JAXBElement<JuvenilePlacementType>(_JuvenilePlacement_QNAME, JuvenilePlacementType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenilePlacementFacilityAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenilePlacementFacilityAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "JuvenilePlacementFacilityAssociation")
    public JAXBElement<JuvenilePlacementFacilityAssociationType> createJuvenilePlacementFacilityAssociation(JuvenilePlacementFacilityAssociationType value) {
        return new JAXBElement<JuvenilePlacementFacilityAssociationType>(_JuvenilePlacementFacilityAssociation_QNAME, JuvenilePlacementFacilityAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JuvenilePlacementPersonAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JuvenilePlacementPersonAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "JuvenilePlacementPersonAssociation")
    public JAXBElement<JuvenilePlacementPersonAssociationType> createJuvenilePlacementPersonAssociation(JuvenilePlacementPersonAssociationType value) {
        return new JAXBElement<JuvenilePlacementPersonAssociationType>(_JuvenilePlacementPersonAssociation_QNAME, JuvenilePlacementPersonAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "Parent")
    public JAXBElement<PersonType> createParent(PersonType value) {
        return new JAXBElement<PersonType>(_Parent_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParentChildAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParentChildAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "ParentChildAssociation")
    public JAXBElement<ParentChildAssociationType> createParentChildAssociation(ParentChildAssociationType value) {
        return new JAXBElement<ParentChildAssociationType>(_ParentChildAssociation_QNAME, ParentChildAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "ParentChildKinshipCategoryAbstract")
    public JAXBElement<Object> createParentChildKinshipCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_ParentChildKinshipCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ParentChildKinshipCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ParentChildKinshipCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "ParentChildKinshipCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", substitutionHeadName = "ParentChildKinshipCategoryAbstract")
    public JAXBElement<ParentChildKinshipCategoryCodeType> createParentChildKinshipCategoryCode(ParentChildKinshipCategoryCodeType value) {
        return new JAXBElement<ParentChildKinshipCategoryCodeType>(_ParentChildKinshipCategoryCode_QNAME, ParentChildKinshipCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonCaseAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonCaseAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "PersonCaseAssociation")
    public JAXBElement<PersonCaseAssociationType> createPersonCaseAssociation(PersonCaseAssociationType value) {
        return new JAXBElement<PersonCaseAssociationType>(_PersonCaseAssociation_QNAME, PersonCaseAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "PersonCaseAssociationAugmentationPoint")
    public JAXBElement<Object> createPersonCaseAssociationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_PersonCaseAssociationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "PlacementAugmentationPoint")
    public JAXBElement<Object> createPlacementAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_PlacementAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "PlacementCategoryAbstract")
    public JAXBElement<Object> createPlacementCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_PlacementCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlacementLocationCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PlacementLocationCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "PlacementCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", substitutionHeadName = "PlacementCategoryAbstract")
    public JAXBElement<PlacementLocationCodeType> createPlacementCategoryCode(PlacementLocationCodeType value) {
        return new JAXBElement<PlacementLocationCodeType>(_PlacementCategoryCode_QNAME, PlacementLocationCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacilityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FacilityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "PlacementFacility")
    public JAXBElement<FacilityType> createPlacementFacility(FacilityType value) {
        return new JAXBElement<FacilityType>(_PlacementFacility_QNAME, FacilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "PlacementPerson")
    public JAXBElement<PersonType> createPlacementPerson(PersonType value) {
        return new JAXBElement<PersonType>(_PlacementPerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "StateDisbursementIndicator")
    public JAXBElement<Boolean> createStateDisbursementIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_StateDisbursementIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", name = "SupportingGroundsDescriptionText")
    public JAXBElement<TextType> createSupportingGroundsDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_SupportingGroundsDescriptionText_QNAME, TextType.class, null, value);
    }

}
