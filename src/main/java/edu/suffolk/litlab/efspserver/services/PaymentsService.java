package edu.suffolk.litlab.efspserver.services;

import static edu.suffolk.litlab.efspserver.services.ServiceHelpers.makeResponse;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.RandomString;
import edu.suffolk.litlab.efspserver.XmlHelper;

import tyler.efm.services.EfmFirmService;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.common.PaymentAccountType;
import tyler.efm.services.schema.common.PaymentAccountTypeType;
import tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;
import tyler.efm.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;
import tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;
import tyler.efm.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;
import tyler.efm.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType;
import tyler.efm.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType;

/** Handles communication with Tyler's API regarding Payments and 
 * the Tyler Online Gateway Activation (?), aka TOGA.
 *
 * @author brycew 
 */
@Path("/payments/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PaymentsService {

  public PaymentsService(SecurityHub security, String togaKey, String togaUrl, EfmFirmService firmFactory) {
    this.security = security;
    // Will generated 21 character long transaction ids, the max length.
    this.transactionIdGen = new RandomString(21);
    this.togaKey = togaKey;
    this.togaUrl = togaUrl;
    this.tempAccounts = new HashMap<String, TempAccount>();
    this.firmFactory = firmFactory;
  }

  @GET
  @Path("/global-accounts")
  public Response getGlobalPaymentList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    PaymentAccountListResponseType accounts = firmPort.get().getGlobalPaymentAccountList();
    return makeResponse(accounts, () -> Response.ok(accounts.getPaymentAccount()).build());
  }

  @GET
  @Path("/global-accounts/{account_id}")
  public Response getGlobalPaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    GetPaymentAccountRequestType req = new GetPaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    GetPaymentAccountResponseType account = firmPort.get().getGlobalPaymentAccount(req);
    return makeResponse(account, () -> Response.ok(account.getPaymentAccount()).build());
  }

  @POST
  @Path("/global-accounts")
  public Response createGlobalWaiverAccount(@Context HttpHeaders httpHeaders,
      String accountName) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    return createWaiverAccount(true, accountName, firmPort.get());
  }

  @PATCH
  @Path("/global-accounts/{account_id}")
  public Response updateGlobalPaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId, String json) {

    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    return updateAccountType(json, () -> {
      GetPaymentAccountRequestType query = new GetPaymentAccountRequestType(); 
      query.setPaymentAccountID(accountId);
      return firmPort.get().getGlobalPaymentAccount(query);
    }, (UpdatePaymentAccountRequestType newAccount) -> {
      return firmPort.get().updateGlobalPaymentAccount(newAccount);
    });
  }

  @DELETE
  @Path("/global-accounts/{account_id}")
  public Response removeGlobalPaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    RemovePaymentAccountRequestType req = new RemovePaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    BaseResponseType resp = firmPort.get().removeGlobalPaymentAccount(req);
    return makeResponse(resp, () -> Response.ok().build());
  }

  @GET
  @Path("/payment-accounts")
  public Response getPaymentAccountList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    PaymentAccountListResponseType list = firmPort.get().getPaymentAccountList();
    return makeResponse(list, () -> Response.ok(list.getPaymentAccount()).build());
  }

  @GET
  @Path("/payment-accounts/{account_id}")
  public Response getPaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    GetPaymentAccountRequestType req = new GetPaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    GetPaymentAccountResponseType resp = firmPort.get().getPaymentAccount(req);

    return makeResponse(resp, () -> Response.ok(resp.getPaymentAccount()).build());
  }

  @DELETE
  @Path("/payment-accounts/{account_id}")
  public Response removePaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    RemovePaymentAccountRequestType req = new RemovePaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    BaseResponseType resp = firmPort.get().removePaymentAccount(req);
    return makeResponse(resp, () -> Response.ok().build());
  }

  @POST
  @Path("/payment-accounts")
  public Response createWaiverAccount(@Context HttpHeaders httpHeaders,
      String accountName) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    return createWaiverAccount(false, accountName, firmPort.get());
  }

  @PATCH
  @Path("/payment-accounts/{account_id}")
  public Response updatePaymentAccount(@Context HttpHeaders httpHeaders,
      @PathParam("account_id") String accountId,
      String json) throws JsonMappingException, JsonProcessingException {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    return updateAccountType(json, () -> {
      GetPaymentAccountRequestType query = new GetPaymentAccountRequestType(); 
      query.setPaymentAccountID(accountId);
      return firmPort.get().getPaymentAccount(query);
    }, (UpdatePaymentAccountRequestType newAccount) -> {
      return firmPort.get().updatePaymentAccount(newAccount);
    });
  }

  @GET
  @Path("/types")
  public Response getPaymentAccountTypeList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    PaymentAccountTypeListResponseType types = firmPort.get().getPaymentAccountTypeList();
    return makeResponse(types, () -> Response.ok(types.getPaymentAccountType()).build());
  }

  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Path("/new-toga-account")
  @Produces("text/html")
  public Response redirectToToga(@Context HttpHeaders httpHeaders,
      @FormParam("account_name") String name, @FormParam("global") boolean global,
      @FormParam("type_code") String typeCode, @FormParam("tyler_info") String tylerInfo,
      @FormParam("original_url") String originalUrl, @FormParam("error_url") String errorUrl) {
    String errorHtml = """
    <html>
      <head>
      </head>
      <body>
        Sorry, but an error has occured. Please restart your redirect process.
        
        The error: %s
      </body>
    """;
    String transactionId = transactionIdGen.nextString();
    TempAccount account = new TempAccount();
    account.name = name;
    account.global = global;
    if (typeCode.equals("WV")) {
      String err = "Don't need TOGA to create a Waiver: send a POST to /waiver-accounts";
      log.error(err);
      return Response.status(422).entity(errorHtml.formatted(err)).build();
    }
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, tylerInfo); 
    if (firmPort.isEmpty()) {
      String err = "Unable to use your login information with Tyler: will not be able to create the payment account.";
      log.error(err);
      return Response.status(422).entity(errorHtml.formatted(err)).build();
    }
    PaymentAccountTypeListResponseType types = firmPort.get().getPaymentAccountTypeList();
    // If this Tyler system dosen't support this payment account type (Credit, bank, etc.), error out
    if (!types.getPaymentAccountType().stream().anyMatch(type -> type.getCode().equalsIgnoreCase(typeCode))) {
      String err = "Cannot create that type of payment account.";
      log.error(err);
      return Response.status(422).entity(errorHtml.formatted(err)).build();
    }
    account.typeCode = typeCode;
    account.loginInfo = tylerInfo;
    account.originalUrl = originalUrl;
    account.errorUrl = errorUrl;
    log.info("Going back to original url: " + originalUrl);
    tempAccounts.put(transactionId, account);

    log.info("Redirecting with transactionId: " + transactionId);
    String fullHtml = """
<html>
    <head>
    </head>
    <body>
    Please wait, this page will redirect...
    </body>
    <script>
      data = '<PaymentRequest><ClientKey>%s</ClientKey><TransactionID>%s</TransactionID>' +
          '<RedirectURL>%s</RedirectURL><Amount>-1</Amount><GetToken>1</GetToken></PaymentRequest>';

      const form = document.createElement('form');
      form.method = 'post';
      form.action = '%s';

      const hiddenField = document.createElement('input');
      hiddenField.type = 'hidden';
      hiddenField.name = 'RequestXML';
      hiddenField.value = data;
      form.appendChild(hiddenField);
      document.body.appendChild(form);
      form.submit();
    </script>
</html>
                """.formatted(this.togaKey, transactionId, this.callbackToUsUrl, this.togaUrl);
    return Response.ok(fullHtml).build();
  }

  @XmlType(name="")
  @XmlRootElement(name="PaymentResponse")
  private static class TogaResponseXml {
    @XmlElement(name="ClientKey")
    String clientKey;
    @XmlElement(name="TransactionID")
    String transactionId;
    @XmlElement(name="Amount")
    String amount;
    @XmlElement(name="ReferenceNumber")
    String referenceNumber;
    @XmlElement(name="PayorToken")
    String payorToken;
    @XmlElement(name="PayorName")
    String payorName;
    @XmlElement(name="TenderDescription")
    String tenderDescription;
    @XmlElement(name="ExpirationMonth")
    int expirationMonth;
    @XmlElement(name="ExpirationYear")
    int expirationYear;
    @XmlElement(name="PaymentTimestamp")
    String paymentTimestamp;
  }

  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Path("/toga-account")
  public Response makeNewPaymentAccount(@Context HttpHeaders httpHeaders,
      @FormParam("ResponseXML") String body) {
    log.info("Making new payment account with Tyler's response: " + body);
    try {
      JAXBContext jaxContext = JAXBContext.newInstance(TogaResponseXml.class);
      Unmarshaller unmar = jaxContext.createUnmarshaller();
      InputStream stream = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));
      TogaResponseXml resp = (TogaResponseXml) unmar.unmarshal(stream);

      CreatePaymentAccountRequestType createAccount = new CreatePaymentAccountRequestType();
      TempAccount tempInfo = tempAccounts.get(resp.transactionId);
      PaymentAccountType newAccount = new PaymentAccountType();
      Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(firmFactory, tempInfo.loginInfo);
      if (firmPort.isEmpty()) {
        return Response.status(403).build();
      }
      List<PaymentAccountTypeType> types = firmPort.get().getPaymentAccountTypeList().getPaymentAccountType();

      // Since users can change their minds and enter a credit card on the TOGA site while telling
      // us they wanted a bank account, we default to the TOGA response. There are several cases: 
      // * TOGA response is a credit card and it's accepted: use it!
      // * it's a Credit card, but not accepted: fallback
      // * it's a bank account, is accepted: use it!
      // * it's a bank account, but not accepted: fallback
      // * can't tell what it is: fallback
      String[] tenderDesc = resp.tenderDescription.split(" ");
      String cardType = tenderDesc[0];
      newAccount.setCardType(tylerCommonObjFac.createPaymentAccountTypeCardType(cardType));
      log.info("Card Type: " + cardType);
      if (cardType.equalsIgnoreCase("MASTERCARD") || cardType.equalsIgnoreCase("DISCOVER") || cardType.equalsIgnoreCase("VISA") 
          || cardType.equalsIgnoreCase("American Express")) {
        if (types.stream().anyMatch(type -> type.getCode().equalsIgnoreCase("CC"))) {
          newAccount.setPaymentAccountTypeCode("CC");
        } else {
          // Fallback to the given type code
          newAccount.setPaymentAccountTypeCode(tempInfo.typeCode);
        }
      } else if (cardType.equalsIgnoreCase("Checking") || cardType.equalsIgnoreCase("Savings")) {
        if (types.stream().anyMatch(type -> type.getCode().equalsIgnoreCase("BankAccount"))) {
          newAccount.setPaymentAccountTypeCode("BankAccount");
        } else {
          newAccount.setPaymentAccountTypeCode(tempInfo.typeCode);
        }
      } else {
        // We don't know what this account type is! Fallback to what we were given initially
        newAccount.setPaymentAccountTypeCode(tempInfo.typeCode);
      }
      newAccount.setAccountName(tempInfo.name);
      newAccount.setAccountToken(resp.payorToken);
      newAccount.setCardHolderName(tylerCommonObjFac.createPaymentAccountTypeCardHolderName(resp.payorName));
      newAccount.setCardMonth(tylerCommonObjFac.createPaymentAccountTypeCardMonth(resp.expirationMonth));
      newAccount.setCardYear(tylerCommonObjFac.createPaymentAccountTypeCardYear(resp.expirationYear));
      String lastItem = tenderDesc[tenderDesc.length - 1];
      String last4 = lastItem.substring(lastItem.length() - 4);
      newAccount.setCardLast4(last4);
      createAccount.setPaymentAccount(newAccount);
      log.info("Final reply for payment account: " + XmlHelper.objectToXmlStrOrError(createAccount, CreatePaymentAccountRequestType.class));
      CreatePaymentAccountResponseType accountResp;
      if (tempInfo.global) {
        accountResp = firmPort.get().createGlobalPaymentAccount(createAccount);
      } else {
        accountResp = firmPort.get().createPaymentAccount(createAccount);
      }
      if (ServiceHelpers.hasError(accountResp)) {
        log.error(accountResp.getError().getErrorCode() + " " + accountResp.getError().getErrorText());
        return Response.status(302).header("Location", tempInfo.errorUrl).build();
      }
      return Response.status(302).header("Location", tempInfo.originalUrl).build();
    } catch (JAXBException jaxbEx) {
      log.error("Couldn't process the TOGA response in XML: " + body);
      log.error(jaxbEx.toString());
      return Response.status(400).entity("<html><body>Sorry, we had an error processing that payment account. Please try again.</body></html>").build();
    }
  }
  
  private static Response createWaiverAccount(boolean global, String accountName, IEfmFirmService firmPort) {
    CreatePaymentAccountRequestType createAccount = new CreatePaymentAccountRequestType();
    PaymentAccountType newAccount = new PaymentAccountType();
    newAccount.setPaymentAccountTypeCode("WV");
    newAccount.setAccountName(accountName);
    createAccount.setPaymentAccount(newAccount);
    CreatePaymentAccountResponseType resp;
    if (global) {
      resp = firmPort.createGlobalPaymentAccount(createAccount);
    } else {
      resp = firmPort.createPaymentAccount(createAccount);
    }
    if (ServiceHelpers.hasError(resp)) {
      return Response.status(400).entity(resp.getError().getErrorCode() + " " + resp.getError().getErrorText()).build();
    }
    
    return Response.ok("\"" + resp.getPaymentAccountID() + "\"").build();
  }


  /** Fluid interface, but modifies the input. */
  private Response updateAccountType(String updateInfoStr, 
      Supplier<GetPaymentAccountResponseType> accountSupplier, 
      Function<UpdatePaymentAccountRequestType, UpdatePaymentAccountResponseType> updateAccount) { 
    ObjectMapper mapper = new ObjectMapper();
    JsonNode updateInfo;
    try {
      updateInfo = mapper.readTree(updateInfoStr);
    } catch (JsonProcessingException ex) {
      return Response.status(400).entity(ex.toString()).build();
    }

    GetPaymentAccountResponseType existingResp = accountSupplier.get(); 
    if (ServiceHelpers.hasError(existingResp)) {
      return Response.status(400).entity(existingResp.getError()).build();
    }
    PaymentAccountType existingAccount = existingResp.getPaymentAccount(); 
    JsonNode active = updateInfo.get("active");
    if (active != null && active.isBoolean()) {
      existingAccount.setActive(tylerCommonObjFac.createPaymentAccountTypeActive(active.asBoolean()));
    }

    JsonNode name = updateInfo.get("account_name");
    if (name != null && name.isTextual()) {
      existingAccount.setAccountName(name.asText());
    }

    UpdatePaymentAccountRequestType update = new UpdatePaymentAccountRequestType();
    update.setPaymentAccount(existingAccount); 
    UpdatePaymentAccountResponseType resp = updateAccount.apply(update);
    return makeResponse(resp, () -> Response.ok().build());
  }

  private static Logger log = LoggerFactory.getLogger(PaymentsService.class);

  private tyler.efm.services.schema.common.ObjectFactory tylerCommonObjFac =
      new tyler.efm.services.schema.common.ObjectFactory();

  private static class TempAccount {
    String name;
    String loginInfo;
    boolean global;
    String typeCode;
    String originalUrl;
    String errorUrl;
  }

  private final Map<String, TempAccount> tempAccounts;

  // Set by some JAX magic.
  @Context
  UriInfo uri;

  private final SecurityHub security;
  private final RandomString transactionIdGen;
  private final String togaKey;
  private final String callbackToUsUrl = ServiceHelpers.BASE_URL + "/payments/toga-account"; 
  private final String togaUrl;
  private final EfmFirmService firmFactory;

}
