
package ecf4.v2025_0.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for TolerancePropType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TolerancePropType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tolerate" type="{urn:ietf:params:xml:ns:icalendar-2.0}ToleranceValueType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TolerancePropType", propOrder = {
    "tolerate"
})
public class TolerancePropType
    extends BasePropertyType
{

    @XmlElement(required = true)
    protected ToleranceValueType tolerate;

    /**
     * Gets the value of the tolerate property.
     * 
     * @return
     *     possible object is
     *     {@link ToleranceValueType }
     *     
     */
    public ToleranceValueType getTolerate() {
        return tolerate;
    }

    /**
     * Sets the value of the tolerate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToleranceValueType }
     *     
     */
    public void setTolerate(ToleranceValueType value) {
        this.tolerate = value;
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
