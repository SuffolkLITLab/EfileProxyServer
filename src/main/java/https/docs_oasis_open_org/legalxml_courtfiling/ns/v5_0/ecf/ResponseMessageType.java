
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import gov.niem.release.niem.domains.cbrn._4.MessageStatusType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.GetPolicyResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.batchdetailresponse.GetBatchDetailResponseMessageType;
import tyler.ecf.v5_0.extensions.batchlistresponse.GetBatchListResponseMessageType;
import tyler.ecf.v5_0.extensions.capturefeesresponse.CaptureFeesResponseMessageType;
import tyler.ecf.v5_0.extensions.casehearingresponse.GetCaseHearingsResponseMessageType;
import tyler.ecf.v5_0.extensions.filingserviceresponse.GetFilingServiceResponseMessageType;
import tyler.ecf.v5_0.extensions.partylistresponse.GetPartyListResponseMessageType;
import tyler.ecf.v5_0.extensions.partyresponse.GetPartyResponseMessageType;
import tyler.ecf.v5_0.extensions.returndateresponse.ReturnDateResponseMessageType;
import tyler.ecf.v5_0.extensions.servicecaselistresponse.GetServiceCaseListResponseMessageType;
import tyler.ecf.v5_0.extensions.serviceinformationhistoryresponse.GetServiceInformationHistoryResponseMessageType;
import tyler.ecf.v5_0.extensions.servicetypesresponse.GetServiceTypesResponseMessageType;
import tyler.ecf.v5_0.extensions.updatefeesresponse.UpdateFeesResponseMessageType;


/**
 * The base message for a synchronous response to a request.
 * 
 * <p>Java class for ResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseFilingType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.1/}MessageStatus" minOccurs="0"/&gt;
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
@XmlType(name = "ResponseMessageType", propOrder = {
    "messageStatus"
})
@XmlSeeAlso({
    GetServiceInformationHistoryResponseMessageType.class,
    GetPartyResponseMessageType.class,
    GetBatchListResponseMessageType.class,
    GetServiceCaseListResponseMessageType.class,
    CaptureFeesResponseMessageType.class,
    UpdateFeesResponseMessageType.class,
    GetCaseHearingsResponseMessageType.class,
    GetFilingServiceResponseMessageType.class,
    GetBatchDetailResponseMessageType.class,
    GetServiceTypesResponseMessageType.class,
    GetPolicyResponseMessageType.class,
    ReturnDateResponseMessageType.class,
    GetPartyListResponseMessageType.class
})
public class ResponseMessageType
    extends CaseFilingType
{

    @XmlElement(name = "MessageStatus", namespace = "http://release.niem.gov/niem/domains/cbrn/4.1/")
    protected MessageStatusType messageStatus;

    /**
     * Gets the value of the messageStatus property.
     * 
     * @return
     *     possible object is
     *     {@link MessageStatusType }
     *     
     */
    public MessageStatusType getMessageStatus() {
        return messageStatus;
    }

    /**
     * Sets the value of the messageStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageStatusType }
     *     
     */
    public void setMessageStatus(MessageStatusType value) {
        this.messageStatus = value;
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
