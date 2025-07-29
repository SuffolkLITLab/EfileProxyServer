package edu.suffolk.litlab.efsp.ecfcodes.tyler;

import java.util.List;
import java.util.Map;

public class DataFields {
  private final List<Map<String, DataFieldRow>> fieldMaps;

  public DataFields() {
    this.fieldMaps = List.of();
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
