
package ecf5.v2024_6.ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for TextPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TextPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextPropertyType", propOrder = {
    "text"
})
@XmlSeeAlso({
    MethodPropType.class,
    ProdidPropType.class,
    VersionPropType.class,
    ClassPropType.class,
    CommentPropType.class,
    DescriptionPropType.class,
    LocationPropType.class,
    StatusPropType.class,
    SummaryPropType.class,
    TranspPropType.class,
    TznamePropType.class,
    ContactPropType.class,
    UidPropType.class,
    ActionPropType.class,
    XBedeworkCostPropType.class,
    XBedeworkExsynchEndtzidPropType.class,
    XBedeworkExsynchLastmodPropType.class,
    XBedeworkExsynchStarttzidPropType.class,
    XMicrosoftCdoBusystatusPropType.class,
    XMicrosoftCdoIntendedstatusPropType.class,
    WsCalendarTypeType.class,
    TzidPropType.class,
    BusytypePropType.class
})
public class TextPropertyType
    extends BasePropertyType
{

    @XmlElement(required = true)
    protected String text;

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setText(String value) {
        this.text = value;
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
