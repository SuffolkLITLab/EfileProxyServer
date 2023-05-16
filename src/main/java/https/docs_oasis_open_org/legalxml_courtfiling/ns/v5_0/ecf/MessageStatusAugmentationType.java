
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for MessageStatusAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageStatusAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ServiceRecipientID" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ServiceStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentIdentification" maxOccurs="unbounded"/&gt;
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
@XmlType(name = "MessageStatusAugmentationType", propOrder = {
    "serviceRecipientID",
    "serviceStatusCode",
    "documentIdentification"
})
public class MessageStatusAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "ServiceRecipientID")
    protected IdentificationType serviceRecipientID;
    @XmlElement(name = "ServiceStatusCode")
    protected NormalizedString serviceStatusCode;
    @XmlElement(name = "DocumentIdentification", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected List<IdentificationType> documentIdentification;

    /**
     * Gets the value of the serviceRecipientID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getServiceRecipientID() {
        return serviceRecipientID;
    }

    /**
     * Sets the value of the serviceRecipientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setServiceRecipientID(IdentificationType value) {
        this.serviceRecipientID = value;
    }

    /**
     * Gets the value of the serviceStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getServiceStatusCode() {
        return serviceStatusCode;
    }

    /**
     * Sets the value of the serviceStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setServiceStatusCode(NormalizedString value) {
        this.serviceStatusCode = value;
    }

    /**
     * Gets the value of the documentIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getDocumentIdentification() {
        if (documentIdentification == null) {
            documentIdentification = new ArrayList<IdentificationType>();
        }
        return this.documentIdentification;
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
