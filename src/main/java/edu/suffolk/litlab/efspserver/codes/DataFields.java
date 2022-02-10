package edu.suffolk.litlab.efspserver.codes;

import java.util.Map;

public class DataFields {
  private final Map<String, DataFieldRow> fieldMap;
  
  public DataFields(Map<String, DataFieldRow> fieldMap) {
    this.fieldMap = fieldMap;
  }
  
  public DataFieldRow getFieldRow(String fieldName) {
    if (fieldMap.containsKey(fieldName)) {
      return fieldMap.get(fieldName);
    }
    return DataFieldRow.MissingDataField(fieldName);
  }

}
