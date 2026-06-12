package edu.suffolk.litlab.efsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationLoader {

  private static final String LOG_KEY = "edu.suffolk.litlab.efsp.enableReqLog";

  public static Properties loadConfig() {
    ServerEnv env = ServerEnv.fromEnvVar();
    String propertiesFile = "application." + env.getName() + ".properties";
    var props = new Properties();
    try (var is = new FileInputStream(propertiesFile)) {
      props.load(is);
    } catch (FileNotFoundException ex) {
      try (var secondIs =
          ConfigurationLoader.class.getClassLoader().getResourceAsStream(propertiesFile)) {
        if (secondIs == null) {
          throw new RuntimeException(
              "Couldn't load config file as file in current dir or as class resource. "
                  + propertiesFile);
        }
        props.load(secondIs);
      } catch (IOException e) {
        throw new RuntimeException(
            "Failed to load properties file as class resource " + propertiesFile, e);
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to load properties file: " + propertiesFile, e);
    }
    return props;
  }

  // TODO(#394): start handling this with Spring cache
  public static boolean shouldLogRequests() {
    var props = loadConfig();
    return Boolean.parseBoolean(props.getProperty(LOG_KEY));
  }
}
