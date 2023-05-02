
package oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.StatuteType;
import gov.niem.niem.niem_core._2.IncidentType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The statutory or ordinance section, the violation of which would constitute a crime if committed by an adult. May include a probation violation.
 * 
 * <p>Java class for DelinquentActType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DelinquentActType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}IncidentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}DelinquentActStatute"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}DelinquentActSeverityCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}DelinquentActDegreeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}DelinquentActApplicabilityCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}DelinquentActSpecialAllegationCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DelinquentActType", propOrder = {
    "delinquentActStatute",
    "delinquentActSeverityCode",
    "delinquentActDegreeCode",
    "delinquentActApplicabilityCode",
    "delinquentActSpecialAllegationCode"
})
public class DelinquentActType
    extends IncidentType
{

    @XmlElement(name = "DelinquentActStatute", required = true)
    protected StatuteType delinquentActStatute;
    @XmlElement(name = "DelinquentActSeverityCode")
    protected TextType delinquentActSeverityCode;
    @XmlElement(name = "DelinquentActDegreeCode")
    protected TextType delinquentActDegreeCode;
    @XmlElement(name = "DelinquentActApplicabilityCode")
    protected TextType delinquentActApplicabilityCode;
    @XmlElement(name = "DelinquentActSpecialAllegationCode")
    protected TextType delinquentActSpecialAllegationCode;

    /**
     * Gets the value of the delinquentActStatute property.
     * 
     * @return
     *     possible object is
     *     {@link StatuteType }
     *     
     */
    public StatuteType getDelinquentActStatute() {
        return delinquentActStatute;
    }

    /**
     * Sets the value of the delinquentActStatute property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatuteType }
     *     
     */
    public void setDelinquentActStatute(StatuteType value) {
        this.delinquentActStatute = value;
    }

    /**
     * Gets the value of the delinquentActSeverityCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDelinquentActSeverityCode() {
        return delinquentActSeverityCode;
    }

    /**
     * Sets the value of the delinquentActSeverityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDelinquentActSeverityCode(TextType value) {
        this.delinquentActSeverityCode = value;
    }

    /**
     * Gets the value of the delinquentActDegreeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDelinquentActDegreeCode() {
        return delinquentActDegreeCode;
    }

    /**
     * Sets the value of the delinquentActDegreeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDelinquentActDegreeCode(TextType value) {
        this.delinquentActDegreeCode = value;
    }

    /**
     * Gets the value of the delinquentActApplicabilityCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDelinquentActApplicabilityCode() {
        return delinquentActApplicabilityCode;
    }

    /**
     * Sets the value of the delinquentActApplicabilityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDelinquentActApplicabilityCode(TextType value) {
        this.delinquentActApplicabilityCode = value;
    }

    /**
     * Gets the value of the delinquentActSpecialAllegationCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDelinquentActSpecialAllegationCode() {
        return delinquentActSpecialAllegationCode;
    }

    /**
     * Sets the value of the delinquentActSpecialAllegationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDelinquentActSpecialAllegationCode(TextType value) {
        this.delinquentActSpecialAllegationCode = value;
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
