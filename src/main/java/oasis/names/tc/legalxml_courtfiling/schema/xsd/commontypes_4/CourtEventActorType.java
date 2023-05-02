
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The actor who performed the action as set forth in the docket entry. E.g. the person who filed the document. Does not include the name of the court clerk composing the docket entry.
 * 
 * <p>Java class for CourtEventActorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtEventActorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}RoleOf"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtEventActorType", propOrder = {
    "roleOf"
})
public class CourtEventActorType
    extends ComplexObjectType
{

    @XmlElementRef(name = "RoleOf", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected JAXBElement<?> roleOf;

    /**
     * Gets the value of the roleOf property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getRoleOf() {
        return roleOf;
    }

    /**
     * Sets the value of the roleOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setRoleOf(JAXBElement<?> value) {
        this.roleOf = value;
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
