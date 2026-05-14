package edu.suffolk.litlab.efsp.docassemble;

import static edu.suffolk.litlab.efsp.utils.JsonHelpers.getStringMember;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.server.ecf4.CodesParser;
import edu.suffolk.litlab.efsp.utils.FilingError;
import edu.suffolk.litlab.efsp.utils.InfoCollector;
import edu.suffolk.litlab.efsp.utils.InterviewVariable;

public class NameDocassembleDeserializer {

  public static Name fromNode(JsonNode node, CodesParser parser, InfoCollector collector)
      throws FilingError {
    if (node == null || node.isNull()) {
      InterviewVariable var =
          collector.requestVar("name", "The full name of the person", "IndividualName");
      collector.addRequired(var);
      node = NullNode.getInstance();
      return new Name("");
    }
    if (!node.isObject() && !node.isNull()) {
      var err =
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
    var firstBuilder =
        collector
            .varBuilder()
            .name("name.first")
            .description("The first name of a person / name of a business")
            .datatype("text");
    String firstName =
        collector.unwrap(parser.vetFirstName(getStringMember(node, "first")), firstBuilder);
    var middleBuilder =
        collector
            .varBuilder()
            .name("name.middle")
            .description("The middle name of a person")
            .datatype("text");
    String middleName =
        collector.unwrap(parser.vetMiddleName(getStringMember(node, "middle")), middleBuilder);
    var lastBuilder =
        collector
            .varBuilder()
            .name("name.last")
            .description("The last name of a person")
            .datatype("text");
    String lastName =
        collector.unwrap(parser.vetLastName(getStringMember(node, "last")), lastBuilder);

    var suffixBuilder =
        collector.varBuilder().name("name.suffix").description("The suffix of a person's name");
    var suffix =
        collector.unwrapCode(parser.vetSuffix(getStringMember(node, "suffix")), suffixBuilder);

    Name name =
        new Name(
            "", // TODO(#55): where should we handle prefixes? Are they always empty?
            firstName,
            middleName,
            lastName,
            suffix,
            "" // TODO(#55): where would Maiden name go, if asked for?
            );

    return name;
  }
}
