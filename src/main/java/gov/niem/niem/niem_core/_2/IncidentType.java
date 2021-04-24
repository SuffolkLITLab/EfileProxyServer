
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.DrivingIncidentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.ParkingViolationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.DelinquentActType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.StatusOffenseActType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for IncidentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="IncidentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}IncidentLocation" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IncidentType", propOrder = {
    "incidentLocation"
})
@XmlSeeAlso({
    ParkingViolationType.class,
    DelinquentActType.class,
    StatusOffenseActType.class,
    DrivingIncidentType.class
})
public class IncidentType
    extends ActivityType
{

    @XmlElement(name = "IncidentLocation", nillable = true)
    protected LocationType incidentLocation;

    /**
     * Gets the value of the incidentLocation property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getIncidentLocation() {
        return incidentLocation;
    }

    /**
     * Sets the value of the incidentLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setIncidentLocation(LocationType value) {
        this.incidentLocation = value;
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
