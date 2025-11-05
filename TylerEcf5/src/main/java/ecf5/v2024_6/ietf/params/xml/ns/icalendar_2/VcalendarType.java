
package ecf5.v2024_6.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *         This type is the basis for all components and provides a base class for
 *         applications.
 *       
 * 
 * <p>Java class for VcalendarType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VcalendarType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseComponentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="components" type="{urn:ietf:params:xml:ns:icalendar-2.0}ArrayOfVcalendarContainedComponents"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VcalendarType", propOrder = {
    "components"
})
public class VcalendarType
    extends BaseComponentType
{

    @XmlElement(required = true)
    protected ArrayOfVcalendarContainedComponents components;

    /**
     * Gets the value of the components property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfVcalendarContainedComponents }
     *     
     */
    public ArrayOfVcalendarContainedComponents getComponents() {
        return components;
    }

    /**
     * Sets the value of the components property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfVcalendarContainedComponents }
     *     
     */
    public void setComponents(ArrayOfVcalendarContainedComponents value) {
        this.components = value;
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
