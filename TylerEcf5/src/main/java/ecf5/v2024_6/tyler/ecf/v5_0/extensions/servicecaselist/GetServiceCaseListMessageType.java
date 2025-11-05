
package tyler.ecf.v5_0.extensions.servicecaselist;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Message to retrieve cases attached to a service contact.
 * 
 * <p>Java class for GetServiceCaseListMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceCaseListMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ServiceRecipientID"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:servicecaselist}GetServiceCaseListMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetServiceCaseListMessageType", propOrder = {
    "serviceRecipientID",
    "getServiceCaseListMessageAugmentationPoint"
})
public class GetServiceCaseListMessageType
    extends RequestMessageType
{

    @XmlElement(name = "ServiceRecipientID", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true)
    protected IdentificationType serviceRecipientID;
    @XmlElement(name = "GetServiceCaseListMessageAugmentationPoint")
    protected List<Object> getServiceCaseListMessageAugmentationPoint;

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
     * Gets the value of the getServiceCaseListMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getServiceCaseListMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetServiceCaseListMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetServiceCaseListMessageAugmentationPoint() {
        if (getServiceCaseListMessageAugmentationPoint == null) {
            getServiceCaseListMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getServiceCaseListMessageAugmentationPoint;
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
