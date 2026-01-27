
package ecf4.v2025_0.tyler.ecf.extensions.notifyservicemessage;

import ecf4.v2025_0.gov.niem.niem.niem_core._2.DateType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.EntityType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import ecf4.v2025_0.gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ServiceRecipientType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceRecipientType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}EntityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:NotifyServiceMessage}ServiceContactID"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:NotifyServiceMessage}SentDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:NotifyServiceMessage}Status"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}EntityPersonReference" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceRecipientType", propOrder = {
    "serviceContactID",
    "sentDate",
    "status",
    "entityPersonReference"
})
public class ServiceRecipientType
    extends EntityType
{

    @XmlElement(name = "ServiceContactID", required = true)
    protected IdentificationType serviceContactID;
    @XmlElement(name = "SentDate")
    protected DateType sentDate;
    @XmlElement(name = "Status", required = true)
    protected TextType status;
    @XmlElement(name = "EntityPersonReference", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected ReferenceType entityPersonReference;

    /**
     * Gets the value of the serviceContactID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getServiceContactID() {
        return serviceContactID;
    }

    /**
     * Sets the value of the serviceContactID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setServiceContactID(IdentificationType value) {
        this.serviceContactID = value;
    }

    /**
     * Gets the value of the sentDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getSentDate() {
        return sentDate;
    }

    /**
     * Sets the value of the sentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setSentDate(DateType value) {
        this.sentDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStatus(TextType value) {
        this.status = value;
    }

    /**
     * Gets the value of the entityPersonReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getEntityPersonReference() {
        return entityPersonReference;
    }

    /**
     * Sets the value of the entityPersonReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setEntityPersonReference(ReferenceType value) {
        this.entityPersonReference = value;
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
