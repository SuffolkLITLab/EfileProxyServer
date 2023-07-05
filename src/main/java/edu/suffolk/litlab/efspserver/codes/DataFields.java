package edu.suffolk.litlab.efspserver.codes;

import java.util.List;
import java.util.Map;

public class DataFields {
  private final List<Map<String, DataFieldRow>> fieldMaps;

  public DataFields(Map<String, DataFieldRow> fieldMap) {
    this.fieldMaps = List.of(fieldMap);
  }

  public DataFields(Map<String, DataFieldRow> fieldMap, Map<String, DataFieldRow> fieldMapParent) {
    this.fieldMaps = List.of(fieldMap, fieldMapParent);
  }

  public DataFields(List<Map<String, DataFieldRow>> fieldMaps) {
    this.fieldMaps = fieldMaps;
  }

  public DataFieldRow getFieldRow(String fieldName) {
    for (var fieldMap : fieldMaps) {
      if (fieldMap.containsKey(fieldName)) {
        return fieldMap.get(fieldName);
      }
    }
    return DataFieldRow.MissingDataField(fieldName);
  }
}
