
package ecf4.v2025_0.gov.niem.release.niem.niem_core._4;

import ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.AnyURI;
import ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.Base64Binary;
import ecf4.v2025_0.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a digital representation of an object encoded in a binary format.
 * 
 * <p>Java class for BinaryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BinaryType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}BinaryID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}BinaryObjectAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}BinaryCapturer" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}BinaryDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}BinaryFormatText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}BinaryURI" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}BinarySizeValue" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BinaryType", propOrder = {
    "binaryID",
    "binaryObjectAbstract",
    "binaryCapturer",
    "binaryDescriptionText",
    "binaryFormatText",
    "binaryURI",
    "binarySizeValue"
})
@XmlSeeAlso({
    ImageType.class
})
public class BinaryType
    extends ObjectType
{

    @XmlElement(name = "BinaryID")
    protected ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String binaryID;
    @XmlElementRef(name = "BinaryObjectAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> binaryObjectAbstract;
    @XmlElement(name = "BinaryCapturer")
    protected EntityType binaryCapturer;
    @XmlElement(name = "BinaryDescriptionText")
    protected TextType binaryDescriptionText;
    @XmlElement(name = "BinaryFormatText")
    protected TextType binaryFormatText;
    @XmlElement(name = "BinaryURI")
    protected AnyURI binaryURI;
    @XmlElement(name = "BinarySizeValue")
    protected NonNegativeDecimalType binarySizeValue;

    /**
     * Gets the value of the binaryID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String getBinaryID() {
        return binaryID;
    }

    /**
     * Sets the value of the binaryID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setBinaryID(ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.binaryID = value;
    }

    /**
     * Gets the value of the binaryObjectAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Base64Binary }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getBinaryObjectAbstract() {
        return binaryObjectAbstract;
    }

    /**
     * Sets the value of the binaryObjectAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Base64Binary }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setBinaryObjectAbstract(JAXBElement<?> value) {
        this.binaryObjectAbstract = value;
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
     * Gets the value of the binaryFormatText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBinaryFormatText() {
        return binaryFormatText;
    }

    /**
     * Sets the value of the binaryFormatText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBinaryFormatText(TextType value) {
        this.binaryFormatText = value;
    }

    /**
     * Gets the value of the binaryURI property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getBinaryURI() {
        return binaryURI;
    }

    /**
     * Sets the value of the binaryURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setBinaryURI(AnyURI value) {
        this.binaryURI = value;
    }

    /**
     * Gets the value of the binarySizeValue property.
     * 
     * @return
     *     possible object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public NonNegativeDecimalType getBinarySizeValue() {
        return binarySizeValue;
    }

    /**
     * Sets the value of the binarySizeValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link NonNegativeDecimalType }
     *     
     */
    public void setBinarySizeValue(NonNegativeDecimalType value) {
        this.binarySizeValue = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
