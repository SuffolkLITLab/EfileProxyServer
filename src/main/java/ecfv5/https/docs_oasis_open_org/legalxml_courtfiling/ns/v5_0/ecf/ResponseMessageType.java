
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.domains.cbrn._4.MessageStatusType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistresponse.GetCaseListResponseMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caseresponse.GetCaseResponseMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentresponse.GetDocumentResponseMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesresponse.GetFeesCalculationResponseMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistresponse.GetFilingListResponseMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusresponse.GetFilingStatusResponseMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.GetPolicyResponseMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.scheduleresponse.GetCourtScheduleResponseMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationresponse.GetServiceInformationResponseMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecfv5.tyler.ecf.v5_0.extensions.reservedateresponse.ReserveDateResponseMessageType;
import ecfv5.tyler.ecf.v5_0.extensions.returndateresponse.ReturnDateResponseMessageType;


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
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}MessageStatus" minOccurs="0"/&gt;
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
    GetDocumentResponseMessageType.class,
    GetFilingStatusResponseMessageType.class,
    ReserveDateResponseMessageType.class,
    GetCourtScheduleResponseMessageType.class,
    ReturnDateResponseMessageType.class,
    GetFilingListResponseMessageType.class,
    GetPolicyResponseMessageType.class,
    GetServiceInformationResponseMessageType.class,
    GetFeesCalculationResponseMessageType.class,
    GetCaseResponseMessageType.class,
    GetCaseListResponseMessageType.class
})
public class ResponseMessageType
    extends CaseFilingType
{

    @XmlElement(name = "MessageStatus", namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/")
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
