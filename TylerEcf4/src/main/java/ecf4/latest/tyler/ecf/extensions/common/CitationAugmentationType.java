
package ecf4.latest.tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseAugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CitationAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitationAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}CitationCaseAugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DrivingIncident" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CitationAugmentationType", propOrder = {
    "rest"
})
public class CitationAugmentationType
    extends CitationCaseAugmentationType
{

    @XmlElementRef(name = "DrivingIncident", namespace = "urn:tyler:ecf:extensions:Common", type = JAXBElement.class, required = false)
    protected List<JAXBElement<DrivingIncidentType>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "DrivingIncident" is used by two different parts of a schema. See: 
     * line 238 of file:/Users/bwilley/Developer/EfileProxyServer/TylerEcf4/src/main/resources/wsdl/v2025_4/base/ecf-22c5291b9ec9e993.xsd
     * line 55 of file:/Users/bwilley/Developer/EfileProxyServer/TylerEcf4/src/main/resources/wsdl/v2025_4/base/ecf-8b83d1c8e68769f4.xsd
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
     * {@link JAXBElement }{@code <}{@link DrivingIncidentType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<DrivingIncidentType>> getRest() {
        if (rest == null) {
            rest = new ArrayList<JAXBElement<DrivingIncidentType>>();
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
