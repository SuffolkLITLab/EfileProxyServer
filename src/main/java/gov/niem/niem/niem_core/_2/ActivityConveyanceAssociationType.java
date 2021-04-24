
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ActivityConveyanceAssociationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ActivityConveyanceAssociationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ActivityReference"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ConveyanceReference"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
