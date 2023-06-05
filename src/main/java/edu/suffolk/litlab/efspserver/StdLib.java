package edu.suffolk.litlab.efspserver;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Things that really should just be in the standard lib. */
public class StdLib {
  private static final Logger log = LoggerFactory.getLogger(StdLib.class);

  public static String strFromException(Exception ex) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    pw.print(ex.toString());
    pw.print(" ");
    ex.printStackTrace(pw);
    return sw.toString();
  }

  /** Quick wrapper to get an env var as an optional. */
  public static Optional<String> GetEnv(String envVarName) {
    String val = System.getenv(envVarName);
    if (val == null || val.isBlank()) {
      return Optional.empty();
    }
    return Optional.of(val);
  }

  public static void closeQuitely(XMLStreamReader xsr) {
    try {
      if (xsr != null) {
        xsr.close();
      }
    } catch (XMLStreamException ex) {
      log.warn("Exception during XMLStreamReader.close(): " + strFromException(ex));
    }
  }
}
