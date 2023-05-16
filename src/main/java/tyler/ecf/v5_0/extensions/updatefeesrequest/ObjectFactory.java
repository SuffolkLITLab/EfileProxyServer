
package tyler.ecf.v5_0.extensions.updatefeesrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.updatefeesrequest package. 
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

    private final static QName _UpdateFeesMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatefeesrequest", "UpdateFeesMessage");
    private final static QName _UpdateFeesMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatefeesrequest", "UpdateFeesMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.updatefeesrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateFeesMessageType }
     * 
     */
    public UpdateFeesMessageType createUpdateFeesMessageType() {
        return new UpdateFeesMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFeesMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateFeesMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatefeesrequest", name = "UpdateFeesMessage")
    public JAXBElement<UpdateFeesMessageType> createUpdateFeesMessage(UpdateFeesMessageType value) {
        return new JAXBElement<UpdateFeesMessageType>(_UpdateFeesMessage_QNAME, UpdateFeesMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatefeesrequest", name = "UpdateFeesMessageAugmentationPoint")
    public JAXBElement<Object> createUpdateFeesMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_UpdateFeesMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
