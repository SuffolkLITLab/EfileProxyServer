package edu.suffolk.assemblyline.efspserver;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;

@Path("/userservice/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class UserService {
  private static final QName USER_SERVICE_NAME = new QName("urn:tyler:efm:services",
      "EfmUserService");
  private IEfmUserService userPort;

  public UserService() {
    init();
  }

  @POST
  @Path("/authenticateuser/")
  public Response authenticateUser(UserAuth userAuth) {
    System.out.println("Invoking User Auth for " + userAuth.getUsername());
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail(userAuth.getUsername());
    authReq.setPassword(userAuth.getPassword());
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);
    System.out.println(authRes.getError().getErrorText());
    if (!authRes.getError().getErrorCode().equals("0")) {
      return Response.status(499, authRes.getError().getErrorText()).build();
    } else {
      return Response.ok(authRes.getPasswordHash()).build();
    }
  }
  
  

  final void init() {
    URL userWsdlUrl = EfmUserService.WSDL_LOCATION;
    userPort = makeUserService(userWsdlUrl);
  }

  public static IEfmUserService makeUserService(URL userWsdlUrl) {
    EfmUserService ss = new EfmUserService(userWsdlUrl, USER_SERVICE_NAME);
    System.out.println(userWsdlUrl.getHost() + userWsdlUrl.getPath());
    IEfmUserService port = ss.getBasicHttpBindingIEfmUserService();
    BindingProvider bp = (BindingProvider) port;
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
    return port;
  }

}
