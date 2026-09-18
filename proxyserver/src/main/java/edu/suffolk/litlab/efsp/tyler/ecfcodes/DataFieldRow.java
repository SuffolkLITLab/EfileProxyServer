package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public record DataFieldRow(
    String code,
    String name,
    boolean isvisible,
    boolean isrequired,
    String helptext,
    String ghosttext,
    String contextualhelpdata,
    String validationmessage,
    Pattern regularexpression,
    String defaultvalueexpression,
    boolean isreadonly,
    String location) {

  /** Constructor directly from Database. */
  public DataFieldRow(
      String code,
      String name,
      boolean isvisible,
      boolean isrequired,
      String helptext,
      String ghosttext,
      String contextualhelpdata,
      String validationmessage,
      String regularexpression,
      String defaultvalueexpression,
      boolean isreadonly,
      String location) {
    this(
        code,
        name,
        isvisible,
        isrequired,
        helptext,
        ghosttext,
        contextualhelpdata,
        validationmessage,
        (regularexpression == null || regularexpression.isEmpty())
            ? null
            : Pattern.compile(regularexpression),
        defaultvalueexpression,
        isreadonly,
        location);
  }

  // Used for testing.
  public DataFieldRow(
      String code, String name, boolean isvisible, boolean isrequired, String location) {
    this(code, name, isvisible, isrequired, "", "", "", "", "", "", false, location);
  }

  /**
   * According to the Tyler docs, if some data field is not defined, it defaults to isVisible=False,
   * and isRequired=False. Everything else will be empty
   *
   * @return
   */
  public static DataFieldRow MissingDataField(String name) {
    return new DataFieldRow("", name, false, false, "", "", "", "", "", "", false, "");
  }

  public boolean matchRegex(String value) {
    if (this.regularexpression == null) {
      return true;
    }
    Matcher matcher = this.regularexpression.matcher(value);
    return matcher.find();
  }

  /**
   * Gets all columns from datafieldconfig table Need to provide the location (1) and the code (2)
   * of the field. For example, 'adams' and 'FilingEventCaseParties'
   *
   * @return the String to make a SQL PreparedStatement from
   */
  public static String getAllFromDataFieldConfigForLoc() {
    return "SELECT code, name, isvisible, isrequired, helptext, ghosttext, contextualhelpdata, "
        + "validationmessage, regularexpression, defaultvalueexpression, isreadonly, location "
        + "FROM datafieldconfig WHERE jurisdiction=? AND location=? AND code=?";
  }

  public static String getAllDataFieldConfigsForLoc() {
    return "SELECT code, name, isvisible, isrequired, helptext, ghosttext, contextualhelpdata, "
        + "validationmessage, regularexpression, defaultvalueexpression, isreadonly, location "
        + "FROM datafieldconfig WHERE jurisdiction=? AND location=?";
  }

  public static String getAllDataFieldNames() {
    return "SELECT code, name FROM datafieldconfig WHERE jurisdiction=? AND location=?";
  }
}
