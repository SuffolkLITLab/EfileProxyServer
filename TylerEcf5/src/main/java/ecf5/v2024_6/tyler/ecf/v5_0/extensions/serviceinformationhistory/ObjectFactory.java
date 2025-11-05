
package tyler.ecf.v5_0.extensions.serviceinformationhistory;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.serviceinformationhistory package. 
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

    private final static QName _GetServiceInformationHistoryMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:serviceinformationhistory", "GetServiceInformationHistoryMessage");
    private final static QName _GetServiceInformationHistoryMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:serviceinformationhistory", "GetServiceInformationHistoryMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.serviceinformationhistory
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServiceInformationHistoryMessageType }
     * 
     */
    public GetServiceInformationHistoryMessageType createGetServiceInformationHistoryMessageType() {
        return new GetServiceInformationHistoryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceInformationHistoryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceInformationHistoryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:serviceinformationhistory", name = "GetServiceInformationHistoryMessage")
    public JAXBElement<GetServiceInformationHistoryMessageType> createGetServiceInformationHistoryMessage(GetServiceInformationHistoryMessageType value) {
        return new JAXBElement<GetServiceInformationHistoryMessageType>(_GetServiceInformationHistoryMessage_QNAME, GetServiceInformationHistoryMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:serviceinformationhistory", name = "GetServiceInformationHistoryMessageAugmentationPoint")
    public JAXBElement<Object> createGetServiceInformationHistoryMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetServiceInformationHistoryMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
