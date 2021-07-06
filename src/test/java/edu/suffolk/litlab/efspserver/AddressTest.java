package edu.suffolk.litlab.efspserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gov.niem.niem.niem_core._2.AddressType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddressTest {

  Address addr;
  
  @BeforeEach
  public void setUp() {
    addr = new Address("100 Circle Road", "Apt 2", "Plano", "TX", "75093", "US");
  }
  
  @Test
  public void addressShouldMakeXml() throws JAXBException {
    JAXBElement<AddressType> addrElem = addr.getAsNiemContactMeans(); 

    // Should be able to grab the xml str without an exception
    XmlHelper.objectToXmlStr(addrElem.getValue(), AddressType.class);
    
    assertNotNull(addrElem.getValue().getAddressRepresentation().getValue());
    
    StructuredAddressType sat = 
        (StructuredAddressType) addrElem.getValue().getAddressRepresentation().getValue();
    assertEquals(sat.getLocationPostalCode().getValue(), "75093");
    assertEquals(sat.getLocationCityName().getValue(), "Plano");
    
    tyler.efm.services.schema.common.AddressType tylerAddr = addr.getAsTylerAddress();
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
