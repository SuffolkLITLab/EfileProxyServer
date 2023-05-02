
package gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AssociationType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ViolatedStatuteAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ViolatedStatuteAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SubjectReference" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}VictimReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}IncidentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}StatuteReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViolatedStatuteAssociationType", propOrder = {
    "subjectReference",
    "victimReference",
    "incidentReference",
    "statuteReference"
})
public class ViolatedStatuteAssociationType
    extends AssociationType
{

    @XmlElement(name = "SubjectReference")
    protected ReferenceType subjectReference;
    @XmlElement(name = "VictimReference")
    protected List<ReferenceType> victimReference;
    @XmlElement(name = "IncidentReference", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected ReferenceType incidentReference;
    @XmlElement(name = "StatuteReference")
    protected List<ReferenceType> statuteReference;

    /**
     * Gets the value of the subjectReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getSubjectReference() {
        return subjectReference;
    }

    /**
     * Sets the value of the subjectReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setSubjectReference(ReferenceType value) {
        this.subjectReference = value;
    }

    /**
     * Gets the value of the victimReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the victimReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVictimReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getVictimReference() {
        if (victimReference == null) {
            victimReference = new ArrayList<ReferenceType>();
        }
        return this.victimReference;
    }

    /**
     * Gets the value of the incidentReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getIncidentReference() {
        return incidentReference;
    }

    /**
     * Sets the value of the incidentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setIncidentReference(ReferenceType value) {
        this.incidentReference = value;
    }

    /**
     * Gets the value of the statuteReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statuteReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatuteReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getStatuteReference() {
        if (statuteReference == null) {
            statuteReference = new ArrayList<ReferenceType>();
        }
        return this.statuteReference;
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
