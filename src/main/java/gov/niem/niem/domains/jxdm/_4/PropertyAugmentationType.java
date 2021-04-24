
package gov.niem.niem.domains.jxdm._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.ItemValueType;
import gov.niem.niem.structures._2.AugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for PropertyAugmentationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PropertyAugmentationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}AugmentationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}PropertyTotalDamageValue" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyAugmentationType", propOrder = {
    "propertyTotalDamageValue"
})
public class PropertyAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "PropertyTotalDamageValue", nillable = true)
    protected ItemValueType propertyTotalDamageValue;

    /**
     * Gets the value of the propertyTotalDamageValue property.
     * 
     * @return
     *     possible object is
     *     {@link ItemValueType }
     *     
     */
    public ItemValueType getPropertyTotalDamageValue() {
        return propertyTotalDamageValue;
    }

    /**
     * Sets the value of the propertyTotalDamageValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemValueType }
     *     
     */
    public void setPropertyTotalDamageValue(ItemValueType value) {
        this.propertyTotalDamageValue = value;
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
