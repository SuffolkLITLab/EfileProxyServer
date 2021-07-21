
package tyler.ecf.extensions.criminal;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.criminal package. 
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

    private final static QName _BondTypeText_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "BondTypeText");
    private final static QName _BondAmount_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "BondAmount");
    private final static QName _FineAmount_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "FineAmount");
    private final static QName _Bond_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "Bond");
    private final static QName _Charge_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "Charge");
    private final static QName _ChargeStatute_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "ChargeStatute");
    private final static QName _AdditionalStatute_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "AdditionalStatute");
    private final static QName _DateOnOrAboutIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "DateOnOrAboutIndicator");
    private final static QName _TimeOnOrAboutIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "TimeOnOrAboutIndicator");
    private final static QName _ChargeComponent_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "ChargeComponent");
    private final static QName _GeneralOffenseText_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "GeneralOffenseText");
    private final static QName _StatuteTypeText_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "StatuteTypeText");
    private final static QName _PhaseTypeText_QNAME = new QName("urn:tyler:ecf:extensions:Criminal", "PhaseTypeText");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.criminal
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BondType }
     * 
     */
    public BondType createBondType() {
        return new BondType();
    }

    /**
     * Create an instance of {@link ChargeType }
     * 
     */
    public ChargeType createChargeType() {
        return new ChargeType();
    }

    /**
     * Create an instance of {@link StatuteType }
     * 
     */
    public StatuteType createStatuteType() {
        return new StatuteType();
    }

    /**
     * Create an instance of {@link ChargeComponentType }
     * 
     */
    public ChargeComponentType createChargeComponentType() {
        return new ChargeComponentType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "BondTypeText")
    public JAXBElement<TextType> createBondTypeText(TextType value) {
        return new JAXBElement<TextType>(_BondTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "BondAmount")
    public JAXBElement<AmountType> createBondAmount(AmountType value) {
        return new JAXBElement<AmountType>(_BondAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "FineAmount")
    public JAXBElement<AmountType> createFineAmount(AmountType value) {
        return new JAXBElement<AmountType>(_FineAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BondType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BondType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "Bond")
    public JAXBElement<BondType> createBond(BondType value) {
        return new JAXBElement<BondType>(_Bond_QNAME, BondType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "Charge", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0", substitutionHeadName = "CaseCharge")
    public JAXBElement<ChargeType> createCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_Charge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "ChargeStatute", substitutionHeadNamespace = "http://niem.gov/niem/domains/jxdm/4.0", substitutionHeadName = "ChargeStatute")
    public JAXBElement<StatuteType> createChargeStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_ChargeStatute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "AdditionalStatute")
    public JAXBElement<StatuteType> createAdditionalStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_AdditionalStatute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "DateOnOrAboutIndicator")
    public JAXBElement<Boolean> createDateOnOrAboutIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DateOnOrAboutIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "TimeOnOrAboutIndicator")
    public JAXBElement<Boolean> createTimeOnOrAboutIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_TimeOnOrAboutIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeComponentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeComponentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "ChargeComponent")
    public JAXBElement<ChargeComponentType> createChargeComponent(ChargeComponentType value) {
        return new JAXBElement<ChargeComponentType>(_ChargeComponent_QNAME, ChargeComponentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "GeneralOffenseText")
    public JAXBElement<TextType> createGeneralOffenseText(TextType value) {
        return new JAXBElement<TextType>(_GeneralOffenseText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "StatuteTypeText")
    public JAXBElement<TextType> createStatuteTypeText(TextType value) {
        return new JAXBElement<TextType>(_StatuteTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Criminal", name = "PhaseTypeText")
    public JAXBElement<TextType> createPhaseTypeText(TextType value) {
        return new JAXBElement<TextType>(_PhaseTypeText_QNAME, TextType.class, null, value);
    }

}
