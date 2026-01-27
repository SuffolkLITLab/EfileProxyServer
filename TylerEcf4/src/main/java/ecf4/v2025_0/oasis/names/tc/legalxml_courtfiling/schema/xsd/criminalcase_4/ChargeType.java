
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.StatuteType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.IncidentType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The crime or violation a defendant is alleged or found to have committed. 
 * 
 * <p>Java class for ChargeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChargeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}ChargeType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}ChargeOffense"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}ChargeChargingAgencyJurisdictionStatute" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}ChargeAmendedIndicator"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargeType", propOrder = {
    "chargeOffense",
    "chargeChargingAgencyJurisdictionStatute",
    "chargeAmendedIndicator"
})
@XmlSeeAlso({
   ecf4.v2025_0.tyler.ecf.extensions.criminal.ChargeType.class
})
public class ChargeType
    extends ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.ChargeType
{

    @XmlElement(name = "ChargeOffense", required = true)
    protected IncidentType chargeOffense;
    @XmlElement(name = "ChargeChargingAgencyJurisdictionStatute")
    protected List<StatuteType> chargeChargingAgencyJurisdictionStatute;
    @XmlElement(name = "ChargeAmendedIndicator", required = true)
    protected Boolean chargeAmendedIndicator;

    /**
     * Gets the value of the chargeOffense property.
     * 
     * @return
     *     possible object is
     *     {@link IncidentType }
     *     
     */
    public IncidentType getChargeOffense() {
        return chargeOffense;
    }

    /**
     * Sets the value of the chargeOffense property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncidentType }
     *     
     */
    public void setChargeOffense(IncidentType value) {
        this.chargeOffense = value;
    }

    /**
     * Gets the value of the chargeChargingAgencyJurisdictionStatute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the chargeChargingAgencyJurisdictionStatute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChargeChargingAgencyJurisdictionStatute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatuteType }
     * 
     * 
     */
    public List<StatuteType> getChargeChargingAgencyJurisdictionStatute() {
        if (chargeChargingAgencyJurisdictionStatute == null) {
            chargeChargingAgencyJurisdictionStatute = new ArrayList<StatuteType>();
        }
        return this.chargeChargingAgencyJurisdictionStatute;
    }

    /**
     * Gets the value of the chargeAmendedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getChargeAmendedIndicator() {
        return chargeAmendedIndicator;
    }

    /**
     * Sets the value of the chargeAmendedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setChargeAmendedIndicator(Boolean value) {
        this.chargeAmendedIndicator = value;
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
