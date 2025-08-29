package edu.suffolk.litlab.efsp.server.services;

import static edu.suffolk.litlab.efsp.server.utils.ServiceHelpers.setupFirmPort;
import static edu.suffolk.litlab.efsp.tyler.TylerErrorCodes.makeResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import edu.suffolk.litlab.efsp.server.utils.MDCWrappers;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.stdlib.RandomString;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import edu.suffolk.litlab.efsp.tyler.TylerErrorCodes;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import edu.suffolk.litlab.efsp.tyler.TylerJurisdiction;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;
import tyler.efm.latest.services.schema.common.PaymentAccountLocationDetails;
import tyler.efm.latest.services.schema.common.PaymentAccountType;
import tyler.efm.latest.services.schema.common.PaymentAccountTypeType;
import tyler.efm.latest.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.latest.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;
import tyler.efm.latest.services.schema.getpaymentaccountlistrequest.GetPaymentAccountListRequestType;
import tyler.efm.latest.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.latest.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;
import tyler.efm.latest.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.latest.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;
import tyler.efm.latest.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;
import tyler.efm.latest.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType;
import tyler.efm.latest.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType;

/**
 * Handles communication with Tyler's API regarding Payments and the Tyler Online Gateway Activation
 * (?), aka TOGA.
 *
 * @author brycew
 */
@Produces(MediaType.APPLICATION_JSON)
public class PaymentsService {
  private static final Logger log = LoggerFactory.getLogger(PaymentsService.class);
  private static final tyler.efm.latest.services.schema.common.ObjectFactory tylerCommonObjFac =
      new tyler.efm.latest.services.schema.common.ObjectFactory();
  private final String callbackToUsUrl;
  private static final String paymentsErrorHtml =
      """
      <!DOCTYPE html>
      <html>
          <head></head>
          <body>Sorry, we had an error processing that payment account. Please try again.</body>
      </html>
      """;

  // Set by some JAX magic.
  @Context UriInfo uri;

  private final RandomString transactionIdGen;
  private final String togaKey;
  private final String togaUrl;
  private final TylerFirmFactory firmFactory;
  private final Supplier<CodeDatabase> cdSupplier;
  private final Supplier<LoginDatabase> ldSupplier;
  private final TylerJurisdiction jurisdiction;

  public PaymentsService(
      TylerDomain domain,
      String togaKey,
      String togaUrl,
      Supplier<LoginDatabase> ldSupplier,
      Supplier<CodeDatabase> cdSupplier) {
    this.jurisdiction = domain.jurisdiction();
    this.callbackToUsUrl =
        ServiceHelpers.EXTERNAL_URL
            + "/jurisdictions/"
            + jurisdiction.getName()
            + "/payments/toga-account";
    // Will generated 21 character long transaction ids, the max length.
    this.transactionIdGen = new RandomString(21);
    this.togaKey = togaKey;
    this.togaUrl = togaUrl;
    this.tempAccounts = new HashMap<String, TempAccount>();
    var maybeFirmFactory = TylerClients.getEfmFirmFactory(domain);
    if (maybeFirmFactory.isPresent()) {
      this.firmFactory = maybeFirmFactory.get();
    } else {
      throw new RuntimeException(domain + " not in SoapClientChooser for EFMFirm");
    }
    this.cdSupplier = cdSupplier;
    this.ldSupplier = ldSupplier;
  }

