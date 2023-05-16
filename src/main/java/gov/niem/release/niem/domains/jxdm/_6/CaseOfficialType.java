
package gov.niem.release.niem.domains.jxdm._6;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.common.CaseJudgeAugmentationType;


/**
 * A data type for an official's involvement in a case.
 * 
 * <p>Java class for CaseOfficialType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseOfficialType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/6.1/}JudicialOfficialType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseOfficialCaseIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseOfficialAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "CaseOfficialType", propOrder = {
    "caseOfficialCaseIdentification",
    "caseOfficialAugmentationPoint"
})
public class CaseOfficialType
    extends JudicialOfficialType
{

    @XmlElement(name = "CaseOfficialCaseIdentification")
    protected IdentificationType caseOfficialCaseIdentification;
    @XmlElementRef(name = "CaseOfficialAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> caseOfficialAugmentationPoint;

    /**
     * Gets the value of the caseOfficialCaseIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getCaseOfficialCaseIdentification() {
        return caseOfficialCaseIdentification;
    }

    /**
     * Sets the value of the caseOfficialCaseIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setCaseOfficialCaseIdentification(IdentificationType value) {
        this.caseOfficialCaseIdentification = value;
    }

    /**
     * Gets the value of the caseOfficialAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseOfficialAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseOfficialAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseOfficialAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link CaseJudgeAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link tyler.ecf.v5_0.extensions.common.CaseOfficialAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getCaseOfficialAugmentationPoint() {
        if (caseOfficialAugmentationPoint == null) {
            caseOfficialAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.caseOfficialAugmentationPoint;
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
