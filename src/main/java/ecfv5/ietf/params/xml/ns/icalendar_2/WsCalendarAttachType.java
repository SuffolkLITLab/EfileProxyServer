
package ecfv5.ietf.params.xml.ns.icalendar_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * types the content of the xCal attach element
 * 
 * <p>Java class for WsCalendarAttachType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WsCalendarAttachType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BasePropertyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}artifact"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}artifactBase"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}uri"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}text"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WsCalendarAttachType", propOrder = {
    "artifactOrArtifactBaseOrUri"
})
public class WsCalendarAttachType
    extends BasePropertyType
{

    @XmlElementRefs({
        @XmlElementRef(name = "artifact", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "artifactBase", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "uri", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "text", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> artifactOrArtifactBaseOrUri;

    /**
     * Gets the value of the artifactOrArtifactBaseOrUri property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artifactOrArtifactBaseOrUri property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtifactOrArtifactBaseOrUri().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ArtifactBaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link ArtifactType }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getArtifactOrArtifactBaseOrUri() {
        if (artifactOrArtifactBaseOrUri == null) {
            artifactOrArtifactBaseOrUri = new ArrayList<JAXBElement<?>>();
        }
        return this.artifactOrArtifactBaseOrUri;
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
