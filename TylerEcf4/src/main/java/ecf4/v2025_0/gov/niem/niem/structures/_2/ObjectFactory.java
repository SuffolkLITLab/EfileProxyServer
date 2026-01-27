
package ecf4.v2025_0.gov.niem.niem.structures._2;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.v2025_0.gov.niem.niem.structures._2 package. 
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

    private final static QName _Augmentation_QNAME = new QName("http://niem.gov/niem/structures/2.0", "Augmentation");
    private final static QName _Metadata_QNAME = new QName("http://niem.gov/niem/structures/2.0", "Metadata");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.v2025_0.gov.niem.niem.structures._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReferenceType }
     * 
     */
    public ReferenceType createReferenceType() {
        return new ReferenceType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/structures/2.0", name = "Augmentation")
    public JAXBElement<AugmentationType> createAugmentation(AugmentationType value) {
        return new JAXBElement<AugmentationType>(_Augmentation_QNAME, AugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/structures/2.0", name = "Metadata")
    public JAXBElement<MetadataType> createMetadata(MetadataType value) {
        return new JAXBElement<MetadataType>(_Metadata_QNAME, MetadataType.class, null, value);
    }

}
