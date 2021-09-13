
package ecfv5.ietf.params.xml.ns.icalendar_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ArrayOfVcalendarContainedComponents complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfVcalendarContainedComponents"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}vcalendarContainedComponent" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfVcalendarContainedComponents", propOrder = {
    "vcalendarContainedComponent"
})
public class ArrayOfVcalendarContainedComponents {

    @XmlElementRef(name = "vcalendarContainedComponent", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends VcalendarContainedComponentType>> vcalendarContainedComponent;

    /**
     * Gets the value of the vcalendarContainedComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vcalendarContainedComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVcalendarContainedComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link VavailabilityType }{@code >}
     * {@link JAXBElement }{@code <}{@link VcalendarContainedComponentType }{@code >}
     * {@link JAXBElement }{@code <}{@link VeventType }{@code >}
     * {@link JAXBElement }{@code <}{@link VfreebusyType }{@code >}
     * {@link JAXBElement }{@code <}{@link VjournalType }{@code >}
     * {@link JAXBElement }{@code <}{@link VtimezoneType }{@code >}
     * {@link JAXBElement }{@code <}{@link VtodoType }{@code >}
     * {@link JAXBElement }{@code <}{@link WsCalendarGluonType }{@code >}
     * {@link JAXBElement }{@code <}{@link WsCalendarIntervalType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends VcalendarContainedComponentType>> getVcalendarContainedComponent() {
        if (vcalendarContainedComponent == null) {
            vcalendarContainedComponent = new ArrayList<JAXBElement<? extends VcalendarContainedComponentType>>();
        }
        return this.vcalendarContainedComponent;
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
