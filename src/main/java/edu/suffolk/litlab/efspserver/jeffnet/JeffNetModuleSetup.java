package edu.suffolk.litlab.efspserver.jeffnet;

import com.opencsv.exceptions.CsvValidationException;
import edu.suffolk.litlab.efspserver.LegalIssuesTaxonomyCodes;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.services.EfmFilingInterface;
import edu.suffolk.litlab.efspserver.services.EfmModuleSetup;
import edu.suffolk.litlab.efspserver.services.EfmRestCallbackInterface;
import edu.suffolk.litlab.efspserver.services.EfspServer;
import edu.suffolk.litlab.efspserver.services.FilingReviewService;
import edu.suffolk.litlab.efspserver.services.InterviewToFilingInformationConverter;
import edu.suffolk.litlab.efspserver.services.JurisdictionServiceHandle;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
    Optional<String> maybeJeffersonEndpoint = StdLib.GetEnv("JEFFERSON_ENDPOINT");
    if (maybeJeffersonEndpoint.isEmpty()) {
      throw new RuntimeException(
          "JEFFERSON_ENDPOINT needs to be the " + "defined. Did you forget to source .env?");
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
  public String getJurisdiction() {
    return "louisiana";
  }

  @Override
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

    var filingReview =
        new FilingReviewService(
            getJurisdiction(), this.userDs, converterMap, filingMap, callbackMap, this.sender);
    var codes =
        new CourtsOnlyCodesService(getJurisdiction(), Map.of("jefferson", "Jefferson Parish"));
    return new JurisdictionServiceHandle(getJurisdiction(), filingReview, codes);
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
