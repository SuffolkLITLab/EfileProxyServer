
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.AmountType;
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
 * <p>Java class for CaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}AmountInControversy" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}CivilClassActionIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}DecedentEstateCase" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}FiduciaryCaseAssociation" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}JurisdictionalGroundsCode" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}JuryDemandIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}ReliefTypeCode" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CauseOfActionCode"/&gt;
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
    "amountInControversy",
    "civilClassActionIndicator",
    "decedentEstateCase",
    "fiduciaryCaseAssociation",
    "jurisdictionalGroundsCode",
    "juryDemandIndicator",
    "reliefTypeCode",
    "causeOfActionCode"
})
public class CaseAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "AmountInControversy")
    protected AmountType amountInControversy;
    @XmlElement(name = "CivilClassActionIndicator")
    protected Boolean civilClassActionIndicator;
    @XmlElement(name = "DecedentEstateCase")
    protected DecedentEstateCaseType decedentEstateCase;
    @XmlElement(name = "FiduciaryCaseAssociation")
    protected FiduciaryCaseAssociationType fiduciaryCaseAssociation;
    @XmlElement(name = "JurisdictionalGroundsCode")
    protected TextType jurisdictionalGroundsCode;
    @XmlElement(name = "JuryDemandIndicator")
    protected Boolean juryDemandIndicator;
    @XmlElement(name = "ReliefTypeCode", required = true)
    protected List<TextType> reliefTypeCode;
    @XmlElement(name = "CauseOfActionCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected TextType causeOfActionCode;

    /**
     * Gets the value of the amountInControversy property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getAmountInControversy() {
        return amountInControversy;
    }

    /**
     * Sets the value of the amountInControversy property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setAmountInControversy(AmountType value) {
        this.amountInControversy = value;
    }

    /**
     * Gets the value of the civilClassActionIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCivilClassActionIndicator() {
        return civilClassActionIndicator;
    }

    /**
     * Sets the value of the civilClassActionIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCivilClassActionIndicator(Boolean value) {
        this.civilClassActionIndicator = value;
    }

    /**
     * Gets the value of the decedentEstateCase property.
     * 
     * @return
     *     possible object is
     *     {@link DecedentEstateCaseType }
     *     
     */
    public DecedentEstateCaseType getDecedentEstateCase() {
        return decedentEstateCase;
    }

    /**
     * Sets the value of the decedentEstateCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link DecedentEstateCaseType }
     *     
     */
    public void setDecedentEstateCase(DecedentEstateCaseType value) {
        this.decedentEstateCase = value;
    }

    /**
     * Gets the value of the fiduciaryCaseAssociation property.
     * 
     * @return
     *     possible object is
     *     {@link FiduciaryCaseAssociationType }
     *     
     */
    public FiduciaryCaseAssociationType getFiduciaryCaseAssociation() {
        return fiduciaryCaseAssociation;
    }

    /**
     * Sets the value of the fiduciaryCaseAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FiduciaryCaseAssociationType }
     *     
     */
    public void setFiduciaryCaseAssociation(FiduciaryCaseAssociationType value) {
        this.fiduciaryCaseAssociation = value;
    }

    /**
     * Gets the value of the jurisdictionalGroundsCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getJurisdictionalGroundsCode() {
        return jurisdictionalGroundsCode;
    }

    /**
     * Sets the value of the jurisdictionalGroundsCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setJurisdictionalGroundsCode(TextType value) {
        this.jurisdictionalGroundsCode = value;
    }

    /**
     * Gets the value of the juryDemandIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getJuryDemandIndicator() {
        return juryDemandIndicator;
    }

    /**
     * Sets the value of the juryDemandIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setJuryDemandIndicator(Boolean value) {
        this.juryDemandIndicator = value;
    }

    /**
     * Gets the value of the reliefTypeCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the reliefTypeCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReliefTypeCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getReliefTypeCode() {
        if (reliefTypeCode == null) {
            reliefTypeCode = new ArrayList<TextType>();
        }
        return this.reliefTypeCode;
    }

    /**
     * Gets the value of the causeOfActionCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCauseOfActionCode() {
        return causeOfActionCode;
    }

    /**
     * Sets the value of the causeOfActionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCauseOfActionCode(TextType value) {
        this.causeOfActionCode = value;
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
