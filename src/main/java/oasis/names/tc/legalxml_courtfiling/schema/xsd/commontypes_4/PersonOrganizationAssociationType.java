
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A code for the type of relationship between two persons, between two organizations, or between a person and an organization in a case.  Allowable values are set forth in Court Policy.  Examples include parent/child, subsidiary corporation, and chief executive officer.
 * 
 * <p>Java class for PersonOrganizationAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonOrganizationAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}PersonOrganizationAssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}EntityAssociationTypeCode" minOccurs="0"/&gt;
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
    "entityAssociationTypeCode"
})
public class PersonOrganizationAssociationType
    extends gov.niem.niem.niem_core._2.PersonOrganizationAssociationType
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
