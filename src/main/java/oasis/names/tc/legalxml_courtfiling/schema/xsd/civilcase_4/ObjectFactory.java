
package oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4 package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _AmountInControversy_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "AmountInControversy");
    private final static QName _ClassActionIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "ClassActionIndicator");
    private final static QName _CivilCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "CivilCase");
    private final static QName _DecedentEstateCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "DecedentEstateCase");
    private final static QName _FiduciaryCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "FiduciaryCase");
    private final static QName _FiduciaryTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "FiduciaryTypeCode");
    private final static QName _JurisdictionalGroundsCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "JurisdictionalGroundsCode");
    private final static QName _JuryDemandIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "JuryDemandIndicator");
    private final static QName _PersonFiduciaryAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "PersonFiduciaryAssociation");
    private final static QName _PersonFiduciaryAssociationTypeText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "PersonFiduciaryAssociationTypeText");
    private final static QName _ReliefTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "ReliefTypeCode");
    private final static QName _WillFilingDate_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", "WillFilingDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CivilCaseType }
     * 
     */
    public CivilCaseType createCivilCaseType() {
        return new CivilCaseType();
    }

    /**
     * Create an instance of {@link DecedentEstateCaseType }
     * 
     */
    public DecedentEstateCaseType createDecedentEstateCaseType() {
        return new DecedentEstateCaseType();
    }

    /**
     * Create an instance of {@link FiduciaryCaseType }
     * 
     */
    public FiduciaryCaseType createFiduciaryCaseType() {
        return new FiduciaryCaseType();
    }

    /**
     * Create an instance of {@link PersonFiduciaryAssociationType }
     * 
     */
    public PersonFiduciaryAssociationType createPersonFiduciaryAssociationType() {
        return new PersonFiduciaryAssociationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "AmountInControversy")
    public JAXBElement<AmountType> createAmountInControversy(AmountType value) {
        return new JAXBElement<AmountType>(_AmountInControversy_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "ClassActionIndicator")
    public JAXBElement<Boolean> createClassActionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ClassActionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "CivilCase", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Case")
    public JAXBElement<CivilCaseType> createCivilCase(CivilCaseType value) {
        return new JAXBElement<CivilCaseType>(_CivilCase_QNAME, CivilCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecedentEstateCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DecedentEstateCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "DecedentEstateCase")
    public JAXBElement<DecedentEstateCaseType> createDecedentEstateCase(DecedentEstateCaseType value) {
        return new JAXBElement<DecedentEstateCaseType>(_DecedentEstateCase_QNAME, DecedentEstateCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FiduciaryCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FiduciaryCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "FiduciaryCase")
    public JAXBElement<FiduciaryCaseType> createFiduciaryCase(FiduciaryCaseType value) {
        return new JAXBElement<FiduciaryCaseType>(_FiduciaryCase_QNAME, FiduciaryCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "FiduciaryTypeCode")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "JurisdictionalGroundsCode")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "JuryDemandIndicator")
    public JAXBElement<Boolean> createJuryDemandIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_JuryDemandIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonFiduciaryAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonFiduciaryAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "PersonFiduciaryAssociation")
    public JAXBElement<PersonFiduciaryAssociationType> createPersonFiduciaryAssociation(PersonFiduciaryAssociationType value) {
        return new JAXBElement<PersonFiduciaryAssociationType>(_PersonFiduciaryAssociation_QNAME, PersonFiduciaryAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "PersonFiduciaryAssociationTypeText")
    public JAXBElement<TextType> createPersonFiduciaryAssociationTypeText(TextType value) {
        return new JAXBElement<TextType>(_PersonFiduciaryAssociationTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "ReliefTypeCode")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0", name = "WillFilingDate")
    public JAXBElement<DateType> createWillFilingDate(DateType value) {
        return new JAXBElement<DateType>(_WillFilingDate_QNAME, DateType.class, null, value);
    }

}
