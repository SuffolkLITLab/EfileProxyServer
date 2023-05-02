
package gov.niem.niem.niem_core._2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemOtherIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemValue" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
