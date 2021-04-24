
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ItemType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ItemType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemDescriptionText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemOtherIdentification" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemValue" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemType", propOrder = {
    "itemDescriptionText",
    "itemOtherIdentification",
    "itemValue"
})
@XmlSeeAlso({
    TangibleItemType.class
})
public class ItemType
    extends ComplexObjectType
{

    @XmlElement(name = "ItemDescriptionText", nillable = true)
    protected TextType itemDescriptionText;
    @XmlElement(name = "ItemOtherIdentification", nillable = true)
    protected IdentificationType itemOtherIdentification;
    @XmlElement(name = "ItemValue", nillable = true)
    protected ItemValueType itemValue;

    /**
     * Gets the value of the itemDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getItemDescriptionText() {
        return itemDescriptionText;
    }

    /**
     * Sets the value of the itemDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setItemDescriptionText(TextType value) {
        this.itemDescriptionText = value;
    }

    /**
     * Gets the value of the itemOtherIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getItemOtherIdentification() {
        return itemOtherIdentification;
    }

    /**
     * Sets the value of the itemOtherIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setItemOtherIdentification(IdentificationType value) {
        this.itemOtherIdentification = value;
    }

    /**
     * Gets the value of the itemValue property.
     * 
     * @return
     *     possible object is
     *     {@link ItemValueType }
     *     
     */
    public ItemValueType getItemValue() {
        return itemValue;
    }

    /**
     * Sets the value of the itemValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemValueType }
     *     
     */
    public void setItemValue(ItemValueType value) {
        this.itemValue = value;
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
