package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.1
 * 2023-08-23T13:45:39.740-04:00
 * Generated source version: 4.0.1
 *
 */
@WebServiceClient(name = "FilingReviewMDEService",
                  wsdlLocation = "file:illinois-ecf5-FilingReviewMDEService.wsdl",
                  targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/FilingReviewMDE")
public class FilingReviewMDEService extends Service {

    public final static QName SERVICE = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/FilingReviewMDE", "FilingReviewMDEService");
    public final static QName FilingReviewMDE = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0WSDL/FilingReviewMDE", "FilingReviewMDE");

    public FilingReviewMDEService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public FilingReviewMDEService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
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
     *     returns FilingReviewMDE
     */
    @WebEndpoint(name = "FilingReviewMDE")
    public FilingReviewMDE getFilingReviewMDE() {
        return super.getPort(FilingReviewMDE, FilingReviewMDE.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FilingReviewMDE
     */
    @WebEndpoint(name = "FilingReviewMDE")
    public FilingReviewMDE getFilingReviewMDE(WebServiceFeature... features) {
        return super.getPort(FilingReviewMDE, FilingReviewMDE.class, features);
    }

}
