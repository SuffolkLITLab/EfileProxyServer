
package gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.ActivityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.LocationType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ArrestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestAgency" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestAgencyRecordIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestBailRecommendationText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestBloodAlcoholContentNumberText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestLocation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestOfficial" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestSubject" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ArrestWarrant" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}Booking" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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
    "arrestBailRecommendationText",
    "arrestBloodAlcoholContentNumberText",
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

    @XmlElementRef(name = "ArrestAgency", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends gov.niem.niem.niem_core._2.OrganizationType> arrestAgency;
    @XmlElement(name = "ArrestAgencyRecordIdentification", nillable = true)
    protected IdentificationType arrestAgencyRecordIdentification;
    @XmlElement(name = "ArrestBailRecommendationText", nillable = true)
    protected TextType arrestBailRecommendationText;
    @XmlElement(name = "ArrestBloodAlcoholContentNumberText", nillable = true)
    protected TextType arrestBloodAlcoholContentNumberText;
    @XmlElement(name = "ArrestCharge", nillable = true)
    protected List<ChargeType> arrestCharge;
    @XmlElement(name = "ArrestLocation", nillable = true)
    protected LocationType arrestLocation;
    @XmlElement(name = "ArrestOfficial", nillable = true)
    protected List<EnforcementOfficialType> arrestOfficial;
    @XmlElementRef(name = "ArrestSubject", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends gov.niem.niem.domains.jxdm._4.SubjectType> arrestSubject;
    @XmlElement(name = "ArrestWarrant", nillable = true)
    protected WarrantType arrestWarrant;
    @XmlElement(name = "Booking", nillable = true)
    protected BookingType booking;

    /**
     * Gets the value of the arrestAgency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType }{@code >}
     *     
     */
    public JAXBElement<? extends gov.niem.niem.niem_core._2.OrganizationType> getArrestAgency() {
        return arrestAgency;
    }

    /**
     * Sets the value of the arrestAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType }{@code >}
     *     
     */
    public void setArrestAgency(JAXBElement<? extends gov.niem.niem.niem_core._2.OrganizationType> value) {
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
     * Gets the value of the arrestBailRecommendationText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getArrestBailRecommendationText() {
        return arrestBailRecommendationText;
    }

    /**
     * Sets the value of the arrestBailRecommendationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setArrestBailRecommendationText(TextType value) {
        this.arrestBailRecommendationText = value;
    }

    /**
     * Gets the value of the arrestBloodAlcoholContentNumberText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getArrestBloodAlcoholContentNumberText() {
        return arrestBloodAlcoholContentNumberText;
    }

    /**
     * Sets the value of the arrestBloodAlcoholContentNumberText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setArrestBloodAlcoholContentNumberText(TextType value) {
        this.arrestBloodAlcoholContentNumberText = value;
    }

    /**
     * Gets the value of the arrestCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrestOfficial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrestOfficial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnforcementOfficialType }
     * 
     * 
     */
    public List<EnforcementOfficialType> getArrestOfficial() {
        if (arrestOfficial == null) {
            arrestOfficial = new ArrayList<EnforcementOfficialType>();
        }
        return this.arrestOfficial;
    }

    /**
     * Gets the value of the arrestSubject property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.domains.jxdm._4.SubjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.SubjectType }{@code >}
     *     
     */
    public JAXBElement<? extends gov.niem.niem.domains.jxdm._4.SubjectType> getArrestSubject() {
        return arrestSubject;
    }

    /**
     * Sets the value of the arrestSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.domains.jxdm._4.SubjectType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.SubjectType }{@code >}
     *     
     */
    public void setArrestSubject(JAXBElement<? extends gov.niem.niem.domains.jxdm._4.SubjectType> value) {
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
