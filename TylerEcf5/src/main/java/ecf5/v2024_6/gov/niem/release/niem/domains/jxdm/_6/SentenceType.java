
package ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.ActivityType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a punishment resulting from conviction of charges in a court case.
 * 
 * <p>Java class for SentenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SentenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}SentenceCharge" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}SentenceDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}SentenceTerm" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}SupervisionFineAmount" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}SentenceAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "SentenceType", propOrder = {
    "sentenceCharge",
    "sentenceDescriptionText",
    "sentenceTerm",
    "supervisionFineAmount",
    "sentenceAugmentationPoint"
})
public class SentenceType
    extends ActivityType
{

    @XmlElement(name = "SentenceCharge", required = true, nillable = true)
    protected List<ChargeType> sentenceCharge;
    @XmlElement(name = "SentenceDescriptionText")
    protected TextType sentenceDescriptionText;
    @XmlElement(name = "SentenceTerm")
    protected TermType sentenceTerm;
    @XmlElement(name = "SupervisionFineAmount")
    protected List<AmountType> supervisionFineAmount;
    @XmlElement(name = "SentenceAugmentationPoint")
    protected List<Object> sentenceAugmentationPoint;

    /**
     * Gets the value of the sentenceCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the sentenceCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSentenceCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeType }
     * 
     * 
     */
    public List<ChargeType> getSentenceCharge() {
        if (sentenceCharge == null) {
            sentenceCharge = new ArrayList<ChargeType>();
        }
        return this.sentenceCharge;
    }

    /**
     * Gets the value of the sentenceDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getSentenceDescriptionText() {
        return sentenceDescriptionText;
    }

    /**
     * Sets the value of the sentenceDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setSentenceDescriptionText(TextType value) {
        this.sentenceDescriptionText = value;
    }

    /**
     * Gets the value of the sentenceTerm property.
     * 
     * @return
     *     possible object is
     *     {@link TermType }
     *     
     */
    public TermType getSentenceTerm() {
        return sentenceTerm;
    }

    /**
     * Sets the value of the sentenceTerm property.
     * 
     * @param value
     *     allowed object is
     *     {@link TermType }
     *     
     */
    public void setSentenceTerm(TermType value) {
        this.sentenceTerm = value;
    }

    /**
     * Gets the value of the supervisionFineAmount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the supervisionFineAmount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupervisionFineAmount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getSupervisionFineAmount() {
        if (supervisionFineAmount == null) {
            supervisionFineAmount = new ArrayList<AmountType>();
        }
        return this.supervisionFineAmount;
    }

    /**
     * Gets the value of the sentenceAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the sentenceAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSentenceAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getSentenceAugmentationPoint() {
        if (sentenceAugmentationPoint == null) {
            sentenceAugmentationPoint = new ArrayList<Object>();
        }
        return this.sentenceAugmentationPoint;
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
