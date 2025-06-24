
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusresponse;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.MatchingFilingType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;


/**
 * A court response to a FilingStatusQueryMessage.
 * 
 * <p>Java class for GetFilingStatusResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFilingStatusResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}MatchingFiling"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filingstatusresponse}GetFilingStatusResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetFilingStatusResponseMessageType", propOrder = {
    "matchingFiling",
    "getFilingStatusResponseMessageAugmentationPoint"
})
public class GetFilingStatusResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(name = "MatchingFiling", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected MatchingFilingType matchingFiling;
    @XmlElement(name = "GetFilingStatusResponseMessageAugmentationPoint")
    protected List<Object> getFilingStatusResponseMessageAugmentationPoint;

    /**
     * Gets the value of the matchingFiling property.
     * 
     * @return
     *     possible object is
     *     {@link MatchingFilingType }
     *     
     */
    public MatchingFilingType getMatchingFiling() {
        return matchingFiling;
    }

    /**
     * Sets the value of the matchingFiling property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatchingFilingType }
     *     
     */
    public void setMatchingFiling(MatchingFilingType value) {
        this.matchingFiling = value;
    }

    /**
     * Gets the value of the getFilingStatusResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getFilingStatusResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetFilingStatusResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetFilingStatusResponseMessageAugmentationPoint() {
        if (getFilingStatusResponseMessageAugmentationPoint == null) {
            getFilingStatusResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getFilingStatusResponseMessageAugmentationPoint;
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
