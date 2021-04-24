
package tyler.ecf.extensions.notifyservicemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for ServiceRecipientType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceRecipientType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}EntityType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:NotifyServiceMessage}ServiceContactID"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:NotifyServiceMessage}SentDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:NotifyServiceMessage}Status"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}EntityPersonReference" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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

}
