
package ecf4.v2025_0.gov.niem.niem.niem_core._2;

import ecf4.v2025_0.gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ActivityConveyanceAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActivityConveyanceAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ActivityReference"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ConveyanceReference"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActivityConveyanceAssociationType", propOrder = {
    "activityReference",
    "conveyanceReference"
})
public class ActivityConveyanceAssociationType
    extends AssociationType
{

    @XmlElement(name = "ActivityReference", required = true)
    protected ReferenceType activityReference;
    @XmlElement(name = "ConveyanceReference", required = true)
    protected ReferenceType conveyanceReference;

    /**
     * Gets the value of the activityReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getActivityReference() {
        return activityReference;
    }

    /**
     * Sets the value of the activityReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setActivityReference(ReferenceType value) {
        this.activityReference = value;
    }

    /**
     * Gets the value of the conveyanceReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getConveyanceReference() {
        return conveyanceReference;
    }

    /**
     * Sets the value of the conveyanceReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setConveyanceReference(ReferenceType value) {
        this.conveyanceReference = value;
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
