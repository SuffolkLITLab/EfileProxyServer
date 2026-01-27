
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.IncidentAugmentationType;
import ecf4.latest.gov.niem.niem.niem_core._2.ActivityConveyanceAssociationType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The incident from which a traffic ticket arose..
 * 
 * <p>Java class for DrivingIncidentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrivingIncidentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}DrivingIncidentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}IncidentAugmentation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}IncidentVehicleAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}RedLightCameraIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrivingIncidentType", propOrder = {
    "incidentAugmentation",
    "incidentVehicleAssociation",
    "redLightCameraIndicator"
})
@XmlSeeAlso({
    ecf4.latest.tyler.ecf.extensions.common.DrivingIncidentType.class
})
public class DrivingIncidentType
    extends ecf4.latest.gov.niem.niem.domains.jxdm._4.DrivingIncidentType
{

    @XmlElement(name = "IncidentAugmentation", namespace = "http://niem.gov/niem/domains/jxdm/4.0")
    protected IncidentAugmentationType incidentAugmentation;
    @XmlElement(name = "IncidentVehicleAssociation", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected List<ActivityConveyanceAssociationType> incidentVehicleAssociation;
    @XmlElement(name = "RedLightCameraIndicator")
    protected Boolean redLightCameraIndicator;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the incidentVehicleAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIncidentVehicleAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityConveyanceAssociationType }
     * 
     * 
     */
    public List<ActivityConveyanceAssociationType> getIncidentVehicleAssociation() {
        if (incidentVehicleAssociation == null) {
            incidentVehicleAssociation = new ArrayList<ActivityConveyanceAssociationType>();
        }
        return this.incidentVehicleAssociation;
    }

    /**
     * Gets the value of the redLightCameraIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getRedLightCameraIndicator() {
        return redLightCameraIndicator;
    }

    /**
     * Sets the value of the redLightCameraIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRedLightCameraIndicator(Boolean value) {
        this.redLightCameraIndicator = value;
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
