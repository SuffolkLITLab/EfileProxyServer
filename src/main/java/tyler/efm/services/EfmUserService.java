package tyler.efm.services;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * This class was generated by Apache CXF 4.0.4
 * 2024-06-17T22:54:34.701-04:00
 * Generated source version: 4.0.4
 *
 */
@WebServiceClient(name = "EfmUserService",
                  wsdlLocation = "file:illinois-EFMUserServiceSingle.svc.wsdl",
                  targetNamespace = "urn:tyler:efm:services")
public class EfmUserService extends Service {

    public static final QName SERVICE = new QName("urn:tyler:efm:services", "EfmUserService");
    public static final QName BasicHttpBindingIEfmUserService = new QName("urn:tyler:efm:services", "BasicHttpBinding_IEfmUserService");
    public static final QName BasicHttpBindingIEfmUserService1 = new QName("urn:tyler:efm:services", "BasicHttpBinding_IEfmUserService1");

    public EfmUserService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EfmUserService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EfmUserService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EfmUserService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns IEfmUserService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmUserService")
    public IEfmUserService getBasicHttpBindingIEfmUserService() {
        return super.getPort(BasicHttpBindingIEfmUserService, IEfmUserService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IEfmUserService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmUserService")
    public IEfmUserService getBasicHttpBindingIEfmUserService(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIEfmUserService, IEfmUserService.class, features);
    }


    /**
     *
     * @return
     *     returns IEfmUserService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmUserService1")
    public IEfmUserService getBasicHttpBindingIEfmUserService1() {
        return super.getPort(BasicHttpBindingIEfmUserService1, IEfmUserService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IEfmUserService
     */
    @WebEndpoint(name = "BasicHttpBinding_IEfmUserService1")
    public IEfmUserService getBasicHttpBindingIEfmUserService1(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIEfmUserService1, IEfmUserService.class, features);
    }

}
