package edu.suffolk.litlab.efsp.tyler;

import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;
import tyler.efm.EfmFirmService;

public class TylerFirmFactory {
  private final EfmFirmService firmService;
  private final TylerVersion version;

  public TylerFirmFactory(EfmFirmService firmService, TylerVersion version) {
    this.firmService = firmService;
    this.version = version;
  }

  public TylerFirmClient makeFirmClient(Consumer<BindingProvider> setup) {
    return new TylerFirmClient(firmService, version, setup);
  }
}
