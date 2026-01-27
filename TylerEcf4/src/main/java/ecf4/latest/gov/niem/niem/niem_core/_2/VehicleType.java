
package ecf4.latest.gov.niem.niem.niem_core._2;

import ecf4.latest.gov.niem.niem.fbi._2.VMACodeType;
import ecf4.latest.gov.niem.niem.fbi._2.VMOCodeType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for VehicleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ConveyanceType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}VehicleIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}VehicleMakeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}VehicleModelCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleType", propOrder = {
    "vehicleIdentification",
    "vehicleMakeCode",
    "vehicleModelCode"
})
@XmlSeeAlso({
    ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.VehicleType.class
})
public class VehicleType
    extends ConveyanceType
{

    @XmlElement(name = "VehicleIdentification", nillable = true)
    protected IdentificationType vehicleIdentification;
    @XmlElement(name = "VehicleMakeCode", nillable = true)
    protected VMACodeType vehicleMakeCode;
    @XmlElement(name = "VehicleModelCode", nillable = true)
    protected VMOCodeType vehicleModelCode;

    /**
     * Gets the value of the vehicleIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getVehicleIdentification() {
        return vehicleIdentification;
    }

    /**
     * Sets the value of the vehicleIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setVehicleIdentification(IdentificationType value) {
        this.vehicleIdentification = value;
    }

    /**
     * Gets the value of the vehicleMakeCode property.
     * 
     * @return
     *     possible object is
     *     {@link VMACodeType }
     *     
     */
    public VMACodeType getVehicleMakeCode() {
        return vehicleMakeCode;
    }

    /**
     * Sets the value of the vehicleMakeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link VMACodeType }
     *     
     */
    public void setVehicleMakeCode(VMACodeType value) {
        this.vehicleMakeCode = value;
    }

    /**
     * Gets the value of the vehicleModelCode property.
     * 
     * @return
     *     possible object is
     *     {@link VMOCodeType }
     *     
     */
    public VMOCodeType getVehicleModelCode() {
        return vehicleModelCode;
    }

    /**
     * Sets the value of the vehicleModelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link VMOCodeType }
     *     
     */
    public void setVehicleModelCode(VMOCodeType value) {
        this.vehicleModelCode = value;
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
