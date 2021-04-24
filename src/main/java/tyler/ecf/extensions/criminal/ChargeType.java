
package tyler.ecf.extensions.criminal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * The crime or violation a defendant is alleged or found to have committed. 
 * 
 * &lt;p&gt;Java class for ChargeType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ChargeType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}ChargeType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}DateOnOrAboutIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}TimeOnOrAboutIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}AdditionalStatute" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}Bond" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}FineAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}ChargeComponent" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}PhaseTypeText" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargeType", propOrder = {
    "dateOnOrAboutIndicator",
    "timeOnOrAboutIndicator",
    "additionalStatute",
    "bond",
    "fineAmount",
    "chargeComponent",
    "phaseTypeText"
})
public class ChargeType
    extends oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.ChargeType
{

    @XmlElement(name = "DateOnOrAboutIndicator")
    protected Boolean dateOnOrAboutIndicator;
    @XmlElement(name = "TimeOnOrAboutIndicator")
    protected Boolean timeOnOrAboutIndicator;
    @XmlElement(name = "AdditionalStatute")
    protected List<StatuteType> additionalStatute;
    @XmlElement(name = "Bond")
    protected BondType bond;
    @XmlElement(name = "FineAmount")
    protected AmountType fineAmount;
    @XmlElement(name = "ChargeComponent")
    protected List<ChargeComponentType> chargeComponent;
    @XmlElement(name = "PhaseTypeText")
    protected TextType phaseTypeText;

    /**
     * Gets the value of the dateOnOrAboutIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDateOnOrAboutIndicator() {
        return dateOnOrAboutIndicator;
    }

    /**
     * Sets the value of the dateOnOrAboutIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDateOnOrAboutIndicator(Boolean value) {
        this.dateOnOrAboutIndicator = value;
    }

    /**
     * Gets the value of the timeOnOrAboutIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getTimeOnOrAboutIndicator() {
        return timeOnOrAboutIndicator;
    }

    /**
     * Sets the value of the timeOnOrAboutIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTimeOnOrAboutIndicator(Boolean value) {
        this.timeOnOrAboutIndicator = value;
    }

    /**
     * Gets the value of the additionalStatute property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the additionalStatute property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAdditionalStatute().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link StatuteType }
     * 
     * 
     */
    public List<StatuteType> getAdditionalStatute() {
        if (additionalStatute == null) {
            additionalStatute = new ArrayList<StatuteType>();
        }
        return this.additionalStatute;
    }

    /**
     * Gets the value of the bond property.
     * 
     * @return
     *     possible object is
     *     {@link BondType }
     *     
     */
    public BondType getBond() {
        return bond;
    }

    /**
     * Sets the value of the bond property.
     * 
     * @param value
     *     allowed object is
     *     {@link BondType }
     *     
     */
    public void setBond(BondType value) {
        this.bond = value;
    }

    /**
     * Gets the value of the fineAmount property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getFineAmount() {
        return fineAmount;
    }

    /**
     * Sets the value of the fineAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setFineAmount(AmountType value) {
        this.fineAmount = value;
    }

    /**
     * Gets the value of the chargeComponent property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the chargeComponent property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getChargeComponent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeComponentType }
     * 
     * 
     */
    public List<ChargeComponentType> getChargeComponent() {
        if (chargeComponent == null) {
            chargeComponent = new ArrayList<ChargeComponentType>();
        }
        return this.chargeComponent;
    }

    /**
     * Gets the value of the phaseTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPhaseTypeText() {
        return phaseTypeText;
    }

    /**
     * Sets the value of the phaseTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPhaseTypeText(TextType value) {
        this.phaseTypeText = value;
    }

}
