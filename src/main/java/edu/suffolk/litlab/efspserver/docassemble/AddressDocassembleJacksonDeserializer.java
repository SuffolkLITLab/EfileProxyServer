package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.databind.JsonNode;

import edu.suffolk.litlab.efspserver.Address;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import gov.niem.niem.fips_10_4._2.CountryCodeSimpleType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressDocassembleJacksonDeserializer {
  private static Logger log = LoggerFactory.getLogger(AddressDocassembleJacksonDeserializer.class); 

  protected AddressDocassembleJacksonDeserializer() {} 

  /** Parses an address from the DA Json Object. Used by Deserializers that include addresses. 
   * @throws FilingError */
  public Address fromNode(JsonNode node, InfoCollector collector) throws FilingError {
    if (!node.isObject()) {
      FilingError err = FilingError.malformedInterview(
          "Refusing to parse address that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
      throw err;
    }

    for (String member : List.of("address", "unit", "city", "state", "zip")) {
      if (!node.has(member)) {
        InterviewVariable memberVar = new InterviewVariable(
            member, "part of the address", "text", List.of());
        collector.addRequired(memberVar);
      }
      if (!node.get(member).isTextual()) {
        FilingError err = FilingError.malformedInterview(
            "Refusing to parse an address where the " + member + " isn't text: " 
            + node.toPrettyString());
        collector.error(err);
        throw err;
      }
    }
    String address = node.get("address").asText("");
    String unit = node.get("unit").asText("");
    String city = node.get("city").asText("");
    String state = node.get("state").asText("");
    String zip = node.get("zip").asText("");
    String country = "US"; 
    JsonNode countryNode = node.get("country");
    if (countryNode != null) {
      country = countryNode.asText("US");
    }
    CountryCodeSimpleType countryCode; 
    try {
      countryCode = CountryCodeSimpleType.fromValue(country);
    } catch (IllegalArgumentException ex) {
      log.error("Country " + country + " isn't a valid country: " + ex);
      List<String> countries = Arrays.stream(CountryCodeSimpleType.values()) 
          .map((t) -> t.toString())
          .collect(Collectors.toList());
      InterviewVariable countryOptions = collector.requestVar("country", 
          "The 2 letter country code", "choices", countries);
      FilingError err = FilingError.wrongValue(countryOptions); 
      collector.error(err);
      throw err;
    }
    Address addr = new Address(address, unit, city, state, zip, countryCode);
    return addr; 
  }
}
