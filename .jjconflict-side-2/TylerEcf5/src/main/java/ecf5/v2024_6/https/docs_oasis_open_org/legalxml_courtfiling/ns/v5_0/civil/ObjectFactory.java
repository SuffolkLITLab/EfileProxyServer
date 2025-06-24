
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.PersonType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil package. 
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

    private final static QName _AmountInControversy_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "AmountInControversy");
    private final static QName _CaseAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "CaseAugmentation");
    private final static QName _CivilClassActionIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "CivilClassActionIndicator");
    private final static QName _Decedent_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "Decedent");
    private final static QName _DecedentEstateCase_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "DecedentEstateCase");
    private final static QName _FiduciaryCaseAssociation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "FiduciaryCaseAssociation");
    private final static QName _FiduciaryTypeCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "FiduciaryTypeCode");
    private final static QName _JurisdictionalGroundsCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "JurisdictionalGroundsCode");
    private final static QName _JuryDemandIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "JuryDemandIndicator");
    private final static QName _ReliefTypeCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "ReliefTypeCode");
    private final static QName _WillFilingDate_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", "WillFilingDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil
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
     * Create an instance of {@link DecedentEstateCaseType }
     * 
     */
    public DecedentEstateCaseType createDecedentEstateCaseType() {
        return new DecedentEstateCaseType();
    }

    /**
     * Create an instance of {@link FiduciaryCaseAssociationType }
     * 
     */
    public FiduciaryCaseAssociationType createFiduciaryCaseAssociationType() {
        return new FiduciaryCaseAssociationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "AmountInControversy")
    public JAXBElement<AmountType> createAmountInControversy(AmountType value) {
        return new JAXBElement<AmountType>(_AmountInControversy_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "CaseAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CaseAugmentationPoint")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "CivilClassActionIndicator")
    public JAXBElement<Boolean> createCivilClassActionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CivilClassActionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "Decedent")
    public JAXBElement<PersonType> createDecedent(PersonType value) {
        return new JAXBElement<PersonType>(_Decedent_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecedentEstateCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DecedentEstateCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "DecedentEstateCase")
    public JAXBElement<DecedentEstateCaseType> createDecedentEstateCase(DecedentEstateCaseType value) {
        return new JAXBElement<DecedentEstateCaseType>(_DecedentEstateCase_QNAME, DecedentEstateCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FiduciaryCaseAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FiduciaryCaseAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "FiduciaryCaseAssociation")
    public JAXBElement<FiduciaryCaseAssociationType> createFiduciaryCaseAssociation(FiduciaryCaseAssociationType value) {
        return new JAXBElement<FiduciaryCaseAssociationType>(_FiduciaryCaseAssociation_QNAME, FiduciaryCaseAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "FiduciaryTypeCode")
    public JAXBElement<TextType> createFiduciaryTypeCode(TextType value) {
        return new JAXBElement<TextType>(_FiduciaryTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "JurisdictionalGroundsCode")
    public JAXBElement<TextType> createJurisdictionalGroundsCode(TextType value) {
        return new JAXBElement<TextType>(_JurisdictionalGroundsCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "JuryDemandIndicator")
    public JAXBElement<Boolean> createJuryDemandIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_JuryDemandIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "ReliefTypeCode")
    public JAXBElement<TextType> createReliefTypeCode(TextType value) {
        return new JAXBElement<TextType>(_ReliefTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil", name = "WillFilingDate")
    public JAXBElement<DateType> createWillFilingDate(DateType value) {
        return new JAXBElement<DateType>(_WillFilingDate_QNAME, DateType.class, null, value);
    }

}
