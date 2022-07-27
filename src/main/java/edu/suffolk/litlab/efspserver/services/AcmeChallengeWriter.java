package edu.suffolk.litlab.efspserver.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AcmeChallengeWriter implements AcmeChallengePublisher {

  public final static File TOKEN_FILE= new File("acme_token_file.txt");
  public final static File CONTENT_FILE= new File("acme_content_file.txt");

  @Override
  public boolean setTokenContent(String token, String content) {
    try {
      Writer tokenWriter = new FileWriter(TOKEN_FILE);
      tokenWriter.write(token);
      tokenWriter.close();
      Writer contentWriter = new FileWriter(CONTENT_FILE);
      contentWriter.write(content);
      contentWriter.close();
      return true;
    } catch (IOException ex) {
      return false;
    }
  }

  @Override
  public boolean removeTokenContent() {
    return TOKEN_FILE.delete() && CONTENT_FILE.delete();
  }
}
