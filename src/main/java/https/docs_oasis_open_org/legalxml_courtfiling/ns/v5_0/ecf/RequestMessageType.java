
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest.GetCaseListRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest.GetCaseRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest.GetFilingStatusRequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdaterequest.RequestCourtDateRequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.batchdetailrequest.GetBatchDetailMessageType;
import tyler.ecf.v5_0.extensions.batchlistrequest.GetBatchListMessageType;
import tyler.ecf.v5_0.extensions.casehearingrequest.GetCaseHearingsMessageType;
import tyler.ecf.v5_0.extensions.filingservicerequest.GetFilingServiceMessageType;
import tyler.ecf.v5_0.extensions.partylistrequest.GetPartyListMessageType;
import tyler.ecf.v5_0.extensions.partyrequest.GetPartyMessageType;
import tyler.ecf.v5_0.extensions.securecase.SecureCaseMessageType;
import tyler.ecf.v5_0.extensions.servicecaselist.GetServiceCaseListMessageType;
import tyler.ecf.v5_0.extensions.serviceinformationhistory.GetServiceInformationHistoryMessageType;
import tyler.ecf.v5_0.extensions.servicetypesrequest.GetServiceTypesMessageType;


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
    GetBatchDetailMessageType.class,
    GetFilingStatusRequestMessageType.class,
    GetServiceCaseListMessageType.class,
    GetBatchListMessageType.class,
    GetCaseListRequestMessageType.class,
    GetPartyListMessageType.class,
    SecureCaseMessageType.class,
    RequestCourtDateRequestMessageType.class,
    GetFilingServiceMessageType.class,
    GetServiceInformationHistoryMessageType.class,
    GetServiceTypesMessageType.class,
    GetCaseHearingsMessageType.class,
    GetCaseRequestMessageType.class,
    GetPartyMessageType.class
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
