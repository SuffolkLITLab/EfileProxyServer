
package oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information required to initiate a new case in an appellate court.
 * 
 * &lt;p&gt;Java class for AppellateCaseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AppellateCaseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}AppellateCaseType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseAugmentation"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseAugmentation"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellantInCustodyIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCaseAddedParty" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCaseJurisdictionBasisText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCaseSettlementRequestText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCaseRemovedParty" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;choice minOccurs="0"&amp;gt;
 *           &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCivilCase"/&amp;gt;
 *           &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCourtRuleCase"/&amp;gt;
 *         &amp;lt;/choice&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppellateCaseType", propOrder = {
    "rest"
})
public class AppellateCaseType
    extends gov.niem.niem.domains.jxdm._4.AppellateCaseType
{

    @XmlElementRefs({
        @XmlElementRef(name = "CaseAugmentation", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CaseAugmentation", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AppellantInCustodyIndicator", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AppellateCaseAddedParty", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AppellateCaseJurisdictionBasisText", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AppellateCaseSettlementRequestText", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AppellateCaseRemovedParty", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AppellateCivilCase", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "AppellateCourtRuleCase", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * &lt;p&gt;
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "CaseAugmentation" is used by two different parts of a schema. See: 
     * line 0 of https://illinois-stage.tylerhost.net/EFM/Schema/casetype/ECF-4.0-AppellateCase.xsd
     * line 0 of https://illinois-stage.tylerhost.net/EFM/Schema/casetype/ECF-4.0-AppellateCase.xsd
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
     * {@link JAXBElement }{@code <}{@link gov.niem.niem.domains.jxdm._4.CaseAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.CaseAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link AppellateCaseAddedPartyType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link AppellateCaseRemovedPartyType }{@code >}
     * {@link JAXBElement }{@code <}{@link AppellateCivilCaseType }{@code >}
     * {@link JAXBElement }{@code <}{@link AppellateCourtRuleCaseType }{@code >}
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
