
package gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PersonOrganizationAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonOrganizationAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonReference" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}OrganizationReference" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonOrganizationAssociationType", propOrder = {
    "personReference",
    "organizationReference"
})
@XmlSeeAlso({
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonOrganizationAssociationType.class
})
public class PersonOrganizationAssociationType
    extends AssociationType
{

    @XmlElement(name = "PersonReference", required = true)
    protected List<ReferenceType> personReference;
    @XmlElement(name = "OrganizationReference", required = true)
    protected List<ReferenceType> organizationReference;

    /**
     * Gets the value of the personReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getPersonReference() {
        if (personReference == null) {
            personReference = new ArrayList<ReferenceType>();
        }
        return this.personReference;
    }

    /**
     * Gets the value of the organizationReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the organizationReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizationReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getOrganizationReference() {
        if (organizationReference == null) {
            organizationReference = new ArrayList<ReferenceType>();
        }
        return this.organizationReference;
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
