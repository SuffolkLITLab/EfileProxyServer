
package oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AssociationType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information about the person or organization orther than parent or guardian with whom the juvenile lives. Examples: Foster home, foster parents, state institution, hospital, shelter.
 * 
 * &lt;p&gt;Java class for PlacementAssociationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PlacementAssociationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}AssociationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}PlacementTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}PlacementStartDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}PlacementEntity" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlacementAssociationType", propOrder = {
    "placementTypeCode",
    "placementStartDate",
    "placementEntity"
})
public abstract class PlacementAssociationType
    extends AssociationType
{

    @XmlElement(name = "PlacementTypeCode")
    protected TextType placementTypeCode;
    @XmlElement(name = "PlacementStartDate")
    protected DateType placementStartDate;
    @XmlElement(name = "PlacementEntity")
    protected EntityType placementEntity;

    /**
     * Gets the value of the placementTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPlacementTypeCode() {
        return placementTypeCode;
    }

    /**
     * Sets the value of the placementTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPlacementTypeCode(TextType value) {
        this.placementTypeCode = value;
    }

    /**
     * Gets the value of the placementStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getPlacementStartDate() {
        return placementStartDate;
    }

    /**
     * Sets the value of the placementStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setPlacementStartDate(DateType value) {
        this.placementStartDate = value;
    }

    /**
     * Gets the value of the placementEntity property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getPlacementEntity() {
        return placementEntity;
    }

    /**
     * Sets the value of the placementEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setPlacementEntity(EntityType value) {
        this.placementEntity = value;
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
