
package gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseDispositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseDispositionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}DispositionType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseDispositionFinalDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseDispositionDecision" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseDispositionType", propOrder = {
    "caseDispositionFinalDate",
    "caseDispositionDecision"
})
public class CaseDispositionType
    extends DispositionType
{

    @XmlElement(name = "CaseDispositionFinalDate", nillable = true)
    protected DateType caseDispositionFinalDate;
    @XmlElement(name = "CaseDispositionDecision", nillable = true)
    protected List<CaseDispositionDecisionType> caseDispositionDecision;

    /**
     * Gets the value of the caseDispositionFinalDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getCaseDispositionFinalDate() {
        return caseDispositionFinalDate;
    }

    /**
     * Sets the value of the caseDispositionFinalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setCaseDispositionFinalDate(DateType value) {
        this.caseDispositionFinalDate = value;
    }

    /**
     * Gets the value of the caseDispositionDecision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseDispositionDecision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseDispositionDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CaseDispositionDecisionType }
     * 
     * 
     */
    public List<CaseDispositionDecisionType> getCaseDispositionDecision() {
        if (caseDispositionDecision == null) {
            caseDispositionDecision = new ArrayList<CaseDispositionDecisionType>();
        }
        return this.caseDispositionDecision;
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
