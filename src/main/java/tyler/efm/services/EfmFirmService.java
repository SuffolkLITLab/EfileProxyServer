package tyler.efm.services;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.4
 * 2024-06-17T22:54:14.367-04:00
 * Generated source version: 4.0.4
 *
 */
@WebServiceClient(name = "EfmFirmService",
                  wsdlLocation = "file:illinois-EFMFirmServiceSingle.svc.wsdl",
                  targetNamespace = "urn:tyler:efm:services")
public class EfmFirmService extends Service {

    public static final URL WSDL_LOCATION;

    public static final QName SERVICE = new QName("urn:tyler:efm:services", "EfmFirmService");
    public static final QName BasicHttpBindingIEfmFirmService = new QName("urn:tyler:efm:services", "BasicHttpBinding_IEfmFirmService");
    public static final QName BasicHttpBindingIEfmFirmService1 = new QName("urn:tyler:efm:services", "BasicHttpBinding_IEfmFirmService1");
    static {
        URL url = null;
        try {
            url = new URL("file:illinois-EFMFirmServiceSingle.svc.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EfmFirmService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:illinois-EFMFirmServiceSingle.svc.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EfmFirmService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EfmFirmService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EfmFirmService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public EfmFirmService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EfmFirmService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EfmFirmService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns IEfmFirmService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmFirmService")
    public IEfmFirmService getBasicHttpBindingIEfmFirmService() {
        return super.getPort(BasicHttpBindingIEfmFirmService, IEfmFirmService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IEfmFirmService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmFirmService")
    public IEfmFirmService getBasicHttpBindingIEfmFirmService(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIEfmFirmService, IEfmFirmService.class, features);
    }


    /**
     *
     * @return
     *     returns IEfmFirmService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmFirmService1")
    public IEfmFirmService getBasicHttpBindingIEfmFirmService1() {
        return super.getPort(BasicHttpBindingIEfmFirmService1, IEfmFirmService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IEfmFirmService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmFirmService1")
    public IEfmFirmService getBasicHttpBindingIEfmFirmService1(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIEfmFirmService1, IEfmFirmService.class, features);
    }

}
