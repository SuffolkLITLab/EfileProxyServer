
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reviewfilingcallback;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reviewfilingcallback package. 
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

    private final static QName _NotifyFilingReviewCompleteMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reviewfilingcallback", "NotifyFilingReviewCompleteMessage");
    private final static QName _NotifyFilingReviewCompleteMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reviewfilingcallback", "NotifyFilingReviewCompleteMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reviewfilingcallback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyFilingReviewCompleteMessageType }
     * 
     */
    public NotifyFilingReviewCompleteMessageType createNotifyFilingReviewCompleteMessageType() {
        return new NotifyFilingReviewCompleteMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyFilingReviewCompleteMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyFilingReviewCompleteMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reviewfilingcallback", name = "NotifyFilingReviewCompleteMessage")
    public JAXBElement<NotifyFilingReviewCompleteMessageType> createNotifyFilingReviewCompleteMessage(NotifyFilingReviewCompleteMessageType value) {
        return new JAXBElement<NotifyFilingReviewCompleteMessageType>(_NotifyFilingReviewCompleteMessage_QNAME, NotifyFilingReviewCompleteMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reviewfilingcallback", name = "NotifyFilingReviewCompleteMessageAugmentationPoint")
    public JAXBElement<Object> createNotifyFilingReviewCompleteMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_NotifyFilingReviewCompleteMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
