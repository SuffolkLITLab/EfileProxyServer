
package tyler.ecf.extensions.common;

import gov.niem.niem.niem_core._2.MeasureType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DrivingIncidentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrivingIncidentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}DrivingIncidentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}LegalSpeedRate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ActualSpeedRate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrivingIncidentType", propOrder = {
    "legalSpeedRate",
    "actualSpeedRate"
})
public class DrivingIncidentType
    extends oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.DrivingIncidentType
{

    @XmlElement(name = "LegalSpeedRate")
    protected MeasureType legalSpeedRate;
    @XmlElement(name = "ActualSpeedRate")
    protected MeasureType actualSpeedRate;

    /**
     * Gets the value of the legalSpeedRate property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getLegalSpeedRate() {
        return legalSpeedRate;
    }

    /**
     * Sets the value of the legalSpeedRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setLegalSpeedRate(MeasureType value) {
        this.legalSpeedRate = value;
    }

    /**
     * Gets the value of the actualSpeedRate property.
     * 
     * @return
     *     possible object is
     *     {@link MeasureType }
     *     
     */
    public MeasureType getActualSpeedRate() {
        return actualSpeedRate;
    }

    /**
     * Sets the value of the actualSpeedRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeasureType }
     *     
     */
    public void setActualSpeedRate(MeasureType value) {
        this.actualSpeedRate = value;
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
