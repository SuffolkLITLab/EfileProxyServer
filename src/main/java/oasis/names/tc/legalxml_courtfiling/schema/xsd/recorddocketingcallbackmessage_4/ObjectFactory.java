
package oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingcallbackmessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingcallbackmessage_4 package. 
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

    private final static QName _RecordDocketingCallbackMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingCallbackMessage-4.0", "RecordDocketingCallbackMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingcallbackmessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecordDocketingCallbackMessageType }
     * 
     */
    public RecordDocketingCallbackMessageType createRecordDocketingCallbackMessageType() {
        return new RecordDocketingCallbackMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordDocketingCallbackMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RecordDocketingCallbackMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingCallbackMessage-4.0", name = "RecordDocketingCallbackMessage")
    public JAXBElement<RecordDocketingCallbackMessageType> createRecordDocketingCallbackMessage(RecordDocketingCallbackMessageType value) {
        return new JAXBElement<RecordDocketingCallbackMessageType>(_RecordDocketingCallbackMessage_QNAME, RecordDocketingCallbackMessageType.class, null, value);
    }

}
