package edu.suffolk.litlab.efsp.ecfcodes;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public interface CodeUrlGetter {
    public InputStream get(String url) throws IOException, URISyntaxException;
    public boolean refresh();
}
