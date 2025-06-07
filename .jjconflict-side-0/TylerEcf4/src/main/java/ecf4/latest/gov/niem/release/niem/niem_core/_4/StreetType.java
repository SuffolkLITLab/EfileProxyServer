
package ecf4.latest.gov.niem.release.niem.niem_core._4;

import ecf4.latest.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a road, thoroughfare, or highway.
 * 
 * <p>Java class for StreetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StreetType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StreetFullText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StreetNumberText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StreetPredirectionalText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StreetName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StreetCategoryText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StreetPostdirectionalText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StreetExtensionText" minOccurs="0"/&gt;
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
@XmlType(name = "StreetType", propOrder = {
    "streetFullText",
    "streetNumberText",
    "streetPredirectionalText",
    "streetName",
    "streetCategoryText",
    "streetPostdirectionalText",
    "streetExtensionText"
})
public class StreetType
    extends ObjectType
{

    @XmlElement(name = "StreetFullText")
    protected TextType streetFullText;
    @XmlElement(name = "StreetNumberText")
    protected TextType streetNumberText;
    @XmlElement(name = "StreetPredirectionalText")
    protected TextType streetPredirectionalText;
    @XmlElement(name = "StreetName")
    protected ProperNameTextType streetName;
    @XmlElement(name = "StreetCategoryText")
    protected TextType streetCategoryText;
    @XmlElement(name = "StreetPostdirectionalText")
    protected TextType streetPostdirectionalText;
    @XmlElement(name = "StreetExtensionText")
    protected TextType streetExtensionText;

    /**
     * Gets the value of the streetFullText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStreetFullText() {
        return streetFullText;
    }

    /**
     * Sets the value of the streetFullText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStreetFullText(TextType value) {
        this.streetFullText = value;
    }

    /**
     * Gets the value of the streetNumberText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStreetNumberText() {
        return streetNumberText;
    }

    /**
     * Sets the value of the streetNumberText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStreetNumberText(TextType value) {
        this.streetNumberText = value;
    }

    /**
     * Gets the value of the streetPredirectionalText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStreetPredirectionalText() {
        return streetPredirectionalText;
    }

    /**
     * Sets the value of the streetPredirectionalText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStreetPredirectionalText(TextType value) {
        this.streetPredirectionalText = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link ProperNameTextType }
     *     
     */
    public ProperNameTextType getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProperNameTextType }
     *     
     */
    public void setStreetName(ProperNameTextType value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the streetCategoryText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStreetCategoryText() {
        return streetCategoryText;
    }

    /**
     * Sets the value of the streetCategoryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStreetCategoryText(TextType value) {
        this.streetCategoryText = value;
    }

    /**
     * Gets the value of the streetPostdirectionalText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStreetPostdirectionalText() {
        return streetPostdirectionalText;
    }

    /**
     * Sets the value of the streetPostdirectionalText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStreetPostdirectionalText(TextType value) {
        this.streetPostdirectionalText = value;
    }

    /**
     * Gets the value of the streetExtensionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStreetExtensionText() {
        return streetExtensionText;
    }

    /**
     * Sets the value of the streetExtensionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStreetExtensionText(TextType value) {
        this.streetExtensionText = value;
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