  @GET
  @Path("/")
  public Response getAll() {
    EndpointReflection ef =
        new EndpointReflection("/jurisdictions/" + jurisdiction.getName() + "/payments");
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(PaymentsService.class))))
        .build();
  }

  @GET
  @Path("/global-accounts")
  public Response getGlobalPaymentList(@Context HttpHeaders httpHeaders) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.getGlobalPaymentList");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    PaymentAccountListResponseType accounts = firmPort.get().getGlobalPaymentAccountList();
    return makeResponse(accounts, () -> Response.ok(accounts.getPaymentAccount()).build());
  }

  @GET
  @Path("/global-accounts/{account_id}")
  public Response getGlobalPaymentAccount(
      @Context HttpHeaders httpHeaders, @PathParam("account_id") String accountId) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.getGlobalPaymentAccount");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    GetPaymentAccountRequestType req = new GetPaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    GetPaymentAccountResponseType account = firmPort.get().getGlobalPaymentAccount(req);
    return makeResponse(account, () -> Response.ok(account.getPaymentAccount()).build());
  }

  /**
   * Creates a new global waiver account, which can be used for all filers in this EFSP.
   *
   * <p>Access to this API should be gated at the client level. (TODO: should be gated here too, but
   * required new server admin features to be tied to a single Tyler account).
   *
   * @param httpHeaders
   * @param accountName The body should of this should be the waiver account's name.
   * @return The UUID of this new account, to be used as the `tyler_payment_id` attribute when
   *     filing.
   */
  @POST
  @Path("/global-accounts")
  public Response createGlobalWaiverAccount(@Context HttpHeaders httpHeaders, String accountName) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.createGlobalWaiverAccount");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    return createWaiverAccount(true, accountName, firmPort.get());
  }

  @PATCH
  @Path("/global-accounts/{account_id}")
  public Response updateGlobalPaymentAccount(
      @Context HttpHeaders httpHeaders, @PathParam("account_id") String accountId, String json) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.updateGlobalPaymentAccount");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    return updateAccountType(
        json,
        () -> {
          GetPaymentAccountRequestType query = new GetPaymentAccountRequestType();
          query.setPaymentAccountID(accountId);
          return firmPort.get().getGlobalPaymentAccount(query);
        },
        (UpdatePaymentAccountRequestType newAccount) -> {
          return firmPort.get().updateGlobalPaymentAccount(newAccount);
        });
  }

  @DELETE
  @Path("/global-accounts/{account_id}")
  public Response removeGlobalPaymentAccount(
      @Context HttpHeaders httpHeaders, @PathParam("account_id") String accountId) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.removeGlobalPaymentAccount");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    RemovePaymentAccountRequestType req = new RemovePaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    BaseResponseType resp = firmPort.get().removeGlobalPaymentAccount(req);
    return makeResponse(resp, () -> Response.ok().build());
  }

  @GET
  @Path("/payment-accounts/{account_id}")
  public Response getPaymentAccount(
      @Context HttpHeaders httpHeaders, @PathParam("account_id") String accountId) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.getPaymentAccount");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
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
  public Response removePaymentAccount(
      @Context HttpHeaders httpHeaders, @PathParam("account_id") String accountId) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.removePaymentAccount");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    RemovePaymentAccountRequestType req = new RemovePaymentAccountRequestType();
    req.setPaymentAccountID(accountId);
    BaseResponseType resp = firmPort.get().removePaymentAccount(req);
    return makeResponse(resp, () -> Response.ok().build());
  }

  @GET
  @Path("/payment-accounts")
  public Response getPaymentAccountList(
      @Context HttpHeaders httpHeaders, @DefaultValue("") @QueryParam("court_id") String courtId)
      throws SQLException {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.getPaymentAccountList");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    GetPaymentAccountListRequestType req =
        new tyler.efm.latest.services.schema.getpaymentaccountlistrequest.ObjectFactory()
            .createGetPaymentAccountListRequestType();
    if (courtId != null && !courtId.isBlank()) {
      try (CodeDatabase cd = cdSupplier.get()) {
        if (!cd.getAllLocations().contains(courtId)) {
          return Response.status(404).entity("Court does not exist " + courtId).build();
        }
      }
      req.setCourtIdentifier(courtId);
    }

    PaymentAccountListResponseType list = firmPort.get().getPaymentAccountList(req);
    return makeResponse(list, () -> Response.ok(list.getPaymentAccount()).build());
  }

  /**
   * Creates a new waiver account. To create a non-waiver account, see /new-toga-account.
   *
   * @param httpHeaders
   * @param accountName The body should of this should be the waiver account's name. If the user is
   *     manually creating this account, it should be given by them. If you are automatically
   *     creating the waiver account, it's name should be tied to the form the user is submitting
   *     with it (as these are linked on the courts side usually).
   * @return The UUID of this new account, to be used as the `tyler_payment_id` attribute when
   *     filing.
   */
  @POST
  @Path("/payment-accounts")
  public Response createWaiverAccount(@Context HttpHeaders httpHeaders, String accountName) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.createWaiverAccount");
    Optional<TylerFirmClient> firmPort =
        setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    return createWaiverAccount(false, accountName, firmPort.get());
  }

  /**
   * Edits payment account information.
   *
   * <p>Can only edit the <code>account_name</code> and whether it is <code>active</code>.
   *
   * <p>To edit information like the card or bank account number, you will need to create a whole
   * new form of payment.
   */
  @PATCH
  @Path("/payment-accounts/{account_id}")
  public Response updatePaymentAccount(
      @Context HttpHeaders httpHeaders, @PathParam("account_id") String accountId, String json)
      throws JsonMappingException, JsonProcessingException {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.updatePaymentAccount");
    Optional<TylerFirmClient> firmPort =
        ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    return updateAccountType(
        json,
        () -> {
          GetPaymentAccountRequestType query = new GetPaymentAccountRequestType();
          query.setPaymentAccountID(accountId);
          return firmPort.get().getPaymentAccount(query);
        },
        (UpdatePaymentAccountRequestType newAccount) -> {
          return firmPort.get().updatePaymentAccount(newAccount);
        });
  }

  @GET
  @Path("/types")
  public Response getPaymentAccountTypeList(@Context HttpHeaders httpHeaders) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.getPaymentAccountTypeList");
    Optional<TylerFirmClient> firmPort =
        ServiceHelpers.setupFirmPort(firmFactory, httpHeaders, ldSupplier, jurisdiction);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    PaymentAccountTypeListResponseType types = firmPort.get().getPaymentAccountTypeList();
    return makeResponse(types, () -> Response.ok(types.getPaymentAccountType()).build());
  }

  /**
   * An endpoint that generates HTML+JS in order to send a user to Tyler's site where payment
   * information can be securely entered. Should be visited with a form submission from the user's
   * browser, so they can be securely redirected to Tyler's site.
   *
   * <p>The HTML will generate a form submission from the user's browser targeted to Tyler's payment
   * page, using Javascript.
   *
   * <p>Tyler will redirect the user to back to <code>/payments/toga-account</code> once payment
   * info is entered.
   *
   * @param name The desired name of the account
   * @param global whether the new payment type should be global or not (should be false in most
   *     cases).
   * @param typeCode a valid string code from <code>/types</code> (getPaymentAccountTypeList).
   * @param typeCodeId (optional, deprecated) the numerical code ID of the payment; used if Tyler
   *     responds back with an invalid type.
   * @param tylerInfo the login / token information of an authenticated Tyler user. Include here
   *     instead of the headers since this page is reached via a form submission. The info is saved
   *     to act as the user on Tyler's redirection response.
   * @param originalUrl If entry on Tyler's site is successful, forwards the user to this URL.
   * @param errorUrl If there's an error from Tyler's side, forwards the user to this URL.
   * @return an HTML page that the user should visit directly
   */
  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Path("/new-toga-account")
  @Produces("text/html")
  public Response redirectToToga(
      @Context HttpHeaders httpHeaders,
      @FormParam("account_name") String name,
      @FormParam("global") boolean global,
      @FormParam("type_code") String typeCode,
      @Deprecated @FormParam("type_code_id") int typeCodeId,
      @FormParam("tyler_info") String tylerInfo,
      @FormParam("original_url") String originalUrl,
      @FormParam("error_url") String errorUrl) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.redirectToToga");
    String errorHtml =
        """
        <!DOCTYPE html>
        <html>
          <head>
          </head>
          <body>
            Sorry, but an error has occured. Please restart your redirect process.

            The error: %s
          </body>
        </html>
        """;
    String transactionId = transactionIdGen.nextString();
    TempAccount account = new TempAccount();
    account.name = name;
    account.global = global;
    if (typeCode.equals("WV")) {
      String err = "Don't need TOGA to create a Waiver: send a POST to /payment-accounts";
      log.error(err);
      return Response.status(422).entity(errorHtml.formatted(err)).build();
    }
    Optional<TylerFirmClient> firmPort = ServiceHelpers.setupFirmPort(firmFactory, tylerInfo);
    if (firmPort.isEmpty()) {
      String err =
          "Unable to use your login information with Tyler: will not be able to create the payment"
              + " account.";
      log.error(err);
      return Response.status(422).entity(errorHtml.formatted(err)).build();
    }
    PaymentAccountTypeListResponseType types = firmPort.get().getPaymentAccountTypeList();
    // If this Tyler system dosen't support this payment account type (Credit, bank, etc.), error
    // out
    if (!types.getPaymentAccountType().stream()
        .anyMatch(type -> type.getCode().equalsIgnoreCase(typeCode))) {
      String err = "Cannot create that type of payment account.";
      log.error(err);
      return Response.status(422).entity(errorHtml.formatted(err)).build();
    }
    account.typeCodeId = typeCodeId;
    account.loginInfo = tylerInfo;
    account.originalUrl = originalUrl;
    account.errorUrl = errorUrl;
    log.info("Going back to original url: {}", originalUrl);
    tempAccounts.put(transactionId, account);

    log.info("Redirecting with transactionId: {}", transactionId);
    String fullHtml =
