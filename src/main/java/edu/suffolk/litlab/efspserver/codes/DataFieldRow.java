package edu.suffolk.litlab.efspserver.codes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataFieldRow {
  public String code;
  public String name;
  public boolean isvisible;
  public boolean isrequired;
  public String helptext;
  public String ghosttext;
  public String contextualhelpdata;
  public String validationmessage;
  public Pattern regularexpression;
  public String defaultvalueexpression;
  public boolean isreadonly;
  public String location;

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
    this.code = code;
    this.name = name;
    this.isvisible = isvisible;
    this.isrequired = isrequired;
    this.helptext = helptext;
    this.ghosttext = ghosttext;
    this.contextualhelpdata = contextualhelpdata;
    this.validationmessage = validationmessage;
    if (regularexpression == null || regularexpression.isEmpty()) {
      this.regularexpression = null;
    } else {
      this.regularexpression = Pattern.compile(regularexpression);
    }
    this.defaultvalueexpression = defaultvalueexpression;
    this.isreadonly = isreadonly;
    this.location = location;
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
        + "FROM datafieldconfig WHERE domain=? AND location=? AND code=?";
  }

  public static String getAllDataFieldConfigsForLoc() {
    return "SELECT code, name, isvisible, isrequired, helptext, ghosttext, contextualhelpdata, "
        + "validationmessage, regularexpression, defaultvalueexpression, isreadonly, location "
        + "FROM datafieldconfig WHERE domain=? AND location=?";
  }

  public static String getAllDataFieldNames() {
    return "SELECT code, name FROM datafieldconfig WHERE domain=? AND location=?";
  }
}
