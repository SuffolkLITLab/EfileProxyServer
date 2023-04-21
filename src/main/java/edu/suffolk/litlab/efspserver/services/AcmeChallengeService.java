package edu.suffolk.litlab.efspserver.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/.well-known")
public class AcmeChallengeService implements AcmeChallengePublisher {

  private String token;
  private String content;

  public boolean setTokenContent(String token, String content) {
    this.token = token;
    this.content = content;
    return true;
  }

  public boolean removeTokenContent() {
    this.token = "";
    this.content = "";
    return true;
  }

  @GET
  @Path("/acme-challenge/{token}")
  public Response getChallengeResponse(@PathParam("token") String inToken) {
    if (inToken == null || inToken.isBlank()) {
      return Response.status(404).build();
    }
    if (inToken.equals(token)) {
      return Response.ok(content).build();
    }
    if (AcmeChallengeWriter.TOKEN_FILE.exists()) {
      try {
        String fromFileToken = smallFileReading(AcmeChallengeWriter.TOKEN_FILE);
        String fromFileContent = smallFileReading(AcmeChallengeWriter.CONTENT_FILE);
        if (inToken.equals(fromFileToken)) {
          return Response.ok(fromFileContent).build();
        }
      } catch (IOException ex) {
        return Response.status(500).build();
      }
    }
    return Response.status(404).build();
  }

  private static String smallFileReading(File fileToRead) throws IOException {
    FileInputStream tokenStream = new FileInputStream(fileToRead);
    byte[] data = new byte[(int) fileToRead.length()];
    tokenStream.read(data);
    tokenStream.close();
    return new String(data, "UTF-8");
  }
}
