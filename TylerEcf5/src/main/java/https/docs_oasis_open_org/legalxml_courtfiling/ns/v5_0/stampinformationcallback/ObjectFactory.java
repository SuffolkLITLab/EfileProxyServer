
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformationcallback;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformationcallback package. 
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

    private final static QName _NotifyDocumentStampInformationMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformationcallback", "NotifyDocumentStampInformationMessage");
    private final static QName _NotifyDocumentStampInformationMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformationcallback", "NotifyDocumentStampInformationMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformationcallback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyDocumentStampInformationMessageType }
     * 
     */
    public NotifyDocumentStampInformationMessageType createNotifyDocumentStampInformationMessageType() {
        return new NotifyDocumentStampInformationMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyDocumentStampInformationMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyDocumentStampInformationMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformationcallback", name = "NotifyDocumentStampInformationMessage")
    public JAXBElement<NotifyDocumentStampInformationMessageType> createNotifyDocumentStampInformationMessage(NotifyDocumentStampInformationMessageType value) {
        return new JAXBElement<NotifyDocumentStampInformationMessageType>(_NotifyDocumentStampInformationMessage_QNAME, NotifyDocumentStampInformationMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/stampinformationcallback", name = "NotifyDocumentStampInformationMessageAugmentationPoint")
    public JAXBElement<Object> createNotifyDocumentStampInformationMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_NotifyDocumentStampInformationMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
