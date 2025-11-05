
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse;

import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.AnyURI;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A structure representing a court-specific data structure passed to a particular operation on a particular MDE.
 * 
 * <p>Java class for ExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}ExtensionCanonicalURI"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}ExtensionCanonicalVersionURI"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}ExtensionLocationURI"/&gt;
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
@XmlType(name = "ExtensionType", propOrder = {
    "extensionCanonicalURI",
    "extensionCanonicalVersionURI",
    "extensionLocationURI"
})
@XmlSeeAlso({
    CodeListExtensionType.class,
    SchemaExtensionType.class
})
public class ExtensionType
    extends ObjectType
{

    @XmlElement(name = "ExtensionCanonicalURI", required = true)
    protected AnyURI extensionCanonicalURI;
    @XmlElement(name = "ExtensionCanonicalVersionURI", required = true)
    protected AnyURI extensionCanonicalVersionURI;
    @XmlElement(name = "ExtensionLocationURI", required = true)
    protected AnyURI extensionLocationURI;

    /**
     * Gets the value of the extensionCanonicalURI property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getExtensionCanonicalURI() {
        return extensionCanonicalURI;
    }

    /**
     * Sets the value of the extensionCanonicalURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setExtensionCanonicalURI(AnyURI value) {
        this.extensionCanonicalURI = value;
    }

    /**
     * Gets the value of the extensionCanonicalVersionURI property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getExtensionCanonicalVersionURI() {
        return extensionCanonicalVersionURI;
    }

    /**
     * Sets the value of the extensionCanonicalVersionURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setExtensionCanonicalVersionURI(AnyURI value) {
        this.extensionCanonicalVersionURI = value;
    }

    /**
     * Gets the value of the extensionLocationURI property.
     * 
     * @return
     *     possible object is
     *     {@link AnyURI }
     *     
     */
    public AnyURI getExtensionLocationURI() {
        return extensionLocationURI;
    }

    /**
     * Sets the value of the extensionLocationURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyURI }
     *     
     */
    public void setExtensionLocationURI(AnyURI value) {
        this.extensionLocationURI = value;
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
