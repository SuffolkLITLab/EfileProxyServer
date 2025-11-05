
package ietf.params.xml.ns.icalendar_2;

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
 * <p>Java class for ArrayOfParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfParameters"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}baseParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfParameters", propOrder = {
    "baseParameter"
})
public class ArrayOfParameters {

    @XmlElementRef(name = "baseParameter", namespace = "urn:ietf:params:xml:ns:icalendar-2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends BaseParameterType>> baseParameter;

    /**
     * Gets the value of the baseParameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the baseParameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBaseParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link AltrepParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link BaseParameterType }{@code >}
     * {@link JAXBElement }{@code <}{@link CnParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link CutypeParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link DelegatedFromParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link DelegatedToParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link DirParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link DurationParameterType }{@code >}
     * {@link JAXBElement }{@code <}{@link EncodingParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link FbtypeParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link FmttypeParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link LanguageParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link MemberParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link PartstatParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link RangeParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link RelatedParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link ReltypeParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link RoleParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link RsvpParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link ScheduleAgentParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link ScheduleForceSendParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link ScheduleStatusParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link SentByParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextParameterType }{@code >}
     * {@link JAXBElement }{@code <}{@link TzidParamType }{@code >}
     * {@link JAXBElement }{@code <}{@link XBedeworkUidParamType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends BaseParameterType>> getBaseParameter() {
        if (baseParameter == null) {
            baseParameter = new ArrayList<JAXBElement<? extends BaseParameterType>>();
        }
        return this.baseParameter;
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
