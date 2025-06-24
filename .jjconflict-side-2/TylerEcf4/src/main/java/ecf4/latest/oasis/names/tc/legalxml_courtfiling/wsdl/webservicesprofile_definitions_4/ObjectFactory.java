
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4 package. 
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

    private final static QName _NotifyFilingReviewCompleteRequestMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0", "NotifyFilingReviewCompleteRequestMessage");
    private final static QName _RecordFilingRequestMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0", "RecordFilingRequestMessage");
    private final static QName _ReviewFilingRequestMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0", "ReviewFilingRequestMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyFilingReviewCompleteRequestMessageType }
     * 
     */
    public NotifyFilingReviewCompleteRequestMessageType createNotifyFilingReviewCompleteRequestMessageType() {
        return new NotifyFilingReviewCompleteRequestMessageType();
    }

    /**
     * Create an instance of {@link RecordFilingRequestMessageType }
     * 
     */
    public RecordFilingRequestMessageType createRecordFilingRequestMessageType() {
        return new RecordFilingRequestMessageType();
    }

    /**
     * Create an instance of {@link ReviewFilingRequestMessageType }
     * 
     */
    public ReviewFilingRequestMessageType createReviewFilingRequestMessageType() {
        return new ReviewFilingRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyFilingReviewCompleteRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyFilingReviewCompleteRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0", name = "NotifyFilingReviewCompleteRequestMessage")
    public JAXBElement<NotifyFilingReviewCompleteRequestMessageType> createNotifyFilingReviewCompleteRequestMessage(NotifyFilingReviewCompleteRequestMessageType value) {
        return new JAXBElement<NotifyFilingReviewCompleteRequestMessageType>(_NotifyFilingReviewCompleteRequestMessage_QNAME, NotifyFilingReviewCompleteRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordFilingRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RecordFilingRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0", name = "RecordFilingRequestMessage")
    public JAXBElement<RecordFilingRequestMessageType> createRecordFilingRequestMessage(RecordFilingRequestMessageType value) {
        return new JAXBElement<RecordFilingRequestMessageType>(_RecordFilingRequestMessage_QNAME, RecordFilingRequestMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviewFilingRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReviewFilingRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0", name = "ReviewFilingRequestMessage")
    public JAXBElement<ReviewFilingRequestMessageType> createReviewFilingRequestMessage(ReviewFilingRequestMessageType value) {
        return new JAXBElement<ReviewFilingRequestMessageType>(_ReviewFilingRequestMessage_QNAME, ReviewFilingRequestMessageType.class, null, value);
    }

}
