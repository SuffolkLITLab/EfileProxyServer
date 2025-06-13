
package tyler.efm.v2024_6.services.schema.replaceservicecontactrequest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2024_6.services.schema.baserequest.BaseRequestType;


/**
 * <p>Java class for ReplaceServiceContactRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReplaceServiceContactRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseRequest}BaseRequestType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OldServiceContactID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NewServiceContactID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "ReplaceServiceContactRequestType", propOrder = {
    "oldServiceContactID",
    "newServiceContactID",
    "caseID",
    "casePartyID"
})
public class ReplaceServiceContactRequestType
    extends BaseRequestType
{

    @XmlElement(name = "OldServiceContactID")
    protected String oldServiceContactID;
    @XmlElement(name = "NewServiceContactID")
    protected String newServiceContactID;
    @XmlElement(name = "CaseID")
    protected String caseID;
    @XmlElement(name = "CasePartyID")
    protected String casePartyID;

    /**
     * Gets the value of the oldServiceContactID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldServiceContactID() {
        return oldServiceContactID;
    }

    /**
     * Sets the value of the oldServiceContactID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldServiceContactID(String value) {
        this.oldServiceContactID = value;
    }

    /**
     * Gets the value of the newServiceContactID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewServiceContactID() {
        return newServiceContactID;
    }

    /**
     * Sets the value of the newServiceContactID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewServiceContactID(String value) {
        this.newServiceContactID = value;
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
