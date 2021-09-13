
package ecfv5.tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecfv5.gov.niem.release.niem.structures._4.AugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingAttorney" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CrossReferenceNumber" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "CaseAugmentationType", propOrder = {
    "filingParty",
    "filingAttorney",
    "crossReferenceNumber"
})
public class CaseAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "FilingParty")
    protected FilingPartyEntityType filingParty;
    @XmlElement(name = "FilingAttorney")
    protected FilingAttorneyEntityType filingAttorney;
    @XmlElement(name = "CrossReferenceNumber")
    protected List<IdentificationType> crossReferenceNumber;

    /**
     * Gets the value of the filingParty property.
     * 
     * @return
     *     possible object is
     *     {@link FilingPartyEntityType }
     *     
     */
    public FilingPartyEntityType getFilingParty() {
        return filingParty;
    }

    /**
     * Sets the value of the filingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingPartyEntityType }
     *     
     */
    public void setFilingParty(FilingPartyEntityType value) {
        this.filingParty = value;
    }

    /**
     * Gets the value of the filingAttorney property.
     * 
     * @return
     *     possible object is
     *     {@link FilingAttorneyEntityType }
     *     
     */
    public FilingAttorneyEntityType getFilingAttorney() {
        return filingAttorney;
    }

    /**
     * Sets the value of the filingAttorney property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingAttorneyEntityType }
     *     
     */
    public void setFilingAttorney(FilingAttorneyEntityType value) {
        this.filingAttorney = value;
    }

    /**
     * Gets the value of the crossReferenceNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the crossReferenceNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCrossReferenceNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getCrossReferenceNumber() {
        if (crossReferenceNumber == null) {
            crossReferenceNumber = new ArrayList<IdentificationType>();
        }
        return this.crossReferenceNumber;
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
