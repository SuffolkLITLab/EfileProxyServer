
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.ArrestType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.BookingType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.CitationType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.CourtEventType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.CourtOrderType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.DriverLicenseWithdrawalType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.OffenseType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.SentenceType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.TermType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a single or set of related actions, events, or process steps.
 * 
 * <p>Java class for ActivityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ActivityIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ActivityDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ActivityStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ActivityDisposition" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ActivityDate" minOccurs="0"/&gt;
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
@XmlType(name = "ActivityType", propOrder = {
    "activityIdentification",
    "activityDescriptionText",
    "activityStatus",
    "activityDisposition",
    "activityDate"
})
@XmlSeeAlso({
    CaseType.class,
    ArrestType.class,
    BookingType.class,
    CourtEventType.class,
    CitationType.class,
    DriverLicenseWithdrawalType.class,
    OffenseType.class,
    SentenceType.class,
    TermType.class,
    SupervisionType.class,
    CourtOrderType.class,
    PersonDisunionType.class,
    PersonUnionSeparationType.class,
    IncidentType.class
})
public class ActivityType
    extends ObjectType
{

    @XmlElement(name = "ActivityIdentification")
    protected IdentificationType activityIdentification;
    @XmlElement(name = "ActivityDescriptionText")
    protected TextType activityDescriptionText;
    @XmlElement(name = "ActivityStatus")
    protected StatusType activityStatus;
    @XmlElementRef(name = "ActivityDisposition", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends DispositionType> activityDisposition;
    @XmlElement(name = "ActivityDate")
    protected DateType activityDate;

    /**
     * Gets the value of the activityIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getActivityIdentification() {
        return activityIdentification;
    }

    /**
     * Sets the value of the activityIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setActivityIdentification(IdentificationType value) {
        this.activityIdentification = value;
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
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CaseDispositionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DispositionType }{@code >}
     *     
     */
    public JAXBElement<? extends DispositionType> getActivityDisposition() {
        return activityDisposition;
    }

    /**
     * Sets the value of the activityDisposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CaseDispositionType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DispositionType }{@code >}
     *     
     */
    public void setActivityDisposition(JAXBElement<? extends DispositionType> value) {
        this.activityDisposition = value;
    }

    /**
     * Gets the value of the activityDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getActivityDate() {
        return activityDate;
    }

    /**
     * Sets the value of the activityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setActivityDate(DateType value) {
        this.activityDate = value;
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
