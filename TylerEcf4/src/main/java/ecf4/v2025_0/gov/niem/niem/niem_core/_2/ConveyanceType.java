
package ecf4.v2025_0.gov.niem.niem.niem_core._2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ConveyanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConveyanceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}TangibleItemType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ConveyanceRegistrationPlateIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConveyanceType", propOrder = {
    "conveyanceRegistrationPlateIdentification"
})
@XmlSeeAlso({
    VehicleType.class
})
public class ConveyanceType
    extends TangibleItemType
{

    @XmlElement(name = "ConveyanceRegistrationPlateIdentification", nillable = true)
    protected IdentificationType conveyanceRegistrationPlateIdentification;

    /**
     * Gets the value of the conveyanceRegistrationPlateIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getConveyanceRegistrationPlateIdentification() {
        return conveyanceRegistrationPlateIdentification;
    }

    /**
     * Sets the value of the conveyanceRegistrationPlateIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setConveyanceRegistrationPlateIdentification(IdentificationType value) {
        this.conveyanceRegistrationPlateIdentification = value;
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
