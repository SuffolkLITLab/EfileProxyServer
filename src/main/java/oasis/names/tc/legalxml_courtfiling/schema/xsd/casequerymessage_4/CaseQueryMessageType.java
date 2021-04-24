
package oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A message requesting a list of cases from a court's case management information system conforming to the parameter or parameters identified in the message.
 * 
 * &lt;p&gt;Java class for CaseQueryMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseQueryMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseQueryMessage-4.0}CaseQueryCriteria"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseQueryMessageType", propOrder = {
    "caseTrackingID",
    "caseQueryCriteria"
})
public class CaseQueryMessageType
    extends QueryMessageType
{

    @XmlElement(name = "CaseTrackingID", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String caseTrackingID;
    @XmlElement(name = "CaseQueryCriteria", required = true)
    protected CaseQueryCriteriaType caseQueryCriteria;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseTrackingID(gov.niem.niem.proxy.xsd._2.String value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the caseQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link CaseQueryCriteriaType }
     *     
     */
    public CaseQueryCriteriaType getCaseQueryCriteria() {
        return caseQueryCriteria;
    }

    /**
     * Sets the value of the caseQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseQueryCriteriaType }
     *     
     */
    public void setCaseQueryCriteria(CaseQueryCriteriaType value) {
        this.caseQueryCriteria = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
