
package oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4 package. 
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

    private final static QName _ReviewFilingCallbackMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ReviewFilingCallbackMessage-4.0", "ReviewFilingCallbackMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReviewFilingCallbackMessageType }
     * 
     */
    public ReviewFilingCallbackMessageType createReviewFilingCallbackMessageType() {
        return new ReviewFilingCallbackMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviewFilingCallbackMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReviewFilingCallbackMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:ReviewFilingCallbackMessage-4.0", name = "ReviewFilingCallbackMessage")
    public JAXBElement<ReviewFilingCallbackMessageType> createReviewFilingCallbackMessage(ReviewFilingCallbackMessageType value) {
        return new JAXBElement<ReviewFilingCallbackMessageType>(_ReviewFilingCallbackMessage_QNAME, ReviewFilingCallbackMessageType.class, null, value);
    }

}
