package edu.suffolk.litlab.efsp.ecf5;

import java.util.function.Consumer;

import ecf5.CourtSchedulingMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;

public class CourtSchedulingClient {
    private ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtschedulingmde.CourtSchedulingMDE v2024Port;
    private TylerVersion version;

    public CourtSchedulingClient(CourtSchedulingMDEService factory, TylerVersion version, Consumer<BindingProvider> setup) {
        this.version = version;
        switch(version) {
            case v2022_1:
                this.v2024Port = factory.getCourtSchedulingMDE();
                setup.accept((BindingProvider) v2024Port);
                break;
            case v2024_6:
              this.v2024Port = factory.getCourtSchedulingMDE();
              setup.accept((BindingProvider) v2024Port);
              break;
            case v2025_0:
              this.v2024Port = factory.getCourtSchedulingMDE();
              setup.accept((BindingProvider) v2024Port);
              break;
            default:
              this.v2024Port = factory.getCourtSchedulingMDE();
              setup.accept((BindingProvider) v2024Port);
              break;
        }
    }

    public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCourtScheduleResponseType getCourtSchedule(
        ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.GetCourtScheduleRequestType body
    ) {
        return v2024Port.getCourtSchedule(body);
    }

    public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.NotifyCourtDateResponseType notifyCourtDate(
        ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.NotifyCourtDateRequestType body
    ) {
        return v2024Port.notifyCourtDate(body);
    }
    
    public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ReserveCourtDateResponseType reserveCourtDate(
        ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ReserveCourtDateRequestType body
    ) {
        return v2024Port.reserveCourtDate(body);
    }

    public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.RequestCourtDateResponseType requestCourtDate(
        ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.RequestCourtDateRequestType body
    ) {
        return v2024Port.requestCourtDate(body);
    }
    
}
