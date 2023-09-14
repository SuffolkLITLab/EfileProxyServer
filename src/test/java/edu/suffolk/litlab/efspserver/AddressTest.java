package edu.suffolk.litlab.efspserver;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.ecf4.EcfCourtSpecificSerializer;
import edu.suffolk.litlab.efspserver.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.tyler.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.tyler.codes.CourtLocationInfo;

import gov.niem.niem.fips_10_4._2.CountryCodeSimpleType;
import gov.niem.niem.niem_core._2.AddressType;
import gov.niem.niem.niem_core._2.ProperNameTextType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressTest {

  Address addr;
  EcfCourtSpecificSerializer serializer;
  
  @BeforeEach
  public void setUp() {
    addr = new Address("100 Circle Road", "Apt 2", "Plano", "TX", "75093", CountryCodeSimpleType.US);
    CodeDatabase cd = mock(CodeDatabase.class);
    when(cd.getStateCodes("adams", "US")).thenReturn(List.of("TX", "MA"));
    CourtLocationInfo loc = new CourtLocationInfo();
    loc.code = "adams";
    serializer = new EcfCourtSpecificSerializer(cd, loc); 
  }
  
  @Test
  public void addressShouldMakeXml() throws JAXBException, FilingError {
    FailFastCollector collector = new FailFastCollector();
    JAXBElement<AddressType> addrElem = serializer.serializeNiemContactMeans(addr, collector); 

    // Should be able to grab the xml str without an exception
    Ecf4Helper.objectToXmlStr(addrElem.getValue(), AddressType.class);
    
    assertNotNull(addrElem.getValue().getAddressRepresentation().getValue());
    
    StructuredAddressType sat = 
        (StructuredAddressType) addrElem.getValue().getAddressRepresentation().getValue();
    assertEquals(sat.getLocationPostalCode().getValue(), "75093");
    assertEquals(sat.getLocationCityName().getValue(), "Plano");
    assertNotEquals(sat.getLocationCountry().getValue(), null);
    JAXBElement<?> state = sat.getLocationState();
    assertTrue(state.getValue() instanceof ProperNameTextType);
    
    tyler.efm.services.schema.common.AddressType tylerAddr =
        EcfCourtSpecificSerializer.serializeTylerAddress(addr);
    assertEquals(tylerAddr.getAddressLine1(), "100 Circle Road");
    assertEquals(tylerAddr.getAddressLine2(), "Apt 2");
    assertEquals(tylerAddr.getCity(), "Plano");
    assertEquals(tylerAddr.getState(), "TX");
    assertEquals(tylerAddr.getCountry(), "US");
  }
  
  @Test
  public void addressShouldMakeJson() {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode addrJson = mapper.valueToTree(addr);
    assertEquals(addrJson.get("AddressLine1").asText(), "100 Circle Road");
    assertEquals(addrJson.get("AddressLine2").asText(), "Apt 2"); 
    assertEquals(addrJson.get("City").asText(), "Plano"); 
    assertEquals(addrJson.get("State").asText(), "TX"); 
    assertEquals(addrJson.get("ZipCode").asText(), "75093"); 
  }
}
