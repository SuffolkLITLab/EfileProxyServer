package edu.suffolk.litlab.efsp.server.setup.truefiling;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.server.services.FilingReviewService;
import edu.suffolk.litlab.efsp.server.services.JurisdictionServiceHandle;
import edu.suffolk.litlab.efsp.server.services.api.EfmFilingInterface;
import edu.suffolk.litlab.efsp.server.services.impl.TrueFilingCodesService;
import edu.suffolk.litlab.efsp.server.services.impl.TrueFilingFiler;
import edu.suffolk.litlab.efsp.server.setup.EfmModuleSetup;
import edu.suffolk.litlab.efsp.server.setup.EfmRestCallbackInterface;
import edu.suffolk.litlab.efsp.server.setup.tyler.OasisEcfWsCallback;
import edu.suffolk.litlab.efsp.server.truefiling.PolicyCacher;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TFCodeDatabase;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TrueFilingCodeUpdater;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeDatabase;
import edu.suffolk.litlab.efsp.utils.InterviewToFilingInformationConverter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import javax.sql.DataSource;

public class TrueFilingModuleSetup implements EfmModuleSetup {

  private final Jurisdiction jurisdiction;
  private final DataSource codeDs;
  private final DataSource userDs;
  private final Map<String, InterviewToFilingInformationConverter> converterMap;

  private final OrgMessageSender sender;

  public static Optional<TrueFilingModuleSetup> create(
      Jurisdiction jurisdiction,
      DataSource codeDs,
      DataSource userDs,
      Map<String, InterviewToFilingInformationConverter> converterMap,
      OrgMessageSender sender) {
    return Optional.of(
        new TrueFilingModuleSetup(jurisdiction, codeDs, userDs, converterMap, sender));
  }

  private TrueFilingModuleSetup(
      Jurisdiction jurisdiction,
      DataSource codeDs,
      DataSource userDs,
      Map<String, InterviewToFilingInformationConverter> converterMap,
      OrgMessageSender sender) {
    this.jurisdiction = jurisdiction;
    this.codeDs = codeDs;
    this.userDs = userDs;
    this.converterMap = converterMap;
    this.sender = sender;
  }

  @Override
  public void preSetup() {
    // Check that tables exist: pull from sources if they don't
    try (TFCodeDatabase cd = new TFCodeDatabase(jurisdiction, codeDs.getConnection())) {
      cd.createTablesIfAbsent();
      // There is always one hard-coded location in AK, so check a different table.
      List<String> locations = cd.getAllLocations();
      boolean downloadAll = (cd.getBundleStatuses(locations.get(0)).size() == 0);
      if (downloadAll) {
        log.info("Downloading all codes for {}: please wait a bit", jurisdiction);
        TrueFilingCodeUpdater.executeCommand(() -> cd, jurisdiction, List.of("replaceall"));
      }
    } catch (SQLException e) {
      log.error("SQL Exception in true filing setup: ", e);
      throw new RuntimeException(e);
    }
    log.info("Done checking table if absent");
  }

  @Override
  public void shutdown() {
    // No scheduling of code updates needed.
    return;
  }

  public Set<String> getCourts() {
    return Set.of("55da5b11-2bc4-4881-abd1-b0dfdb506bb1");
  }

  @Override
  public JurisdictionServiceHandle getServiceHandle() {
    var filingMap = new HashMap<String, EfmFilingInterface>();
    var callbackMap = new HashMap<String, EfmRestCallbackInterface>();
    Supplier<TFCodeDatabase> cdSupplier =
        () -> {
          return TFCodeDatabase.fromDS(jurisdiction, this.codeDs);
        };

    PolicyCacher policyCacher = new PolicyCacher();
    EfmFilingInterface filer = new TrueFilingFiler(jurisdiction, cdSupplier, policyCacher);
    for (String court : getCourts()) {
      filingMap.put(court, filer);
      getCallback().ifPresent(call -> callbackMap.put(court, call));
    }
    Supplier<UserDatabase> udSupplier = () -> UserDatabase.fromDS(this.userDs);
    var filingReview =
        new FilingReviewService(
            getJurisdiction(), udSupplier, converterMap, filingMap, callbackMap, this.sender);
    var codes = new TrueFilingCodesService(getJurisdiction(), cdSupplier);
    JurisdictionServiceHandle handle =
        new JurisdictionServiceHandle(getJurisdiction(), filingReview, codes);
    return handle;
  }

  @Override
  public Optional<EfmRestCallbackInterface> getCallback() {
    return Optional.empty();
  }

  @Override
  public Jurisdiction getJurisdiction() {
    return jurisdiction;
  }

  @Override
  public void setupGlobals() {
    Supplier<CodeDatabase> makeCD = () -> CodeDatabase.fromDS(jurisdiction, codeDs);
    Supplier<UserDatabase> makeUD = () -> UserDatabase.fromDS(userDs);
    // TODO: actually setup the Ecf callback stuff.
    OasisEcfWsCallback implementor = new OasisEcfWsCallback(makeCD, makeUD, sender);
    String address =
        ServiceHelpers.BASE_LOCAL_URL
            + "/jurisdictions/"
            + jurisdiction.getName()
            + ServiceHelpers.ASSEMBLY_PORT;
    // EndpointImpl jaxWsEndpoint =
    jakarta.xml.ws.Endpoint.publish(address, implementor);
    return;
  }

  @Override
  public String toString() {
    return "TrueFilingModuleSetup[jurisdiction=" + jurisdiction + "]";
  }
}
