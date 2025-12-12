
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.schedulerequest;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A request for the schedule of upcoming events in a court
 * 
 * <p>Java class for GetCourtScheduleRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCourtScheduleRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/schedulerequest}GetCourtScheduleRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/schedulerequest}ScheduleQueryCriteria"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCourtScheduleRequestMessageType", propOrder = {
    "getCourtScheduleRequestMessageAugmentationPoint",
    "scheduleQueryCriteria"
})
public class GetCourtScheduleRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "GetCourtScheduleRequestMessageAugmentationPoint")
    protected List<Object> getCourtScheduleRequestMessageAugmentationPoint;
    @XmlElement(name = "ScheduleQueryCriteria", required = true)
    protected ScheduleQueryCriteriaType scheduleQueryCriteria;

    /**
     * Gets the value of the getCourtScheduleRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getCourtScheduleRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCourtScheduleRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetCourtScheduleRequestMessageAugmentationPoint() {
        if (getCourtScheduleRequestMessageAugmentationPoint == null) {
            getCourtScheduleRequestMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getCourtScheduleRequestMessageAugmentationPoint;
    }

    /**
     * Gets the value of the scheduleQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduleQueryCriteriaType }
     *     
     */
    public ScheduleQueryCriteriaType getScheduleQueryCriteria() {
        return scheduleQueryCriteria;
    }

    /**
     * Sets the value of the scheduleQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduleQueryCriteriaType }
     *     
     */
    public void setScheduleQueryCriteria(ScheduleQueryCriteriaType value) {
        this.scheduleQueryCriteria = value;
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
