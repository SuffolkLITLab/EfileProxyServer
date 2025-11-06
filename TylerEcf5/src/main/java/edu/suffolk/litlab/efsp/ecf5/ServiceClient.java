package edu.suffolk.litlab.efsp.ecf5;

import java.util.function.Consumer;

import ecf5.ServiceMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;

public class ServiceClient {
    private ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.servicemde.ServiceMDE v2024Port;
    private TylerVersion version;

    public ServiceClient(ServiceMDEService factory, TylerVersion version, Consumer<BindingProvider> setup) {
        this.version = version;
        switch(version) {
            case v2022_1:
                this.v2024Port = factory.getServiceMDE();
                setup.accept((BindingProvider) v2024Port);
                break;
            case v2024_6:
              this.v2024Port = factory.getServiceMDE();
              setup.accept((BindingProvider) v2024Port);
              break;
            case v2025_0:
              this.v2024Port = factory.getServiceMDE();
              setup.accept((BindingProvider) v2024Port);
              break;
            default:
              this.v2024Port = factory.getServiceMDE();
              setup.accept((BindingProvider) v2024Port);
              break;
        }
    }

    public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ServeProcessResponseType serveProcess(
        ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ServeProcessRequestType body
    ) {
        return v2024Port.serveProcess(body);
    }

    public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ServeFilingResponseType serveFiling(
        ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ServeFilingRequestType body
    ) {
        return v2024Port.serveFiling(body);
    }
    
}
