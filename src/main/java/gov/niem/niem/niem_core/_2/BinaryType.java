
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.AnyURI;
import gov.niem.niem.proxy.xsd._2.Base64Binary;
import gov.niem.niem.structures._2.ComplexObjectType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentAttachmentType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for BinaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BinaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}BinaryObject" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}BinaryCaptureDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}BinaryCapturer" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}BinaryDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}BinaryFormatStandardName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}BinaryLocationURI" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}BinarySizeValue" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}BinaryCategoryText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinaryType", propOrder = {
    "binaryObject",
    "binaryCaptureDate",
    "binaryCapturer",
    "binaryDescriptionText",
    "binaryFormatStandardName",
    "binaryLocationURI",
    "binarySizeValue",
    "binaryCategoryText"
})
@XmlSeeAlso({
    ImageType.class,
    DocumentAttachmentType.class
})
public class BinaryType
    extends ComplexObjectType
{

    @XmlElementRef(name = "BinaryObject", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> binaryObject;
    @XmlElement(name = "BinaryCaptureDate", nillable = true)
    protected DateType binaryCaptureDate;
    @XmlElement(name = "BinaryCapturer", nillable = true)
    protected EntityType binaryCapturer;
    @XmlElement(name = "BinaryDescriptionText", nillable = true)
    protected TextType binaryDescriptionText;
    @XmlElement(name = "BinaryFormatStandardName", nillable = true)
    protected TextType binaryFormatStandardName;
    @XmlElement(name = "BinaryLocationURI", nillable = true)
    protected AnyURI binaryLocationURI;
    @XmlElementRef(name = "BinarySizeValue", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<NonNegativeDecimalType> binarySizeValue;
    @XmlElement(name = "BinaryCategoryText", nillable = true)
    protected TextType binaryCategoryText;

    /**
     * Gets the value of the binaryObject property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Base64Binary }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getBinaryObject() {
        return binaryObject;
    }

    /**
     * Sets the value of the binaryObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Base64Binary }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setBinaryObject(JAXBElement<?> value) {
        this.binaryObject = value;
    }

    /**
     * Gets the value of the binaryCaptureDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getBinaryCaptureDate() {
        return binaryCaptureDate;
    }

    /**
     * Sets the value of the binaryCaptureDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setBinaryCaptureDate(DateType value) {
        this.binaryCaptureDate = value;
    }

    /**
     * Gets the value of the binaryCapturer property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getBinaryCapturer() {
        return binaryCapturer;
    }

    /**
     * Sets the value of the binaryCapturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setBinaryCapturer(EntityType value) {
        this.binaryCapturer = value;
    }

    /**
     * Gets the value of the binaryDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBinaryDescriptionText() {
        return binaryDescriptionText;
    }

    /**
     * Sets the value of the binaryDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBinaryDescriptionText(TextType value) {
        this.binaryDescriptionText = value;
    }

    /**
     * Gets the value of the binaryFormatStandardName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBinaryFormatStandardName() {
        return binaryFormatStandardName;
    }

    /**
     * Sets the value of the binaryFormatStandardName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBinaryFormatStandardName(TextType value) {
        this.binaryFormatStandardName = value;
    }

    /**
     * Gets the value of the binaryLocationURI property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getBinaryLocationURI() {
        return binaryLocationURI;
    }

    /**
     * Sets the value of the binaryLocationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setBinaryLocationURI(AnyURI value) {
        this.binaryLocationURI = value;
    }

    /**
     * Gets the value of the binarySizeValue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     *     
     */
    public JAXBElement<NonNegativeDecimalType> getBinarySizeValue() {
        return binarySizeValue;
    }

    /**
     * Sets the value of the binarySizeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     *     
     */
    public void setBinarySizeValue(JAXBElement<NonNegativeDecimalType> value) {
        this.binarySizeValue = value;
    }

    /**
     * Gets the value of the binaryCategoryText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBinaryCategoryText() {
        return binaryCategoryText;
    }

    /**
     * Sets the value of the binaryCategoryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBinaryCategoryText(TextType value) {
        this.binaryCategoryText = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
