
package ecfv5.gov.niem.release.niem.domains.jxdm._6;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.structures._4.AugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for additional information about an organization.
 * 
 * <p>Java class for OrganizationAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}OrganizationAlternateName" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationAugmentationType", propOrder = {
    "organizationAlternateName"
})
public class OrganizationAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "OrganizationAlternateName")
    protected OrganizationAlternateNameType organizationAlternateName;

    /**
     * Gets the value of the organizationAlternateName property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationAlternateNameType }
     *     
     */
    public OrganizationAlternateNameType getOrganizationAlternateName() {
        return organizationAlternateName;
    }

    /**
     * Sets the value of the organizationAlternateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationAlternateNameType }
     *     
     */
    public void setOrganizationAlternateName(OrganizationAlternateNameType value) {
        this.organizationAlternateName = value;
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
