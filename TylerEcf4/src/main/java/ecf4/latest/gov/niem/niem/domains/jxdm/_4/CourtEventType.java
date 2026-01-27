
package ecf4.latest.gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.niem_core._2.ActivityType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.niem_core._2.ScheduleDayType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CourtEventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CourtEventJudge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CourtEventSchedule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CourtEventSequenceID" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtEventType", propOrder = {
    "courtEventJudge",
    "courtEventSchedule",
    "courtEventSequenceID"
})
@XmlSeeAlso({
    ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CourtEventType.class
})
public class CourtEventType
    extends ActivityType
{

    @XmlElement(name = "CourtEventJudge", nillable = true)
    protected List<JudicialOfficialType> courtEventJudge;
    @XmlElement(name = "CourtEventSchedule", nillable = true)
    protected List<ScheduleDayType> courtEventSchedule;
    @XmlElement(name = "CourtEventSequenceID", nillable = true)
    protected IdentificationType courtEventSequenceID;

    /**
     * Gets the value of the courtEventJudge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtEventJudge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtEventJudge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JudicialOfficialType }
     * 
     * 
     */
    public List<JudicialOfficialType> getCourtEventJudge() {
        if (courtEventJudge == null) {
            courtEventJudge = new ArrayList<JudicialOfficialType>();
        }
        return this.courtEventJudge;
    }

    /**
     * Gets the value of the courtEventSchedule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtEventSchedule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtEventSchedule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScheduleDayType }
     * 
     * 
     */
    public List<ScheduleDayType> getCourtEventSchedule() {
        if (courtEventSchedule == null) {
            courtEventSchedule = new ArrayList<ScheduleDayType>();
        }
        return this.courtEventSchedule;
    }

    /**
     * Gets the value of the courtEventSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getCourtEventSequenceID() {
        return courtEventSequenceID;
    }

    /**
     * Sets the value of the courtEventSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setCourtEventSequenceID(IdentificationType value) {
        this.courtEventSequenceID = value;
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
