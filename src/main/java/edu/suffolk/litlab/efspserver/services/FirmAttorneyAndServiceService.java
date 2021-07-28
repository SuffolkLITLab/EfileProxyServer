package edu.suffolk.litlab.efspserver.services;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import tyler.efm.services.EfmFirmService;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.schema.getfirmresponse.GetFirmResponseType;

/**
 * Service that handles the Firm, Attorney, and Service
 * Endpoints.
 * @author litlab
 *
 */
@Path("/firmattorneyservice/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class FirmAttorneyAndServiceService {

  private static Logger log = 
      LoggerFactory.getLogger(FirmAttorneyAndServiceService.class); 

  private EfmFirmService firmServiceFactory;
  private SecurityHub security;
  
  public FirmAttorneyAndServiceService(SecurityHub security) {
    this.security = security;
    init();
  }

  final void init() {
    URL firmWsdlUrl = EfmFirmService.WSDL_LOCATION;
    firmServiceFactory = FirmAttorneyAndServiceService.makeFirmServiceFactory(firmWsdlUrl);
  }

  @GET
  @Path("/firm")
  public Response getSelfFirm(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = setupFirmPort(httpHeaders);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    GetFirmResponseType firm = firmPort.get().getFirm();
    return Response.ok(firm.getFirm()).build();
  }
  
  private static EfmFirmService makeFirmServiceFactory(URL firmWsdlUrl) {
    return new EfmFirmService(firmWsdlUrl, EfmFirmService.SERVICE); 
  }

  private Optional<IEfmFirmService> setupFirmPort(HttpHeaders httpHeaders) {
    String activeToken = httpHeaders.getHeaderString("X-API-KEY");
    Optional<String> tylerCreds = security.checkLogin(activeToken, "tyler");
    if (tylerCreds.isEmpty()) {
      log.warn("Couldn't checkLogin");
      return Optional.empty();
    }
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerCreds.get());
    if (creds.isEmpty()) {
      log.warn("No creds?");
      return Optional.empty();
    }

    IEfmFirmService port = firmServiceFactory.getBasicHttpBindingIEfmFirmService();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      log.warn(ex.toString());
      return Optional.empty();
    }

    return Optional.of(port);
  }


}
