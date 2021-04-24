
package oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.ImmediateFamilyAssociationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information concerning a petition for child support.
 * 
 * &lt;p&gt;Java class for DomesticCaseChildSupportPetitionType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DomesticCaseChildSupportPetitionType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ImmediateFamilyAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}JurisdictionReasonText" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DomesticCaseChildSupportPetitionType", propOrder = {
    "immediateFamilyAssociation",
    "jurisdictionReasonText"
})
public class DomesticCaseChildSupportPetitionType
    extends ComplexObjectType
{

    @XmlElement(name = "ImmediateFamilyAssociation", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected List<ImmediateFamilyAssociationType> immediateFamilyAssociation;
    @XmlElement(name = "JurisdictionReasonText")
    protected TextType jurisdictionReasonText;

    /**
     * Gets the value of the immediateFamilyAssociation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the immediateFamilyAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getImmediateFamilyAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ImmediateFamilyAssociationType }
     * 
     * 
     */
    public List<ImmediateFamilyAssociationType> getImmediateFamilyAssociation() {
        if (immediateFamilyAssociation == null) {
            immediateFamilyAssociation = new ArrayList<ImmediateFamilyAssociationType>();
        }
        return this.immediateFamilyAssociation;
    }

    /**
     * Gets the value of the jurisdictionReasonText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getJurisdictionReasonText() {
        return jurisdictionReasonText;
    }

    /**
     * Sets the value of the jurisdictionReasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setJurisdictionReasonText(TextType value) {
        this.jurisdictionReasonText = value;
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
