package edu.suffolk.litlab.efspserver;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

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
  
  /** Returns the JsonNode where `.isArray()` is true. 
   * 
   * For DAList objects, Docassemble puts the actual JSON array nested in the `elements` attribute.
   * This function lets you treat a normal JSON array and a DAList JSON object the same.
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
  
  public static Optional<JsonNode> unwrapDADict(JsonNode obj) {
    if (obj == null) {
      return Optional.empty();
    }
    if (obj.isObject()) {
      if (obj.has("_class") && obj.has("instanceName") && obj.has("elements")
          && obj.get("elements").isObject()) {
        return Optional.of(obj.get("elements"));
      } else {
        return Optional.of(obj);
      }
    }
    return Optional.empty();
  }
}
