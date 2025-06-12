
package oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4;

import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information concerning a petition for domestic violence restraining or protective order.
 * 
 * <p>Java class for DomesticCaseViolencePetitionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DomesticCaseViolencePetitionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}RequestToVacateCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}RequestToVacateText"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}StayawayDistanceText"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}NoContactCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}CustodyDescriptionText"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}ChildSupportText"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:DomesticCase-4.0}RespondentDangerAlertIndicator"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DomesticCaseViolencePetitionType", propOrder = {
    "requestToVacateCode",
    "requestToVacateText",
    "stayawayDistanceText",
    "noContactCode",
    "custodyDescriptionText",
    "childSupportText",
    "respondentDangerAlertIndicator"
})
public class DomesticCaseViolencePetitionType
    extends ComplexObjectType
{

    @XmlElement(name = "RequestToVacateCode", required = true)
    protected TextType requestToVacateCode;
    @XmlElement(name = "RequestToVacateText", required = true)
    protected TextType requestToVacateText;
    @XmlElement(name = "StayawayDistanceText", required = true)
    protected TextType stayawayDistanceText;
    @XmlElement(name = "NoContactCode", required = true)
    protected TextType noContactCode;
    @XmlElement(name = "CustodyDescriptionText", required = true)
    protected TextType custodyDescriptionText;
    @XmlElement(name = "ChildSupportText", required = true)
    protected TextType childSupportText;
    @XmlElement(name = "RespondentDangerAlertIndicator", required = true)
    protected Boolean respondentDangerAlertIndicator;

    /**
     * Gets the value of the requestToVacateCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRequestToVacateCode() {
        return requestToVacateCode;
    }

    /**
     * Sets the value of the requestToVacateCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRequestToVacateCode(TextType value) {
        this.requestToVacateCode = value;
    }

    /**
     * Gets the value of the requestToVacateText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRequestToVacateText() {
        return requestToVacateText;
    }

    /**
     * Sets the value of the requestToVacateText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRequestToVacateText(TextType value) {
        this.requestToVacateText = value;
    }

    /**
     * Gets the value of the stayawayDistanceText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStayawayDistanceText() {
        return stayawayDistanceText;
    }

    /**
     * Sets the value of the stayawayDistanceText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStayawayDistanceText(TextType value) {
        this.stayawayDistanceText = value;
    }

    /**
     * Gets the value of the noContactCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getNoContactCode() {
        return noContactCode;
    }

    /**
     * Sets the value of the noContactCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setNoContactCode(TextType value) {
        this.noContactCode = value;
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
     * Gets the value of the childSupportText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getChildSupportText() {
        return childSupportText;
    }

    /**
     * Sets the value of the childSupportText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setChildSupportText(TextType value) {
        this.childSupportText = value;
    }

    /**
     * Gets the value of the respondentDangerAlertIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getRespondentDangerAlertIndicator() {
        return respondentDangerAlertIndicator;
    }

    /**
     * Sets the value of the respondentDangerAlertIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRespondentDangerAlertIndicator(Boolean value) {
        this.respondentDangerAlertIndicator = value;
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
