package edu.suffolk.litlab.efspserver.docassemble;

import static edu.suffolk.litlab.efspserver.JsonHelpers.getStringMember;

import com.fasterxml.jackson.databind.JsonNode;
import edu.suffolk.litlab.efspserver.Name;
import edu.suffolk.litlab.efspserver.services.FilingError;
import edu.suffolk.litlab.efspserver.services.InfoCollector;
import edu.suffolk.litlab.efspserver.services.InterviewVariable;

public class NameDocassembleDeserializer {

  public static Name fromNode(JsonNode node, InfoCollector collector) throws FilingError {
    if (node == null) {
      InterviewVariable var =
          collector.requestVar("name", "The full name of the person", "IndividualName");
      collector.addRequired(var);
    }
    if (!node.isObject()) {
      FilingError err =
          FilingError.malformedInterview(
              "Can't parse person with name that's not a JSON object: "
                  + node.get("name").toPrettyString());
      collector.error(err);
      throw err;
    }
    if (!node.has("first")) {
      InterviewVariable var =
          collector.requestVar(
              "name.first", "The first name of a person / name of a business", "text");
      collector.addRequired(var);
    }

    Name name =
        new Name(
            "", // TODO(#55): where should we handle prefixes? Are they always empty?
            getStringMember(node, "first").orElse(""),
            getStringMember(node, "middle").orElse(""),
            getStringMember(node, "last").orElse(""),
            getStringMember(node, "suffix").orElse(""),
            "" // TODO(#55): where would Maiden name go, if asked for?
            );

    return name;
  }
}
