
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information describing or constituting the signature on a document submitted to a court for filing.
 * 
 * <p>Java class for DocumentSignatureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentSignatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}SignatureAugmentation" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}SignatureProfileCode"/&gt;
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
@XmlType(name = "DocumentSignatureType", propOrder = {
    "signatureAugmentation",
    "signatureProfileCode"
})
public class DocumentSignatureType
    extends ObjectType
{

    @XmlElement(name = "SignatureAugmentation")
    protected SignatureAugmentationType signatureAugmentation;
    @XmlElement(name = "SignatureProfileCode", required = true)
    protected NormalizedString signatureProfileCode;

    /**
     * Gets the value of the signatureAugmentation property.
     * 
     * @return
     *     possible object is
     *     {@link SignatureAugmentationType }
     *     
     */
    public SignatureAugmentationType getSignatureAugmentation() {
        return signatureAugmentation;
    }

    /**
     * Sets the value of the signatureAugmentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureAugmentationType }
     *     
     */
    public void setSignatureAugmentation(SignatureAugmentationType value) {
        this.signatureAugmentation = value;
    }

    /**
     * Gets the value of the signatureProfileCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getSignatureProfileCode() {
        return signatureProfileCode;
    }

    /**
     * Sets the value of the signatureProfileCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setSignatureProfileCode(NormalizedString value) {
        this.signatureProfileCode = value;
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
