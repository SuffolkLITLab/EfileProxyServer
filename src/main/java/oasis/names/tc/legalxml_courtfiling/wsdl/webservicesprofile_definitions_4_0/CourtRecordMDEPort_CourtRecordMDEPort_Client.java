
package oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;

/**
 * This class was generated by Apache CXF 3.5.0-SNAPSHOT-3e40a2387febaf00f47fe893d97ffdf63aaa4626
 * 2021-07-21T17:05:34.856-04:00
 * Generated source version: 3.5.0-SNAPSHOT
 *
 */
public final class CourtRecordMDEPort_CourtRecordMDEPort_Client {

    private static final QName SERVICE_NAME = new QName("urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0", "CourtRecordMDEService");

    private CourtRecordMDEPort_CourtRecordMDEPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CourtRecordMDEService.WSDL_LOCATION;
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

        CourtRecordMDEService ss = new CourtRecordMDEService(wsdlURL, SERVICE_NAME);
        CourtRecordMDEPort port = ss.getCourtRecordMDEPort();

        {
        System.out.println("Invoking recordFiling...");
        oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.RecordFilingRequestMessageType _recordFiling_recordFilingRequestMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType _recordFiling__return = port.recordFiling(_recordFiling_recordFilingRequestMessage);
        System.out.println("recordFiling.result=" + _recordFiling__return);


        }
        {
        System.out.println("Invoking notifyService...");
        tyler.ecf.extensions.notifyservicemessage.NotifyServiceMessageType _notifyService_notifyServiceMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType _notifyService__return = port.notifyService(_notifyService_notifyServiceMessage);
        System.out.println("notifyService.result=" + _notifyService__return);


        }
        {
        System.out.println("Invoking createCase...");
        tyler.ecf.extensions.createcasemessage.CreateCaseMessageType _createCase_createCaseMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType _createCase__return = port.createCase(_createCase_createCaseMessage);
        System.out.println("createCase.result=" + _createCase__return);


        }
        {
        System.out.println("Invoking notifyReceiptComplete...");
        tyler.ecf.extensions.notifyreceiptmessage.NotifyReceiptMessageType _notifyReceiptComplete_notifyReceiptMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType _notifyReceiptComplete__return = port.notifyReceiptComplete(_notifyReceiptComplete_notifyReceiptMessage);
        System.out.println("notifyReceiptComplete.result=" + _notifyReceiptComplete__return);


        }
        {
        System.out.println("Invoking getCase...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryMessageType _getCase_caseQueryMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType _getCase__return = port.getCase(_getCase_caseQueryMessage);
        System.out.println("getCase.result=" + _getCase__return);


        }
        {
        System.out.println("Invoking getServiceAttachCaseList...");
        tyler.ecf.extensions.serviceattachcaselistquerymessage.ServiceAttachCaseListQueryMessageType _getServiceAttachCaseList_serviceAttachCaseListQueryMessage = null;
        tyler.ecf.extensions.serviceattachcaselistresponsemessage.ServiceAttachCaseListResponseMessageType _getServiceAttachCaseList__return = port.getServiceAttachCaseList(_getServiceAttachCaseList_serviceAttachCaseListQueryMessage);
        System.out.println("getServiceAttachCaseList.result=" + _getServiceAttachCaseList__return);


        }
        {
        System.out.println("Invoking getCaseList...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseListQueryMessageType _getCaseList_caseListQueryMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistresponsemessage_4.CaseListResponseMessageType _getCaseList__return = port.getCaseList(_getCaseList_caseListQueryMessage);
        System.out.println("getCaseList.result=" + _getCaseList__return);


        }
        {
        System.out.println("Invoking getDocument...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.documentquerymessage_4.DocumentQueryMessageType _getDocument_documentQueryMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.documentresponsemessage_4.DocumentResponseMessageType _getDocument__return = port.getDocument(_getDocument_documentQueryMessage);
        System.out.println("getDocument.result=" + _getDocument__return);


        }
        {
        System.out.println("Invoking getServiceInformation...");
        oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationquerymessage_4.ServiceInformationQueryMessageType _getServiceInformation_serviceInformationQueryMessage = null;
        oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationresponsemessage_4.ServiceInformationResponseMessageType _getServiceInformation__return = port.getServiceInformation(_getServiceInformation_serviceInformationQueryMessage);
        System.out.println("getServiceInformation.result=" + _getServiceInformation__return);


        }
        {
        System.out.println("Invoking getServiceInformationHistory...");
        tyler.ecf.extensions.serviceinformationhistoryquerymessage.ServiceInformationHistoryQueryMessageType _getServiceInformationHistory_serviceInformationHistoryQueryMessage = null;
        tyler.ecf.extensions.serviceinformationhistoryresponsemessage.ServiceInformationHistoryResponseMessageType _getServiceInformationHistory__return = port.getServiceInformationHistory(_getServiceInformationHistory_serviceInformationHistoryQueryMessage);
        System.out.println("getServiceInformationHistory.result=" + _getServiceInformationHistory__return);


        }

        System.exit(0);
    }

}
