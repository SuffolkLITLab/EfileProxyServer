
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.MetadataType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.GetPolicyResponseMessageAugmentationType;


/**
 * The response to a request for a court Court Policy.
 * 
 * <p>Java class for GetPolicyResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPolicyResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Metadata" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}DevelopmentPolicy"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}GetPolicyResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}PolicyVersionID"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}RuntimePolicy"/&gt;
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
@XmlType(name = "GetPolicyResponseMessageType", propOrder = {
    "rest"
})
public class GetPolicyResponseMessageType
    extends ResponseMessageType
{

    @XmlElementRefs({
        @XmlElementRef(name = "Metadata", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "DevelopmentPolicy", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "GetPolicyResponseMessageAugmentationPoint", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "PolicyVersionID", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "RuntimePolicy", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> rest;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Metadata" is used by two different parts of a schema. See: 
     * line 67 of file:/Users/bwilley/Developer/EfileProxyServer/TylerEcf5/src/main/resources/wsdl/v2024_6/base/ecfv5-ce2b15e0e59d017e.xsd
     * line 25 of file:/Users/bwilley/Developer/EfileProxyServer/TylerEcf5/src/main/resources/wsdl/v2024_6/base/ecfv5-43381e9aa490c46d.xsd
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
     * {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     * {@link JAXBElement }{@code <}{@link DevelopmentPolicyType }{@code >}
     * {@link JAXBElement }{@code <}{@link RuntimePolicyType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link GetPolicyResponseMessageAugmentationType }{@code >}
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