"""
<!DOCTYPE html>
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
"""
            .formatted(this.togaKey, transactionId, this.callbackToUsUrl, this.togaUrl);
    return Response.ok(fullHtml).build();
  }

  @XmlType(name = "")
  @XmlRootElement(name = "PaymentResponse")
  private static class TogaResponseXml {
    @XmlElement(name = "ClientKey")
    String clientKey;

    @XmlElement(name = "TransactionID")
    String transactionId;

    @XmlElement(name = "Amount")
    String amount;

    @XmlElement(name = "ReferenceNumber")
    String referenceNumber;

    @XmlElement(name = "PayorToken")
    String payorToken;

    @XmlElement(name = "PayorName")
    String payorName;

    @XmlElement(name = "TenderDescription")
    String tenderDescription;

    @XmlElement(name = "ExpirationMonth")
    int expirationMonth;

    @XmlElement(name = "ExpirationYear")
    int expirationYear;

    @XmlElement(name = "PaymentTimestamp")
    String paymentTimestamp;
  }

  /**
   * The endpoint that Tyler calls when the user enters their payment info into Tyler's system.
   * <code>/payments/new-toga-account</code> will always be called before this endpoint.
   *
   * @param httpHeaders
   * @param body XML that adheres to TogaResponseXml.
   */
  @StatusCodes({
    @ResponseCode(
        code = 302,
        condition =
            "when creating the payment account succeeds or fails, redirects to either originalUrl or errorUrl given to /new-toga-account"),
    @ResponseCode(code = 400, condition = "when the 'ResponseXML' param doesn't contain valid XML"),
    @ResponseCode(
        code = 403,
        condition =
            "when the saved Tyler Token can't be used to create a payment method (i.e. for a firm filer without the permission)"),
    @ResponseCode(
        code = 404,
        condition = "when the 'ResponseXML' contains a transactionId that doesn't exist")
  })
  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Path("/toga-account")
  public Response makeNewPaymentAccount(
      @Context HttpHeaders httpHeaders, @FormParam("ResponseXML") String body) {
    MDC.put(MDCWrappers.OPERATION, "PaymentsService.makeNewPaymentAccount");
    log.info("Making new payment account with Tyler's response: {}", body);
    try {
      JAXBContext jaxContext = JAXBContext.newInstance(TogaResponseXml.class);
      Unmarshaller unmar = jaxContext.createUnmarshaller();
      InputStream stream = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));
      TogaResponseXml resp = (TogaResponseXml) unmar.unmarshal(stream);

      CreatePaymentAccountRequestType createAccount = new CreatePaymentAccountRequestType();
      if (!tempAccounts.containsKey(resp.transactionId)) {
        log.warn("Response transaction id for: {} not there!", resp.transactionId);
        return Response.status(404).entity(paymentsErrorHtml).build();
      }
      TempAccount tempInfo = tempAccounts.get(resp.transactionId);
      Optional<TylerFirmClient> maybeFirmPort =
          ServiceHelpers.setupFirmPort(firmFactory, tempInfo.loginInfo);
      if (maybeFirmPort.isEmpty()) {
        log.warn("Couldn't get the firm port for {}", resp.transactionId);
        return Response.status(403).entity(paymentsErrorHtml).build();
      }
      TylerFirmClient firmPort = maybeFirmPort.get();

      PaymentAccountType newAccount = new PaymentAccountType();
      String[] tenderDesc = resp.tenderDescription.split(" ");
      String cardTypeName = tenderDesc[0];
      newAccount.setCardType(tylerCommonObjFac.createPaymentAccountTypeCardType(cardTypeName));
      List<PaymentAccountTypeType> paymentTypes =
          firmPort.getPaymentAccountTypeList().getPaymentAccountType();
      int codeId = getCodeInt(cardTypeName, paymentTypes, tempInfo.typeCodeId);
      newAccount.setPaymentAccountTypeCode(Integer.toString(codeId));
      newAccount.setPaymentAccountTypeCodeId(
          tylerCommonObjFac.createPaymentAccountTypePaymentAccountTypeCodeId(codeId));
      newAccount.setAccountName(tempInfo.name);
      newAccount.setAccountToken(resp.payorToken);
      newAccount.setCardHolderName(
          tylerCommonObjFac.createPaymentAccountTypeCardHolderName(resp.payorName));
      newAccount.setCardMonth(
          tylerCommonObjFac.createPaymentAccountTypeCardMonth(resp.expirationMonth));
      newAccount.setCardYear(
          tylerCommonObjFac.createPaymentAccountTypeCardYear(resp.expirationYear));
      String lastItem = tenderDesc[tenderDesc.length - 1];
      String last4 = lastItem.substring(lastItem.length() - 4);
      newAccount.setCardLast4(last4);
      createAccount.setPaymentAccount(newAccount);
      CreatePaymentAccountResponseType accountResp;
      if (tempInfo.global) {
        accountResp = firmPort.createGlobalPaymentAccount(createAccount);
      } else {
        accountResp = firmPort.createPaymentAccount(createAccount);
      }
      if (TylerErrorCodes.hasError(accountResp)) {
        log.error(
            "{} {}", accountResp.getError().getErrorCode(), accountResp.getError().getErrorText());
        return Response.status(302).header("Location", tempInfo.errorUrl).build();
      }
      return Response.status(302).header("Location", tempInfo.originalUrl).build();
    } catch (JAXBException jaxbEx) {
      log.error("Couldn't process the TOGA response in XML: {}", body, jaxbEx);
      return Response.status(400).entity(paymentsErrorHtml).build();
    }
  }

  /**
   * Since users can change their minds and enter a credit card on the TOGA site while telling us
   * they wanted a bank account, we default to the TOGA response. There are several cases: - TOGA
   * response is a credit card and it's accepted: use it! - TOGA's a Credit card, but not accepted:
   * fallback - TOGA's a bank account, is accepted: use it! - TOGA's a bank account, but not
   * accepted: fallback - can't tell what it is: fallback
   */
  private static int getCodeInt(
      String cardType, List<PaymentAccountTypeType> types, int fallbackType) {
    if (cardType.equalsIgnoreCase("MASTERCARD")
        || cardType.equalsIgnoreCase("DISCOVER")
        || cardType.equalsIgnoreCase("VISA")
        || cardType.equalsIgnoreCase("AMEX")) {
      var ccType = types.stream().filter(type -> type.getCode().equalsIgnoreCase("CC")).findFirst();
      return ccType.map(t -> t.getCodeId().getValue()).orElse(fallbackType);
    } else if (cardType.equalsIgnoreCase("Checking") || cardType.equalsIgnoreCase("Savings")) {
      var bankType =
          types.stream().filter(type -> type.getCode().equalsIgnoreCase("BankAccount")).findFirst();
      return bankType.map(t -> t.getCodeId().getValue()).orElse(fallbackType);
    } else {
      // We don't know what this account type is! Fallback to what we were given initially
      return fallbackType;
    }
  }

  private static Response createWaiverAccount(
      boolean global, String accountName, TylerFirmClient firmPort) {
    CreatePaymentAccountRequestType createAccount = new CreatePaymentAccountRequestType();
    PaymentAccountType newAccount = new PaymentAccountType();
    List<PaymentAccountTypeType> types =
        firmPort.getPaymentAccountTypeList().getPaymentAccountType();
    Optional<PaymentAccountTypeType> maybeWaiver =
        types.stream().filter((type) -> type.getCode().equalsIgnoreCase("WV")).findFirst();
    if (maybeWaiver.isEmpty()) {
      return Response.status(500).entity("No WV (waiver) account type available? " + types).build();
    }
    var waiverType = maybeWaiver.get();
    if (waiverType.getCodeId() != null) {
      newAccount.setPaymentAccountTypeCode(Integer.toString(waiverType.getCodeId().getValue()));
      newAccount.setPaymentAccountTypeCodeId(
          tylerCommonObjFac.createPaymentAccountTypePaymentAccountTypeCodeId(
              waiverType.getCodeId().getValue()));
    } else {
      newAccount.setPaymentAccountTypeCode(waiverType.getCode());
    }
    PaymentAccountLocationDetails locationDetails =
        tylerCommonObjFac.createPaymentAccountLocationDetails();
    newAccount.setPaymentAccountLocationDetails(locationDetails);
    newAccount.setAccountName(accountName);
    log.info("newAccount: {}", newAccount);
    createAccount.setPaymentAccount(newAccount);
    log.info("createAccount: {}", createAccount);
    CreatePaymentAccountResponseType resp;
    if (global) {
      resp = firmPort.createGlobalPaymentAccount(createAccount);
    } else {
      resp = firmPort.createPaymentAccount(createAccount);
    }
    if (TylerErrorCodes.hasError(resp)) {
      return Response.status(400)
          .entity(resp.getError().getErrorCode() + " " + resp.getError().getErrorText())
          .build();
    }

    return Response.ok("\"" + resp.getPaymentAccountID() + "\"").build();
  }

  /** Fluid interface, but modifies the input. */
  private static Response updateAccountType(
      String updateInfoStr,
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
    if (TylerErrorCodes.hasError(existingResp)) {
      return Response.status(400).entity(existingResp.getError()).build();
    }
    PaymentAccountType existingAccount = existingResp.getPaymentAccount();
    JsonNode active = updateInfo.get("active");
    if (active != null && active.isBoolean()) {
      existingAccount.setActive(
          tylerCommonObjFac.createPaymentAccountTypeActive(active.asBoolean()));
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

  private static class TempAccount {
    String name;
    String loginInfo;
    boolean global;
    int typeCodeId;
    String originalUrl;
    String errorUrl;
  }

  private final Map<String, TempAccount> tempAccounts;
}
