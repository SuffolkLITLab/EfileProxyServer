package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import edu.suffolk.litlab.efsp.ecfcodes.CodeUrlGetter;
import edu.suffolk.litlab.efsp.server.utils.HeaderSigner;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.zip.ZipInputStream;

public class TylerCodeUrlGetter implements CodeUrlGetter {

  private HeaderSigner signer;

  public TylerCodeUrlGetter(HeaderSigner signer) {
    this.signer = signer;
  }

  @Override
  public InputStream get(String url) throws IOException, URISyntaxException {
    return getCodesZip(url, signer.signedCurrentTime());
  }

  @Override
  public boolean refresh(String court) {
    return signer.refresh();
  }

  /**
   * Either downloads the codes file from Tyler, or opens an already downloaded local zip file.
   *
   * <p>Code for HttpConnection: https://stackoverflow.com/a/1485730/11416267
   *
   * @return InputStream
   * @throws IOException
   */
  private static InputStream getCodesZip(String toRead, String authHeader)
      throws IOException, URISyntaxException {
    if (toRead.startsWith("http://") || toRead.startsWith("https://")) {
      URL url = (new URI(toRead)).toURL();
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("tyl-efm-api", authHeader);
      var urlStream = conn.getInputStream();

      ZipInputStream zip = new ZipInputStream(urlStream);
      zip.getNextEntry();
      return zip;
    } else {
      return new FileInputStream(toRead);
    }
  }
}
