package edu.suffolk.litlab.efsp.ecf5;

import ecf5.TylerCourtSchedulingMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;

public class TylerCourtSchedulingClient {
  private ecf5.v2024_6.tyler.ecf.v5_0.extensions.tylercourtschedulingmde.TylerCourtSchedulingMDE
      v2024Port;
  private TylerVersion version;

  public TylerCourtSchedulingClient(
      TylerCourtSchedulingMDEService factory,
      TylerVersion version,
      Consumer<BindingProvider> setup) {
    this.version = version;
    switch (version) {
      case v2022_1:
        this.v2024Port = factory.getTylerCourtSchedulingMDE();
        break;
      case v2024_6:
        this.v2024Port = factory.getTylerCourtSchedulingMDE();
        break;
      case v2025_0:
        this.v2024Port = factory.getTylerCourtSchedulingMDE();
        break;
      default:
        this.v2024Port = factory.getTylerCourtSchedulingMDE();
        break;
    }
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetReturnDateResponseType getReturnDate(
      ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetReturnDateRequestType body) {
    return v2024Port.getReturnDate(body);
  }
}
