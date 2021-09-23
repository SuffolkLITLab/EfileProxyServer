package edu.suffolk.litlab.efspserver.jeffnet;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Set;

import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.services.EfmFilingInterface;
import edu.suffolk.litlab.efspserver.services.EfmModuleSetup;
import edu.suffolk.litlab.efspserver.services.EfmRestCallbackInterface;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;

public class JeffNetModuleSetup implements EfmModuleSetup {
  private URI jeffnetEndpoint;
  private UserDatabase ud;
  private OrgMessageSender sender;

  private JeffNetModuleSetup(URI jeffnetUri,
      UserDatabase ud, OrgMessageSender sender) {
    this.jeffnetEndpoint = jeffnetUri;
    this.ud = ud;
    this.sender = sender;
  }

  public static Optional<JeffNetModuleSetup> create(UserDatabase ud, OrgMessageSender sender) throws URISyntaxException {
    Optional<String> maybeJeffersonEndpoint = EfmModuleSetup.GetEnv("JEFFERSON_ENDPOINT");
    if (maybeJeffersonEndpoint.isEmpty()) {
      throw new RuntimeException("JEFFERSON_ENDPOINT needs to be the "
            + "defined. Did you forget to source .env?");
    }

    URI jeffnetUri = new URI(maybeJeffersonEndpoint.get());
    return Optional.of(new JeffNetModuleSetup(jeffnetUri, ud, sender));
  }

  @Override
  public void preSetup() {
    // N/A
  }

  @Override
  public Set<String> getCourts() {
    return Set.of("Jefferson");
  }

  @Override
  public EfmFilingInterface getInterface() {
    return new JeffNetFiler(jeffnetEndpoint);
  }

  @Override
  public Optional<EfmRestCallbackInterface> getCallback() {
    return Optional.of(new JeffNetRestCallback(ud, sender));
  }

  @Override
  public void setupGlobals() {
    // N/A
  }

  @Override
  public void shutdown() {
    // N/A
  }

}
