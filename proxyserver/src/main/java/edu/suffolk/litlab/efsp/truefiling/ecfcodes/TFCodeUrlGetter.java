package edu.suffolk.litlab.efsp.truefiling.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.CodeUrlGetter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TFCodeUrlGetter implements CodeUrlGetter {

  public TFCodeUrlGetter() {}

  @Override
  public InputStream get(String url) throws IOException, URISyntaxException {
    return getCodesZip(url);
  }

  @Override
  public boolean refresh(String court) {
    return true;
  }

  private InputStream getCodesZip(String toRead) throws URISyntaxException, IOException {
    if (toRead.startsWith("http://") || toRead.startsWith("https://")) {
      URL url = (new URI(toRead)).toURL();
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      return conn.getInputStream();
    } else {
      return new FileInputStream(toRead);
    }
  }
}
