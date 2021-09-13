
package ecfv5.ietf.params.xml.ns.icalendar_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *         This type is the basis for all components that can be contained within
 *         a vcalendar component
 *       
 * 
 * <p>Java class for VcalendarContainedComponentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VcalendarContainedComponentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseComponentType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VcalendarContainedComponentType")
@XmlSeeAlso({
    WsCalendarGluonType.class,
    WsCalendarIntervalType.class,
    VjournalType.class,
    VfreebusyType.class,
    VtimezoneType.class,
    VavailabilityType.class,
    EventTodoComponentType.class
})
public class VcalendarContainedComponentType
    extends BaseComponentType
{


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
