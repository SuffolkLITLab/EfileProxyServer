
package tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseAugmentationType;


/**
 * &lt;p&gt;Java class for CitationAugmentationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CitationAugmentationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}CitationCaseAugmentationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}DrivingIncident" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
     * &lt;p&gt;
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "DrivingIncident" is used by two different parts of a schema. See: 
     * line 0 of https://illinois-stage.tylerhost.net/EFM/Schema/substitution/Tyler.xsd
     * line 0 of https://illinois-stage.tylerhost.net/EFM/Schema/casetype/ECF-4.0-CitationCase.xsd
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

}
