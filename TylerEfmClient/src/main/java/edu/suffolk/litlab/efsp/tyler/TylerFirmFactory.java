package edu.suffolk.litlab.efsp.tyler;

import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;
import tyler.efm.EfmFirmService;

public class TylerFirmFactory {
  private final EfmFirmService firmService;
  private final TylerVersion version;
  private final boolean shouldLogRequests;

  public TylerFirmFactory(
      EfmFirmService firmService, TylerVersion version, boolean shouldLogRequests) {
    this.firmService = firmService;
    this.version = version;
    this.shouldLogRequests = shouldLogRequests;
  }

  public TylerFirmClient makeFirmClient(Consumer<BindingProvider> setup) {
    return new TylerFirmClient(firmService, version, setup, shouldLogRequests);
  }
}
