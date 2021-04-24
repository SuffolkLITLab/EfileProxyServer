
package oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.IncidentAugmentationType;
import gov.niem.niem.niem_core._2.ActivityConveyanceAssociationType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The incident from which a traffic ticket arose..
 * 
 * &lt;p&gt;Java class for DrivingIncidentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DrivingIncidentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}DrivingIncidentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}IncidentAugmentation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}IncidentVehicleAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}RedLightCameraIndicator" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    tyler.ecf.extensions.common.DrivingIncidentType.class
})
public class DrivingIncidentType
    extends gov.niem.niem.domains.jxdm._4.DrivingIncidentType
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the incidentVehicleAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getIncidentVehicleAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
