
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.filingassemblymde;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import tyler.efm.wsdl.webservicesprofile_implementation_5_0.FilingAssemblyMDEService;

/**
 * This class was generated by Apache CXF 3.5.0-SNAPSHOT-3e40a2387febaf00f47fe893d97ffdf63aaa4626
 * 2021-11-08T17:36:27.139-05:00
 * Generated source version: 3.5.0-SNAPSHOT
 *
 */
public final class FilingAssemblyMDE_FilingAssemblyMDEPort_Client {

    private static final QName SERVICE_NAME = new QName("urn:tyler:efm:wsdl:WebServicesProfile-Implementation-5.0", "FilingAssemblyMDEService");

    private FilingAssemblyMDE_FilingAssemblyMDEPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = FilingAssemblyMDEService.WSDL_LOCATION;
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

        FilingAssemblyMDEService ss = new FilingAssemblyMDEService(wsdlURL, SERVICE_NAME);
        FilingAssemblyMDE port = ss.getFilingAssemblyMDEPort();

        {
        System.out.println("Invoking notifyCourtDate...");
        https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyCourtDateRequestType _notifyCourtDate_body = null;
        https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyCourtDateResponseType _notifyCourtDate__return = port.notifyCourtDate(_notifyCourtDate_body);
        System.out.println("notifyCourtDate.result=" + _notifyCourtDate__return);


        }
        {
        System.out.println("Invoking notifyFilingReviewComplete...");
        https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyFilingReviewCompleteRequestType _notifyFilingReviewComplete_body = null;
        //ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyFilingReviewCompleteResponseType _notifyFilingReviewComplete__return = port.notifyFilingReviewComplete(_notifyFilingReviewComplete_body);
        //System.out.println("notifyFilingReviewComplete.result=" + _notifyFilingReviewComplete__return);


        }

        System.exit(0);
    }

}
