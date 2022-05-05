package edu.suffolk.litlab.efspserver.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CrossReference;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;

public class CodesServiceTest {
  private static Logger log = LoggerFactory.getLogger(CodesServiceTest.class);
  
  private static final String caseType = "78334";
  private static final String ENDPOINT_ADDRESS = "http://localhost:9090";
  private Server server;
  private CodeDatabase cd;
  
  private void startServer() throws Exception {
    cd = mock(CodeDatabase.class);
    List<CrossReference> refs = List.of(
        new CrossReference("76343", "PIN#", caseType, "True", "False", "", "", "", "cook:cd1"),
        new CrossReference("87374", "Cook County Attorney/Self-Represented Litigant Code", caseType, 
                "False", "True", "^[0-9]{5}$", "Case type requires a 5-digit Case Cross Reference number and Case Cross Reference type \"Cook County Attorney Code\", if self-represented use 99500.", "COOKCOUNTYATTORNEY", "cook:cd1")
        );
    List<CrossReference> blank = List.of();
    when(cd.getCrossReference("cook:cd1", caseType)).thenReturn(refs);
    when(cd.getCrossReference("adams", caseType)).thenReturn(blank);
    when(cd.getLanguages("not_real")).thenReturn(List.of("English", "Polish", "Spanish"));
    when(cd.getDataField(eq("not_real"), anyString())).thenReturn(DataFieldRow.MissingDataField(""));
    when(cd.getDataField(eq("not_real"), eq("PartyGender"))).thenReturn(
        new DataFieldRow("PartyGender", "Party Gender", "True", "False", "", "", "", "", "", "", "", ""));

    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(CodesService.class);
    sf.setResourceProvider(CodesService.class, new SingletonResourceProvider(new CodesService(cd)));
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
    startServer();
  }
  
  @AfterEach
  public void destroy() throws Exception {
    server.stop();
    server.destroy();
  }
  
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
    JsonNode node = mapper.readTree(getServerResponseAt("/codes/")); 
    assertTrue(node.has("getCodesUnderCourt"), "didn't have codes post court: " + node);
    assertTrue(node.has("getCourtLocationCodes"), "didn't have court location codes: " + node);
    assertTrue(node.has("getCaseTypes"));
    assertTrue(node.has("getCaseSubtypes"));
    assertTrue(node.has("getPartyTypes"));
  }
  
  @Test
  public void testGetSubCourt() throws JsonMappingException, JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(getServerResponseAt("/codes/courts/adams")); 
    assertTrue(node.has("getCourtLocationCodes"), "didn't have court location codes: " + node);
    assertEquals(
        ServiceHelpers.BASE_URL + "/codes/courts/adams/codes",
        node.get("getCourtLocationCodes").asText());
    assertTrue(node.has("getCaseTypes"));
    assertEquals(
        ServiceHelpers.BASE_URL + "/codes/courts/adams/case_types",
        node.get("getCaseTypes").asText());
  }
  
  @Test
  public void testGetCase() throws JsonMappingException, JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(getServerResponseAt("/codes/courts/adams/case_types/1234")); 
    assertTrue(node.has("getCaseSubtypes"), "didn't have case sub types: " + node);
    assertEquals(
        ServiceHelpers.BASE_URL + "/codes/courts/adams/case_types/1234/case_subtypes",
        node.get("getCaseSubtypes").asText());
    assertTrue(node.has("getPartyTypes"));
    assertEquals(
        ServiceHelpers.BASE_URL + "/codes/courts/adams/case_types/1234/party_types", 
        node.get("getPartyTypes").asText());
  }
  
  @Test
  public void testGetUnderFilingCode() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(getServerResponseAt("/codes/courts/adams/filing_codes/1234")); 
    assertTrue(node.has("getOptionalServices"), "didn't have optionalServices: " + node);
    assertEquals(
        ServiceHelpers.BASE_URL + "/codes/courts/adams/filing_codes/1234/optional_services",
        node.get("getOptionalServices").asText());
    assertTrue(node.has("getFilingComponents"));
    assertEquals(
        ServiceHelpers.BASE_URL + "/codes/courts/adams/filing_codes/1234/filing_components", 
        node.get("getFilingComponents").asText());
    
  }
  
  
}
