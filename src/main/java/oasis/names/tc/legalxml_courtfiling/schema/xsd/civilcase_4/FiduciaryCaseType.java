
package oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information about a guardianship, conservatorship, trust, or mental health case.
 * 
 * &lt;p&gt;Java class for FiduciaryCaseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FiduciaryCaseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0}FiduciaryTypeCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0}PersonFiduciaryAssociationTypeText"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FiduciaryCaseType", propOrder = {
    "fiduciaryTypeCode",
    "personFiduciaryAssociationTypeText"
})
public class FiduciaryCaseType
    extends ComplexObjectType
{

    @XmlElement(name = "FiduciaryTypeCode", required = true)
    protected TextType fiduciaryTypeCode;
    @XmlElement(name = "PersonFiduciaryAssociationTypeText", required = true)
    protected TextType personFiduciaryAssociationTypeText;

    /**
     * Gets the value of the fiduciaryTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFiduciaryTypeCode() {
        return fiduciaryTypeCode;
    }

    /**
     * Sets the value of the fiduciaryTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFiduciaryTypeCode(TextType value) {
        this.fiduciaryTypeCode = value;
    }

    /**
     * Gets the value of the personFiduciaryAssociationTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPersonFiduciaryAssociationTypeText() {
        return personFiduciaryAssociationTypeText;
    }

    /**
     * Sets the value of the personFiduciaryAssociationTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPersonFiduciaryAssociationTypeText(TextType value) {
        this.personFiduciaryAssociationTypeText = value;
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
