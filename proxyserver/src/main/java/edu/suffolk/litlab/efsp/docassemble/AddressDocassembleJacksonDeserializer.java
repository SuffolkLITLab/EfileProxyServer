package edu.suffolk.litlab.efsp.docassemble;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efsp.model.Address;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;
import gov.niem.niem.fips_10_4._2.CountryCodeSimpleType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddressDocassembleJacksonDeserializer {
  private static Logger log = LoggerFactory.getLogger(AddressDocassembleJacksonDeserializer.class);

  protected AddressDocassembleJacksonDeserializer() {}

  /**
   * Parses an address from the DA Json Object. Used by Deserializers that include addresses.
   *
   * @throws FilingError if @param node isn't a JSON object describing an address
   */
  public static Optional<Address> fromNode(JsonNode node, InfoCollector collector)
      throws FilingError {
    if (!node.isObject()) {
      FilingError err =
          FilingError.malformedInterview(
              "Refusing to parse address that isn't a Json Object: " + node.toPrettyString());
      collector.error(err);
      throw err;
    }

    List<InterviewVariable> potentiallyReq = new ArrayList<InterviewVariable>();
    boolean oneMissing = false;
    for (String member : List.of("address", "unit", "city", "state", "zip")) {
      if (!node.has(member)) {
        oneMissing = true;
        potentiallyReq.add(collector.requestVar(member, "part of the address", "text"));
        continue;
      }
      if (node.has(member) && !node.get(member).isTextual()) {
        FilingError err =
            FilingError.malformedInterview(
                "Refusing to parse an address where the "
                    + member
                    + " isn't text: "
                    + node.toPrettyString());
        collector.error(err);
        throw err;
      }
    }
    if (oneMissing) {
      return Optional.empty();
    }
    if (!potentiallyReq.isEmpty()) {
      for (InterviewVariable memberVar : potentiallyReq) {
        collector.addRequired(memberVar);
      }
    }
    String address = (node.has("address")) ? node.get("address").asText("") : "";
    String unit = (node.has("unit")) ? node.get("unit").asText("") : "";
    String city = (node.has("city")) ? node.get("city").asText("") : "";
    String state = (node.has("state")) ? node.get("state").asText("") : "";
    String zip = (node.has("zip")) ? node.get("zip").asText("") : "";
    String country = (node.has("country")) ? node.get("country").asText("US") : "US";
    CountryCodeSimpleType countryCode;
    try {
      countryCode = CountryCodeSimpleType.fromValue(country);
    } catch (IllegalArgumentException ex) {
      log.error("Country {} isn't a valid country", country, ex);
      List<String> countries =
          Arrays.stream(CountryCodeSimpleType.values())
              .map((t) -> t.toString())
              .collect(Collectors.toList());
      InterviewVariable countryOptions =
          collector.requestVar(
              "country", "The 2 letter country code", "choices", countries, Optional.of(country));
      FilingError err = FilingError.wrongValue(countryOptions);
      collector.error(err);
      throw err;
    }
    Address addr = new Address(address, unit, city, state, zip, countryCode);
    return Optional.of(addr);
  }
}
