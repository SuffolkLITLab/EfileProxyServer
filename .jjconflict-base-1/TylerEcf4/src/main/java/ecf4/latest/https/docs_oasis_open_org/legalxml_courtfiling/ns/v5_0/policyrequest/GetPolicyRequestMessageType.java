
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyrequest;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;


/**
 * A request for a court's Court Policy.
 * 
 * <p>Java class for GetPolicyRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPolicyRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyrequest}GetPolicyRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetPolicyRequestMessageType", propOrder = {
    "caseTypeCode",
    "getPolicyRequestMessageAugmentationPoint"
})
public class GetPolicyRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "CaseTypeCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected NormalizedString caseTypeCode;
    @XmlElement(name = "GetPolicyRequestMessageAugmentationPoint")
    protected List<Object> getPolicyRequestMessageAugmentationPoint;

    /**
     * Gets the value of the caseTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getCaseTypeCode() {
        return caseTypeCode;
    }

    /**
     * Sets the value of the caseTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setCaseTypeCode(NormalizedString value) {
        this.caseTypeCode = value;
    }

    /**
     * Gets the value of the getPolicyRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getPolicyRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetPolicyRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetPolicyRequestMessageAugmentationPoint() {
        if (getPolicyRequestMessageAugmentationPoint == null) {
            getPolicyRequestMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getPolicyRequestMessageAugmentationPoint;
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
