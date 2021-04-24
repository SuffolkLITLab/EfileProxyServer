
package tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.fbi._2.VCOCodeType;
import gov.niem.niem.fbi._2.VMACodeType;
import gov.niem.niem.niem_core._2.ProperNameTextType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.proxy.xsd._2.GYear;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for VehicleType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="VehicleType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}VehicleType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PartyReference" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}RegistrationNumber"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}RegistrationStateCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}VehicleTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ModelYear" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}VehicleMakeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}VehicleColorPrimaryCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CommercialVehicleIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}HazardousIndicator" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleType", propOrder = {
    "rest"
})
public class VehicleType
    extends oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.VehicleType
{

    @XmlElementRefs({
        @XmlElementRef(name = "PartyReference", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RegistrationNumber", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RegistrationStateCode", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "VehicleTypeCode", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "ModelYear", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "VehicleMakeCode", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "VehicleColorPrimaryCode", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CommercialVehicleIndicator", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "HazardousIndicator", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * &lt;p&gt;
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "VehicleMakeCode" is used by two different parts of a schema. See: 
     * line 0 of https://illinois-stage.tylerhost.net/EFM/Schema/substitution/Tyler.xsd
     * line 0 of https://illinois-stage.tylerhost.net/EFM/Schema/constraint/niem/niem-core/2.0/niem-core.xsd
     * &lt;p&gt;
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the rest property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the rest property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRest().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link GYear }{@code >}
     * {@link JAXBElement }{@code <}{@link VMACodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
        }
        return this.rest;
    }

}
