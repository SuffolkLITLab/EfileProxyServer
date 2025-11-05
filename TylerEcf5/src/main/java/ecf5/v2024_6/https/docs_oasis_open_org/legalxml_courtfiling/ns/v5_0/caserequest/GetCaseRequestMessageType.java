
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.common.GetCaseRequestAugmentationType;


/**
 * A message requesting a case from a court case management information system conforming to the parameter or parameters identified in the message.
 * 
 * <p>Java class for GetCaseRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}CaseQueryCriteria"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}GetCaseRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetCaseRequestMessageType", propOrder = {
    "caseQueryCriteria",
    "getCaseRequestMessageAugmentationPoint"
})
public class GetCaseRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "CaseQueryCriteria", required = true)
    protected CaseQueryCriteriaType caseQueryCriteria;
    @XmlElementRef(name = "GetCaseRequestMessageAugmentationPoint", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> getCaseRequestMessageAugmentationPoint;

    /**
     * Gets the value of the caseQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link CaseQueryCriteriaType }
     *     
     */
    public CaseQueryCriteriaType getCaseQueryCriteria() {
        return caseQueryCriteria;
    }

    /**
     * Sets the value of the caseQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseQueryCriteriaType }
     *     
     */
    public void setCaseQueryCriteria(CaseQueryCriteriaType value) {
        this.caseQueryCriteria = value;
    }

    /**
     * Gets the value of the getCaseRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getCaseRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCaseRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link GetCaseRequestAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getGetCaseRequestMessageAugmentationPoint() {
        if (getCaseRequestMessageAugmentationPoint == null) {
            getCaseRequestMessageAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.getCaseRequestMessageAugmentationPoint;
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
