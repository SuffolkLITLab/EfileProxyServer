
package tyler.ecf.v5_0.extensions.criminal;

import javax.xml.namespace.QName;
import gov.niem.release.niem.domains.jxdm._6.StatuteType;
import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.criminal package. 
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

    private final static QName _AdditionalStatute_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "AdditionalStatute");
    private final static QName _AppearanceRequiredText_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "AppearanceRequiredText");
    private final static QName _Bond_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "Bond");
    private final static QName _BondAmount_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "BondAmount");
    private final static QName _BondTypeCode_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "BondTypeCode");
    private final static QName _ChargeAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "ChargeAugmentation");
    private final static QName _ChargeHistory_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "ChargeHistory");
    private final static QName _ChargeHistoryIdentification_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "ChargeHistoryIdentification");
    private final static QName _CitationAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "CitationAugmentation");
    private final static QName _DateOnOrAboutIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "DateOnOrAboutIndicator");
    private final static QName _DispositionAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "DispositionAugmentation");
    private final static QName _DispositionIdentification_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "DispositionIdentification");
    private final static QName _FineAmount_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "FineAmount");
    private final static QName _GeneralOffenseCode_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "GeneralOffenseCode");
    private final static QName _IncidentNotationText_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "IncidentNotationText");
    private final static QName _JuryTrialDemandDate_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "JuryTrialDemandDate");
    private final static QName _JuryTrialDemandIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "JuryTrialDemandIndicator");
    private final static QName _LocalOrdinanceIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "LocalOrdinanceIndicator");
    private final static QName _LocalOrdinanceNumberText_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "LocalOrdinanceNumberText");
    private final static QName _OffenseDate_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "OffenseDate");
    private final static QName _PhaseTypeCode_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "PhaseTypeCode");
    private final static QName _Plea_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "Plea");
    private final static QName _PleaDate_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "PleaDate");
    private final static QName _PleaDescriptionText_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "PleaDescriptionText");
    private final static QName _PleaIdentification_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "PleaIdentification");
    private final static QName _ReleaseNotes_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "ReleaseNotes");
    private final static QName _SequenceNumber_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "SequenceNumber");
    private final static QName _SpeedyTrialDemandDate_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "SpeedyTrialDemandDate");
    private final static QName _SpeedyTrialDemandIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "SpeedyTrialDemandIndicator");
    private final static QName _StatuteAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "StatuteAugmentation");
    private final static QName _StatuteTypeCode_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "StatuteTypeCode");
    private final static QName _TimeOnOrAboutIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "TimeOnOrAboutIndicator");
    private final static QName _TotalAmount_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "TotalAmount");
    private final static QName _TrackingNumber_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:criminal", "TrackingNumber");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.criminal
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
     * Create an instance of {@link ChargeAugmentationType }
     * 
     */
    public ChargeAugmentationType createChargeAugmentationType() {
        return new ChargeAugmentationType();
    }

    /**
     * Create an instance of {@link ChargeHistoryType }
     * 
     */
    public ChargeHistoryType createChargeHistoryType() {
        return new ChargeHistoryType();
    }

    /**
     * Create an instance of {@link CitationAugmentationType }
     * 
     */
    public CitationAugmentationType createCitationAugmentationType() {
        return new CitationAugmentationType();
    }

    /**
     * Create an instance of {@link DispositionAugmentationType }
     * 
     */
    public DispositionAugmentationType createDispositionAugmentationType() {
        return new DispositionAugmentationType();
    }

    /**
     * Create an instance of {@link PleaType }
     * 
     */
    public PleaType createPleaType() {
        return new PleaType();
    }

    /**
     * Create an instance of {@link StatuteAugmentationType }
     * 
     */
    public StatuteAugmentationType createStatuteAugmentationType() {
        return new StatuteAugmentationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "AdditionalStatute")
    public JAXBElement<StatuteType> createAdditionalStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_AdditionalStatute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "AppearanceRequiredText")
    public JAXBElement<TextType> createAppearanceRequiredText(TextType value) {
        return new JAXBElement<TextType>(_AppearanceRequiredText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BondType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BondType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "Bond")
    public JAXBElement<BondType> createBond(BondType value) {
        return new JAXBElement<BondType>(_Bond_QNAME, BondType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "BondAmount")
    public JAXBElement<AmountType> createBondAmount(AmountType value) {
        return new JAXBElement<AmountType>(_BondAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "BondTypeCode")
    public JAXBElement<TextType> createBondTypeCode(TextType value) {
        return new JAXBElement<TextType>(_BondTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "ChargeAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", substitutionHeadName = "ChargeAugmentationPoint")
    public JAXBElement<ChargeAugmentationType> createChargeAugmentation(ChargeAugmentationType value) {
        return new JAXBElement<ChargeAugmentationType>(_ChargeAugmentation_QNAME, ChargeAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeHistoryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeHistoryType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "ChargeHistory")
    public JAXBElement<ChargeHistoryType> createChargeHistory(ChargeHistoryType value) {
        return new JAXBElement<ChargeHistoryType>(_ChargeHistory_QNAME, ChargeHistoryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "ChargeHistoryIdentification")
    public JAXBElement<IdentificationType> createChargeHistoryIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ChargeHistoryIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CitationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CitationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "CitationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/structures/4.0/", substitutionHeadName = "ObjectAugmentationPoint")
    public JAXBElement<CitationAugmentationType> createCitationAugmentation(CitationAugmentationType value) {
        return new JAXBElement<CitationAugmentationType>(_CitationAugmentation_QNAME, CitationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "DateOnOrAboutIndicator")
    public JAXBElement<Boolean> createDateOnOrAboutIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DateOnOrAboutIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DispositionAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DispositionAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "DispositionAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/structures/4.0/", substitutionHeadName = "ObjectAugmentationPoint")
    public JAXBElement<DispositionAugmentationType> createDispositionAugmentation(DispositionAugmentationType value) {
        return new JAXBElement<DispositionAugmentationType>(_DispositionAugmentation_QNAME, DispositionAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "DispositionIdentification")
    public JAXBElement<IdentificationType> createDispositionIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_DispositionIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "FineAmount")
    public JAXBElement<AmountType> createFineAmount(AmountType value) {
        return new JAXBElement<AmountType>(_FineAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "GeneralOffenseCode")
    public JAXBElement<TextType> createGeneralOffenseCode(TextType value) {
        return new JAXBElement<TextType>(_GeneralOffenseCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "IncidentNotationText")
    public JAXBElement<TextType> createIncidentNotationText(TextType value) {
        return new JAXBElement<TextType>(_IncidentNotationText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "JuryTrialDemandDate")
    public JAXBElement<DateType> createJuryTrialDemandDate(DateType value) {
        return new JAXBElement<DateType>(_JuryTrialDemandDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "JuryTrialDemandIndicator")
    public JAXBElement<Boolean> createJuryTrialDemandIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_JuryTrialDemandIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "LocalOrdinanceIndicator")
    public JAXBElement<Boolean> createLocalOrdinanceIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_LocalOrdinanceIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "LocalOrdinanceNumberText")
    public JAXBElement<TextType> createLocalOrdinanceNumberText(TextType value) {
        return new JAXBElement<TextType>(_LocalOrdinanceNumberText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "OffenseDate")
    public JAXBElement<DateType> createOffenseDate(DateType value) {
        return new JAXBElement<DateType>(_OffenseDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "PhaseTypeCode")
    public JAXBElement<TextType> createPhaseTypeCode(TextType value) {
        return new JAXBElement<TextType>(_PhaseTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PleaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PleaType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "Plea")
    public JAXBElement<PleaType> createPlea(PleaType value) {
        return new JAXBElement<PleaType>(_Plea_QNAME, PleaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "PleaDate")
    public JAXBElement<DateType> createPleaDate(DateType value) {
        return new JAXBElement<DateType>(_PleaDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "PleaDescriptionText")
    public JAXBElement<TextType> createPleaDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_PleaDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "PleaIdentification")
    public JAXBElement<IdentificationType> createPleaIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PleaIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "ReleaseNotes")
    public JAXBElement<TextType> createReleaseNotes(TextType value) {
        return new JAXBElement<TextType>(_ReleaseNotes_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "SequenceNumber")
    public JAXBElement<TextType> createSequenceNumber(TextType value) {
        return new JAXBElement<TextType>(_SequenceNumber_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "SpeedyTrialDemandDate")
    public JAXBElement<DateType> createSpeedyTrialDemandDate(DateType value) {
        return new JAXBElement<DateType>(_SpeedyTrialDemandDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "SpeedyTrialDemandIndicator")
    public JAXBElement<Boolean> createSpeedyTrialDemandIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_SpeedyTrialDemandIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "StatuteAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/structures/4.0/", substitutionHeadName = "ObjectAugmentationPoint")
    public JAXBElement<StatuteAugmentationType> createStatuteAugmentation(StatuteAugmentationType value) {
        return new JAXBElement<StatuteAugmentationType>(_StatuteAugmentation_QNAME, StatuteAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "StatuteTypeCode")
    public JAXBElement<TextType> createStatuteTypeCode(TextType value) {
        return new JAXBElement<TextType>(_StatuteTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "TimeOnOrAboutIndicator")
    public JAXBElement<Boolean> createTimeOnOrAboutIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_TimeOnOrAboutIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "TotalAmount")
    public JAXBElement<AmountType> createTotalAmount(AmountType value) {
        return new JAXBElement<AmountType>(_TotalAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:criminal", name = "TrackingNumber")
    public JAXBElement<TextType> createTrackingNumber(TextType value) {
        return new JAXBElement<TextType>(_TrackingNumber_QNAME, TextType.class, null, value);
    }

}
