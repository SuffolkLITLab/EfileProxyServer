package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.servicemde;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.1
 * 2023-08-23T20:31:44.930-04:00
 * Generated source version: 4.0.1
 *
 */
@WebServiceClient(name = "ServiceMDEService",
                  wsdlLocation = "file:illinois-ecf5-ServiceMDEService.wsdl",
                  targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/ServiceMDE")
public class ServiceMDEService extends Service {

    public final static QName SERVICE = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/ServiceMDE", "ServiceMDEService");
    public final static QName ServiceMDE = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/ServiceMDE", "ServiceMDE");

    public ServiceMDEService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServiceMDEService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServiceMDEService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ServiceMDEService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns ServiceMDE
     */
    @WebEndpoint(name = "ServiceMDE")
    public ServiceMDE getServiceMDE() {
        return super.getPort(ServiceMDE, ServiceMDE.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServiceMDE
     */
    @WebEndpoint(name = "ServiceMDE")
    public ServiceMDE getServiceMDE(WebServiceFeature... features) {
        return super.getPort(ServiceMDE, ServiceMDE.class, features);
    }

}
