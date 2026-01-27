
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.InsuranceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information describing a motor vehicle.
 * 
 * <p>Java class for VehicleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}VehicleType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}VehicleOwnerInsuranceCoverage" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}VehicleOperatorInsuranceCoverage" minOccurs="0"/&gt;
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
    "vehicleOwnerInsuranceCoverage",
    "vehicleOperatorInsuranceCoverage"
})
@XmlSeeAlso({
   ecf4.v2025_0.tyler.ecf.extensions.common.VehicleType.class
})
public class VehicleType
    extends ecf4.v2025_0.gov.niem.niem.niem_core._2.VehicleType
{

    @XmlElement(name = "VehicleOwnerInsuranceCoverage")
    protected InsuranceType vehicleOwnerInsuranceCoverage;
    @XmlElement(name = "VehicleOperatorInsuranceCoverage")
    protected InsuranceType vehicleOperatorInsuranceCoverage;

    /**
     * Gets the value of the vehicleOwnerInsuranceCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link InsuranceType }
     *     
     */
    public InsuranceType getVehicleOwnerInsuranceCoverage() {
        return vehicleOwnerInsuranceCoverage;
    }

    /**
     * Sets the value of the vehicleOwnerInsuranceCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsuranceType }
     *     
     */
    public void setVehicleOwnerInsuranceCoverage(InsuranceType value) {
        this.vehicleOwnerInsuranceCoverage = value;
    }

    /**
     * Gets the value of the vehicleOperatorInsuranceCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link InsuranceType }
     *     
     */
    public InsuranceType getVehicleOperatorInsuranceCoverage() {
        return vehicleOperatorInsuranceCoverage;
    }

    /**
     * Sets the value of the vehicleOperatorInsuranceCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link InsuranceType }
     *     
     */
    public void setVehicleOperatorInsuranceCoverage(InsuranceType value) {
        this.vehicleOperatorInsuranceCoverage = value;
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
