package edu.suffolk.litlab.efspserver.docassemble;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efspserver.Address;
import edu.suffolk.litlab.efspserver.services.ExtractError;
import edu.suffolk.litlab.efspserver.services.FailFastCollector;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;
import edu.suffolk.litlab.efspserver.services.JsonExtractException;
import gov.niem.niem.fips_10_4._2.CountryCodeSimpleType;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressDocassembleJacksonDeserializer extends StdDeserializer<Address> {
  private static Logger log = LoggerFactory.getLogger(AddressDocassembleJacksonDeserializer.class); 

  private static final long serialVersionUID = 1L;

  protected AddressDocassembleJacksonDeserializer(Class<Address> t) {
    super(t);
  }

  /** Parses an address from the DA Json Object. Used by Deserializers that include addresses. */
  public Result<Address, ExtractError> fromNode(JsonNode node, InfoCollector collector) {
    if (!node.isObject()) {
      ExtractError err = ExtractError.malformedInterview(
          "Refusing to parse address that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
      return Result.err(err);
    }

    for (String member : List.of("address", "unit", "city", "state", "zip")) {
      if (!node.has(member)) {
        InterviewVariable memberVar = new InterviewVariable(
            member, "part of the address", "text", List.of());
        collector.addRequired(memberVar);
        if (collector.finished()) {
          return Result.err(ExtractError.missingRequired(memberVar));
        }
      }
      if (!node.get(member).isTextual()) {
        ExtractError err = ExtractError.malformedInterview(
            "Refusing to parse an address where the " + member + " isn't text: " 
            + node.toPrettyString());
        collector.error(err);
        return Result.err(err);
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
      ExtractError err = ExtractError.malformedInterview("Country " + country + " isn't a valid country");
      return Result.err(err);
    }
    Address addr = new Address(address, unit, city, state, zip, countryCode);
    return Result.ok(addr); 
  }

  @Override
  public Address deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    JsonNode node = p.readValueAsTree();
    InfoCollector collector = new FailFastCollector();
    Result<Address, ExtractError> address = fromNode(node, collector);
    if (address.isErr()) {
      throw new JsonExtractException(p, address.unwrapErrOrElseThrow());
    }
    return address.unwrapOrElseThrow();
  }
}
