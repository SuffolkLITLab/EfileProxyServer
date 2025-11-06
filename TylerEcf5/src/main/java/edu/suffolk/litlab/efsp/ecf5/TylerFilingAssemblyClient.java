package edu.suffolk.litlab.efsp.ecf5;

import java.util.function.Consumer;

import ecf5.TylerFilingAssemblyMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;

public class TylerFilingAssemblyClient {
    private ecf5.v2024_6.tyler.ecf.v5_0.extensions.tylerfilingassemblymde.TylerFilingAssemblyMDE v2024Port;
    private TylerVersion version;

    public TylerFilingAssemblyClient(TylerFilingAssemblyMDEService factory, TylerVersion version, Consumer<BindingProvider> setup) {
        this.version = version;
        switch(version) {
            case v2022_1:
              this.v2024Port = factory.getTylerFilingAssemblyMDE();
              break;
            case v2024_6:
              this.v2024Port = factory.getTylerFilingAssemblyMDE();
              break;
            case v2025_0:
              this.v2024Port = factory.getTylerFilingAssemblyMDE();
              break;
            default:
              this.v2024Port = factory.getTylerFilingAssemblyMDE();
              break;
        }
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.NotifyEventResponseType notifyEvent(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.NotifyEventRequestType body
    ) {
      return v2024Port.notifyEvent(body);
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.CaptureFeesResponseType captureFees(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.CaptureFeesRequestType body
    ) {
      return v2024Port.captureFees(body);
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.NotifyBatchCompleteResponseType notifyBatchComplete(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.NotifyBatchCompleteRequestType body
    ) {
      return v2024Port.notifyBatchComplete(body);
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.NotifyServiceCompleteResponseType notifyServiceComplete(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.NotifyServiceCompleteRequestType body
    ) {
      return v2024Port.notifyServiceComplete(body);
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.UpdateFeesResponseType updateFees(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.UpdateFeesRequestType body
    ) {
      return v2024Port.updateFees(body);
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.NotifyEnvelopeCompleteResponseType notifyEnvelopeComplete(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.NotifyEnvelopeCompleteRequestType body
    ) {
      return v2024Port.notifyEnvelopeComplete(body);
    }
    
}
