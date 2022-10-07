package edu.suffolk.litlab.efspserver;

import com.hubspot.jinjava.Jinjava;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import edu.suffolk.litlab.efspserver.services.EfmModuleSetup;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMessage {
  private static Logger log = LoggerFactory.getLogger(SendMessage.class);
  
  private final String sendingMethod;
  private final String smtpServer;
  private final String smtpPort;
  private final String smtpEnableAuth;
  private final String smtpUser;
  private final String smtpPassword;
  private final String sendgridApiKey;
  private final String twilioAccountSid;
  private final String twilioAuthToken;
  private final String twilioSendingNumber;
  
  public static Optional<SendMessage> create() {
    Optional<String> maybeSendingMethod = EfmModuleSetup.GetEnv("EMAIL_METHOD");
    if (maybeSendingMethod.isEmpty()) {
      log.warn("Need EMAIL_METHOD env var to send email confirmations to users.");
      return Optional.empty();
    }
    String sendingMethod = maybeSendingMethod.get();
    String sendgridApiKey = null;
    if (sendingMethod.equalsIgnoreCase("sendgrid")) {
      Optional<String> maybeKey = EfmModuleSetup.GetEnv("SENDGRID_API_KEY");
      if (maybeKey.isEmpty()) {
        log.warn("Need SENDGRID_API_KEY if sending method is " + sendingMethod);
        return Optional.empty();
      }
      sendgridApiKey = maybeKey.get();
    }
    
    List<String> smtpVars; 
    if (sendingMethod.equalsIgnoreCase("smtp")) {
      Map<Boolean, List<Optional<String>>> allSmtpVars = EfmModuleSetup.GetAllEnvs(
          Stream.of("SMTP_SERVER", "SMTP_PORT", "SMTP_ENABLE_AUTH", "SMTP_USER", "SMTP_PASSWORD"));
      // There should be no empty env vars!
      if (allSmtpVars.containsKey(false) && !allSmtpVars.get(false).isEmpty()) {
        return Optional.empty();
      }
      smtpVars = allSmtpVars.get(true).stream().map(opt -> opt.get()).collect(Collectors.toList());
    } else {
      // SMTP not needed, so pass nulls to the constructor
      smtpVars = List.of(); 
    }
    
    List<String> twilioVars;
    if (sendingMethod.equalsIgnoreCase("twilio")) {
      Map<Boolean, List<Optional<String>>> allTwilioVars = EfmModuleSetup.GetAllEnvs(
          Stream.of("TWILIO_ACCOUNT_SID", "TWILIO_AUTH_TOKEN", "TWILIO_SENDING_NUMBER"));
      if (allTwilioVars.containsKey(false) && !allTwilioVars.get(false).isEmpty()) {
        return Optional.empty();
      }
      twilioVars = allTwilioVars.get(true).stream().map(opt -> opt.get()).collect(Collectors.toList());
    } else {
      // Twilio not needed, so pass nulls to the constructor
      twilioVars = List.of(); 
    }
    
    return Optional.of(new SendMessage(sendingMethod, smtpVars, sendgridApiKey, twilioVars)); 
  }
  
  private SendMessage(String sendingMethod, List<String> smtpVars, String sendgridApiKey, List<String> twilioVars) {
    this(sendingMethod,
        (smtpVars.isEmpty()) ? null : smtpVars.get(0),
        (smtpVars.isEmpty()) ? null : smtpVars.get(1),
        (smtpVars.isEmpty()) ? null : smtpVars.get(2),
        (smtpVars.isEmpty()) ? null : smtpVars.get(3),
        (smtpVars.isEmpty()) ? null : smtpVars.get(4),
        sendgridApiKey,
        (twilioVars.isEmpty()) ? null : twilioVars.get(0),
        (twilioVars.isEmpty()) ? null : twilioVars.get(1),
        (twilioVars.isEmpty()) ? null : twilioVars.get(2));
  }
  
  private SendMessage(String sendingMethod,
      String smtpServer,
      String smtpPort,
      String smtpEnableAuth,
      String smtpUser,
      String smtpPassword,
      String sendgridApiKey,
      String twilioAccountSid,
      String twilioAuthToken,
      String twilioSendingNumber) {
    this.sendingMethod = sendingMethod;
    this.smtpServer = smtpServer;
    this.smtpPort = smtpPort;
    this.smtpEnableAuth = smtpEnableAuth;
    this.smtpUser = smtpUser;
    this.smtpPassword = smtpPassword;
    this.sendgridApiKey = sendgridApiKey;
    this.twilioAccountSid = twilioAccountSid;
    this.twilioAuthToken = twilioAuthToken;
    this.twilioSendingNumber = twilioSendingNumber;
  }

  /** Main just for testing. */
  public static void main(String[] args) throws IOException {
    HashMap<String, Object> context = new HashMap<String, Object>();
    context.put("name", "Suffolk LIT Lab Test");
    System.out.println("\n" + System.getenv("SMTP_SERVER") + "\n");

    /*
     sendEmail("test@sender.example.com", "Test email", "test@recipient.example.com",
     "Hello, {{ name }}. message body", context);
    */
    // sendSms("+1.........", "Hello {{ name }}", context);
  }

  /**
   * Send an email, respecting method specified in environment variable
   * EMAIL_METHOD ("smtp" or "sendgrid")
   *
   * @param from            The email "from" address
   * @param subject         The email subject
   * @param to              The email recipient
   * @param messageTemplate A string with optional Jinja2 template variables. Will
   *                        be rendered as plain text.
   * @param context         A HashMap containing variables that will be
   *                        substituted in the message_template
   * @throws IOException If there's a network error talking to sendgrid
   */
  public int sendEmail(String from, String subject, String to, String messageTemplate,
      Map<String, Object> context) throws IOException {

    if (sendingMethod.equalsIgnoreCase("sendgrid")) {
      return sendSendgridEmail(from, subject, to, messageTemplate, context);
    } else if (sendingMethod.equalsIgnoreCase("smtp")) {
      boolean success = sendSmtpEmail(from, subject, to, messageTemplate, context);
      return (success) ? 200 : 400; // Should remove the status code and make this a void method
    } else {
      log.error("No email method not correctly specified. Should be sendgrid or smtp, is: " + sendingMethod);
      return 400;
    }
  }

  /**
   * Send an email via plain SMTP
   *
   * @param from            The email "from" address
   * @param subject         The email subject
   * @param to              The email recipient
   * @param messageTemplate A string with optional Jinja2 template variables. Will
   *                        be rendered as plain text.
   * @param context         A HashMap containing variables that will be
   *                        substituted in the message_template
   * @throws IOException If there's a network error
   */
  public boolean sendSmtpEmail(String from, String subject, String to, String messageTemplate,
      Map<String, Object> context) throws IOException {

    Properties props = new Properties();
    props.setProperty("mail.smtp.host", smtpServer);
    props.setProperty("mail.smtp.port", smtpPort); // 587 for TLS; 465 for SSL; 25 without (uncommon)
    props.setProperty("mail.smtp.auth", smtpEnableAuth); // Use lowercase true/false
    
    Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(smtpUser, smtpPassword); 
       }
    });

    Jinjava jinjava = new Jinjava();
    String renderedTemplate = jinjava.render(messageTemplate, context);

    try {
      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(from));
      msg.setRecipients(RecipientType.TO, to);
      msg.setSubject(subject);
      msg.setSentDate(new Date());
      msg.setText(renderedTemplate);
      Transport.send(msg);
      return true;
    } catch (MessagingException mex) {
      log.error("Email send failed, exception: " + mex);
      return false;
    }
  }

  /**
   * Send an email via Twilio Sendgrid API. Depends on the env variable
   * SENDGRID_API_KEY. which should be a valid API key for Twilio SendGrid.
   *
   * @param from            The email "from" address
   * @param subject         The email subject
   * @param to              The email recipient
   * @param messageTemplate A string with optional Jinja2 template variables. Will
   *                        be rendered as plain text.
   * @param context         A HashMap containing variables that will be
   *                        substituted in the message_template
   * @throws IOException If there's a network error talking to sendgrid
   */
  public int sendSendgridEmail(String from, String subject, String to, String messageTemplate,
      Map<String, Object> context) throws IOException {

    SendGrid sg = new SendGrid(sendgridApiKey); 
    Request request = new Request();
    Jinjava jinjava = new Jinjava();
    String renderedTemplate = jinjava.render(messageTemplate, context).strip();

    String contentType = "text/plain";
    if (renderedTemplate.startsWith("<!DOCTYPE html>")) {
      contentType = "text/html";
    }
    Mail mail = new Mail(new Email(from), subject, new Email(to), new Content(contentType, renderedTemplate));

    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    request.setBody(mail.build());
    Response response = sg.api(request);
    log.info(response.getStatusCode() + " " + response.getHeaders() + " " + response.getBody());
    return response.getStatusCode();
  }

  /**
   * Send an SMS Message, currently using Twilio SMS API. Depends on env variables
   * - TWILIO_ACCOUNT_SID. 
   * - TWILIO_AUTH_TOKEN, and 
   * - TWILIO_SENDING_NUMBER.
   *
   * @param to              a valid phone number for SMS messaging, in ISO format.
   * @param messageTemplate A string with Jinja2 template variables. Will be
   *                        rendered as plain text.
   * @param context         a HashMap with variables that will be substituted into
   *                        the message_template
   */
  public String sendSms(String to, String messageTemplate, HashMap<String, Object> context) {
    Twilio.init(twilioAccountSid, twilioAuthToken); 
    Jinjava jinjava = new Jinjava();
    String renderedTemplate = jinjava.render(messageTemplate, context);

    Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(twilioSendingNumber), renderedTemplate).create();

    return message.getSid();
  }

  public static boolean isValidEmail(String email) {
    // TODO(brycew-later): See RFC 6854 for full validation
    return email.contains("@");
  }

  public static boolean isValidPhoneNumber(String phoneNumber) {
    // TODO(brycew-later): what format does Twilio need numbers in?
    return true;
  }
}
