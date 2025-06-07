
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentresponse;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DocumentType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;


/**
 * The court response to a request for an electronic document in the court official record.
 * 
 * <p>Java class for GetDocumentResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetDocumentResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}CaseTrackingID"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Document" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/documentresponse}GetDocumentResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetDocumentResponseMessageType", propOrder = {
    "caseTrackingID",
    "document",
    "getDocumentResponseMessageAugmentationPoint"
})
public class GetDocumentResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(name = "CaseTrackingID", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String caseTrackingID;
    @XmlElement(name = "Document", namespace = "http://release.niem.gov/niem/niem-core/4.0/", nillable = true)
    protected DocumentType document;
    @XmlElement(name = "GetDocumentResponseMessageAugmentationPoint")
    protected List<Object> getDocumentResponseMessageAugmentationPoint;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setCaseTrackingID(ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType }
     *     
     */
    public DocumentType getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType }
     *     
     */
    public void setDocument(DocumentType value) {
        this.document = value;
    }

    /**
     * Gets the value of the getDocumentResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getDocumentResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetDocumentResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetDocumentResponseMessageAugmentationPoint() {
        if (getDocumentResponseMessageAugmentationPoint == null) {
            getDocumentResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getDocumentResponseMessageAugmentationPoint;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
