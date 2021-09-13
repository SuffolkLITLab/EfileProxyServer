
package ecfv5.ietf.params.xml.ns.icalendar_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for BasePropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BasePropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}parameters" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BasePropertyType", propOrder = {
    "parameters"
})
@XmlSeeAlso({
    CalscalePropType.class,
    AttachPropType.class,
    GeoPropType.class,
    DurationPropType.class,
    FreebusyPropType.class,
    RelatedToPropType.class,
    TriggerPropType.class,
    RequestStatusPropType.class,
    LinkPropType.class,
    TolerancePropType.class,
    WsCalendarAttachType.class,
    TextListPropertyType.class,
    CalAddressPropertyType.class,
    IntegerPropertyType.class,
    UriPropertyType.class,
    UtcOffsetPropertyType.class,
    DatetimePropertyType.class,
    UtcDatetimePropertyType.class,
    DateDatetimePropertyType.class,
    RecurPropertyType.class,
    TextPropertyType.class
})
public abstract class BasePropertyType {

    protected ArrayOfParameters parameters;

    /**
     * Gets the value of the parameters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfParameters }
     *     
     */
    public ArrayOfParameters getParameters() {
        return parameters;
    }

    /**
     * Sets the value of the parameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfParameters }
     *     
     */
    public void setParameters(ArrayOfParameters value) {
        this.parameters = value;
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
