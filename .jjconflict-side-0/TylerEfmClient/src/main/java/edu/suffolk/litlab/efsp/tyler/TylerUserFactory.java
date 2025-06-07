package edu.suffolk.litlab.efsp.tyler;

import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;
import tyler.efm.EfmUserService;

public class TylerUserFactory {
  private final EfmUserService userService;
  private final TylerVersion version;

  public TylerUserFactory(EfmUserService userService, TylerVersion version) {
    this.userService = userService;
    this.version = version;
  }

  public TylerUserClient makeUserClient(Consumer<BindingProvider> setup) {
    return new TylerUserClient(userService, version, setup);
  }
}
