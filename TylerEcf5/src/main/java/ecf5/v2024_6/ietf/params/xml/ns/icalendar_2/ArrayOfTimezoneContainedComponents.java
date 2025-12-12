
package ecf5.v2024_6.ietf.params.xml.ns.icalendar_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ArrayOfTimezoneContainedComponents complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfTimezoneContainedComponents"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}standard"/&gt;
 *           &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}daylight"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfTimezoneContainedComponents", propOrder = {
    "standardOrDaylight"
})
public class ArrayOfTimezoneContainedComponents {

    @XmlElements({
        @XmlElement(name = "standard", type = StandardType.class),
        @XmlElement(name = "daylight", type = DaylightType.class)
    })
    protected List<BaseComponentType> standardOrDaylight;

    /**
     * Gets the value of the standardOrDaylight property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the standardOrDaylight property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandardOrDaylight().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DaylightType }
     * {@link StandardType }
     * 
     * 
     */
    public List<BaseComponentType> getStandardOrDaylight() {
        if (standardOrDaylight == null) {
            standardOrDaylight = new ArrayList<BaseComponentType>();
        }
        return this.standardOrDaylight;
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
