
package ecf4.latest.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *          A gluon takes vavailability.
 *       
 * 
 * <p>Java class for WsCalendarGluonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WsCalendarGluonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}VcalendarContainedComponentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="components" type="{urn:ietf:params:xml:ns:icalendar-2.0}ArrayOfGluonContainedComponents"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsCalendarGluonType", propOrder = {
    "components"
})
public class WsCalendarGluonType
    extends VcalendarContainedComponentType
{

    @XmlElement(required = true)
    protected ArrayOfGluonContainedComponents components;

    /**
     * Gets the value of the components property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGluonContainedComponents }
     *     
     */
    public ArrayOfGluonContainedComponents getComponents() {
        return components;
    }

    /**
     * Sets the value of the components property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGluonContainedComponents }
     *     
     */
    public void setComponents(ArrayOfGluonContainedComponents value) {
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
