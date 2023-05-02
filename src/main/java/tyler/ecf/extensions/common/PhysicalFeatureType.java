
package tyler.ecf.extensions.common;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PhysicalFeatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PhysicalFeatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}PhysicalFeatureDescriptionText"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}PhysicalFeatureReference"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
