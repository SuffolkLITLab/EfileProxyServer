package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

public class JsonExtractException extends JsonParseException {

  private FilingError err;
  private static final long serialVersionUID = 1L;

  public JsonExtractException(JsonParser p, FilingError err) {
    super(p, err.toString());
    this.err = err;
  }
  
  public FilingError getError() {
    return err;
  }
}
