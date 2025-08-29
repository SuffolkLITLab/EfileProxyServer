package edu.suffolk.litlab.efsp.server.setup.jeffnet;

import com.opencsv.exceptions.CsvValidationException;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.server.EfspServer;
import edu.suffolk.litlab.efsp.server.services.CourtsOnlyCodesService;
import edu.suffolk.litlab.efsp.server.services.FilingReviewService;
import edu.suffolk.litlab.efsp.server.services.JurisdictionServiceHandle;
import edu.suffolk.litlab.efsp.server.services.impl.EfmFilingInterface;
import edu.suffolk.litlab.efsp.server.setup.EfmModuleSetup;
import edu.suffolk.litlab.efsp.server.setup.EfmRestCallbackInterface;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import edu.suffolk.litlab.efsp.utils.InterviewToFilingInformationConverter;
import edu.suffolk.litlab.efsp.utils.LegalIssuesTaxonomyCodes;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JeffNetModuleSetup implements EfmModuleSetup {
  private static Logger log = LoggerFactory.getLogger(JeffNetModuleSetup.class);

  private final URI jeffnetEndpoint;
  private final DataSource userDs;
  private final OrgMessageSender sender;
  private final LegalIssuesTaxonomyCodes taxonomyCodes;
  private final Map<String, InterviewToFilingInformationConverter> converterMap;

  private JeffNetModuleSetup(
      URI jeffnetUri,
      Map<String, InterviewToFilingInformationConverter> converterMap,
      DataSource userDs,
      OrgMessageSender sender,
      LegalIssuesTaxonomyCodes taxonomyCodes) {
    this.converterMap = converterMap;
    this.jeffnetEndpoint = jeffnetUri;
    this.userDs = userDs;
    this.sender = sender;
    this.taxonomyCodes = taxonomyCodes;
  }

  public static Optional<JeffNetModuleSetup> create(
      Map<String, InterviewToFilingInformationConverter> converter,
      DataSource ds,
      OrgMessageSender sender)
      throws URISyntaxException {
    final String ENDPOINT_ENV_VAR_NAME = "JEFFERSON_ENDPOINT";
    Optional<String> maybeJeffersonEndpoint = StdLib.GetEnv(ENDPOINT_ENV_VAR_NAME);
    if (maybeJeffersonEndpoint.isEmpty()) {
      log.warn("JeffNet not being used: {} should be an env var", ENDPOINT_ENV_VAR_NAME);
      return Optional.empty();
    }

    URI jeffnetUri = new URI(maybeJeffersonEndpoint.get());
    InputStream taxonomyCsv = EfspServer.class.getResourceAsStream("/taxonomy.csv");
    LegalIssuesTaxonomyCodes taxonomyCodes;
    try {
      taxonomyCodes = new LegalIssuesTaxonomyCodes(taxonomyCsv);
      return Optional.of(new JeffNetModuleSetup(jeffnetUri, converter, ds, sender, taxonomyCodes));
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
  public String getJurisdictionId() {
    return "louisiana";
  }

  public Set<String> getCourts() {
    return Set.of("jefferson");
  }

  @Override
  public JurisdictionServiceHandle getServiceHandle() {
    var filer = new JeffNetFiler(jeffnetEndpoint, taxonomyCodes);
    var filingMap = new HashMap<String, EfmFilingInterface>();
    var callbackMap = new HashMap<String, EfmRestCallbackInterface>();

    for (String court : getCourts()) {
      filingMap.put(court, filer);
      getCallback().ifPresent(call -> callbackMap.put(court, call));
    }

    Supplier<LoginDatabase> ldSupplier = () -> LoginDatabase.fromDS(this.userDs);
    Supplier<UserDatabase> udSupplier = () -> UserDatabase.fromDS(this.userDs);

    var filingReview =
        new FilingReviewService(
            getJurisdictionId(),
            ldSupplier,
            udSupplier,
            converterMap,
            filingMap,
            callbackMap,
            this.sender);
    var codes =
        new CourtsOnlyCodesService(getJurisdictionId(), Map.of("jefferson", "Jefferson Parish"));
    return new JurisdictionServiceHandle(getJurisdictionId(), filingReview, codes);
  }

  @Override
  public Optional<EfmRestCallbackInterface> getCallback() {
    return Optional.of(new JeffNetRestCallback(userDs, sender));
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
