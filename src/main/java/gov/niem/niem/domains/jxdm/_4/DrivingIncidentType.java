
package gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.ansi_d20._2.AccidentSeverityCodeType;
import gov.niem.niem.ansi_d20._2.HazMatCodeType;
import gov.niem.niem.niem_core._2.IncidentType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DrivingIncidentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrivingIncidentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}IncidentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}DrivingAccidentSeverity" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}DrivingIncidentRecordedSpeedRate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}DrivingIncidentHazMat" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}DrivingIncidentLaserDetectionIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}DrivingIncidentLegalSpeedRate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}DrivingIncidentPassengerQuantityText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}DrivingIncidentRadarDetectionIndicator" maxOccurs="unbounded" minOccurs="0"/&gt;
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
    "drivingAccidentSeverity",
    "drivingIncidentRecordedSpeedRate",
    "drivingIncidentHazMat",
    "drivingIncidentLaserDetectionIndicator",
    "drivingIncidentLegalSpeedRate",
    "drivingIncidentPassengerQuantityText",
    "drivingIncidentRadarDetectionIndicator"
})
@XmlSeeAlso({
    oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.DrivingIncidentType.class
})
public class DrivingIncidentType
    extends IncidentType
{

    @XmlElementRef(name = "DrivingAccidentSeverity", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> drivingAccidentSeverity;
    @XmlElement(name = "DrivingIncidentRecordedSpeedRate", nillable = true)
    protected MeasureType drivingIncidentRecordedSpeedRate;
    @XmlElementRef(name = "DrivingIncidentHazMat", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> drivingIncidentHazMat;
    @XmlElement(name = "DrivingIncidentLaserDetectionIndicator", nillable = true)
    protected Boolean drivingIncidentLaserDetectionIndicator;
    @XmlElement(name = "DrivingIncidentLegalSpeedRate", nillable = true)
    protected MeasureType drivingIncidentLegalSpeedRate;
    @XmlElement(name = "DrivingIncidentPassengerQuantityText", nillable = true)
    protected TextType drivingIncidentPassengerQuantityText;
    @XmlElement(name = "DrivingIncidentRadarDetectionIndicator", nillable = true)
    protected List<Boolean> drivingIncidentRadarDetectionIndicator;

    /**
     * Gets the value of the drivingAccidentSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AccidentSeverityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDrivingAccidentSeverity() {
        return drivingAccidentSeverity;
    }

    /**
     * Sets the value of the drivingAccidentSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AccidentSeverityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDrivingAccidentSeverity(JAXBElement<?> value) {
        this.drivingAccidentSeverity = value;
    }

    /**
     * Gets the value of the drivingIncidentRecordedSpeedRate property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getDrivingIncidentRecordedSpeedRate() {
        return drivingIncidentRecordedSpeedRate;
    }

    /**
     * Sets the value of the drivingIncidentRecordedSpeedRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setDrivingIncidentRecordedSpeedRate(MeasureType value) {
        this.drivingIncidentRecordedSpeedRate = value;
    }

    /**
     * Gets the value of the drivingIncidentHazMat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HazMatCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDrivingIncidentHazMat() {
        return drivingIncidentHazMat;
    }

    /**
     * Sets the value of the drivingIncidentHazMat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HazMatCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDrivingIncidentHazMat(JAXBElement<?> value) {
        this.drivingIncidentHazMat = value;
    }

    /**
     * Gets the value of the drivingIncidentLaserDetectionIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDrivingIncidentLaserDetectionIndicator() {
        return drivingIncidentLaserDetectionIndicator;
    }

    /**
     * Sets the value of the drivingIncidentLaserDetectionIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDrivingIncidentLaserDetectionIndicator(Boolean value) {
        this.drivingIncidentLaserDetectionIndicator = value;
    }

    /**
     * Gets the value of the drivingIncidentLegalSpeedRate property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getDrivingIncidentLegalSpeedRate() {
        return drivingIncidentLegalSpeedRate;
    }

    /**
     * Sets the value of the drivingIncidentLegalSpeedRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setDrivingIncidentLegalSpeedRate(MeasureType value) {
        this.drivingIncidentLegalSpeedRate = value;
    }

    /**
     * Gets the value of the drivingIncidentPassengerQuantityText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDrivingIncidentPassengerQuantityText() {
        return drivingIncidentPassengerQuantityText;
    }

    /**
     * Sets the value of the drivingIncidentPassengerQuantityText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDrivingIncidentPassengerQuantityText(TextType value) {
        this.drivingIncidentPassengerQuantityText = value;
    }

    /**
     * Gets the value of the drivingIncidentRadarDetectionIndicator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drivingIncidentRadarDetectionIndicator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrivingIncidentRadarDetectionIndicator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Boolean }
     * 
     * 
     */
    public List<Boolean> getDrivingIncidentRadarDetectionIndicator() {
        if (drivingIncidentRadarDetectionIndicator == null) {
            drivingIncidentRadarDetectionIndicator = new ArrayList<Boolean>();
        }
        return this.drivingIncidentRadarDetectionIndicator;
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
