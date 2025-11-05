
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.structures._2.AugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Additional information about an organization.
 * 
 * <p>Java class for OrganizationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrganizationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}OrganizationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}OrganizationAugmentation" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}OrganizationAugmentation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrganizationType", propOrder = {
    "rest"
})
public class OrganizationType
    extends ecf4.latest.gov.niem.niem.niem_core._2.OrganizationType
{

    @XmlElementRefs({
        @XmlElementRef(name = "OrganizationAugmentation", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrganizationAugmentation", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends AugmentationType>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "OrganizationAugmentation" is used by two different parts of a schema. See: 
     * line 360 of file:/home/bryce/Developer/LITLab/code/EfileProxyServer/src/main/resources/wsdl/stage/ecf-18.xsd
     * line 359 of file:/home/bryce/Developer/LITLab/code/EfileProxyServer/src/main/resources/wsdl/stage/ecf-18.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the rest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ecf4.latest.gov.niem.niem.domains.jxdm._4.OrganizationAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends AugmentationType>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<? extends AugmentationType>>();
        }
        return this.rest;
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
