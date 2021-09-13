
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesrequest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.FilingMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * This query is a request for the total amount of court fees required for filing of one or more documents in a case.
 * 
 * <p>Java class for GetFeesCalculationRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFeesCalculationRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing}FilingMessage"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/feesrequest}GetFeesCalculationRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetFeesCalculationRequestMessageType", propOrder = {
    "filingMessage",
    "getFeesCalculationRequestMessageAugmentationPoint"
})
public class GetFeesCalculationRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "FilingMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", required = true)
    protected FilingMessageType filingMessage;
    @XmlElement(name = "GetFeesCalculationRequestMessageAugmentationPoint")
    protected List<Object> getFeesCalculationRequestMessageAugmentationPoint;

    /**
     * Gets the value of the filingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link FilingMessageType }
     *     
     */
    public FilingMessageType getFilingMessage() {
        return filingMessage;
    }

    /**
     * Sets the value of the filingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingMessageType }
     *     
     */
    public void setFilingMessage(FilingMessageType value) {
        this.filingMessage = value;
    }

    /**
     * Gets the value of the getFeesCalculationRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getFeesCalculationRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetFeesCalculationRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetFeesCalculationRequestMessageAugmentationPoint() {
        if (getFeesCalculationRequestMessageAugmentationPoint == null) {
            getFeesCalculationRequestMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getFeesCalculationRequestMessageAugmentationPoint;
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
