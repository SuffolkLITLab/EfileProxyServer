
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.updatefeesresponse;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.updatefeesresponse package. 
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

    private final static QName _UpdateFeesAmount_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatefeesresponse", "UpdateFeesAmount");
    private final static QName _UpdateFeesResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatefeesresponse", "UpdateFeesResponseMessage");
    private final static QName _UpdateFeesResponseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:updatefeesresponse", "UpdateFeesResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.updatefeesresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateFeesResponseMessageType }
     * 
     */
    public UpdateFeesResponseMessageType createUpdateFeesResponseMessageType() {
        return new UpdateFeesResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatefeesresponse", name = "UpdateFeesAmount")
    public JAXBElement<AmountType> createUpdateFeesAmount(AmountType value) {
        return new JAXBElement<AmountType>(_UpdateFeesAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateFeesResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateFeesResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatefeesresponse", name = "UpdateFeesResponseMessage")
    public JAXBElement<UpdateFeesResponseMessageType> createUpdateFeesResponseMessage(UpdateFeesResponseMessageType value) {
        return new JAXBElement<UpdateFeesResponseMessageType>(_UpdateFeesResponseMessage_QNAME, UpdateFeesResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:updatefeesresponse", name = "UpdateFeesResponseMessageAugmentationPoint")
    public JAXBElement<Object> createUpdateFeesResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_UpdateFeesResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
