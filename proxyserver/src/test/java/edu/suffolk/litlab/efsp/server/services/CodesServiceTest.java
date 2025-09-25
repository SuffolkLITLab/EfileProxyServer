package edu.suffolk.litlab.efsp.server.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efsp.db.DatabaseCreator;
import edu.suffolk.litlab.efsp.db.DatabaseVersionTest;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.server.EfspServer;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import javax.sql.DataSource;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@Tag("Docker")
public class CodesServiceTest {
  private static Logger log = LoggerFactory.getLogger(CodesServiceTest.class);

  @Container
  public PostgreSQLContainer<?> postgres =
      new PostgreSQLContainer<>(DockerImageName.parse(DatabaseVersionTest.POSTGRES_DOCKER_NAME));

  private static final String ENDPOINT_ADDRESS = "http://localhost:9090";
  private Server server;

  private void startServer() throws Exception {
    DataSource ds =
        DatabaseCreator.makeDataSource(
            postgres.getJdbcUrl(),
            postgres.getDatabaseName(),
            postgres.getUsername(),
            postgres.getPassword(),
            2,
            100);
    Supplier<CodeDatabase> cdSupplier =
        () -> {
          return CodeDatabase.fromDS("illinois", TylerEnv.STAGE, ds);
        };
    try (CodeDatabase cd = cdSupplier.get()) {
      cd.createTablesIfAbsent();
      Set<String> tables =
          Set.of(
              "casecategory",
              "casesubtype",
              "casetype",
              "filingstatus",
              "servicetype",
              "optionalservices");
      cd.createTableIfAbsent("location");
      cd.updateTable("location", "0", this.getClass().getResourceAsStream("/0_location_test.xml"));
      for (String table : tables) {
        cd.createTableIfAbsent(table);
        String filename = "/" + "adams" + "_" + table + "_test.xml";
        log.info("Updating from file: {}", filename);
        cd.updateTable(table, "adams", this.getClass().getResourceAsStream(filename));
      }
    }
    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(EcfCodesService.class);
    sf.setResourceProvider(
        EcfCodesService.class,
        new SingletonResourceProvider(new EcfCodesService("illinois", cdSupplier)));
    sf.setAddress(ENDPOINT_ADDRESS);
    Map<Object, Object> extensionMappings =
        Map.of(
            "xml", MediaType.APPLICATION_XML,
            "json", MediaType.APPLICATION_JSON);
    sf.setExtensionMappings(extensionMappings);
    List<?> providers = EfspServer.providers();
    sf.setProviders(providers);
    server = sf.create();
  }

  @BeforeEach
  void init() throws Exception {
    postgres.start();
    startServer();
  }

  @AfterEach
  public void destroy() throws Exception {
    server.stop();
    server.destroy();
    postgres.stop();
  }

  @SuppressWarnings("static-method")
  private Response getServerResponseAt(String path, Map<String, String> params) {
    WebClient client = WebClient.create(ENDPOINT_ADDRESS);
    client.accept("application/json");
    client.path(path);
    for (var entry : params.entrySet()) {
      client.replaceQueryParam(entry.getKey(), entry.getValue());
    }
    log.info("Current URI: {}", client.getCurrentURI());
    Response resp = client.get();
    log.info("resp: {}", resp);
    return resp;
  }

  private JsonNode getServerJsonAt(String path, Map<String, String> params)
      throws JsonProcessingException {
    Response resp = getServerResponseAt(path, params);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readTree(resp.readEntity(String.class));
  }

  @Test
  public void testGetAll() throws JsonProcessingException {
    JsonNode node = getServerJsonAt("/", Map.of());
    assertTrue(
        node.has("getCodesUnderCourt"),
        "didn't have codes post court (`getCodesUnderCourt`): " + node);
    assertTrue(node.has("getCourtLocationCodes"), "didn't have court location codes: " + node);
    assertTrue(node.has("getCaseTypes"));
    assertTrue(node.has("getCaseSubtypes"));
    assertTrue(node.has("getPartyTypes"));
  }

  @Test
  public void testGetSubCourt() throws JsonProcessingException {
    JsonNode node = getServerJsonAt("/courts/adams", Map.of());
    assertTrue(node.has("getCourtLocationCodes"), "didn't have court location codes: " + node);
    assertEquals(
        ServiceHelpers.EXTERNAL_URL + "/jurisdictions/illinois/codes/courts/adams/codes",
        node.get("getCourtLocationCodes").get("url").asText());
    assertTrue(node.has("getCaseTypes"));
    assertEquals(
        ServiceHelpers.EXTERNAL_URL + "/jurisdictions/illinois/codes/courts/adams/case_types",
        node.get("getCaseTypes").get("url").asText());
  }

