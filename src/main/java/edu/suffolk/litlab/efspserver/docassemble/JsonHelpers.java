package edu.suffolk.litlab.efspserver.docassemble;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonHelpers {

  public static Optional<String> getStringMember(JsonNode obj, String memberName) {
    if (obj.has(memberName)
        && obj.get(memberName).isTextual()) {
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
    if (obj.has(memberName)
        && obj.get(memberName).isInt()) {
      return Optional.of(obj.get(memberName).asInt());
    }
    return Optional.empty();
  }
  
  public static List<String> getMemberList(JsonNode obj, String memberName) {
    if (!obj.has(memberName) || !obj.get(memberName).isArray()) {
      return List.of();
    }
    JsonNode listNode = obj.get(memberName);
    List<String> returnList = new ArrayList<String>();
    Iterator<JsonNode> elems = listNode.elements();
    while (elems.hasNext()) {
      JsonNode elemNode = elems.next();
      if (elemNode.isTextual()) {
        returnList.add(elemNode.asText()); 
      }
    }
    return returnList;
  }
}
