
package ecfv5.gov.niem.release.niem.domains.jxdm._6;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.PersonNameCategoryCodeType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for another name used by an organization.
 * 
 * <p>Java class for OrganizationAlternateNameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationAlternateNameType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}OrganizationAlternateNameCategoryAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "OrganizationAlternateNameType", propOrder = {
    "organizationAlternateNameCategoryAbstract"
})
public class OrganizationAlternateNameType
    extends ObjectType
{

    @XmlElementRef(name = "OrganizationAlternateNameCategoryAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> organizationAlternateNameCategoryAbstract;

    /**
     * Gets the value of the organizationAlternateNameCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link PersonNameCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getOrganizationAlternateNameCategoryAbstract() {
        return organizationAlternateNameCategoryAbstract;
    }

    /**
     * Sets the value of the organizationAlternateNameCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PersonNameCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setOrganizationAlternateNameCategoryAbstract(JAXBElement<?> value) {
        this.organizationAlternateNameCategoryAbstract = value;
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
