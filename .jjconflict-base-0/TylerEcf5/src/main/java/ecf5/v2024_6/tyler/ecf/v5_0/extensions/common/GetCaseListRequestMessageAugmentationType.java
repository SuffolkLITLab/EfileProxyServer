
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetCaseListRequestMessageAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseListRequestMessageAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseNumberText" minOccurs="0"/&gt;
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
@XmlType(name = "GetCaseListRequestMessageAugmentationType", propOrder = {
    "caseTypeCode",
    "caseNumberText"
})
public class GetCaseListRequestMessageAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "CaseTypeCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected NormalizedString caseTypeCode;
    @XmlElement(name = "CaseNumberText", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected TextType caseNumberText;

    /**
     * Gets the value of the caseTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getCaseTypeCode() {
        return caseTypeCode;
    }

    /**
     * Sets the value of the caseTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setCaseTypeCode(NormalizedString value) {
        this.caseTypeCode = value;
    }

    /**
     * Gets the value of the caseNumberText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseNumberText() {
        return caseNumberText;
    }

    /**
     * Sets the value of the caseNumberText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseNumberText(TextType value) {
        this.caseNumberText = value;
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
