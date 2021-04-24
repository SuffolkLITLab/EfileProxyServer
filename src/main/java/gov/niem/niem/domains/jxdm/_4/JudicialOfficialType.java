
package gov.niem.niem.domains.jxdm._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for JudicialOfficialType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="JudicialOfficialType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}RoleOfPersonReference" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}JudicialOfficialBarMembership" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JudicialOfficialType", propOrder = {
    "roleOfPersonReference",
    "judicialOfficialBarMembership"
})
@XmlSeeAlso({
    CaseOfficialType.class
})
public class JudicialOfficialType
    extends ComplexObjectType
{

    @XmlElement(name = "RoleOfPersonReference", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected ReferenceType roleOfPersonReference;
    @XmlElement(name = "JudicialOfficialBarMembership", nillable = true)
    protected JudicialOfficialBarMembershipType judicialOfficialBarMembership;

    /**
     * Gets the value of the roleOfPersonReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getRoleOfPersonReference() {
        return roleOfPersonReference;
    }

    /**
     * Sets the value of the roleOfPersonReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setRoleOfPersonReference(ReferenceType value) {
        this.roleOfPersonReference = value;
    }

    /**
     * Gets the value of the judicialOfficialBarMembership property.
     * 
     * @return
     *     possible object is
     *     {@link JudicialOfficialBarMembershipType }
     *     
     */
    public JudicialOfficialBarMembershipType getJudicialOfficialBarMembership() {
        return judicialOfficialBarMembership;
    }

    /**
     * Sets the value of the judicialOfficialBarMembership property.
     * 
     * @param value
     *     allowed object is
     *     {@link JudicialOfficialBarMembershipType }
     *     
     */
    public void setJudicialOfficialBarMembership(JudicialOfficialBarMembershipType value) {
        this.judicialOfficialBarMembership = value;
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
