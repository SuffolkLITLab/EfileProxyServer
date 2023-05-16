
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentrequest;

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
 * The base information contained in any query message.
 * 
 * <p>Java class for GetDocumentRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDocumentRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest}DocumentQueryCriteria"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentrequest}GetDocumentRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetDocumentRequestMessageType", propOrder = {
    "documentQueryCriteria",
    "getDocumentRequestMessageAugmentationPoint"
})
public class GetDocumentRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "DocumentQueryCriteria", required = true)
    protected DocumentQueryCriteriaType documentQueryCriteria;
    @XmlElement(name = "GetDocumentRequestMessageAugmentationPoint")
    protected List<Object> getDocumentRequestMessageAugmentationPoint;

    /**
     * Gets the value of the documentQueryCriteria property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentQueryCriteriaType }
     *     
     */
    public DocumentQueryCriteriaType getDocumentQueryCriteria() {
        return documentQueryCriteria;
    }

    /**
     * Sets the value of the documentQueryCriteria property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentQueryCriteriaType }
     *     
     */
    public void setDocumentQueryCriteria(DocumentQueryCriteriaType value) {
        this.documentQueryCriteria = value;
    }

    /**
     * Gets the value of the getDocumentRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getDocumentRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetDocumentRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetDocumentRequestMessageAugmentationPoint() {
        if (getDocumentRequestMessageAugmentationPoint == null) {
            getDocumentRequestMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getDocumentRequestMessageAugmentationPoint;
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
