
package oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.2
 * 2022-05-03T17:24:39.246-04:00
 * Generated source version: 3.5.2
 *
 */
public final class FilingReviewMDEPort_FilingReviewMDEPort_Client {

    private static final QName SERVICE_NAME = new QName("urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0", "FilingReviewMDEService");

    private FilingReviewMDEPort_FilingReviewMDEPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = FilingReviewMDEService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        FilingReviewMDEService ss = new FilingReviewMDEService(wsdlURL, SERVICE_NAME);
        FilingReviewMDEPort port = ss.getFilingReviewMDEPort();

        {
        System.out.println("Invoking notifyDocketingComplete...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingcallbackmessage_4.RecordDocketingCallbackMessageType _notifyDocketingComplete_recordDocketingCallbackMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType _notifyDocketingComplete__return = port.notifyDocketingComplete(_notifyDocketingComplete_recordDocketingCallbackMessage);
        System.out.println("notifyDocketingComplete.result=" + _notifyDocketingComplete__return);


        }
        {
        System.out.println("Invoking getFilingList...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.FilingListQueryMessageType _getFilingList_filingListQueryMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.FilingListResponseMessageType _getFilingList__return = port.getFilingList(_getFilingList_filingListQueryMessage);
        System.out.println("getFilingList.result=" + _getFilingList__return);


        }
        {
        System.out.println("Invoking getFilingService...");
        tyler.ecf.extensions.filingservicequerymessage.FilingServiceQueryMessageType _getFilingService_filingServiceQueryMessage = null;
        tyler.ecf.extensions.filingserviceresponsemessage.FilingServiceResponseMessageType _getFilingService__return = port.getFilingService(_getFilingService_filingServiceQueryMessage);
        System.out.println("getFilingService.result=" + _getFilingService__return);


        }
        {
        System.out.println("Invoking reviewFiling...");
        oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ReviewFilingRequestMessageType _reviewFiling_reviewFilingRequestMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType _reviewFiling__return = port.reviewFiling(_reviewFiling_reviewFilingRequestMessage);
        System.out.println("reviewFiling.result=" + _reviewFiling__return);


        }
        {
        System.out.println("Invoking getFeesCalculation...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.FeesCalculationQueryMessageType _getFeesCalculation_feesCalculationQueryMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationresponsemessage_4.FeesCalculationResponseMessageType _getFeesCalculation__return = port.getFeesCalculation(_getFeesCalculation_feesCalculationQueryMessage);
        System.out.println("getFeesCalculation.result=" + _getFeesCalculation__return);


        }
        {
        System.out.println("Invoking cancelFiling...");
        tyler.ecf.extensions.cancelfilingmessage.CancelFilingMessageType _cancelFiling_cancelFilingMessage = null;
        tyler.ecf.extensions.cancelfilingresponsemessage.CancelFilingResponseMessageType _cancelFiling__return = port.cancelFiling(_cancelFiling_cancelFilingMessage);
        System.out.println("cancelFiling.result=" + _cancelFiling__return);


        }
        {
        System.out.println("Invoking getFilingStatus...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.FilingStatusQueryMessageType _getFilingStatus_filingStatusQueryMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4.FilingStatusResponseMessageType _getFilingStatus__return = port.getFilingStatus(_getFilingStatus_filingStatusQueryMessage);
        System.out.println("getFilingStatus.result=" + _getFilingStatus__return);


        }
        {
        System.out.println("Invoking getPolicy...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType _getPolicy_courtPolicyQueryMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType _getPolicy__return = port.getPolicy(_getPolicy_courtPolicyQueryMessage);
        System.out.println("getPolicy.result=" + _getPolicy__return);


        }
        {
        System.out.println("Invoking getServiceTypes...");
        tyler.ecf.extensions.servicetypesrequestmessage.ServiceTypesRequestMessageType _getServiceTypes_serviceTypesRequestMessage = null;
        tyler.ecf.extensions.servicetypesresponsemessage.ServiceTypesResponseMessageType _getServiceTypes__return = port.getServiceTypes(_getServiceTypes_serviceTypesRequestMessage);
        System.out.println("getServiceTypes.result=" + _getServiceTypes__return);


        }
        {
        System.out.println("Invoking notifyCaseAssignmentComplete...");
        tyler.ecf.extensions.createcasecallbackmessage.CreateCaseCallbackMessageType _notifyCaseAssignmentComplete_createCaseCallbackMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType _notifyCaseAssignmentComplete__return = port.notifyCaseAssignmentComplete(_notifyCaseAssignmentComplete_createCaseCallbackMessage);
        System.out.println("notifyCaseAssignmentComplete.result=" + _notifyCaseAssignmentComplete__return);


        }
        {
        System.out.println("Invoking getFilingDetails...");
        tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType _getFilingDetails_filingDetailQueryMessage = null;
        tyler.ecf.extensions.filingdetailresponsemessage.FilingDetailResponseMessageType _getFilingDetails__return = port.getFilingDetails(_getFilingDetails_filingDetailQueryMessage);
        System.out.println("getFilingDetails.result=" + _getFilingDetails__return);


        }
        {
        System.out.println("Invoking secureCase...");
        tyler.ecf.extensions.securecasemessage.SecureCaseMessageType _secureCase_secureCaseMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType _secureCase__return = port.secureCase(_secureCase_secureCaseMessage);
        System.out.println("secureCase.result=" + _secureCase__return);


        }

        System.exit(0);
    }

}
