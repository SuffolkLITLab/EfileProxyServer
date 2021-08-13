package edu.suffolk.litlab.efspserver.services;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SecurityHub;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;
import tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;

@Path("/payments/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PaymentsService {

  private static Logger log = LoggerFactory.getLogger(PaymentsService.class);
   
  private SecurityHub security;
  
  public PaymentsService(SecurityHub security) {
    this.security = security;
  }

  @GET
  @Path("/global_payment")
  public Response getGlobalPaymentList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
    PaymentAccountListResponseType accounts = firmPort.get().getGlobalPaymentAccountList();
    return Response.ok(accounts.getPaymentAccount()).build();
  }
  
  @GET
  @Path("/global_payment/{account_id}")
  public Response getGlobalPaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
    GetPaymentAccountRequestType req = new GetPaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    GetPaymentAccountResponseType account = firmPort.get().getGlobalPaymentAccount(req);
    return Response.ok(account.getPaymentAccount()).build();
  }
}
