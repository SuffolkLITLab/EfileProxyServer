package tyler.efm.wsdl.webservicesprofile_implementation_4_0;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import tyler.efm.services.EfmUserService;

/**
 * This class was generated by Apache CXF 3.5.0-SNAPSHOT-4da29ea7d55227c652b930318666639adae0c77d
 * 2021-04-14T22:30:50.504-04:00
 * Generated source version: 3.5.0-SNAPSHOT
 *
 */
@WebServiceClient(name = "FilingReviewMDEService",
                  wsdlLocation = "classpath:wsdl/ECF-4.0-FilingReviewMDEService.wsdl",
                  targetNamespace = "urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0")
public class FilingReviewMDEService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0", "FilingReviewMDEService");
    public final static QName FilingReviewMDEPort = new QName("urn:tyler:efm:wsdl:WebServicesProfile-Implementation-4.0", "FilingReviewMDEPort");
    static {
        URL url = FilingReviewMDEService.class.getClassLoader().getResource("wsdl/filingreview/ecf.wsdl"); //ECF-4.0-FilingReviewMDEService.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(EfmUserService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/ECF-4.0-FilingReviewMDEService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public FilingReviewMDEService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public FilingReviewMDEService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FilingReviewMDEService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public FilingReviewMDEService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public FilingReviewMDEService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public FilingReviewMDEService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns FilingReviewMDEPort
     */
    @WebEndpoint(name = "FilingReviewMDEPort")
    public FilingReviewMDEPort getFilingReviewMDEPort() {
        return super.getPort(FilingReviewMDEPort, FilingReviewMDEPort.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FilingReviewMDEPort
     */
    @WebEndpoint(name = "FilingReviewMDEPort")
    public FilingReviewMDEPort getFilingReviewMDEPort(WebServiceFeature... features) {
        return super.getPort(FilingReviewMDEPort, FilingReviewMDEPort.class, features);
    }

}
