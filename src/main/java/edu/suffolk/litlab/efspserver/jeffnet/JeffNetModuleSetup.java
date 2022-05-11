package edu.suffolk.litlab.efspserver.jeffnet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.exceptions.CsvValidationException;

import edu.suffolk.litlab.efspserver.LegalIssuesTaxonomyCodes;
import edu.suffolk.litlab.efspserver.services.EfmFilingInterface;
import edu.suffolk.litlab.efspserver.services.EfmModuleSetup;
import edu.suffolk.litlab.efspserver.services.EfmRestCallbackInterface;
import edu.suffolk.litlab.efspserver.services.EfspServer;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;

public class JeffNetModuleSetup implements EfmModuleSetup {
  private static Logger log =
      LoggerFactory.getLogger(JeffNetModuleSetup.class);

  private final URI jeffnetEndpoint;
  private final DataSource ds;
  private final OrgMessageSender sender;
  private final LegalIssuesTaxonomyCodes taxonomyCodes;

  private JeffNetModuleSetup(URI jeffnetUri,
      DataSource ds, OrgMessageSender sender, LegalIssuesTaxonomyCodes taxonomyCodes) {
    this.jeffnetEndpoint = jeffnetUri;
    this.ds = ds;
    this.sender = sender;
    this.taxonomyCodes = taxonomyCodes;
  }

  public static Optional<JeffNetModuleSetup> create(DataSource ds, OrgMessageSender sender) throws URISyntaxException {
    Optional<String> maybeJeffersonEndpoint = EfmModuleSetup.GetEnv("JEFFERSON_ENDPOINT");
    if (maybeJeffersonEndpoint.isEmpty()) {
      throw new RuntimeException("JEFFERSON_ENDPOINT needs to be the "
            + "defined. Did you forget to source .env?");
    }
    

    URI jeffnetUri = new URI(maybeJeffersonEndpoint.get());
    InputStream taxonomyCsv = EfspServer.class.getResourceAsStream("/taxonomy.csv");
    LegalIssuesTaxonomyCodes taxonomyCodes;
    try {
      taxonomyCodes = new LegalIssuesTaxonomyCodes(taxonomyCsv);
      return Optional.of(new JeffNetModuleSetup(jeffnetUri, ds, sender, taxonomyCodes));
    } catch (CsvValidationException | IOException e) {
      log.warn(e.toString());
      return Optional.empty();
    }
  }

  @Override
  public void preSetup() {
    // N/A
  }

  @Override
  public String getJurisdiction() {
    return "louisiana";
  }

  @Override
  public Set<String> getCourts() {
    return Set.of("Jefferson");
  }

  @Override
  public EfmFilingInterface getInterface() {
    return new JeffNetFiler(jeffnetEndpoint, taxonomyCodes);
  }

  @Override
  public Optional<EfmRestCallbackInterface> getCallback() {
    return Optional.of(new JeffNetRestCallback(ds, sender));
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
