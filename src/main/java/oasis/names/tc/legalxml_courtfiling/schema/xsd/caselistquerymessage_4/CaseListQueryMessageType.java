
package oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.DateRangeType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * This is a query for a list of cases that match a set of criteria including case participants, case classification, case status, and date of the case was initiated.
 * 
 * &lt;p&gt;Java class for CaseListQueryMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseListQueryMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0}CaseListQueryCase" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0}CaseListQueryTimeRange" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0}CaseListQueryCaseParticipant" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseListQueryMessageType", propOrder = {
    "caseListQueryCase",
    "caseListQueryTimeRange",
    "caseListQueryCaseParticipant"
})
public class CaseListQueryMessageType
    extends QueryMessageType
{

    @XmlElement(name = "CaseListQueryCase")
    protected List<CaseType> caseListQueryCase;
    @XmlElement(name = "CaseListQueryTimeRange")
    protected List<DateRangeType> caseListQueryTimeRange;
    @XmlElement(name = "CaseListQueryCaseParticipant")
    protected List<CaseParticipantType> caseListQueryCaseParticipant;

    /**
     * Gets the value of the caseListQueryCase property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the caseListQueryCase property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCaseListQueryCase().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CaseType }
     * 
     * 
     */
    public List<CaseType> getCaseListQueryCase() {
        if (caseListQueryCase == null) {
            caseListQueryCase = new ArrayList<CaseType>();
        }
        return this.caseListQueryCase;
    }

    /**
     * Gets the value of the caseListQueryTimeRange property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the caseListQueryTimeRange property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCaseListQueryTimeRange().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DateRangeType }
     * 
     * 
     */
    public List<DateRangeType> getCaseListQueryTimeRange() {
        if (caseListQueryTimeRange == null) {
            caseListQueryTimeRange = new ArrayList<DateRangeType>();
        }
        return this.caseListQueryTimeRange;
    }

    /**
     * Gets the value of the caseListQueryCaseParticipant property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the caseListQueryCaseParticipant property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getCaseListQueryCaseParticipant().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CaseParticipantType }
     * 
     * 
     */
    public List<CaseParticipantType> getCaseListQueryCaseParticipant() {
        if (caseListQueryCaseParticipant == null) {
            caseListQueryCaseParticipant = new ArrayList<CaseParticipantType>();
        }
        return this.caseListQueryCaseParticipant;
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
