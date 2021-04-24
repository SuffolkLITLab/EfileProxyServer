
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for StreetType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="StreetType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}StreetFullText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}StreetNumberText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}StreetPredirectionalText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}StreetName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}StreetCategoryText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}StreetPostdirectionalText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}StreetExtensionText" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    extends ComplexObjectType
{

    @XmlElement(name = "StreetFullText", nillable = true)
    protected TextType streetFullText;
    @XmlElement(name = "StreetNumberText", nillable = true)
    protected TextType streetNumberText;
    @XmlElement(name = "StreetPredirectionalText", nillable = true)
    protected TextType streetPredirectionalText;
    @XmlElement(name = "StreetName", nillable = true)
    protected ProperNameTextType streetName;
    @XmlElement(name = "StreetCategoryText", nillable = true)
    protected TextType streetCategoryText;
    @XmlElement(name = "StreetPostdirectionalText", nillable = true)
    protected TextType streetPostdirectionalText;
    @XmlElement(name = "StreetExtensionText", nillable = true)
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
