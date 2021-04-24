
package gov.niem.niem.domains.jxdm._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for CaseOfficialType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseOfficialType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}JudicialOfficialType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseOfficialCaseIdentification" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseOfficialRoleText" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseOfficialType", propOrder = {
    "caseOfficialCaseIdentification",
    "caseOfficialRoleText"
})
@XmlSeeAlso({
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseOfficialType.class
})
public class CaseOfficialType
    extends JudicialOfficialType
{

    @XmlElement(name = "CaseOfficialCaseIdentification", nillable = true)
    protected IdentificationType caseOfficialCaseIdentification;
    @XmlElement(name = "CaseOfficialRoleText", nillable = true)
    protected TextType caseOfficialRoleText;

    /**
     * Gets the value of the caseOfficialCaseIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getCaseOfficialCaseIdentification() {
        return caseOfficialCaseIdentification;
    }

    /**
     * Sets the value of the caseOfficialCaseIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setCaseOfficialCaseIdentification(IdentificationType value) {
        this.caseOfficialCaseIdentification = value;
    }

    /**
     * Gets the value of the caseOfficialRoleText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseOfficialRoleText() {
        return caseOfficialRoleText;
    }

    /**
     * Sets the value of the caseOfficialRoleText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseOfficialRoleText(TextType value) {
        this.caseOfficialRoleText = value;
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
