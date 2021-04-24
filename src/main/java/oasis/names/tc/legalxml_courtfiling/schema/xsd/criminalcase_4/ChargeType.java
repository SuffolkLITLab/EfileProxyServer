
package oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.StatuteType;
import gov.niem.niem.niem_core._2.IncidentType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


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
 *     &amp;lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}ChargeType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}ChargeOffense"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}ChargeChargingAgencyJurisdictionStatute" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}ChargeAmendedIndicator"/&amp;gt;
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
    "chargeOffense",
    "chargeChargingAgencyJurisdictionStatute",
    "chargeAmendedIndicator"
})
@XmlSeeAlso({
    tyler.ecf.extensions.criminal.ChargeType.class
})
public class ChargeType
    extends gov.niem.niem.domains.jxdm._4.ChargeType
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the chargeChargingAgencyJurisdictionStatute property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getChargeChargingAgencyJurisdictionStatute().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
