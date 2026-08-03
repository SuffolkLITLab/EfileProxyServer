package edu.suffolk.litlab.efsp.tyler.ecfcodes;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import edu.suffolk.litlab.efsp.ecfcodes.CodeUrlGetter;
import edu.suffolk.litlab.efsp.server.utils.HeaderSigner;

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
    public boolean refresh() {
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
      return conn.getInputStream();
    } else {
      return new FileInputStream(toRead);
    }
  }
    
}
