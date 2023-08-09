
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.domestic;

import gov.niem.release.niem.domains.jxdm._6.ProtectionOrderType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information concerning a petition for domestic violence restraining or protective order.
 * 
 * <p>Java class for DomesticViolencePetitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomesticViolencePetitionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}ChildSuportText"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}CustodyDescriptionText"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/domestic}RespondentDangerAlertindicator"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}ProtectionOrder" minOccurs="0"/&gt;
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
@XmlType(name = "DomesticViolencePetitionType", propOrder = {
    "childSuportText",
    "custodyDescriptionText",
    "respondentDangerAlertindicator",
    "protectionOrder"
})
public class DomesticViolencePetitionType
    extends ObjectType
{

    @XmlElement(name = "ChildSuportText", required = true)
    protected TextType childSuportText;
    @XmlElement(name = "CustodyDescriptionText", required = true)
    protected TextType custodyDescriptionText;
    @XmlElement(name = "RespondentDangerAlertindicator", required = true)
    protected Boolean respondentDangerAlertindicator;
    @XmlElement(name = "ProtectionOrder", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected ProtectionOrderType protectionOrder;

    /**
     * Gets the value of the childSuportText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getChildSuportText() {
        return childSuportText;
    }

    /**
     * Sets the value of the childSuportText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setChildSuportText(TextType value) {
        this.childSuportText = value;
    }

    /**
     * Gets the value of the custodyDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCustodyDescriptionText() {
        return custodyDescriptionText;
    }

    /**
     * Sets the value of the custodyDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCustodyDescriptionText(TextType value) {
        this.custodyDescriptionText = value;
    }

    /**
     * Gets the value of the respondentDangerAlertindicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getRespondentDangerAlertindicator() {
        return respondentDangerAlertindicator;
    }

    /**
     * Sets the value of the respondentDangerAlertindicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRespondentDangerAlertindicator(Boolean value) {
        this.respondentDangerAlertindicator = value;
    }

    /**
     * Gets the value of the protectionOrder property.
     * 
     * @return
     *     possible object is
     *     {@link ProtectionOrderType }
     *     
     */
    public ProtectionOrderType getProtectionOrder() {
        return protectionOrder;
    }

    /**
     * Sets the value of the protectionOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProtectionOrderType }
     *     
     */
    public void setProtectionOrder(ProtectionOrderType value) {
        this.protectionOrder = value;
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
