
package gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.ActivityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.ScheduleDayType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for CourtEventType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CourtEventType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CourtEventJudge" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CourtEventSchedule" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CourtEventSequenceID" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CourtEventType.class
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the courtEventJudge property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCourtEventJudge().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the courtEventSchedule property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCourtEventSchedule().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
