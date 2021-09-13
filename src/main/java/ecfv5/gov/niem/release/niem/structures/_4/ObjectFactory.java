
package ecfv5.gov.niem.release.niem.structures._4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecfv5.gov.niem.release.niem.structures._4 package. 
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

    private final static QName _ObjectAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/structures/4.0/", "ObjectAugmentationPoint");
    private final static QName _AssociationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/structures/4.0/", "AssociationAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecfv5.gov.niem.release.niem.structures._4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/structures/4.0/", name = "ObjectAugmentationPoint")
    public JAXBElement<Object> createObjectAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ObjectAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/structures/4.0/", name = "AssociationAugmentationPoint")
    public JAXBElement<Object> createAssociationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_AssociationAugmentationPoint_QNAME, Object.class, null, value);
    }

}
