
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.CancelFilingMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest.GetCaseListRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest.GetCaseRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentrequest.GetDocumentRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesrequest.GetFeesCalculationRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistrequest.GetFilingListRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest.GetFilingStatusRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyrequest.GetPolicyRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdaterequest.RequestCourtDateRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.schedulerequest.GetCourtScheduleRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationrequest.GetServiceInformationRequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The base message for a synchronous request/query.
 * 
 * <p>Java class for RequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseFilingType"&gt;
 *       &lt;sequence&gt;
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
@XmlType(name = "RequestMessageType")
@XmlSeeAlso({
    GetCaseListRequestMessageType.class,
    GetCaseRequestMessageType.class,
    GetFilingStatusRequestMessageType.class,
    RequestCourtDateRequestMessageType.class,
    CancelFilingMessageType.class,
    GetDocumentRequestMessageType.class,
    GetFeesCalculationRequestMessageType.class,
    GetFilingListRequestMessageType.class,
    GetPolicyRequestMessageType.class,
    GetCourtScheduleRequestMessageType.class,
    GetServiceInformationRequestMessageType.class
})
public class RequestMessageType
    extends CaseFilingType
{


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
