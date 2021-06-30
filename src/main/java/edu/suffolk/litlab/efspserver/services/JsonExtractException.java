package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

public class JsonExtractException extends JsonParseException {

  private ExtractError err;
  private static final long serialVersionUID = 1L;

  public JsonExtractException(JsonParser p, ExtractError err) {
    super(p, err.toString());
    this.err = err;
  }
  
  public ExtractError getError() {
    return err;
  }
}
