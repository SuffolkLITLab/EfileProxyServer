
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistrequest;

import java.util.ArrayList;
import java.util.List;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * This is query to get a list of filings by Filer Identification, Case Identifier, or time period.
 * 
 * <p>Java class for GetFilingListRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilingListRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filinglistrequest}FilingListQueryCriteria"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filinglistrequest}GetFilingListRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetFilingListRequestMessageType", propOrder = {
    "filingListQueryCriteria",
    "getFilingListRequestMessageAugmentationPoint"
})
public class GetFilingListRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "FilingListQueryCriteria", required = true)
    protected FilingListQueryCriteriaType filingListQueryCriteria;
    @XmlElement(name = "GetFilingListRequestMessageAugmentationPoint")
    protected List<Object> getFilingListRequestMessageAugmentationPoint;

    /**
     * Gets the value of the filingListQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link FilingListQueryCriteriaType }
     *     
     */
    public FilingListQueryCriteriaType getFilingListQueryCriteria() {
        return filingListQueryCriteria;
    }

    /**
     * Sets the value of the filingListQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingListQueryCriteriaType }
     *     
     */
    public void setFilingListQueryCriteria(FilingListQueryCriteriaType value) {
        this.filingListQueryCriteria = value;
    }

    /**
     * Gets the value of the getFilingListRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getFilingListRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetFilingListRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetFilingListRequestMessageAugmentationPoint() {
        if (getFilingListRequestMessageAugmentationPoint == null) {
            getFilingListRequestMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getFilingListRequestMessageAugmentationPoint;
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
