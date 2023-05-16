package tyler.ecf.v5_0.extensions.tylerfilingassemblymde;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.1
 * 2023-10-02T16:05:58.934-04:00
 * Generated source version: 4.0.1
 *
 */
@WebServiceClient(name = "TylerFilingAssemblyMDEService",
                  wsdlLocation = "file:illinois-ecf5-TylerFilingAssemblyMDEService.wsdl",
                  targetNamespace = "urn:tyler:ecf:v5.0:extensions:TylerFilingAssemblyMDE")
public class TylerFilingAssemblyMDEService extends Service {

    public final static QName SERVICE = new QName("urn:tyler:ecf:v5.0:extensions:TylerFilingAssemblyMDE", "TylerFilingAssemblyMDEService");
    public final static QName TylerFilingAssemblyMDE = new QName("urn:tyler:ecf:v5.0:extensions:TylerFilingAssemblyMDE", "TylerFilingAssemblyMDE");

    public TylerFilingAssemblyMDEService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TylerFilingAssemblyMDEService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TylerFilingAssemblyMDEService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public TylerFilingAssemblyMDEService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns TylerFilingAssemblyMDE
     */
    @WebEndpoint(name = "TylerFilingAssemblyMDE")
    public TylerFilingAssemblyMDE getTylerFilingAssemblyMDE() {
        return super.getPort(TylerFilingAssemblyMDE, TylerFilingAssemblyMDE.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TylerFilingAssemblyMDE
     */
    @WebEndpoint(name = "TylerFilingAssemblyMDE")
    public TylerFilingAssemblyMDE getTylerFilingAssemblyMDE(WebServiceFeature... features) {
        return super.getPort(TylerFilingAssemblyMDE, TylerFilingAssemblyMDE.class, features);
    }

}
