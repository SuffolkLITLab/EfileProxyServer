package edu.suffolk.litlab.efsp.server.setup.truefiling;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.server.services.JurisdictionServiceHandle;
import edu.suffolk.litlab.efsp.server.setup.EfmModuleSetup;
import edu.suffolk.litlab.efsp.server.setup.EfmRestCallbackInterface;
import edu.suffolk.litlab.efsp.server.setup.tyler.OasisEcfWsCallback;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TFCodeDatabase;
import edu.suffolk.litlab.efsp.truefiling.ecfcodes.TrueFilingCodeUpdater;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeDatabase;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import javax.sql.DataSource;
import org.apache.cxf.jaxws.EndpointImpl;

public class TrueFilingModuleSetup implements EfmModuleSetup {

  private final Jurisdiction jurisdiction;
  private final DataSource codeDs;
  private final DataSource userDs;

  private OrgMessageSender sender;

  public static Optional<TrueFilingModuleSetup> create(
      Jurisdiction jurisdiction, DataSource codeDs, DataSource userDs) {
    return Optional.of(new TrueFilingModuleSetup(jurisdiction, codeDs, userDs));
  }

  private TrueFilingModuleSetup(Jurisdiction jurisdiction, DataSource codeDs, DataSource userDs) {
    this.jurisdiction = jurisdiction;
    this.codeDs = codeDs;
    this.userDs = userDs;
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

  @Override
  public JurisdictionServiceHandle getServiceHandle() {
    // TODO: actually do the rest of the services
    return null;
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
    EndpointImpl jaxWsEndpoint =
        (EndpointImpl) jakarta.xml.ws.Endpoint.publish(address, implementor);
    return;
  }

  @Override
  public String toString() {
    return "TrueFilingModuleSetup[jurisdiction=" + jurisdiction + "]";
  }
}
