package edu.suffolk.litlab.efsp.server.services.api;

import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.server.auth.UserCreds;
import jakarta.ws.rs.core.Response;

public interface CaseSearchAPI {

  public enum ReturnType {
    LEGACY_XML, // just return the raw XML object through the response
    JSON_V1; // convert the XML response into a model object first, the same b/t ECF4 and 5

    public static ReturnType fromString(String s) {
      if (s.equalsIgnoreCase("JSON") || s.equalsIgnoreCase("JSON-V1")) {
        return JSON_V1;
      }
      return LEGACY_XML;
    }
  }

  public Response getCourts();

  public Response queryCases(String courtId, String docketId, UserCreds creds, ReturnType rt);

  public Response queryCases(
      String courtId, Name name, boolean isOrg, UserCreds creds, ReturnType rt);

  public Response getCase(String courtId, String caseId, UserCreds creds, ReturnType rt);

  public Response getServiceInformation(
      String courtId, String caseId, UserCreds creds, ReturnType rt);

  public Response getServiceInformationHistory(
      String courtId, String caseId, UserCreds creds, ReturnType rt);

  public Response queryServiceAttachCases(
      String courtId, String serviceId, UserCreds creds, ReturnType rt);
}
