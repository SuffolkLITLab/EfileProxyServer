
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.MetadataType;
import gov.niem.release.niem.niem_core._4.OrganizationAssociationType;
import gov.niem.release.niem.niem_core._4.PersonAssociationType;
import gov.niem.release.niem.niem_core._4.PersonOrganizationAssociationType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseCategoryCode" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseNewIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseShortTitleText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTrackingID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseNumberText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Metadata" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}OrganizationAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonOrganizationAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "CaseAugmentationType", propOrder = {
    "rest"
})
public class CaseAugmentationType
    extends AugmentationType
{

    @XmlElementRefs({
        @XmlElementRef(name = "CaseCategoryCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CaseNewIndicator", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CaseParty", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CaseShortTitleText", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CaseTrackingID", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CaseTypeCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "CaseNumberText", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Metadata", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OrganizationAssociation", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PersonAssociation", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PersonOrganizationAssociation", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Metadata" is used by two different parts of a schema. See: 
     * line 33 of file:/Users/bwilley/Developer/EfileProxyServer/TylerEcf5/src/main/resources/wsdl/v2024_6/base/ecfv5-ea1e0f75b69752b5.xsd
     * line 65 of file:/Users/bwilley/Developer/EfileProxyServer/TylerEcf5/src/main/resources/wsdl/v2024_6/base/ecfv5-43381e9aa490c46d.xsd
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
     * {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     * {@link JAXBElement }{@code <}{@link OrganizationAssociationType }{@code >}
     * {@link JAXBElement }{@code <}{@link PersonAssociationType }{@code >}
     * {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
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
