
package oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.IncidentAugmentationType;
import gov.niem.niem.niem_core._2.ActivityConveyanceAssociationType;
import gov.niem.niem.niem_core._2.IncidentType;
import gov.niem.niem.niem_core._2.NumericType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information about a parking violation.
 * 
 * &lt;p&gt;Java class for ParkingViolationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ParkingViolationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}IncidentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}IncidentAugmentation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}IncidentVehicleAssociation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}ParkingFacilityName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}ParkingMeterSpaceNumber" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParkingViolationType", propOrder = {
    "incidentAugmentation",
    "incidentVehicleAssociation",
    "parkingFacilityName",
    "parkingMeterSpaceNumber"
})
public class ParkingViolationType
    extends IncidentType
{

    @XmlElement(name = "IncidentAugmentation", namespace = "http://niem.gov/niem/domains/jxdm/4.0")
    protected IncidentAugmentationType incidentAugmentation;
    @XmlElement(name = "IncidentVehicleAssociation", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected ActivityConveyanceAssociationType incidentVehicleAssociation;
    @XmlElement(name = "ParkingFacilityName")
    protected TextType parkingFacilityName;
    @XmlElement(name = "ParkingMeterSpaceNumber")
    protected NumericType parkingMeterSpaceNumber;

    /**
     * Gets the value of the incidentAugmentation property.
     * 
     * @return
     *     possible object is
     *     {@link IncidentAugmentationType }
     *     
     */
    public IncidentAugmentationType getIncidentAugmentation() {
        return incidentAugmentation;
    }

    /**
     * Sets the value of the incidentAugmentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncidentAugmentationType }
     *     
     */
    public void setIncidentAugmentation(IncidentAugmentationType value) {
        this.incidentAugmentation = value;
    }

    /**
     * Gets the value of the incidentVehicleAssociation property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityConveyanceAssociationType }
     *     
     */
    public ActivityConveyanceAssociationType getIncidentVehicleAssociation() {
        return incidentVehicleAssociation;
    }

    /**
     * Sets the value of the incidentVehicleAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityConveyanceAssociationType }
     *     
     */
    public void setIncidentVehicleAssociation(ActivityConveyanceAssociationType value) {
        this.incidentVehicleAssociation = value;
    }

    /**
     * Gets the value of the parkingFacilityName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getParkingFacilityName() {
        return parkingFacilityName;
    }

    /**
     * Sets the value of the parkingFacilityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setParkingFacilityName(TextType value) {
        this.parkingFacilityName = value;
    }

    /**
     * Gets the value of the parkingMeterSpaceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link NumericType }
     *     
     */
    public NumericType getParkingMeterSpaceNumber() {
        return parkingMeterSpaceNumber;
    }

    /**
     * Sets the value of the parkingMeterSpaceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link NumericType }
     *     
     */
    public void setParkingMeterSpaceNumber(NumericType value) {
        this.parkingMeterSpaceNumber = value;
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
