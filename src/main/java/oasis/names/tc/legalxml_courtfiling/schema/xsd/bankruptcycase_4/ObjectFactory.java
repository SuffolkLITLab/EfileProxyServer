
package oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import gov.niem.niem.domains.jxdm._4.StatuteType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4 package. 
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

    private final static QName _AssetNoticeIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "AssetNoticeIndicator");
    private final static QName _BankruptcyCase_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "BankruptcyCase");
    private final static QName _BankruptcyStatute_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "BankruptcyStatute");
    private final static QName _DebtorTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "DebtorTypeCode");
    private final static QName _Debtor_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "Debtor");
    private final static QName _EstimatedAssetsValueLevelCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "EstimatedAssetsValueLevelCode");
    private final static QName _EstimatedDebtsValueLevelCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "EstimatedDebtsValueLevelCode");
    private final static QName _JointPetitionIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "JointPetitionIndicator");
    private final static QName _NatureOfDebtCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "NatureOfDebtCode");
    private final static QName _NumberOfCreditorsValueLevelCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "NumberOfCreditorsValueLevelCode");
    private final static QName _Section1121EIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "Section1121eIndicator");
    private final static QName _SmallBusinessIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "SmallBusinessIndicator");
    private final static QName _VoluntaryIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", "VoluntaryIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BankruptcyCaseType }
     * 
     */
    public BankruptcyCaseType createBankruptcyCaseType() {
        return new BankruptcyCaseType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "AssetNoticeIndicator")
    public JAXBElement<Boolean> createAssetNoticeIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_AssetNoticeIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "BankruptcyCase", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Case")
    public JAXBElement<BankruptcyCaseType> createBankruptcyCase(BankruptcyCaseType value) {
        return new JAXBElement<BankruptcyCaseType>(_BankruptcyCase_QNAME, BankruptcyCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "BankruptcyStatute")
    public JAXBElement<StatuteType> createBankruptcyStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_BankruptcyStatute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "DebtorTypeCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createDebtorTypeCode(String value) {
        return new JAXBElement<String>(_DebtorTypeCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "Debtor")
    public JAXBElement<EntityType> createDebtor(EntityType value) {
        return new JAXBElement<EntityType>(_Debtor_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "EstimatedAssetsValueLevelCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createEstimatedAssetsValueLevelCode(String value) {
        return new JAXBElement<String>(_EstimatedAssetsValueLevelCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "EstimatedDebtsValueLevelCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createEstimatedDebtsValueLevelCode(String value) {
        return new JAXBElement<String>(_EstimatedDebtsValueLevelCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "JointPetitionIndicator")
    public JAXBElement<Boolean> createJointPetitionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_JointPetitionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "NatureOfDebtCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createNatureOfDebtCode(String value) {
        return new JAXBElement<String>(_NatureOfDebtCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "NumberOfCreditorsValueLevelCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<String> createNumberOfCreditorsValueLevelCode(String value) {
        return new JAXBElement<String>(_NumberOfCreditorsValueLevelCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "Section1121eIndicator")
    public JAXBElement<Boolean> createSection1121EIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_Section1121EIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "SmallBusinessIndicator")
    public JAXBElement<Boolean> createSmallBusinessIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_SmallBusinessIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:BankruptcyCase-4.0", name = "VoluntaryIndicator")
    public JAXBElement<Boolean> createVoluntaryIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_VoluntaryIndicator_QNAME, Boolean.class, null, value);
    }

}
