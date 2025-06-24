
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest;

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
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.GetFilingStatusRequestMessageAugmentationType;


/**
 * This is query to get a filing status by Filing Number.
 * 
 * <p>Java class for GetFilingStatusRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilingStatusRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest}FilingStatusQueryCriteria"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest}GetFilingStatusRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetFilingStatusRequestMessageType", propOrder = {
    "filingStatusQueryCriteria",
    "getFilingStatusRequestMessageAugmentationPoint"
})
public class GetFilingStatusRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "FilingStatusQueryCriteria", required = true)
    protected FilingStatusQueryCriteriaType filingStatusQueryCriteria;
    @XmlElementRef(name = "GetFilingStatusRequestMessageAugmentationPoint", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusrequest", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> getFilingStatusRequestMessageAugmentationPoint;

    /**
     * Gets the value of the filingStatusQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatusQueryCriteriaType }
     *     
     */
    public FilingStatusQueryCriteriaType getFilingStatusQueryCriteria() {
        return filingStatusQueryCriteria;
    }

    /**
     * Sets the value of the filingStatusQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatusQueryCriteriaType }
     *     
     */
    public void setFilingStatusQueryCriteria(FilingStatusQueryCriteriaType value) {
        this.filingStatusQueryCriteria = value;
    }

    /**
     * Gets the value of the getFilingStatusRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getFilingStatusRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetFilingStatusRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link GetFilingStatusRequestMessageAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getGetFilingStatusRequestMessageAugmentationPoint() {
        if (getFilingStatusRequestMessageAugmentationPoint == null) {
            getFilingStatusRequestMessageAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.getFilingStatusRequestMessageAugmentationPoint;
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