  @Test
  public void testGetCase() throws JsonProcessingException {
    JsonNode node = getServerJsonAt("/courts/adams/case_types/25361", Map.of());
    assertTrue(node.has("getCaseSubtypes"), "didn't have `getCaseSubtypes`. Response was: " + node);
    assertEquals(
        ServiceHelpers.EXTERNAL_URL
            + "/jurisdictions/illinois/codes/courts/adams/case_types/25361/case_subtypes",
        node.get("getCaseSubtypes").get("url").asText());
    assertTrue(node.has("getPartyTypes"));
    assertEquals(
        ServiceHelpers.EXTERNAL_URL
            + "/jurisdictions/illinois/codes/courts/adams/case_types/25361/party_types",
        node.get("getPartyTypes").get("url").asText());
  }

  @Test
  public void testSearchOptionalServices() throws JsonProcessingException {
    final String SEARCH_TERM = "fees";
    var resp =
        getServerResponseAt(
            "/optional_services", Map.of("search", SEARCH_TERM, "result", "BAD_VALUE"));
    assertThat(resp.getStatus()).isEqualTo(400);

    JsonNode noEnumSearch = getServerJsonAt("/optional_services", Map.of("search", SEARCH_TERM));
    assertThat(noEnumSearch.isArray()).isTrue();
    assertThat(noEnumSearch.iterator())
        .allMatch(
            node -> {
              var matches = node.isTextual() && node.asText().toLowerCase().contains(SEARCH_TERM);
              if (matches) {
                try {
                  var retrieve =
                      getServerJsonAt(
                          "/optional_services/" + node.asText().replace("/", "%2F"), Map.of());
                  assertThat(retrieve.size()).isGreaterThan(0);
                  assertThat(retrieve.iterator())
                      .allMatch(
                          loc ->
                              loc.has("location") && loc.get("location").asText().equals("adams"));
                } catch (JsonProcessingException e) {
                  log.error("Error when retrieving {}", node.asText(), e);
                  return false;
                }
              }
              return matches;
            });

    JsonNode nameEnumSearch =
        getServerJsonAt("/optional_services", Map.of("search", SEARCH_TERM, "result", "NAMES"));
    assertThat(noEnumSearch).isEqualTo(nameEnumSearch);

    JsonNode courtCoverageSearch =
        getServerJsonAt(
            "/optional_services", Map.of("search", SEARCH_TERM, "result", "COURT_COVERAGE"));
    assertThat(courtCoverageSearch.size()).isEqualTo(1);
    assertThat(courtCoverageSearch.iterator())
        .allMatch(court -> court.isTextual() && court.asText().equals("adams"));
  }

  @Test
  public void testSearchCaseType() throws JsonProcessingException {
    final String SEARCH_TERM = "order";
    var resp =
        getServerResponseAt("/case_types", Map.of("search", SEARCH_TERM, "result", "BAD_VALUE"));
    assertThat(resp.getStatus()).isEqualTo(400);

    JsonNode noEnumSearch = getServerJsonAt("/case_types", Map.of("search", SEARCH_TERM));
    assertThat(noEnumSearch.isArray()).isTrue();
    assertThat(noEnumSearch.iterator())
        .allMatch(
            node -> {
              var matches = node.isTextual() && node.asText().toLowerCase().contains(SEARCH_TERM);
              if (matches) {
                try {
                  var retrieve =
                      getServerJsonAt("/case_types/" + node.asText().replace("/", "%2F"), Map.of());
                  assertThat(retrieve.size()).isGreaterThan(0);
                  assertThat(retrieve.iterator())
                      .allMatch(
                          loc ->
                              loc.has("location") && loc.get("location").asText().equals("adams"));
                } catch (JsonProcessingException e) {
                  log.error("Error when retrieving {}", node.asText(), e);
                  return false;
                }
              }
              return matches;
            });

    JsonNode nameEnumSearch =
        getServerJsonAt("/case_types", Map.of("search", SEARCH_TERM, "result", "NAMES"));
    assertThat(noEnumSearch).isEqualTo(nameEnumSearch);

    JsonNode courtCoverageSearch =
        getServerJsonAt("/case_types", Map.of("search", SEARCH_TERM, "result", "COURT_COVERAGE"));
    assertThat(courtCoverageSearch.size()).isEqualTo(1);
    assertThat(courtCoverageSearch.iterator())
        .allMatch(court -> court.isTextual() && court.asText().equals("adams"));
  }
}
