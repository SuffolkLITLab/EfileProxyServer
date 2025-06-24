
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentrequest;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Criteria limiting the document information to be returned.
 * 
 * <p>Java class for DocumentQueryCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentQueryCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTrackingID" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseNumberText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentFileControlID"/&gt;
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
@XmlType(name = "DocumentQueryCriteriaType", propOrder = {
    "caseTrackingID",
    "caseNumberText",
    "documentFileControlID"
})
public class DocumentQueryCriteriaType
    extends ObjectType
{

    @XmlElement(name = "CaseTrackingID", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected List<IdentificationType> caseTrackingID;
    @XmlElement(name = "CaseNumberText", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected TextType caseNumberText;
    @XmlElement(name = "DocumentFileControlID", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String documentFileControlID;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseTrackingID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseTrackingID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getCaseTrackingID() {
        if (caseTrackingID == null) {
            caseTrackingID = new ArrayList<IdentificationType>();
        }
        return this.caseTrackingID;
    }

    /**
     * Gets the value of the caseNumberText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseNumberText() {
        return caseNumberText;
    }

    /**
     * Sets the value of the caseNumberText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseNumberText(TextType value) {
        this.caseNumberText = value;
    }

    /**
     * Gets the value of the documentFileControlID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String getDocumentFileControlID() {
        return documentFileControlID;
    }

    /**
     * Sets the value of the documentFileControlID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setDocumentFileControlID(ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.documentFileControlID = value;
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
