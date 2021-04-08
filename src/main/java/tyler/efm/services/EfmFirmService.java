package tyler.efm.services;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.0-SNAPSHOT-4da29ea7d55227c652b930318666639adae0c77d
 * 2021-04-07T12:14:42.396-04:00
 * Generated source version: 3.5.0-SNAPSHOT
 *
 */
@WebServiceClient(name = "EfmFirmService",
                  wsdlLocation = "classpath:wsdl/EFMFirmServiceSingle.svc.wsdl",
                  targetNamespace = "urn:tyler:efm:services")
public class EfmFirmService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:tyler:efm:services", "EfmFirmService");
    public final static QName BasicHttpBindingIEfmFirmService = new QName("urn:tyler:efm:services", "BasicHttpBinding_IEfmFirmService");
    public final static QName BasicHttpBindingIEfmFirmService1 = new QName("urn:tyler:efm:services", "BasicHttpBinding_IEfmFirmService1");
    static {
        URL url = EfmFirmService.class.getClassLoader().getResource("classpath:wsdl/EFMFirmServiceSingle.svc.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(EfmFirmService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/EFMFirmServiceSingle.svc.wsdl");
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
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
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
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IEfmFirmService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmFirmService1")
    public IEfmFirmService getBasicHttpBindingIEfmFirmService1(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIEfmFirmService1, IEfmFirmService.class, features);
    }

}
