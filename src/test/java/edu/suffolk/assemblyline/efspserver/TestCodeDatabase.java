package edu.suffolk.assemblyline.efspserver;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

public class TestCodeDatabase {
  
  @Test
  public void allNamespacesMapToTables() {
    Collection<String> tables = CodeUpdater.ncToTableName.values();
    for (String table : tables) {
      assertNotEquals(CodeTableConstants.getTableColumns(table).orElse(List.of()).size(),
          0, "Expected " + table + " to exist");
    }
  }

}
