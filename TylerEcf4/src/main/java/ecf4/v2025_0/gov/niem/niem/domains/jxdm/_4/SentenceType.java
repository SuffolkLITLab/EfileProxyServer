
package ecf4.v2025_0.gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.ActivityType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for SentenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SentenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SentenceCharge" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SentenceDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SentenceTerm" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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
    "sentenceTerm"
})
@XmlSeeAlso({
   ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.SentenceType.class
})
public class SentenceType
    extends ActivityType
{

    @XmlElement(name = "SentenceCharge", required = true, nillable = true)
    protected List<ChargeType> sentenceCharge;
    @XmlElement(name = "SentenceDescriptionText", nillable = true)
    protected TextType sentenceDescriptionText;
    @XmlElement(name = "SentenceTerm", nillable = true)
    protected TermType sentenceTerm;

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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
