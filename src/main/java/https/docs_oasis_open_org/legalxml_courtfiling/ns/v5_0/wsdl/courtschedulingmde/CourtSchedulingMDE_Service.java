package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.1-SNAPSHOT-f8d1850dc906be4ac45e2630ae30961b20228938
 * 2023-05-02T17:42:51.641-04:00
 * Generated source version: 4.0.1-SNAPSHOT
 *
 */
@WebServiceClient(name = "CourtSchedulingMDE",
                  wsdlLocation = "file:illinois-CourtSchedulingMDE.wsdl",
                  targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE")
public class CourtSchedulingMDE_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE", "CourtSchedulingMDE");
    public final static QName CourtSchedulingMDEPort = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE", "CourtSchedulingMDEPort");
    static {
        URL url = null;
        try {
            url = new URL("file:illinois-CourtSchedulingMDE.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CourtSchedulingMDE_Service.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:illinois-CourtSchedulingMDE.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CourtSchedulingMDE_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CourtSchedulingMDE_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CourtSchedulingMDE_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    public CourtSchedulingMDE_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CourtSchedulingMDE_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CourtSchedulingMDE_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns CourtSchedulingMDE
     */
    @WebEndpoint(name = "CourtSchedulingMDEPort")
    public CourtSchedulingMDE getCourtSchedulingMDEPort() {
        return super.getPort(CourtSchedulingMDEPort, CourtSchedulingMDE.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CourtSchedulingMDE
     */
    @WebEndpoint(name = "CourtSchedulingMDEPort")
    public CourtSchedulingMDE getCourtSchedulingMDEPort(WebServiceFeature... features) {
        return super.getPort(CourtSchedulingMDEPort, CourtSchedulingMDE.class, features);
    }

}
