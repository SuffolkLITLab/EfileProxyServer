
package ecfv5.ietf.params.xml.ns.icalendar_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *         Events and todos only contain alarms
 *       
 * 
 * <p>Java class for EventTodoComponentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventTodoComponentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}VcalendarContainedComponentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="components" type="{urn:ietf:params:xml:ns:icalendar-2.0}ArrayOfEventTodoContainedComponents"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventTodoComponentType", propOrder = {
    "components"
})
@XmlSeeAlso({
    VeventType.class,
    VtodoType.class
})
public class EventTodoComponentType
    extends VcalendarContainedComponentType
{

    @XmlElement(required = true)
    protected ArrayOfEventTodoContainedComponents components;

    /**
     * Gets the value of the components property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfEventTodoContainedComponents }
     *     
     */
    public ArrayOfEventTodoContainedComponents getComponents() {
        return components;
    }

    /**
     * Sets the value of the components property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfEventTodoContainedComponents }
     *     
     */
    public void setComponents(ArrayOfEventTodoContainedComponents value) {
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
