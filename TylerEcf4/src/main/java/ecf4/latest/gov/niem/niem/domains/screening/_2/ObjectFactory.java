
package ecf4.latest.gov.niem.niem.domains.screening._2;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.gov.niem.niem.domains.screening._2 package. 
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

    private final static QName _DivorceDecreeIndicator_QNAME = new QName("http://niem.gov/niem/domains/screening/2.0", "DivorceDecreeIndicator");
    private final static QName _ExpirationDate_QNAME = new QName("http://niem.gov/niem/domains/screening/2.0", "ExpirationDate");
    private final static QName _MarriageAssociationAugmentation_QNAME = new QName("http://niem.gov/niem/domains/screening/2.0", "MarriageAssociationAugmentation");
    private final static QName _MarriageCityName_QNAME = new QName("http://niem.gov/niem/domains/screening/2.0", "MarriageCityName");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.gov.niem.niem.domains.screening._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MarriageAssociationAugmentationType }
     * 
     */
    public MarriageAssociationAugmentationType createMarriageAssociationAugmentationType() {
        return new MarriageAssociationAugmentationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/screening/2.0", name = "DivorceDecreeIndicator")
    public JAXBElement<Boolean> createDivorceDecreeIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DivorceDecreeIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/screening/2.0", name = "ExpirationDate")
    public JAXBElement<DateType> createExpirationDate(DateType value) {
        return new JAXBElement<DateType>(_ExpirationDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarriageAssociationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MarriageAssociationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/screening/2.0", name = "MarriageAssociationAugmentation", substitutionHeadNamespace = "http://niem.gov/niem/structures/2.0", substitutionHeadName = "Augmentation")
    public JAXBElement<MarriageAssociationAugmentationType> createMarriageAssociationAugmentation(MarriageAssociationAugmentationType value) {
        return new JAXBElement<MarriageAssociationAugmentationType>(_MarriageAssociationAugmentation_QNAME, MarriageAssociationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/screening/2.0", name = "MarriageCityName")
    public JAXBElement<TextType> createMarriageCityName(TextType value) {
        return new JAXBElement<TextType>(_MarriageCityName_QNAME, TextType.class, null, value);
    }

}
