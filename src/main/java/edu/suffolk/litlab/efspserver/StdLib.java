package edu.suffolk.litlab.efspserver;

import java.io.PrintWriter;
import java.io.StringWriter;

/** Things that really should just be in the standard lib. */
public class StdLib {

  public static String strFromException(Exception ex) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    ex.printStackTrace(pw);
    return ex.toString() + " " + sw.toString();
  }

}
