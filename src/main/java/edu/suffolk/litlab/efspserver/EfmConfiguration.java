package edu.suffolk.litlab.efspserver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class EfmConfiguration {
  
  public static Map<String, String> loadConfig() throws IOException {
    Properties properties = new Properties();
    try (var inStream = EfmConfiguration.class.getResourceAsStream("/efms.properties")) {
      if (inStream != null) {
        properties.load(inStream);
      }
    }
    Map<String, String> map = new HashMap<>();
    for (String key: properties.stringPropertyNames()) {
      if (key.startsWith("efmversion.")) {
        String value = properties.getProperty(key);
        map.put(key.split("\\.")[1], value);
      }
    }
    return map;
  }
}
