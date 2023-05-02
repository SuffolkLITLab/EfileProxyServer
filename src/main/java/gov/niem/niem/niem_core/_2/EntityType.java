
package gov.niem.niem.niem_core._2;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import gov.niem.niem.structures._2.ReferenceType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.PersonFilerType;


/**
 * <p>Java class for EntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EntityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}EntityRepresentation"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntityType", propOrder = {
    "entityRepresentation"
})
@XmlSeeAlso({
    CaseParticipantType.class,
    tyler.ecf.extensions.notifyservicemessage.ServiceRecipientType.class,
    tyler.ecf.extensions.serviceinformationhistoryresponsemessage.ServiceRecipientType.class
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
     *     {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PersonFilerType }{@code >}
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
     *     {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PersonFilerType }{@code >}
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
