
package tyler.ecf.v5_0.extensions.securecase;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Message to secure a case.
 * 
 * <p>Java class for SecureCaseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecureCaseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseTrackingID"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:securecase}IsSecure"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:securecase}SecureCaseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "SecureCaseMessageType", propOrder = {
    "caseTrackingID",
    "isSecure",
    "secureCaseMessageAugmentationPoint"
})
public class SecureCaseMessageType
    extends RequestMessageType
{

    @XmlElement(name = "CaseTrackingID", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected IdentificationType caseTrackingID;
    @XmlElement(name = "IsSecure", required = true)
    protected Boolean isSecure;
    @XmlElement(name = "SecureCaseMessageAugmentationPoint")
    protected List<Object> secureCaseMessageAugmentationPoint;

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setCaseTrackingID(IdentificationType value) {
        this.caseTrackingID = value;
    }

    /**
     * Gets the value of the isSecure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsSecure() {
        return isSecure;
    }

    /**
     * Sets the value of the isSecure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsSecure(Boolean value) {
        this.isSecure = value;
    }

    /**
     * Gets the value of the secureCaseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the secureCaseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSecureCaseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getSecureCaseMessageAugmentationPoint() {
        if (secureCaseMessageAugmentationPoint == null) {
            secureCaseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.secureCaseMessageAugmentationPoint;
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
