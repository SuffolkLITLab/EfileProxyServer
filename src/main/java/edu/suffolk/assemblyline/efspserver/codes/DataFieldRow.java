package edu.suffolk.assemblyline.efspserver.codes;

public class DataFieldRow {
  public String code;
  public String name;
  public boolean isvisible;
  public boolean isrequired;
  public String helptext;
  public String ghosttext;
  public String contextualhelpdata;
  public String validationmessage;
  public String regularexpression;
  public String defaultvalueexpression;
  public String isreadonly;
  public String location;
  
  /** Constructor directly from Database. */
  public DataFieldRow(String code, String name, String isvisible, String isrequired, 
      String helptext, String ghosttext, String contextualhelpdata, 
      String validationmessage, String regularexpression, String defaultvalueexpression, 
      String isreadonly, String location) {
    this.code = code;
    this.name = name;
    this.isvisible = Boolean.parseBoolean(isvisible);
    this.isrequired = Boolean.parseBoolean(isrequired);
    this.helptext = helptext;
    this.ghosttext = ghosttext;
    this.contextualhelpdata = contextualhelpdata;
    this.validationmessage = validationmessage;
    this.regularexpression = regularexpression;
    this.defaultvalueexpression = defaultvalueexpression;
    this.isreadonly = isreadonly;
    this.location = location;
  }

}
