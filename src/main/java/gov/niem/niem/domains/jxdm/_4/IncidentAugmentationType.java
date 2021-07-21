
package gov.niem.niem.domains.jxdm._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.structures._2.AugmentationType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for IncidentAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IncidentAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}IncidentDamagedPropertyReference" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}IncidentOfficialPresentIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}IncidentTrafficAccidentInvolvedIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IncidentAugmentationType", propOrder = {
    "incidentDamagedPropertyReference",
    "incidentOfficialPresentIndicator",
    "incidentTrafficAccidentInvolvedIndicator"
})
public class IncidentAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "IncidentDamagedPropertyReference")
    protected ReferenceType incidentDamagedPropertyReference;
    @XmlElement(name = "IncidentOfficialPresentIndicator", nillable = true)
    protected Boolean incidentOfficialPresentIndicator;
    @XmlElement(name = "IncidentTrafficAccidentInvolvedIndicator", nillable = true)
    protected Boolean incidentTrafficAccidentInvolvedIndicator;

    /**
     * Gets the value of the incidentDamagedPropertyReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getIncidentDamagedPropertyReference() {
        return incidentDamagedPropertyReference;
    }

    /**
     * Sets the value of the incidentDamagedPropertyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setIncidentDamagedPropertyReference(ReferenceType value) {
        this.incidentDamagedPropertyReference = value;
    }

    /**
     * Gets the value of the incidentOfficialPresentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncidentOfficialPresentIndicator() {
        return incidentOfficialPresentIndicator;
    }

    /**
     * Sets the value of the incidentOfficialPresentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncidentOfficialPresentIndicator(Boolean value) {
        this.incidentOfficialPresentIndicator = value;
    }

    /**
     * Gets the value of the incidentTrafficAccidentInvolvedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncidentTrafficAccidentInvolvedIndicator() {
        return incidentTrafficAccidentInvolvedIndicator;
    }

    /**
     * Sets the value of the incidentTrafficAccidentInvolvedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncidentTrafficAccidentInvolvedIndicator(Boolean value) {
        this.incidentTrafficAccidentInvolvedIndicator = value;
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
