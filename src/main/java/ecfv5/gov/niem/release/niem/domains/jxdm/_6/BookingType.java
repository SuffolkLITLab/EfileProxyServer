
package ecfv5.gov.niem.release.niem.domains.jxdm._6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.ActivityType;
import ecfv5.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecfv5.gov.niem.release.niem.niem_core._4.OrganizationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an administrative step taken after an arrest subject is brought to a police station or detention facility.
 * 
 * <p>Java class for BookingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BookingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}BookingAgency" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}BookingAgencyRecordIdentification" minOccurs="0"/&gt;
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
@XmlType(name = "BookingType", propOrder = {
    "bookingAgency",
    "bookingAgencyRecordIdentification"
})
public class BookingType
    extends ActivityType
{

    @XmlElement(name = "BookingAgency", nillable = true)
    protected OrganizationType bookingAgency;
    @XmlElement(name = "BookingAgencyRecordIdentification")
    protected IdentificationType bookingAgencyRecordIdentification;

    /**
     * Gets the value of the bookingAgency property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationType }
     *     
     */
    public OrganizationType getBookingAgency() {
        return bookingAgency;
    }

    /**
     * Sets the value of the bookingAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationType }
     *     
     */
    public void setBookingAgency(OrganizationType value) {
        this.bookingAgency = value;
    }

    /**
     * Gets the value of the bookingAgencyRecordIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getBookingAgencyRecordIdentification() {
        return bookingAgencyRecordIdentification;
    }

    /**
     * Sets the value of the bookingAgencyRecordIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setBookingAgencyRecordIdentification(IdentificationType value) {
        this.bookingAgencyRecordIdentification = value;
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
