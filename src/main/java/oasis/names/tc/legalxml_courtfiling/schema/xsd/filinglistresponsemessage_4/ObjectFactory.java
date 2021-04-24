
package oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4 package. 
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

    private final static QName _FilingListResponseMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingListResponseMessage-4.0", "FilingListResponseMessage");
    private final static QName _MatchingFiling_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingListResponseMessage-4.0", "MatchingFiling");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilingListResponseMessageType }
     * 
     */
    public FilingListResponseMessageType createFilingListResponseMessageType() {
        return new FilingListResponseMessageType();
    }

    /**
     * Create an instance of {@link MatchingFilingType }
     * 
     */
    public MatchingFilingType createMatchingFilingType() {
        return new MatchingFilingType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingListResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingListResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingListResponseMessage-4.0", name = "FilingListResponseMessage")
    public JAXBElement<FilingListResponseMessageType> createFilingListResponseMessage(FilingListResponseMessageType value) {
        return new JAXBElement<FilingListResponseMessageType>(_FilingListResponseMessage_QNAME, FilingListResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MatchingFilingType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MatchingFilingType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingListResponseMessage-4.0", name = "MatchingFiling")
    public JAXBElement<MatchingFilingType> createMatchingFiling(MatchingFilingType value) {
        return new JAXBElement<MatchingFilingType>(_MatchingFiling_QNAME, MatchingFilingType.class, null, value);
    }

}
