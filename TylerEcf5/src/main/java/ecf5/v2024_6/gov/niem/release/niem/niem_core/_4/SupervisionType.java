
package gov.niem.release.niem.niem_core._4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an act of officially overseeing, supervising, or keeping track in some capacity of a person.
 * 
 * <p>Java class for SupervisionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SupervisionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}SupervisionCustodyStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}SupervisionFacility"/&gt;
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
@XmlType(name = "SupervisionType", propOrder = {
    "supervisionCustodyStatus",
    "supervisionFacility"
})
public class SupervisionType
    extends ActivityType
{

    @XmlElement(name = "SupervisionCustodyStatus")
    protected StatusType supervisionCustodyStatus;
    @XmlElement(name = "SupervisionFacility", required = true)
    protected FacilityType supervisionFacility;

    /**
     * Gets the value of the supervisionCustodyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getSupervisionCustodyStatus() {
        return supervisionCustodyStatus;
    }

    /**
     * Sets the value of the supervisionCustodyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setSupervisionCustodyStatus(StatusType value) {
        this.supervisionCustodyStatus = value;
    }

    /**
     * Gets the value of the supervisionFacility property.
     * 
     * @return
     *     possible object is
     *     {@link FacilityType }
     *     
     */
    public FacilityType getSupervisionFacility() {
        return supervisionFacility;
    }

    /**
     * Sets the value of the supervisionFacility property.
     * 
     * @param value
     *     allowed object is
     *     {@link FacilityType }
     *     
     */
    public void setSupervisionFacility(FacilityType value) {
        this.supervisionFacility = value;
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
