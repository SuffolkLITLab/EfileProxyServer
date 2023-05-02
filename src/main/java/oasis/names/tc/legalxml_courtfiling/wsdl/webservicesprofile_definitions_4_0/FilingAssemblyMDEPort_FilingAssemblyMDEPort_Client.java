package oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import javax.xml.namespace.QName;
import jakarta.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SoapX509CallbackHandler;
import edu.suffolk.litlab.efspserver.services.EfmModuleSetup;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.FilingStatusType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.messagereceiptmessage_4.MessageReceiptMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ReviewFilingCallbackMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.NotifyFilingReviewCompleteRequestMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.ObjectFactory;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingAssemblyMDEService;

public class FilingAssemblyMDEPort_FilingAssemblyMDEPort_Client {
    private static Logger log = 
        LoggerFactory.getLogger(FilingAssemblyMDEPort_FilingAssemblyMDEPort_Client.class); 

    private static final QName SERVICE_NAME = new QName("urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0", "FilingAssemblyMDEService");

    private FilingAssemblyMDEPort_FilingAssemblyMDEPort_Client() {
    }

    /** mvn exec:java@filingassemblyclient */
    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = null; //FilingAssemblyMDEService.WSDL_LOCATION;
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

        Optional<String> maybeX509Password = EfmModuleSetup.GetEnv("X509_PASSWORD");
        SoapX509CallbackHandler.setX509Password(maybeX509Password.get());
        FilingAssemblyMDEService ss = new FilingAssemblyMDEService(wsdlURL, SERVICE_NAME);
        FilingAssemblyMDEPort port = ss.getFilingAssemblyMDEPort();
        ServiceHelpers.setupServicePort((BindingProvider) port);
        ObjectFactory fac = new ObjectFactory();
        oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ObjectFactory revObjFac = 
            new oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ObjectFactory();
        NotifyFilingReviewCompleteRequestMessageType t = fac.createNotifyFilingReviewCompleteRequestMessageType();
        ReviewFilingCallbackMessageType msg = revObjFac.createReviewFilingCallbackMessageType();
        FilingStatusType fst = new FilingStatusType();
        fst.setFilingStatusCode("Good");
        msg.setFilingStatus(fst);
        t.setReviewFilingCallbackMessage(msg);
        
        MessageReceiptMessageType mrmt = port.notifyFilingReviewComplete(t);
        log.info(mrmt.toString());

    }

}
