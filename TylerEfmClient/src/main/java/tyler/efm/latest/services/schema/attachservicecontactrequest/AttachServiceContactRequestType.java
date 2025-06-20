
package tyler.efm.latest.services.schema.attachservicecontactrequest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.latest.services.schema.baserequest.BaseRequestType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for AttachServiceContactRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AttachServiceContactRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseRequest}BaseRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ServiceContactID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CaseID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CasePartyID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachServiceContactRequestType", propOrder = {
    "serviceContactID",
    "caseID",
    "casePartyID"
})
public class AttachServiceContactRequestType
    extends BaseRequestType
{

    @XmlElement(name = "ServiceContactID")
    protected String serviceContactID;
    @XmlElement(name = "CaseID")
    protected String caseID;
    @XmlElement(name = "CasePartyID")
    protected String casePartyID;

    /**
     * Gets the value of the serviceContactID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceContactID() {
        return serviceContactID;
    }

    /**
     * Sets the value of the serviceContactID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceContactID(String value) {
        this.serviceContactID = value;
    }

    /**
     * Gets the value of the caseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseID() {
        return caseID;
    }

    /**
     * Sets the value of the caseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseID(String value) {
        this.caseID = value;
    }

    /**
     * Gets the value of the casePartyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCasePartyID() {
        return casePartyID;
    }

    /**
     * Sets the value of the casePartyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCasePartyID(String value) {
        this.casePartyID = value;
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
