
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.MeasureType;


/**
 * &lt;p&gt;Java class for DrivingIncidentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DrivingIncidentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}DrivingIncidentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}LegalSpeedRate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ActualSpeedRate" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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

}
