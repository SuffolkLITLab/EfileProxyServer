
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationresponse;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.EntityType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The response to a serviceInformationQueryMessage, setting forth the requested information.
 * 
 * <p>Java class for GetServiceInformationResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetServiceInformationResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse}GetServiceInformationResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/serviceinformationresponse}ServiceRecipient" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetServiceInformationResponseMessageType", propOrder = {
    "getServiceInformationResponseMessageAugmentationPoint",
    "serviceRecipient"
})
public class GetServiceInformationResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(name = "GetServiceInformationResponseMessageAugmentationPoint")
    protected List<Object> getServiceInformationResponseMessageAugmentationPoint;
    @XmlElement(name = "ServiceRecipient")
    protected List<EntityType> serviceRecipient;

    /**
     * Gets the value of the getServiceInformationResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getServiceInformationResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetServiceInformationResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetServiceInformationResponseMessageAugmentationPoint() {
        if (getServiceInformationResponseMessageAugmentationPoint == null) {
            getServiceInformationResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getServiceInformationResponseMessageAugmentationPoint;
    }

    /**
     * Gets the value of the serviceRecipient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the serviceRecipient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceRecipient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityType }
     * 
     * 
     */
    public List<EntityType> getServiceRecipient() {
        if (serviceRecipient == null) {
            serviceRecipient = new ArrayList<EntityType>();
        }
        return this.serviceRecipient;
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
