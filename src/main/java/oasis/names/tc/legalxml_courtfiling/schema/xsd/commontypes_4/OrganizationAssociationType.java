
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The relationship between two organizations.  Example: subsidiary corporation.
 * 
 * &lt;p&gt;Java class for OrganizationAssociationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="OrganizationAssociationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}OrganizationAssociationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}EntityAssociationTypeCode" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationAssociationType", propOrder = {
    "entityAssociationTypeCode"
})
public class OrganizationAssociationType
    extends gov.niem.niem.niem_core._2.OrganizationAssociationType
{

    @XmlElement(name = "EntityAssociationTypeCode")
    protected TextType entityAssociationTypeCode;

    /**
     * Gets the value of the entityAssociationTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getEntityAssociationTypeCode() {
        return entityAssociationTypeCode;
    }

    /**
     * Sets the value of the entityAssociationTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setEntityAssociationTypeCode(TextType value) {
        this.entityAssociationTypeCode = value;
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