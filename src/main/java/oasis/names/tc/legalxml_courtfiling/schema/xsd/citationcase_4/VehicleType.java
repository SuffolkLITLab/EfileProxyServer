
package oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.InsuranceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information describing a motor vehicle.
 * 
 * &lt;p&gt;Java class for VehicleType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="VehicleType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}VehicleType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}VehicleOwnerInsuranceCoverage" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}VehicleOperatorInsuranceCoverage" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleType", propOrder = {
    "vehicleOwnerInsuranceCoverage",
    "vehicleOperatorInsuranceCoverage"
})
@XmlSeeAlso({
    tyler.ecf.extensions.common.VehicleType.class
})
public class VehicleType
    extends gov.niem.niem.niem_core._2.VehicleType
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
