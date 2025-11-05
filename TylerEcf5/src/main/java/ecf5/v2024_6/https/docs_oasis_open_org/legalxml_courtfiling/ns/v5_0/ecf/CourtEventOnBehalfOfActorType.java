
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.ItemType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.OrganizationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.PersonType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The actor on whose behalf the filing was submitted to the court as set forth in the docket entry.
 * 
 * <p>Java class for CourtEventOnBehalfOfActorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtEventOnBehalfOfActorType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}RoleOfAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "CourtEventOnBehalfOfActorType", propOrder = {
    "roleOfAbstract"
})
public class CourtEventOnBehalfOfActorType
    extends ObjectType
{

    @XmlElementRef(name = "RoleOfAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> roleOfAbstract;

    /**
     * Gets the value of the roleOfAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getRoleOfAbstract() {
        return roleOfAbstract;
    }

    /**
     * Sets the value of the roleOfAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     *     {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setRoleOfAbstract(JAXBElement<?> value) {
        this.roleOfAbstract = value;
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
