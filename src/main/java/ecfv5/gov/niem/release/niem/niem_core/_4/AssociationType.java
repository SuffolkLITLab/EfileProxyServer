
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.OffenseChargeAssociationType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.OffenseLocationAssociationType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.PersonBloodAlcoholContentAssociationType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.PersonChargeAssociationType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.ViolatedStatuteAssociationType;
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
    ViolatedStatuteAssociationType.class,
    OffenseChargeAssociationType.class,
    OffenseLocationAssociationType.class,
    PersonChargeAssociationType.class,
    PersonBloodAlcoholContentAssociationType.class,
    DocumentAssociationType.class,
    OrganizationAssociationType.class,
    PersonEmploymentAssociationType.class,
    PersonOrganizationAssociationType.class,
    PersonAssociationType.class,
    RelatedActivityAssociationType.class
})
public class AssociationType
    extends ecfv5.gov.niem.release.niem.structures._4.AssociationType
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
