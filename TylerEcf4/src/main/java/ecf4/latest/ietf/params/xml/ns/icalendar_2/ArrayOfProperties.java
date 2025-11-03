
package ecf4.latest.ietf.params.xml.ns.icalendar_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ArrayOfProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProperties"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}baseProperty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProperties", propOrder = {
    "baseProperty"
})
public class ArrayOfProperties {

    @XmlElementRef(name = "baseProperty", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends BasePropertyType>> baseProperty;

    /**
     * Gets the value of the baseProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the baseProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ActionPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link AttachPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link AttendeePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link BasePropertyType }{@code >}
     * {@link JAXBElement }{@code <}{@link CalscalePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link CategoriesPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link ClassPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link CommentPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link CompletedPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link ContactPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link CreatedPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link DescriptionPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link DtendPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link DtstampPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link DtstartPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link DuePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link DurationPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link DurationPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link ExdatePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link ExrulePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link FreebusyPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link GeoPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link LastModifiedPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link LinkPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link LocationPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link MethodPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link OrganizerPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link OrganizerPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link PercentCompletePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link PriorityPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link ProdidPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link RdatePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link RecurrenceIdPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link RelatedToPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link RepeatPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link RequestStatusPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link ResourcesPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link RrulePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link SequencePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link StatusPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link SummaryPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link TolerancePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link TranspPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link TriggerPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link TznamePropType }{@code >}
     * {@link JAXBElement }{@code <}{@link TzoffsetfromPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link TzoffsettoPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link TzurlPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link UidPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link UrlPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link VersionPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link WsCalendarAttachType }{@code >}
     * {@link JAXBElement }{@code <}{@link WsCalendarTypeType }{@code >}
     * {@link JAXBElement }{@code <}{@link XBedeworkCostPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link XBedeworkExsynchEndtzidPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link XBedeworkExsynchLastmodPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link XBedeworkExsynchStarttzidPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link XMicrosoftCdoBusystatusPropType }{@code >}
     * {@link JAXBElement }{@code <}{@link XMicrosoftCdoIntendedstatusPropType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends BasePropertyType>> getBaseProperty() {
        if (baseProperty == null) {
            baseProperty = new ArrayList<JAXBElement<? extends BasePropertyType>>();
        }
        return this.baseProperty;
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
