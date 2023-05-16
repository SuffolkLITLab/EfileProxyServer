
package gov.niem.release.niem.domains.humanservices._4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.AssociationType;
import gov.niem.release.niem.niem_core._4.OrganizationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an association between a juvenile and a criminal gang organization.
 * 
 * <p>Java class for JuvenileGangAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JuvenileGangAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}GangOrganization" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "JuvenileGangAssociationType", propOrder = {
    "gangOrganization"
})
public class JuvenileGangAssociationType
    extends AssociationType
{

    @XmlElement(name = "GangOrganization", required = true, nillable = true)
    protected List<OrganizationType> gangOrganization;

    /**
     * Gets the value of the gangOrganization property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the gangOrganization property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGangOrganization().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OrganizationType }
     * 
     * 
     */
    public List<OrganizationType> getGangOrganization() {
        if (gangOrganization == null) {
            gangOrganization = new ArrayList<OrganizationType>();
        }
        return this.gangOrganization;
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
