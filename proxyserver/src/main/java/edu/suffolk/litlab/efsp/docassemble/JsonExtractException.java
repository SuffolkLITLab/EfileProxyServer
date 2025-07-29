package edu.suffolk.litlab.efsp.docassemble;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import edu.suffolk.litlab.efsp.utils.FilingError;

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
