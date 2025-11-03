
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DocumentAssociationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.EntityType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.MetadataType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf4.latest.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * An augmentation type
 * 
 * <p>Java class for DocumentAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}AffectedParticipant" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentFiler" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentRendition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RedactionRequiredIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RegisterActionDescriptionCode" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}SpecialHandlingInstructionsText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentAssociation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Metadata" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "DocumentAugmentationType", propOrder = {
    "rest"
})
public class DocumentAugmentationType
    extends AugmentationType
{

    @XmlElementRefs({
        @XmlElementRef(name = "AffectedParticipant", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DocumentFiler", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DocumentRendition", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RedactionRequiredIndicator", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RegisterActionDescriptionCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "SpecialHandlingInstructionsText", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DocumentAssociation", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "Metadata", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Metadata" is used by two different parts of a schema. See: 
     * line 140 of file:/home/brycew/eclipse-workspace/EfileProxyServer/src/main/resources/wsdl/stage/ecf-v5-3.xsd
     * line 65 of file:/home/brycew/eclipse-workspace/EfileProxyServer/src/main/resources/wsdl/stage/ecf-v5-7.xsd
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
     * {@link JAXBElement }{@code <}{@link DocumentAssociationType }{@code >}
     * {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * {@link JAXBElement }{@code <}{@link DocumentRenditionType }{@code >}
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
