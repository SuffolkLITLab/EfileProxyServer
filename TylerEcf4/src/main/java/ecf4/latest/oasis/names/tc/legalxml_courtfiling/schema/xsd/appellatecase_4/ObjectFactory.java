
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.niem_core._2.NumericType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4 package. 
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

    private final static QName _AppellateCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCase");
    private final static QName _AppellateCaseAddedParty_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCaseAddedParty");
    private final static QName _AppellateCaseJurisdictionBasisText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCaseJurisdictionBasisText");
    private final static QName _AppellateCaseParty_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCaseParty");
    private final static QName _AppellateCasePartyAddedReasonText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCasePartyAddedReasonText");
    private final static QName _AppellateCasePartyRemovedReasonText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCasePartyRemovedReasonText");
    private final static QName _AppellateCaseRemovedParty_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCaseRemovedParty");
    private final static QName _AppellateCaseSettlementRequestText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCaseSettlementRequestText");
    private final static QName _AppellateCivilCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCivilCase");
    private final static QName _AppellateCourtRuleCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellateCourtRuleCase");
    private final static QName _AppellantInCustodyIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "AppellantInCustodyIndicator");
    private final static QName _FeesWaivedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "FeesWaivedIndicator");
    private final static QName _RuleCollectionText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "RuleCollectionText");
    private final static QName _RuleCollectionNumber_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", "RuleCollectionNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AppellateCaseType }
     * 
     */
    public AppellateCaseType createAppellateCaseType() {
        return new AppellateCaseType();
    }

    /**
     * Create an instance of {@link AppellateCaseAddedPartyType }
     * 
     */
    public AppellateCaseAddedPartyType createAppellateCaseAddedPartyType() {
        return new AppellateCaseAddedPartyType();
    }

    /**
     * Create an instance of {@link AppellateCaseRemovedPartyType }
     * 
     */
    public AppellateCaseRemovedPartyType createAppellateCaseRemovedPartyType() {
        return new AppellateCaseRemovedPartyType();
    }

    /**
     * Create an instance of {@link AppellateCivilCaseType }
     * 
     */
    public AppellateCivilCaseType createAppellateCivilCaseType() {
        return new AppellateCivilCaseType();
    }

    /**
     * Create an instance of {@link AppellateCourtRuleCaseType }
     * 
     */
    public AppellateCourtRuleCaseType createAppellateCourtRuleCaseType() {
        return new AppellateCourtRuleCaseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCase", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Case")
    public JAXBElement<AppellateCaseType> createAppellateCase(AppellateCaseType value) {
        return new JAXBElement<AppellateCaseType>(_AppellateCase_QNAME, AppellateCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCaseAddedPartyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCaseAddedPartyType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCaseAddedParty")
    public JAXBElement<AppellateCaseAddedPartyType> createAppellateCaseAddedParty(AppellateCaseAddedPartyType value) {
        return new JAXBElement<AppellateCaseAddedPartyType>(_AppellateCaseAddedParty_QNAME, AppellateCaseAddedPartyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCaseJurisdictionBasisText")
    public JAXBElement<TextType> createAppellateCaseJurisdictionBasisText(TextType value) {
        return new JAXBElement<TextType>(_AppellateCaseJurisdictionBasisText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCaseParty")
    public JAXBElement<EntityType> createAppellateCaseParty(EntityType value) {
        return new JAXBElement<EntityType>(_AppellateCaseParty_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCasePartyAddedReasonText")
    public JAXBElement<TextType> createAppellateCasePartyAddedReasonText(TextType value) {
        return new JAXBElement<TextType>(_AppellateCasePartyAddedReasonText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCasePartyRemovedReasonText")
    public JAXBElement<TextType> createAppellateCasePartyRemovedReasonText(TextType value) {
        return new JAXBElement<TextType>(_AppellateCasePartyRemovedReasonText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCaseRemovedPartyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCaseRemovedPartyType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCaseRemovedParty")
    public JAXBElement<AppellateCaseRemovedPartyType> createAppellateCaseRemovedParty(AppellateCaseRemovedPartyType value) {
        return new JAXBElement<AppellateCaseRemovedPartyType>(_AppellateCaseRemovedParty_QNAME, AppellateCaseRemovedPartyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCaseSettlementRequestText")
    public JAXBElement<TextType> createAppellateCaseSettlementRequestText(TextType value) {
        return new JAXBElement<TextType>(_AppellateCaseSettlementRequestText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCivilCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCivilCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCivilCase")
    public JAXBElement<AppellateCivilCaseType> createAppellateCivilCase(AppellateCivilCaseType value) {
        return new JAXBElement<AppellateCivilCaseType>(_AppellateCivilCase_QNAME, AppellateCivilCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCourtRuleCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCourtRuleCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellateCourtRuleCase")
    public JAXBElement<AppellateCourtRuleCaseType> createAppellateCourtRuleCase(AppellateCourtRuleCaseType value) {
        return new JAXBElement<AppellateCourtRuleCaseType>(_AppellateCourtRuleCase_QNAME, AppellateCourtRuleCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "AppellantInCustodyIndicator")
    public JAXBElement<Boolean> createAppellantInCustodyIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_AppellantInCustodyIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "FeesWaivedIndicator")
    public JAXBElement<Boolean> createFeesWaivedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_FeesWaivedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "RuleCollectionText")
    public JAXBElement<TextType> createRuleCollectionText(TextType value) {
        return new JAXBElement<TextType>(_RuleCollectionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumericType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NumericType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", name = "RuleCollectionNumber")
    public JAXBElement<NumericType> createRuleCollectionNumber(NumericType value) {
        return new JAXBElement<NumericType>(_RuleCollectionNumber_QNAME, NumericType.class, null, value);
    }

}
