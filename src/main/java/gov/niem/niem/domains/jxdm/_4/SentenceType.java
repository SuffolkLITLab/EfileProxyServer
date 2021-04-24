
package gov.niem.niem.domains.jxdm._4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.ActivityType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for SentenceType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="SentenceType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}ActivityType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SentenceCharge" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SentenceDescriptionText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}SentenceTerm" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.SentenceType.class
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the sentenceCharge property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSentenceCharge().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
