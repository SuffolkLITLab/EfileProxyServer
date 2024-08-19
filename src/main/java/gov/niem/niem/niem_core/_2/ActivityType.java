
package gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import gov.niem.niem.domains.jxdm._4.ArrestType;
import gov.niem.niem.domains.jxdm._4.BookingType;
import gov.niem.niem.domains.jxdm._4.CitationType;
import gov.niem.niem.domains.jxdm._4.CourtEventType;
import gov.niem.niem.domains.jxdm._4.CourtOrderType;
import gov.niem.niem.domains.jxdm._4.SentenceType;
import gov.niem.niem.domains.jxdm._4.TermType;
import gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ActivityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ActivityIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ActivityDateRepresentation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ActivityDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ActivityStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ActivityDisposition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityType", propOrder = {
    "activityIdentification",
    "activityDateRepresentation",
    "activityDescriptionText",
    "activityStatus",
    "activityDisposition"
})
@XmlSeeAlso({
    DriverLicenseWithdrawalType.class,
    ArrestType.class,
    BookingType.class,
    CitationType.class,
    TermType.class,
    CourtEventType.class,
    SentenceType.class,
    CourtOrderType.class,
    CaseType.class,
    IncidentType.class
})
public class ActivityType
    extends ComplexObjectType
{

    @XmlElement(name = "ActivityIdentification", nillable = true)
    protected List<IdentificationType> activityIdentification;
    @XmlElementRef(name = "ActivityDateRepresentation", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> activityDateRepresentation;
    @XmlElement(name = "ActivityDescriptionText", nillable = true)
    protected TextType activityDescriptionText;
    @XmlElement(name = "ActivityStatus", nillable = true)
    protected StatusType activityStatus;
    @XmlElementRef(name = "ActivityDisposition", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends DispositionType>> activityDisposition;

    /**
     * Gets the value of the activityIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the activityIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getActivityIdentification() {
        if (activityIdentification == null) {
            activityIdentification = new ArrayList<IdentificationType>();
        }
        return this.activityIdentification;
    }

    /**
     * Gets the value of the activityDateRepresentation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DateType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getActivityDateRepresentation() {
        return activityDateRepresentation;
    }

    /**
     * Sets the value of the activityDateRepresentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DateType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setActivityDateRepresentation(JAXBElement<?> value) {
        this.activityDateRepresentation = value;
    }

    /**
     * Gets the value of the activityDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getActivityDescriptionText() {
        return activityDescriptionText;
    }

    /**
     * Sets the value of the activityDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setActivityDescriptionText(TextType value) {
        this.activityDescriptionText = value;
    }

    /**
     * Gets the value of the activityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getActivityStatus() {
        return activityStatus;
    }

    /**
     * Sets the value of the activityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setActivityStatus(StatusType value) {
        this.activityStatus = value;
    }

    /**
     * Gets the value of the activityDisposition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the activityDisposition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivityDisposition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CaseDispositionType }{@code >}
     * {@link JAXBElement }{@code <}{@link DispositionType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends DispositionType>> getActivityDisposition() {
        if (activityDisposition == null) {
            activityDisposition = new ArrayList<JAXBElement<? extends DispositionType>>();
        }
        return this.activityDisposition;
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
