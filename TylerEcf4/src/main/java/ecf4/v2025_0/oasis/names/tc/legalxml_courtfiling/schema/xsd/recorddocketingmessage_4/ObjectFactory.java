
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingmessage_4;

import javax.xml.namespace.QName;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingmessage_4 package. 
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

    private final static QName _FilingReviewCommentsText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0", "FilingReviewCommentsText");
    private final static QName _RecordDocketingMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0", "RecordDocketingMessage");
    private final static QName _SealCaseIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0", "SealCaseIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingmessage_4
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0", name = "FilingReviewCommentsText")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0", name = "RecordDocketingMessage")
    public JAXBElement<RecordDocketingMessageType> createRecordDocketingMessage(RecordDocketingMessageType value) {
        return new JAXBElement<RecordDocketingMessageType>(_RecordDocketingMessage_QNAME, RecordDocketingMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0", name = "SealCaseIndicator")
    public JAXBElement<Boolean> createSealCaseIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_SealCaseIndicator_QNAME, Boolean.class, null, value);
    }

}
