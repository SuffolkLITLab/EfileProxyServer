
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.appellate;

import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Party to the original case that is not party to the appeal.
 * 
 * <p>Java class for AppellateCaseRemovedPartyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppellateCaseRemovedPartyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/appellate}AppellateCasePartyRemovedReasonText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseParty"/&gt;
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
@XmlType(name = "AppellateCaseRemovedPartyType", propOrder = {
    "appellateCasePartyRemovedReasonText",
    "caseParty"
})
public class AppellateCaseRemovedPartyType
    extends ObjectType
{

    @XmlElement(name = "AppellateCasePartyRemovedReasonText")
    protected TextType appellateCasePartyRemovedReasonText;
    @XmlElement(name = "CaseParty", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected EntityType caseParty;

    /**
     * Gets the value of the appellateCasePartyRemovedReasonText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAppellateCasePartyRemovedReasonText() {
        return appellateCasePartyRemovedReasonText;
    }

    /**
     * Sets the value of the appellateCasePartyRemovedReasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAppellateCasePartyRemovedReasonText(TextType value) {
        this.appellateCasePartyRemovedReasonText = value;
    }

    /**
     * Gets the value of the caseParty property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getCaseParty() {
        return caseParty;
    }

    /**
     * Sets the value of the caseParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setCaseParty(EntityType value) {
        this.caseParty = value;
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
