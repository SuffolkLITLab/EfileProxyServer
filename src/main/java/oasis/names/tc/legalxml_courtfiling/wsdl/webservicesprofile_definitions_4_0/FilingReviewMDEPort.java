package oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 4.0.4
 * 2024-06-17T22:55:22.158-04:00
 * Generated source version: 4.0.4
 *
 */
@WebService(targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0", name = "FilingReviewMDEPort")
@XmlSeeAlso({tyler.ecf.extensions.filingdetailresponsemessage.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.ObjectFactory.class, gov.niem.niem.iso_4217._2.ObjectFactory.class, tyler.ecf.extensions.eventcallbackmessage.ObjectFactory.class, tyler.ecf.extensions.serviceinformationhistoryresponsemessage.ObjectFactory.class, tyler.ecf.extensions.servicetypesresponsemessage.ObjectFactory.class, gov.niem.niem.proxy.xsd._2.ObjectFactory.class, gov.niem.niem.domains.screening._2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.documentresponsemessage_4.ObjectFactory.class, tyler.ecf.extensions.cancelfilingresponsemessage.ObjectFactory.class, tyler.ecf.extensions.createcasemessage.ObjectFactory.class, gov.niem.niem.usps_states._2.ObjectFactory.class, org.w3._2000._09.xmldsig_.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.servicereceiptmessage_4.ObjectFactory.class, gov.niem.niem.structures._2.ObjectFactory.class, tyler.ecf.extensions.filingserviceresponsemessage.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ObjectFactory.class, gov.niem.niem.ansi_d20._2.ObjectFactory.class, tyler.ecf.extensions.serviceinformationhistoryquerymessage.ObjectFactory.class, tyler.ecf.extensions.servicetypesrequestmessage.ObjectFactory.class, gov.niem.niem.fips_10_4._2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationresponsemessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingcallbackmessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.ObjectFactory.class, tyler.ecf.extensions.filingservicequerymessage.ObjectFactory.class, gov.niem.niem.iso_639_3._2.ObjectFactory.class, oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistresponsemessage_4.ObjectFactory.class, gov.niem.niem.fips_6_4._2.ObjectFactory.class, tyler.ecf.extensions.serviceattachcaselistquerymessage.ObjectFactory.class, gov.niem.niem.fbi._2.ObjectFactory.class, tyler.ecf.extensions.massachusetts.ObjectFactory.class, gov.niem.niem.domains.jxdm._4.ObjectFactory.class, tyler.ecf.extensions.serviceattachcaselistresponsemessage.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.ObjectFactory.class, tyler.ecf.extensions.criminal.ObjectFactory.class, tyler.ecf.extensions.cancelfilingmessage.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.ObjectFactory.class, tyler.ecf.extensions.securecasemessage.ObjectFactory.class, un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.ObjectFactory.class, tyler.ecf.extensions.notifyservicemessage.ObjectFactory.class, tyler.ecf.extensions.createcasecallbackmessage.ObjectFactory.class, gov.niem.niem.ansi_nist._2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory.class, oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.appinfo_4.ObjectFactory.class, tyler.ecf.extensions.servicecallbackmessage.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.documentquerymessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingmessage_4.ObjectFactory.class, gov.niem.niem.appinfo._2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.ObjectFactory.class, oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationresponsemessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationquerymessage_4.ObjectFactory.class, tyler.ecf.extensions.filingdetailquerymessage.ObjectFactory.class, gov.niem.niem.niem_core._2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.ObjectFactory.class, gov.niem.niem.unece_rec20_misc._2.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory.class, tyler.ecf.extensions.common.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentreceiptmessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.ObjectFactory.class, oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.ObjectFactory.class, tyler.ecf.extensions.notifyreceiptmessage.ObjectFactory.class, gov.niem.niem.nonauthoritative_code._2.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface FilingReviewMDEPort {

    @WebMethod(operationName = "NotifyDocketingComplete", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/NotifyDocketingCompleteRequest")
    @WebResult(name = "MessageReceiptMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:MessageReceiptMessage-4.0", partName = "MessageReceiptMessage")
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType notifyDocketingComplete(

        @WebParam(partName = "RecordDocketingCallbackMessage", name = "RecordDocketingCallbackMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingCallbackMessage-4.0")
        oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingcallbackmessage_4.RecordDocketingCallbackMessageType recordDocketingCallbackMessage
    );

    @WebMethod(operationName = "GetFilingList", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/GetFilingListRequest")
    @WebResult(name = "FilingListResponseMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingListResponseMessage-4.0", partName = "FilingListResponseMessage")
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.FilingListResponseMessageType getFilingList(

        @WebParam(partName = "FilingListQueryMessage", name = "FilingListQueryMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingListQueryMessage-4.0")
        oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.FilingListQueryMessageType filingListQueryMessage
    );

    @WebMethod(operationName = "GetFilingService", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/GetFilingServiceRequest")
    @WebResult(name = "FilingServiceResponseMessage", targetNamespace = "urn:tyler:ecf:extensions:FilingServiceResponseMessage", partName = "FilingServiceResponseMessage")
    public tyler.ecf.extensions.filingserviceresponsemessage.FilingServiceResponseMessageType getFilingService(

        @WebParam(partName = "FilingServiceQueryMessage", name = "FilingServiceQueryMessage", targetNamespace = "urn:tyler:ecf:extensions:FilingServiceQueryMessage")
        tyler.ecf.extensions.filingservicequerymessage.FilingServiceQueryMessageType filingServiceQueryMessage
    );

    @WebMethod(operationName = "ReviewFiling", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/ReviewFilingRequest")
    @WebResult(name = "MessageReceiptMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:MessageReceiptMessage-4.0", partName = "MessageReceiptMessage")
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType reviewFiling(

        @WebParam(partName = "ReviewFilingRequestMessage", name = "ReviewFilingRequestMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0")
        oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ReviewFilingRequestMessageType reviewFilingRequestMessage
    );

    @WebMethod(operationName = "GetFeesCalculation", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/GetFeesCalculationRequest")
    @WebResult(name = "FeesCalculationResponseMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FeesCalculationResponseMessage-4.0", partName = "FeesCalculationResponseMessage")
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationresponsemessage_4.FeesCalculationResponseMessageType getFeesCalculation(

        @WebParam(partName = "FeesCalculationQueryMessage", name = "FeesCalculationQueryMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FeesCalculationQueryMessage-4.0")
        oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.FeesCalculationQueryMessageType feesCalculationQueryMessage
    );

    @WebMethod(operationName = "CancelFiling", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/CancelFilingRequest")
    @WebResult(name = "CancelFilingResponseMessage", targetNamespace = "urn:tyler:ecf:extensions:CancelFilingResponseMessage", partName = "CancelFilingResponseMessage")
    public tyler.ecf.extensions.cancelfilingresponsemessage.CancelFilingResponseMessageType cancelFiling(

        @WebParam(partName = "CancelFilingMessage", name = "CancelFilingMessage", targetNamespace = "urn:tyler:ecf:extensions:CancelFilingMessage")
        tyler.ecf.extensions.cancelfilingmessage.CancelFilingMessageType cancelFilingMessage
    );

    @WebMethod(operationName = "GetFilingStatus", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/GetFilingStatusRequest")
    @WebResult(name = "FilingStatusResponseMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingStatusResponseMessage-4.0", partName = "FilingStatusReponseMessage")
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4.FilingStatusResponseMessageType getFilingStatus(

        @WebParam(partName = "FilingStatusQueryMessage", name = "FilingStatusQueryMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FilingStatusQueryMessage-4.0")
        oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.FilingStatusQueryMessageType filingStatusQueryMessage
    );

    @WebMethod(operationName = "GetPolicy", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/GetPolicyRequest")
    @WebResult(name = "CourtPolicyResponseMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", partName = "CourtPolicyResponseMessage")
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType getPolicy(

        @WebParam(partName = "CourtPolicyQueryMessage", name = "CourtPolicyQueryMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyQueryMessage-4.0")
        oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType courtPolicyQueryMessage
    );

    @WebMethod(operationName = "GetServiceTypes", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/GetServiceTypesRequest")
    @WebResult(name = "ServiceTypesResponseMessage", targetNamespace = "urn:tyler:ecf:extensions:ServiceTypesResponseMessage", partName = "ServiceTypesResponseMessage")
    public tyler.ecf.extensions.servicetypesresponsemessage.ServiceTypesResponseMessageType getServiceTypes(

        @WebParam(partName = "ServiceTypesRequestMessage", name = "ServiceTypesRequestMessage", targetNamespace = "urn:tyler:ecf:extensions:ServiceTypesRequestMessage")
        tyler.ecf.extensions.servicetypesrequestmessage.ServiceTypesRequestMessageType serviceTypesRequestMessage
    );

    @WebMethod(operationName = "NotifyCaseAssignmentComplete", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/NotifyCaseAssignmentCompleteRequest")
    @WebResult(name = "MessageReceiptMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:MessageReceiptMessage-4.0", partName = "MessageReceiptMessage")
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType notifyCaseAssignmentComplete(

        @WebParam(partName = "CreateCaseCallbackMessage", name = "CreateCaseCallbackMessage", targetNamespace = "urn:tyler:ecf:extensions:CreateCaseCallbackMessage")
        tyler.ecf.extensions.createcasecallbackmessage.CreateCaseCallbackMessageType createCaseCallbackMessage
    );

    @WebMethod(operationName = "GetFilingDetails", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/GetFilingDetailsRequest")
    @WebResult(name = "FilingDetailResponseMessage", targetNamespace = "urn:tyler:ecf:extensions:FilingDetailResponseMessage", partName = "FilingDetailResponseMessage")
    public tyler.ecf.extensions.filingdetailresponsemessage.FilingDetailResponseMessageType getFilingDetails(

        @WebParam(partName = "FilingDetailQueryMessage", name = "FilingDetailQueryMessage", targetNamespace = "urn:tyler:ecf:extensions:FilingDetailQueryMessage")
        tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType filingDetailQueryMessage
    );

    @WebMethod(operationName = "SecureCase", action = "urn:oasis:names:tc:legalxml-courtfiling:wsdl:WebServicesProfile-Definitions-4.0/FilingReviewMDEPort/SecureCaseRequest")
    @WebResult(name = "MessageReceiptMessage", targetNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:MessageReceiptMessage-4.0", partName = "MessageReceiptMessage")
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType secureCase(

        @WebParam(partName = "SecureCaseMessage", name = "SecureCaseMessage", targetNamespace = "urn:tyler:ecf:extensions:SecureCaseMessage")
        tyler.ecf.extensions.securecasemessage.SecureCaseMessageType secureCaseMessage
    );
}
