
package oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.CaseAbstractorType;


/**
 * Placeholder for all case participants, i.e. persons or organizations playing a role in a case. This is where all actor details are expressed.
 * 
 * &lt;p&gt;Java class for CaseParticipantType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseParticipantType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;choice&amp;gt;
 *           &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseParticipant"/&amp;gt;
 *           &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CaseListQueryMessage-4.0}FilingSubmissionSubmitterID"/&amp;gt;
 *         &amp;lt;/choice&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseParticipantType", propOrder = {
    "caseParticipant",
    "filingSubmissionSubmitterID"
})
public class CaseParticipantType
    extends ComplexObjectType
{

    @XmlElementRef(name = "CaseParticipant", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType> caseParticipant;
    @XmlElement(name = "FilingSubmissionSubmitterID")
    protected IdentificationType filingSubmissionSubmitterID;

    /**
     * Gets the value of the caseParticipant property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CaseAbstractorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType }{@code >}
     *     
     */
    public JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType> getCaseParticipant() {
        return caseParticipant;
    }

    /**
     * Sets the value of the caseParticipant property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CaseAbstractorType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType }{@code >}
     *     
     */
    public void setCaseParticipant(JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType> value) {
        this.caseParticipant = value;
    }

    /**
     * Gets the value of the filingSubmissionSubmitterID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getFilingSubmissionSubmitterID() {
        return filingSubmissionSubmitterID;
    }

    /**
     * Sets the value of the filingSubmissionSubmitterID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setFilingSubmissionSubmitterID(IdentificationType value) {
        this.filingSubmissionSubmitterID = value;
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
