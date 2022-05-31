package edu.suffolk.litlab.efspserver.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.db.DatabaseCreator;

public class CodesServiceTest {
  private static Logger log = LoggerFactory.getLogger(CodesServiceTest.class);
  
  @Container
  public PostgreSQLContainer<?> postgres =
    new PostgreSQLContainer<>(DockerImageName.parse("postgres:13.2"));

  private static final String ENDPOINT_ADDRESS = "http://localhost:9090";
  private Server server;
  private CodeDatabase cd;
  
  private void startServer() throws Exception {
    DataSource ds = DatabaseCreator.makeDataSource(postgres.getJdbcUrl(), postgres.getDatabaseName(), postgres.getUsername(), postgres.getPassword(), 2, 100);
    cd = new CodeDatabase("illinois", "stage", ds.getConnection());
    cd.createTablesIfAbsent();
    Set<String> tables = Set.of(
        "casecategory", 
        "casesubtype", 
        "casetype", 
        "filingstatus",
        "servicetype", 
        "optionalservices"); 
    cd.createTableIfAbsent("location");
    cd.updateTable("location", "0", this.getClass().getResourceAsStream("/0_location_test.xml"));
    for (String table: tables) {
      cd.createTableIfAbsent(table);
      String filename = "/" + "adams" + "_" + table + "_test.xml";
      log.info("Updating from file: " + filename);
      cd.updateTable(table, "adams", this.getClass().getResourceAsStream(filename)); 
    }

    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(CodesService.class);
    sf.setResourceProvider(CodesService.class, new SingletonResourceProvider(new CodesService("illinois", "stage", ds)));
    sf.setAddress(ENDPOINT_ADDRESS);
    Map<Object, Object> extensionMappings = Map.of(
        "xml", MediaType.APPLICATION_XML,
        "json", MediaType.APPLICATION_JSON);
    sf.setExtensionMappings(extensionMappings);
    List<Object> providers = List.of(
        new JAXBElementProvider<Object>(),
        new JacksonJsonProvider());
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
    cd.close();
    postgres.stop();
  }
  
  @SuppressWarnings("static-method")
  private String getServerResponseAt(String path) {
    WebClient client = WebClient.create(ENDPOINT_ADDRESS);
    client.accept("application/json");
    client.path(path);
    Response resp = client.get();
    log.info("resp: " + resp);
    return resp.readEntity(String.class); 
  }
  
  @Test
  public void testGetAll() throws JsonMappingException, JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(getServerResponseAt("/"));
    assertTrue(node.has("getCodesUnderCourt"), "didn't have codes post court: " + node);
    assertTrue(node.has("getCourtLocationCodes"), "didn't have court location codes: " + node);
    assertTrue(node.has("getCaseTypes"));
    assertTrue(node.has("getCaseSubtypes"));
    assertTrue(node.has("getPartyTypes"));
  }
  
  @Test
  public void testGetSubCourt() throws JsonMappingException, JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(getServerResponseAt("/courts/adams"));
    assertTrue(node.has("getCourtLocationCodes"), "didn't have court location codes: " + node);
    assertEquals(
        ServiceHelpers.BASE_URL + "/jurisdictions/illinois/codes/courts/adams/codes",
        node.get("getCourtLocationCodes").asText());
    assertTrue(node.has("getCaseTypes"));
    assertEquals(
        ServiceHelpers.BASE_URL + "/jurisdictions/illinois/codes/courts/adams/case_types",
        node.get("getCaseTypes").asText());
  }
  
  @Test
  public void testGetCase() throws JsonMappingException, JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(getServerResponseAt("/courts/adams/case_types/1234"));
    assertTrue(node.has("getCaseSubtypes"), "didn't have case sub types: " + node);
    assertEquals(
        ServiceHelpers.BASE_URL + "/jurisdictions/illinois/codes/courts/adams/case_types/1234/case_subtypes",
        node.get("getCaseSubtypes").asText());
    assertTrue(node.has("getPartyTypes"));
    assertEquals(
        ServiceHelpers.BASE_URL + "/jurisdictions/illinois/codes/courts/adams/case_types/1234/party_types", 
        node.get("getPartyTypes").asText());
  }
  
  @Test
  public void testGetUnderFilingCode() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(getServerResponseAt("/courts/adams/filing_types/1234"));
    assertTrue(node.has("getOptionalServices"), "didn't have optionalServices: " + node);
    assertEquals(
        ServiceHelpers.BASE_URL + "/jurisdictions/illinois/codes/courts/adams/filing_types/1234/optional_services",
        node.get("getOptionalServices").asText());
    assertTrue(node.has("getFilingComponents"));
    assertEquals(
        ServiceHelpers.BASE_URL + "/jurisdictions/illinois/codes/courts/adams/filing_types/1234/filing_components",
        node.get("getFilingComponents").asText());
  }
  
}
