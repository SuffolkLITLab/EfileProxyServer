
package gov.niem.niem.niem_core._2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.DrivingIncidentType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.ParkingViolationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.DelinquentActType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.StatusOffenseActType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for IncidentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IncidentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}IncidentLocation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IncidentType", propOrder = {
    "incidentLocation"
})
@XmlSeeAlso({
    DelinquentActType.class,
    StatusOffenseActType.class,
    DrivingIncidentType.class,
    ParkingViolationType.class
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
