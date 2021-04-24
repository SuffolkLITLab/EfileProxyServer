
package oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.RelatedActivityAssociationType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A sentence associated with a specific charge in a case. A sentence may have multiple components (prison, probation, post-incarceration supervision/probation fine, etc.).
 * 
 * &lt;p&gt;Java class for SentenceType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="SentenceType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}SentenceType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}SentenceConcurrentAssociation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CriminalCase-4.0}SentenceFineAmount" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ChargeReference" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
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
    "sentenceConcurrentAssociation",
    "sentenceFineAmount",
    "chargeReference"
})
public class SentenceType
    extends gov.niem.niem.domains.jxdm._4.SentenceType
{

    @XmlElement(name = "SentenceConcurrentAssociation")
    protected List<RelatedActivityAssociationType> sentenceConcurrentAssociation;
    @XmlElement(name = "SentenceFineAmount")
    protected List<AmountType> sentenceFineAmount;
    @XmlElement(name = "ChargeReference", namespace = "http://niem.gov/niem/domains/jxdm/4.0")
    protected List<ReferenceType> chargeReference;

    /**
     * Gets the value of the sentenceConcurrentAssociation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the sentenceConcurrentAssociation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSentenceConcurrentAssociation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link RelatedActivityAssociationType }
     * 
     * 
     */
    public List<RelatedActivityAssociationType> getSentenceConcurrentAssociation() {
        if (sentenceConcurrentAssociation == null) {
            sentenceConcurrentAssociation = new ArrayList<RelatedActivityAssociationType>();
        }
        return this.sentenceConcurrentAssociation;
    }

    /**
     * Gets the value of the sentenceFineAmount property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the sentenceFineAmount property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSentenceFineAmount().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link AmountType }
     * 
     * 
     */
    public List<AmountType> getSentenceFineAmount() {
        if (sentenceFineAmount == null) {
            sentenceFineAmount = new ArrayList<AmountType>();
        }
        return this.sentenceFineAmount;
    }

    /**
     * Gets the value of the chargeReference property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the chargeReference property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getChargeReference().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getChargeReference() {
        if (chargeReference == null) {
            chargeReference = new ArrayList<ReferenceType>();
        }
        return this.chargeReference;
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
