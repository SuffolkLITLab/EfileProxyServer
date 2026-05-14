package edu.suffolk.litlab.efsp.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JsonHelpers {

  public static boolean isNull(JsonNode j) {
    return j == null || j.isNull();
  }

  public static Optional<String> getStringMember(JsonNode obj, String memberName) {
    if (obj.has(memberName) && obj.get(memberName).isTextual()) {
      return Optional.of(obj.get(memberName).asText());
    }
    return Optional.empty();
  }

  public static Optional<String> getNonEmptyStringMember(JsonNode obj, String memberName) {
    var maybeStr = getStringMember(obj, memberName);
    if (maybeStr.map(str -> str.isBlank()).orElse(true)) {
      return Optional.empty();
    }
    return maybeStr;
  }

  public static String getStringDefault(JsonNode obj, String memberName, String def) {
    if (!obj.has(memberName)) {
      return def;
    }
    return obj.get(memberName).asText(def);
  }

  public static Optional<Integer> getIntMember(JsonNode obj, String memberName) {
    if (obj.has(memberName) && obj.get(memberName).isInt()) {
      return Optional.of(obj.get(memberName).asInt());
    }
    return Optional.empty();
  }

  public static Optional<BigDecimal> getNumberMember(JsonNode obj, String memberName) {
    if (obj.has(memberName) && obj.get(memberName).isNumber()) {
      return Optional.of(obj.get(memberName).decimalValue());
    }
    return Optional.empty();
  }

  public static Optional<Boolean> getBoolMember(JsonNode obj, String memberName) {
    if (obj.has(memberName) && obj.get(memberName).isBoolean()) {
      return Optional.of(obj.get(memberName).asBoolean());
    }
    return Optional.empty();
  }

  public static List<String> getMemberList(JsonNode obj, String memberName) {
    if (!obj.has(memberName) || !obj.get(memberName).isArray()) {
      return List.of();
    }
    JsonNode listNode = obj.get(memberName);
    List<String> returnList = new ArrayList<String>();
    Iterable<JsonNode> elems = listNode::elements;
    for (JsonNode elemNode : elems) {
      if (elemNode.isTextual()) {
        returnList.add(elemNode.asText());
      }
    }
    return returnList;
  }

  /**
   * Returns the JsonNode where `.isArray()` is true.
   *
   * <p>For DAList objects, Docassemble puts the actual JSON array nested in the `elements`
   * attribute. This function lets you treat a normal JSON array and a DAList JSON object the same.
   */
  public static Optional<JsonNode> unwrapDAList(JsonNode obj) {
    if (obj == null) {
      return Optional.empty();
    }
    if (obj.isArray()) {
      return Optional.of(obj);
    }
    if (obj.isObject() && obj.has("elements") && obj.get("elements").isArray()) {
      return Optional.of(obj.get("elements"));
    }
    return Optional.empty();
  }

  public static Result<Optional<JsonNode>, NullValue> unwrapDADict(JsonNode obj) {
    if (obj == null) {
      return Result.ok(Optional.empty());
    }
    if (obj.isObject()) {
      if ((obj.has("_class")
          || obj.has("instanceName"))
          && obj.has("elements")
          && obj.get("elements").isObject()) {
        return Result.ok(Optional.of(obj.get("elements")));
      } else {
        return Result.ok(Optional.of(obj));
      }
    }
    return Result.nullErr();
  }

  public static Result<Optional<Map<String, String>>, NullValue> unwrapSimpleDict(JsonNode obj) {
    var maybeDict = unwrapDADict(obj);
    if (maybeDict.isErr()) {
      return maybeDict.propagateErr();
    } else if (maybeDict.unwrapOrElseThrow().isEmpty()) {
      return Result.ok(Optional.empty());
    }
    var dict = maybeDict.unwrapOrElseThrow().get();
    Map<String, String> output = new HashMap<>();
    Iterable<String> dictKeys = dict::fieldNames;
    for (String dictKey : dictKeys) {
      if (dict.get(dictKey) != null && dict.get(dictKey).isTextual()) {
        String value = dict.get(dictKey).asText();
        output.put(dictKey, value);
      } else {
        return Result.nullErr();
      }
    }
    return Result.ok(Optional.of(output));
  }
}
