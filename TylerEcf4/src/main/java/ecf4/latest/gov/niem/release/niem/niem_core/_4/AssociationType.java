
package ecf4.latest.gov.niem.release.niem.niem_core._4;

import ecf4.latest.gov.niem.release.niem.domains.humanservices._4.JuvenileGangAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.humanservices._4.JuvenilePlacementFacilityAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.humanservices._4.JuvenilePlacementPersonAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.humanservices._4.ParentChildAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.humanservices._4.PersonCaseAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.OffenseChargeAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.OffenseLocationAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonBloodAlcoholContentAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonChargeAssociationType;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.ViolatedStatuteAssociationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an association, connection, relationship, or involvement somehow linking people, things, and/or activities together.
 * 
 * <p>Java class for AssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}AssociationDescriptionText" minOccurs="0"/&gt;
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
@XmlType(name = "AssociationType", propOrder = {
    "associationDescriptionText"
})
@XmlSeeAlso({
    DocumentAssociationType.class,
    OrganizationAssociationType.class,
    PersonEmploymentAssociationType.class,
    PersonOrganizationAssociationType.class,
    PersonAssociationType.class,
    RelatedActivityAssociationType.class,
    ViolatedStatuteAssociationType.class,
    OffenseChargeAssociationType.class,
    OffenseLocationAssociationType.class,
    PersonChargeAssociationType.class,
    PersonBloodAlcoholContentAssociationType.class,
    JuvenilePlacementFacilityAssociationType.class,
    JuvenilePlacementPersonAssociationType.class,
    ParentChildAssociationType.class,
    PersonCaseAssociationType.class,
    JuvenileGangAssociationType.class
})
public class AssociationType
    extends ecf4.latest.gov.niem.release.niem.structures._4.AssociationType
{

    @XmlElement(name = "AssociationDescriptionText")
    protected TextType associationDescriptionText;

    /**
     * Gets the value of the associationDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAssociationDescriptionText() {
        return associationDescriptionText;
    }

    /**
     * Sets the value of the associationDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAssociationDescriptionText(TextType value) {
        this.associationDescriptionText = value;
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
