
package tyler.ecf.v5_0.extensions.taxdelinquency;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.taxdelinquency package. 
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

    private final static QName _ServiceTypeCode_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:taxdelinquency", "ServiceTypeCode");
    private final static QName _DeliveryMethodCode_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:taxdelinquency", "DeliveryMethodCode");
    private final static QName _PartyService_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:taxdelinquency", "PartyService");
    private final static QName _Abstractor_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:taxdelinquency", "Abstractor");
    private final static QName _Fees_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:taxdelinquency", "Fees");
    private final static QName _CaseAbstractor_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:taxdelinquency", "CaseAbstractor");
    private final static QName _PropertyAccountNumber_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:taxdelinquency", "PropertyAccountNumber");
    private final static QName _CaseAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:taxdelinquency", "CaseAugmentation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.taxdelinquency
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PartyServiceType }
     * 
     */
    public PartyServiceType createPartyServiceType() {
        return new PartyServiceType();
    }

    /**
     * Create an instance of {@link CaseAbstractorType }
     * 
     */
    public CaseAbstractorType createCaseAbstractorType() {
        return new CaseAbstractorType();
    }

    /**
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:taxdelinquency", name = "ServiceTypeCode")
    public JAXBElement<TextType> createServiceTypeCode(TextType value) {
        return new JAXBElement<TextType>(_ServiceTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:taxdelinquency", name = "DeliveryMethodCode")
    public JAXBElement<TextType> createDeliveryMethodCode(TextType value) {
        return new JAXBElement<TextType>(_DeliveryMethodCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartyServiceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PartyServiceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:taxdelinquency", name = "PartyService")
    public JAXBElement<PartyServiceType> createPartyService(PartyServiceType value) {
        return new JAXBElement<PartyServiceType>(_PartyService_QNAME, PartyServiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:taxdelinquency", name = "Abstractor")
    public JAXBElement<EntityType> createAbstractor(EntityType value) {
        return new JAXBElement<EntityType>(_Abstractor_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:taxdelinquency", name = "Fees")
    public JAXBElement<AmountType> createFees(AmountType value) {
        return new JAXBElement<AmountType>(_Fees_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAbstractorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAbstractorType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:taxdelinquency", name = "CaseAbstractor")
    public JAXBElement<CaseAbstractorType> createCaseAbstractor(CaseAbstractorType value) {
        return new JAXBElement<CaseAbstractorType>(_CaseAbstractor_QNAME, CaseAbstractorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:taxdelinquency", name = "PropertyAccountNumber")
    public JAXBElement<TextType> createPropertyAccountNumber(TextType value) {
        return new JAXBElement<TextType>(_PropertyAccountNumber_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:taxdelinquency", name = "CaseAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CaseAugmentationPoint")
    public JAXBElement<CaseAugmentationType> createCaseAugmentation(CaseAugmentationType value) {
        return new JAXBElement<CaseAugmentationType>(_CaseAugmentation_QNAME, CaseAugmentationType.class, null, value);
    }

}
