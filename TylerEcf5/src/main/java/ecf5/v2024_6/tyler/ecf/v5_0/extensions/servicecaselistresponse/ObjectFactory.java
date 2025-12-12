
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicecaselistresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicecaselistresponse package. 
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

    private final static QName _GetServiceCaseListResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicecaselistresponse", "GetServiceCaseListResponseMessage");
    private final static QName _GetServiceCaseListResponseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicecaselistresponse", "GetServiceCaseListResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicecaselistresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServiceCaseListResponseMessageType }
     * 
     */
    public GetServiceCaseListResponseMessageType createGetServiceCaseListResponseMessageType() {
        return new GetServiceCaseListResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceCaseListResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceCaseListResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicecaselistresponse", name = "GetServiceCaseListResponseMessage")
    public JAXBElement<GetServiceCaseListResponseMessageType> createGetServiceCaseListResponseMessage(GetServiceCaseListResponseMessageType value) {
        return new JAXBElement<GetServiceCaseListResponseMessageType>(_GetServiceCaseListResponseMessage_QNAME, GetServiceCaseListResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicecaselistresponse", name = "GetServiceCaseListResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetServiceCaseListResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetServiceCaseListResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
