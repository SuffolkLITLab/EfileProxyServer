
package ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.codes.aamva_d20._4.AccidentSeverityCodeType;
import ecf5.v2024_6.gov.niem.release.niem.codes.aamva_d20._4.HazMatCodeType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IncidentType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.SpeedMeasureType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for details of an incident involving a vehicle.
 * 
 * <p>Java class for DrivingIncidentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrivingIncidentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}IncidentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DrivingAccidentSeverityAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DrivingIncidentRecordedSpeedRateMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DrivingIncidentHazMatAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DrivingIncidentLaserDetectionIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DrivingIncidentLegalSpeedRateMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DrivingIncidentPassengerQuantityText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DrivingIncidentRadarDetectionIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DrivingIncidentAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "DrivingIncidentType", propOrder = {
    "drivingAccidentSeverityAbstract",
    "drivingIncidentRecordedSpeedRateMeasure",
    "drivingIncidentHazMatAbstract",
    "drivingIncidentLaserDetectionIndicator",
    "drivingIncidentLegalSpeedRateMeasure",
    "drivingIncidentPassengerQuantityText",
    "drivingIncidentRadarDetectionIndicator",
    "drivingIncidentAugmentationPoint"
})
public class DrivingIncidentType
    extends IncidentType
{

    @XmlElementRef(name = "DrivingAccidentSeverityAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> drivingAccidentSeverityAbstract;
    @XmlElement(name = "DrivingIncidentRecordedSpeedRateMeasure")
    protected SpeedMeasureType drivingIncidentRecordedSpeedRateMeasure;
    @XmlElementRef(name = "DrivingIncidentHazMatAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> drivingIncidentHazMatAbstract;
    @XmlElement(name = "DrivingIncidentLaserDetectionIndicator")
    protected Boolean drivingIncidentLaserDetectionIndicator;
    @XmlElement(name = "DrivingIncidentLegalSpeedRateMeasure")
    protected SpeedMeasureType drivingIncidentLegalSpeedRateMeasure;
    @XmlElement(name = "DrivingIncidentPassengerQuantityText")
    protected TextType drivingIncidentPassengerQuantityText;
    @XmlElement(name = "DrivingIncidentRadarDetectionIndicator")
    protected Boolean drivingIncidentRadarDetectionIndicator;
    @XmlElement(name = "DrivingIncidentAugmentationPoint")
    protected List<Object> drivingIncidentAugmentationPoint;

    /**
     * Gets the value of the drivingAccidentSeverityAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link AccidentSeverityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDrivingAccidentSeverityAbstract() {
        return drivingAccidentSeverityAbstract;
    }

    /**
     * Sets the value of the drivingAccidentSeverityAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AccidentSeverityCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDrivingAccidentSeverityAbstract(JAXBElement<?> value) {
        this.drivingAccidentSeverityAbstract = value;
    }

    /**
     * Gets the value of the drivingIncidentRecordedSpeedRateMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link SpeedMeasureType }
     *     
     */
    public SpeedMeasureType getDrivingIncidentRecordedSpeedRateMeasure() {
        return drivingIncidentRecordedSpeedRateMeasure;
    }

    /**
     * Sets the value of the drivingIncidentRecordedSpeedRateMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedMeasureType }
     *     
     */
    public void setDrivingIncidentRecordedSpeedRateMeasure(SpeedMeasureType value) {
        this.drivingIncidentRecordedSpeedRateMeasure = value;
    }

    /**
     * Gets the value of the drivingIncidentHazMatAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link HazMatCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDrivingIncidentHazMatAbstract() {
        return drivingIncidentHazMatAbstract;
    }

    /**
     * Sets the value of the drivingIncidentHazMatAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link HazMatCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDrivingIncidentHazMatAbstract(JAXBElement<?> value) {
        this.drivingIncidentHazMatAbstract = value;
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
     * Gets the value of the drivingIncidentLegalSpeedRateMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link SpeedMeasureType }
     *     
     */
    public SpeedMeasureType getDrivingIncidentLegalSpeedRateMeasure() {
        return drivingIncidentLegalSpeedRateMeasure;
    }

    /**
     * Sets the value of the drivingIncidentLegalSpeedRateMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedMeasureType }
     *     
     */
    public void setDrivingIncidentLegalSpeedRateMeasure(SpeedMeasureType value) {
        this.drivingIncidentLegalSpeedRateMeasure = value;
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
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDrivingIncidentRadarDetectionIndicator() {
        return drivingIncidentRadarDetectionIndicator;
    }

    /**
     * Sets the value of the drivingIncidentRadarDetectionIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDrivingIncidentRadarDetectionIndicator(Boolean value) {
        this.drivingIncidentRadarDetectionIndicator = value;
    }

    /**
     * Gets the value of the drivingIncidentAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the drivingIncidentAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrivingIncidentAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getDrivingIncidentAugmentationPoint() {
        if (drivingIncidentAugmentationPoint == null) {
            drivingIncidentAugmentationPoint = new ArrayList<Object>();
        }
        return this.drivingIncidentAugmentationPoint;
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
