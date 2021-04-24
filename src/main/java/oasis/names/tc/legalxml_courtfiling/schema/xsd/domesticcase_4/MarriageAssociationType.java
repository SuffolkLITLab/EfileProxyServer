
package oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.screening._2.MarriageAssociationAugmentationType;
import gov.niem.niem.niem_core._2.PersonUnionAssociationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information about a marriage, civil domestic union, or other domestic relationship defined by law.
 * 
 * &lt;p&gt;Java class for MarriageAssociationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="MarriageAssociationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}PersonUnionAssociationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/screening/2.0}MarriageAssociationAugmentation"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MarriageAssociationType", propOrder = {
    "marriageAssociationAugmentation"
})
public class MarriageAssociationType
    extends PersonUnionAssociationType
{

    @XmlElement(name = "MarriageAssociationAugmentation", namespace = "http://niem.gov/niem/domains/screening/2.0", required = true)
    protected MarriageAssociationAugmentationType marriageAssociationAugmentation;

    /**
     * Gets the value of the marriageAssociationAugmentation property.
     * 
     * @return
     *     possible object is
     *     {@link MarriageAssociationAugmentationType }
     *     
     */
    public MarriageAssociationAugmentationType getMarriageAssociationAugmentation() {
        return marriageAssociationAugmentation;
    }

    /**
     * Sets the value of the marriageAssociationAugmentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarriageAssociationAugmentationType }
     *     
     */
    public void setMarriageAssociationAugmentation(MarriageAssociationAugmentationType value) {
        this.marriageAssociationAugmentation = value;
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
