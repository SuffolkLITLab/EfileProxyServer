
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.CaseAbstractorType;


/**
 * Information about a case participant.
 * 
 * &lt;p&gt;Java class for CaseParticipantType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseParticipantType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}EntityType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseParticipantRoleCode"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
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
    "caseParticipantRoleCode",
    "contactInformation"
})
@XmlSeeAlso({
    CaseAbstractorType.class
})
public class CaseParticipantType
    extends EntityType
{

    @XmlElement(name = "CaseParticipantRoleCode", required = true)
    protected TextType caseParticipantRoleCode;
    @XmlElement(name = "ContactInformation", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected List<ContactInformationType> contactInformation;

    /**
     * Gets the value of the caseParticipantRoleCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseParticipantRoleCode() {
        return caseParticipantRoleCode;
    }

    /**
     * Sets the value of the caseParticipantRoleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseParticipantRoleCode(TextType value) {
        this.caseParticipantRoleCode = value;
    }

    /**
     * Gets the value of the contactInformation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the contactInformation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getContactInformation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ContactInformationType }
     * 
     * 
     */
    public List<ContactInformationType> getContactInformation() {
        if (contactInformation == null) {
            contactInformation = new ArrayList<ContactInformationType>();
        }
        return this.contactInformation;
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
