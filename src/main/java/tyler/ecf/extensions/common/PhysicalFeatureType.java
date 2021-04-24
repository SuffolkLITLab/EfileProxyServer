
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for PhysicalFeatureType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PhysicalFeatureType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PhysicalFeatureDescriptionText"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PhysicalFeatureReference"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PhysicalFeatureType", propOrder = {
    "physicalFeatureDescriptionText",
    "physicalFeatureReference"
})
public class PhysicalFeatureType {

    @XmlElement(name = "PhysicalFeatureDescriptionText", required = true)
    protected TextType physicalFeatureDescriptionText;
    @XmlElement(name = "PhysicalFeatureReference", required = true)
    protected ReferenceType physicalFeatureReference;

    /**
     * Gets the value of the physicalFeatureDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPhysicalFeatureDescriptionText() {
        return physicalFeatureDescriptionText;
    }

    /**
     * Sets the value of the physicalFeatureDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPhysicalFeatureDescriptionText(TextType value) {
        this.physicalFeatureDescriptionText = value;
    }

    /**
     * Gets the value of the physicalFeatureReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPhysicalFeatureReference() {
        return physicalFeatureReference;
    }

    /**
     * Sets the value of the physicalFeatureReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPhysicalFeatureReference(ReferenceType value) {
        this.physicalFeatureReference = value;
    }

}
