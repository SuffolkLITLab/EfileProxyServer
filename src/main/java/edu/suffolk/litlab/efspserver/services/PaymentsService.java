package edu.suffolk.litlab.efspserver.services;

import java.net.URI;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.SecurityHub;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.common.PaymentAccountType;
import tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;
import tyler.efm.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;
import tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;

@Path("/payments/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PaymentsService {

  private static Logger log = LoggerFactory.getLogger(PaymentsService.class);
   
  @Context
  UriInfo uri;

  private SecurityHub security;
  
  public PaymentsService(SecurityHub security) {
    this.security = security;
  }

  @GET
  @Path("/global-accounts")
  public Response getGlobalPaymentList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
    PaymentAccountListResponseType accounts = firmPort.get().getGlobalPaymentAccountList();
    if (hasError(accounts)) {
      return Response.status(400).entity(accounts.getError()).build();
    }
    return Response.ok(accounts.getPaymentAccount()).build();
  }
  
  @GET
  @Path("/global-accounts/{account_id}")
  public Response getGlobalPaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
    GetPaymentAccountRequestType req = new GetPaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    GetPaymentAccountResponseType account = firmPort.get().getGlobalPaymentAccount(req);
    if (hasError(account)) {
      return Response.status(400).entity(account.getError()).build();
    }
    return Response.ok(account.getPaymentAccount()).build();
  }
  
  /*
  @PUT
  @Path("/global-accounts")
  public Response createPaymentAccount(@Context HttpHeaders httpHeaders,
      String json) {
    
    
  }
  
  @PATCH
  @Path("/global-accounts/{account_id}")
  public Response updateGlobalPaymentAccount(@Context HttpHeaders httpHeaders,
      String json) {
  }
  
  @DELETE
  @Path("/global-accounts/{account_id}")
  public Response removeGlobalPaymentAccount(@Context HttpHeaders httpHeaders) {
    
  }
  */
  
  @GET
  @Path("/payment-accounts")
  public Response getPaymentAccountList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
    PaymentAccountListResponseType list = firmPort.get().getPaymentAccountList();
    if (hasError(list)) {
      return Response.status(400).entity(list.getError()).build();
    }
    
    return Response.ok(list.getPaymentAccount()).build();
  }
  
  /*
  @GET
  @Path("/payment-accounts/{account_id}")
  public Response getPaymentAccount(@Context HttpHeaders httpHeaders, 
      @PathParam("account_id") String accountId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
  }
  */
  
  /*
  @DELETE
  @Path("/payment-accounts/{account_id}")
  public Response removePaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
  }
  */
  
  @PUT
  @Path("/payment-accounts")
  public Response createPaymentAccount(@Context HttpHeaders httpHeaders,
      PaymentAccountType newAccount) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
    CreatePaymentAccountRequestType createAccount = new CreatePaymentAccountRequestType();
    createAccount.setPaymentAccount(newAccount);
    CreatePaymentAccountResponseType resp = firmPort.get().createPaymentAccount(createAccount);
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getError()).build();
    }
    
    URI newUri = uri.getBaseUriBuilder().path("/payment-account/" + resp.getPaymentAccountID()).build();
    return Response.created(newUri).build();
  }
  
  /*
  @PATCH
  @Path("/payment-accounts/{account_id}")
  public Response updatePaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId,
      String json) throws JsonMappingException, JsonProcessingException {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(json);
    
    GetPaymentAccountRequestType query = new GetPaymentAccountRequestType();
    query.setPaymentAccountID(accountId);
    GetPaymentAccountResponseType existingResp = firmPort.get().getPaymentAccount(query);
    if (hasError(existingResp)) {
      return Response.status(400).entity(existingResp.getError()).build();
    }
    
    PaymentAccountType existingAccount = existingResp.getPaymentAccount();
    
  }
  */

  @GET
  @Path("/payment-account-types")
  public Response getPaymentAccountTypeList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    
    PaymentAccountTypeListResponseType types = firmPort.get().getPaymentAccountTypeList();
    if (hasError(types)) {
      return Response.status(400).entity(types.getError()).build();
    }
    
    return Response.ok(types.getPaymentAccountType()).build();
  }

  private boolean hasError(BaseResponseType resp) {
    return !resp.getError().getErrorCode().equals("0");
  }
  
}
