
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.docket;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.CaseType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.docket package. 
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

    private final static QName _CorrectedCase_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", "CorrectedCase");
    private final static QName _FilingReviewCommentsText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", "FilingReviewCommentsText");
    private final static QName _RecordDocketingMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", "RecordDocketingMessage");
    private final static QName _RecordDocketingMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", "RecordDocketingMessageAugmentationPoint");
    private final static QName _SealCaseIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", "SealCaseIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.docket
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecordDocketingMessageType }
     * 
     */
    public RecordDocketingMessageType createRecordDocketingMessageType() {
        return new RecordDocketingMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", name = "CorrectedCase")
    public JAXBElement<CaseType> createCorrectedCase(CaseType value) {
        return new JAXBElement<CaseType>(_CorrectedCase_QNAME, CaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", name = "FilingReviewCommentsText")
    public JAXBElement<TextType> createFilingReviewCommentsText(TextType value) {
        return new JAXBElement<TextType>(_FilingReviewCommentsText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordDocketingMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RecordDocketingMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", name = "RecordDocketingMessage")
    public JAXBElement<RecordDocketingMessageType> createRecordDocketingMessage(RecordDocketingMessageType value) {
        return new JAXBElement<RecordDocketingMessageType>(_RecordDocketingMessage_QNAME, RecordDocketingMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", name = "RecordDocketingMessageAugmentationPoint")
    public JAXBElement<Object> createRecordDocketingMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_RecordDocketingMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket", name = "SealCaseIndicator")
    public JAXBElement<Boolean> createSealCaseIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_SealCaseIndicator_QNAME, Boolean.class, null, value);
    }

}
