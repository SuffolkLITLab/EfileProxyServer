
package tyler.ecf.v5_0.extensions.criminal;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.domains.jxdm._6.StatuteType;
import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ChargeAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChargeAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}TrackingNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}OffenseDate"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}DateOnOrAboutIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}TimeOnOrAboutIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}Bond" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}FineAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}PhaseTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}SequenceNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}AdditionalStatute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}ChargeHistory" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}Plea" minOccurs="0"/&gt;
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
@XmlType(name = "ChargeAugmentationType", propOrder = {
    "trackingNumber",
    "offenseDate",
    "dateOnOrAboutIndicator",
    "timeOnOrAboutIndicator",
    "bond",
    "fineAmount",
    "phaseTypeCode",
    "sequenceNumber",
    "additionalStatute",
    "chargeHistory",
    "plea"
})
public class ChargeAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "TrackingNumber")
    protected TextType trackingNumber;
    @XmlElement(name = "OffenseDate", required = true)
    protected DateType offenseDate;
    @XmlElement(name = "DateOnOrAboutIndicator")
    protected Boolean dateOnOrAboutIndicator;
    @XmlElement(name = "TimeOnOrAboutIndicator")
    protected Boolean timeOnOrAboutIndicator;
    @XmlElement(name = "Bond")
    protected BondType bond;
    @XmlElement(name = "FineAmount")
    protected AmountType fineAmount;
    @XmlElement(name = "PhaseTypeCode")
    protected TextType phaseTypeCode;
    @XmlElement(name = "SequenceNumber")
    protected TextType sequenceNumber;
    @XmlElement(name = "AdditionalStatute")
    protected List<StatuteType> additionalStatute;
    @XmlElement(name = "ChargeHistory")
    protected List<ChargeHistoryType> chargeHistory;
    @XmlElement(name = "Plea")
    protected PleaType plea;

    /**
     * Gets the value of the trackingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getTrackingNumber() {
        return trackingNumber;
    }

    /**
     * Sets the value of the trackingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setTrackingNumber(TextType value) {
        this.trackingNumber = value;
    }

    /**
     * Gets the value of the offenseDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getOffenseDate() {
        return offenseDate;
    }

    /**
     * Sets the value of the offenseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setOffenseDate(DateType value) {
        this.offenseDate = value;
    }

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
     * Gets the value of the phaseTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPhaseTypeCode() {
        return phaseTypeCode;
    }

    /**
     * Sets the value of the phaseTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPhaseTypeCode(TextType value) {
        this.phaseTypeCode = value;
    }

    /**
     * Gets the value of the sequenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Sets the value of the sequenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setSequenceNumber(TextType value) {
        this.sequenceNumber = value;
    }

    /**
     * Gets the value of the additionalStatute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the additionalStatute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalStatute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * Gets the value of the chargeHistory property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the chargeHistory property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeHistory().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeHistoryType }
     * 
     * 
     */
    public List<ChargeHistoryType> getChargeHistory() {
        if (chargeHistory == null) {
            chargeHistory = new ArrayList<ChargeHistoryType>();
        }
        return this.chargeHistory;
    }

    /**
     * Gets the value of the plea property.
     * 
     * @return
     *     possible object is
     *     {@link PleaType }
     *     
     */
    public PleaType getPlea() {
        return plea;
    }

    /**
     * Sets the value of the plea property.
     * 
     * @param value
     *     allowed object is
     *     {@link PleaType }
     *     
     */
    public void setPlea(PleaType value) {
        this.plea = value;
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
