
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import gov.niem.niem.structures._2.ReferenceType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.PersonFilerType;


/**
 * &lt;p&gt;Java class for EntityType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="EntityType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}EntityRepresentation"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntityType", propOrder = {
    "entityRepresentation"
})
@XmlSeeAlso({
    tyler.ecf.extensions.serviceinformationhistoryresponsemessage.ServiceRecipientType.class,
    tyler.ecf.extensions.notifyservicemessage.ServiceRecipientType.class,
    CaseParticipantType.class
})
public class EntityType
    extends ComplexObjectType
{

    @XmlElementRef(name = "EntityRepresentation", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected JAXBElement<?> entityRepresentation;

    /**
     * Gets the value of the entityRepresentation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonFilerType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getEntityRepresentation() {
        return entityRepresentation;
    }

    /**
     * Sets the value of the entityRepresentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonFilerType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setEntityRepresentation(JAXBElement<?> value) {
        this.entityRepresentation = value;
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
