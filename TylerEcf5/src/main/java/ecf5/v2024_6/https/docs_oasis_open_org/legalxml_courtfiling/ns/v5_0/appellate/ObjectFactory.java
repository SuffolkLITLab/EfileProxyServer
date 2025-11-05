
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.appellate;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.NumericType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.appellate package. 
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

    private final static QName _AppellantInCustodyIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "AppellantInCustodyIndicator");
    private final static QName _AppellateCaseAddedParty_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "AppellateCaseAddedParty");
    private final static QName _AppellateCaseJurisdictionBasisText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "AppellateCaseJurisdictionBasisText");
    private final static QName _AppellateCasePartyAddedReasonText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "AppellateCasePartyAddedReasonText");
    private final static QName _AppellateCasePartyRemovedReasonText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "AppellateCasePartyRemovedReasonText");
    private final static QName _AppellateCaseRemovedParty_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "AppellateCaseRemovedParty");
    private final static QName _AppellateCaseSettlementRequestText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "AppellateCaseSettlementRequestText");
    private final static QName _AppellateCourtRuleCase_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "AppellateCourtRuleCase");
    private final static QName _CaseAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "CaseAugmentation");
    private final static QName _FeesWaivedIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "FeesWaivedIndicator");
    private final static QName _RuleCollectionNumber_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "RuleCollectionNumber");
    private final static QName _RuleCollectionText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", "RuleCollectionText");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.appellate
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link AppellateCourtRuleCaseType }
     * 
     */
    public AppellateCourtRuleCaseType createAppellateCourtRuleCaseType() {
        return new AppellateCourtRuleCaseType();
    }

    /**
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "AppellantInCustodyIndicator")
    public JAXBElement<Boolean> createAppellantInCustodyIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_AppellantInCustodyIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCaseAddedPartyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCaseAddedPartyType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "AppellateCaseAddedParty")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "AppellateCaseJurisdictionBasisText")
    public JAXBElement<TextType> createAppellateCaseJurisdictionBasisText(TextType value) {
        return new JAXBElement<TextType>(_AppellateCaseJurisdictionBasisText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "AppellateCasePartyAddedReasonText")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "AppellateCasePartyRemovedReasonText")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "AppellateCaseRemovedParty")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "AppellateCaseSettlementRequestText")
    public JAXBElement<TextType> createAppellateCaseSettlementRequestText(TextType value) {
        return new JAXBElement<TextType>(_AppellateCaseSettlementRequestText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCourtRuleCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCourtRuleCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "AppellateCourtRuleCase")
    public JAXBElement<AppellateCourtRuleCaseType> createAppellateCourtRuleCase(AppellateCourtRuleCaseType value) {
        return new JAXBElement<AppellateCourtRuleCaseType>(_AppellateCourtRuleCase_QNAME, AppellateCourtRuleCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "CaseAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CaseAugmentationPoint")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "FeesWaivedIndicator")
    public JAXBElement<Boolean> createFeesWaivedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_FeesWaivedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumericType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NumericType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "RuleCollectionNumber")
    public JAXBElement<NumericType> createRuleCollectionNumber(NumericType value) {
        return new JAXBElement<NumericType>(_RuleCollectionNumber_QNAME, NumericType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate", name = "RuleCollectionText")
    public JAXBElement<TextType> createRuleCollectionText(TextType value) {
        return new JAXBElement<TextType>(_RuleCollectionText_QNAME, TextType.class, null, value);
    }

}
