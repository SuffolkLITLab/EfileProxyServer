
package ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ActivityType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.LocationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.OrganizationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for the apprehension of a subject by a peace official.
 * 
 * <p>Java class for ArrestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ArrestAgency" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ArrestAgencyRecordIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ArrestCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ArrestLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ArrestOfficial" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ArrestSubject" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ArrestWarrant" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}Booking" minOccurs="0"/&gt;
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
@XmlType(name = "ArrestType", propOrder = {
    "arrestAgency",
    "arrestAgencyRecordIdentification",
    "arrestCharge",
    "arrestLocation",
    "arrestOfficial",
    "arrestSubject",
    "arrestWarrant",
    "booking"
})
public class ArrestType
    extends ActivityType
{

    @XmlElement(name = "ArrestAgency", nillable = true)
    protected OrganizationType arrestAgency;
    @XmlElement(name = "ArrestAgencyRecordIdentification")
    protected IdentificationType arrestAgencyRecordIdentification;
    @XmlElement(name = "ArrestCharge", nillable = true)
    protected List<ChargeType> arrestCharge;
    @XmlElement(name = "ArrestLocation", nillable = true)
    protected LocationType arrestLocation;
    @XmlElement(name = "ArrestOfficial")
    protected EnforcementOfficialType arrestOfficial;
    @XmlElement(name = "ArrestSubject")
    protected SubjectType arrestSubject;
    @XmlElement(name = "ArrestWarrant")
    protected WarrantType arrestWarrant;
    @XmlElement(name = "Booking")
    protected BookingType booking;

    /**
     * Gets the value of the arrestAgency property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationType }
     *     
     */
    public OrganizationType getArrestAgency() {
        return arrestAgency;
    }

    /**
     * Sets the value of the arrestAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationType }
     *     
     */
    public void setArrestAgency(OrganizationType value) {
        this.arrestAgency = value;
    }

    /**
     * Gets the value of the arrestAgencyRecordIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getArrestAgencyRecordIdentification() {
        return arrestAgencyRecordIdentification;
    }

    /**
     * Sets the value of the arrestAgencyRecordIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setArrestAgencyRecordIdentification(IdentificationType value) {
        this.arrestAgencyRecordIdentification = value;
    }

    /**
     * Gets the value of the arrestCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the arrestCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrestCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeType }
     * 
     * 
     */
    public List<ChargeType> getArrestCharge() {
        if (arrestCharge == null) {
            arrestCharge = new ArrayList<ChargeType>();
        }
        return this.arrestCharge;
    }

    /**
     * Gets the value of the arrestLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getArrestLocation() {
        return arrestLocation;
    }

    /**
     * Sets the value of the arrestLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setArrestLocation(LocationType value) {
        this.arrestLocation = value;
    }

    /**
     * Gets the value of the arrestOfficial property.
     * 
     * @return
     *     possible object is
     *     {@link EnforcementOfficialType }
     *     
     */
    public EnforcementOfficialType getArrestOfficial() {
        return arrestOfficial;
    }

    /**
     * Sets the value of the arrestOfficial property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnforcementOfficialType }
     *     
     */
    public void setArrestOfficial(EnforcementOfficialType value) {
        this.arrestOfficial = value;
    }

    /**
     * Gets the value of the arrestSubject property.
     * 
     * @return
     *     possible object is
     *     {@link SubjectType }
     *     
     */
    public SubjectType getArrestSubject() {
        return arrestSubject;
    }

    /**
     * Sets the value of the arrestSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubjectType }
     *     
     */
    public void setArrestSubject(SubjectType value) {
        this.arrestSubject = value;
    }

    /**
     * Gets the value of the arrestWarrant property.
     * 
     * @return
     *     possible object is
     *     {@link WarrantType }
     *     
     */
    public WarrantType getArrestWarrant() {
        return arrestWarrant;
    }

    /**
     * Sets the value of the arrestWarrant property.
     * 
     * @param value
     *     allowed object is
     *     {@link WarrantType }
     *     
     */
    public void setArrestWarrant(WarrantType value) {
        this.arrestWarrant = value;
    }

    /**
     * Gets the value of the booking property.
     * 
     * @return
     *     possible object is
     *     {@link BookingType }
     *     
     */
    public BookingType getBooking() {
        return booking;
    }

    /**
     * Sets the value of the booking property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingType }
     *     
     */
    public void setBooking(BookingType value) {
        this.booking = value;
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
