package edu.suffolk.litlab.efsp.ecf5;

import java.util.function.Consumer;

import ecf5.TylerFilingReviewMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;

public class TylerFilingReviewClient {
    private ecf5.v2024_6.tyler.ecf.v5_0.extensions.tylerfilingreviewmde.TylerFilingReviewMDE v2024Port;
    private TylerVersion version;

    public TylerFilingReviewClient(TylerFilingReviewMDEService factory, TylerVersion version, Consumer<BindingProvider> setup) {
        this.version = version;
        switch(version) {
            case v2022_1:
              this.v2024Port = factory.getTylerFilingReviewMDE();
              break;
            case v2024_6:
              this.v2024Port = factory.getTylerFilingReviewMDE();
              break;
            case v2025_0:
              this.v2024Port = factory.getTylerFilingReviewMDE();
              break;
            default:
              this.v2024Port = factory.getTylerFilingReviewMDE();
              break;
        }
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetBatchListResponseType getBatchList(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetBatchListRequestType body
    ) {
      return v2024Port.getBatchList(body);
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetBatchDetailResponseType getBatchDetail(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetBatchDetailRequestType body
    ) {
      return v2024Port.getBatchDetail(body);
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetFilingServiceResponseType getFilingService(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetFilingServiceRequestType body
    ) {
      return v2024Port.getFilingService(body);
    }

    public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetServiceTypesResponseType getServiceTypes(
        ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetServiceTypesRequestType body
    ) {
      return v2024Port.getServiceTypes(body);
    }
}
