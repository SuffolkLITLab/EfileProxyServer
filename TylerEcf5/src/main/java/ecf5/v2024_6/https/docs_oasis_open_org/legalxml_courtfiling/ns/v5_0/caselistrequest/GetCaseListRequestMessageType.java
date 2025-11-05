
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.GetCaseListRequestMessageAugmentationType;


/**
 * This is a query for a list of cases that match a set of criteria including case participants, case classification, case status, and date of the case was initiated.
 * 
 * <p>Java class for GetCaseListRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseListRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest}CaseListQueryCriteria"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest}GetCaseListRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetCaseListRequestMessageType", propOrder = {
    "caseListQueryCriteria",
    "getCaseListRequestMessageAugmentationPoint"
})
public class GetCaseListRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "CaseListQueryCriteria", required = true)
    protected CaseListQueryCriteriaType caseListQueryCriteria;
    @XmlElementRef(name = "GetCaseListRequestMessageAugmentationPoint", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> getCaseListRequestMessageAugmentationPoint;

    /**
     * Gets the value of the caseListQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link CaseListQueryCriteriaType }
     *     
     */
    public CaseListQueryCriteriaType getCaseListQueryCriteria() {
        return caseListQueryCriteria;
    }

    /**
     * Sets the value of the caseListQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseListQueryCriteriaType }
     *     
     */
    public void setCaseListQueryCriteria(CaseListQueryCriteriaType value) {
        this.caseListQueryCriteria = value;
    }

    /**
     * Gets the value of the getCaseListRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getCaseListRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCaseListRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link GetCaseListRequestMessageAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getGetCaseListRequestMessageAugmentationPoint() {
        if (getCaseListRequestMessageAugmentationPoint == null) {
            getCaseListRequestMessageAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.getCaseListRequestMessageAugmentationPoint;
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
