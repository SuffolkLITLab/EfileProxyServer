package edu.suffolk.litlab.efspserver;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Things that really should just be in the standard lib. */
public class StdLib {
  private final static Logger log =
      LoggerFactory.getLogger(StdLib.class);

  public static String strFromException(Exception ex) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    ex.printStackTrace(pw);
    return ex.toString() + " " + sw.toString();
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
