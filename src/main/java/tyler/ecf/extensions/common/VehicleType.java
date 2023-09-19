
package tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import gov.niem.niem.fbi._2.VCOCodeType;
import gov.niem.niem.fbi._2.VMACodeType;
import gov.niem.niem.niem_core._2.ProperNameTextType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.proxy.xsd._2.GYear;
import gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for VehicleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}VehicleType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}PartyReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}RegistrationNumber"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}RegistrationStateCode"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}VehicleTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ModelYear" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}VehicleMakeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}VehicleColorPrimaryCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CommercialVehicleIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}HazardousIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "VehicleMakeCode" is used by two different parts of a schema. See: 
     * line 187 of file:/home/brycew/eclipse-workspace/EfileProxyServer/src/main/resources/wsdl/stage/ecf-60.xsd
     * line 811 of file:/home/brycew/eclipse-workspace/EfileProxyServer/src/main/resources/wsdl/stage/ecf-2.xsd
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
     * {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link VMACodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link GYear }{@code >}
     * {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<?>>();
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
