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
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import java.io.*;
import java.net.InetAddress;


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
  public static int sendEmail(String from, String subject, String to, String messageTemplate,
      Map<String, Object> context) throws IOException {

    String sendingMethod = System.getenv("EMAIL_METHOD");
    if (sendingMethod == "sendgrid") {
      return sendSendgridEmail(from, subject, to, messageTemplate, context);
    } else {
      boolean success = sendSmtpEmail(from, subject, to, messageTemplate, context);
      return (success) ? 200 : 400; // Should remove the status code and make this a void method
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
  public static boolean sendSmtpEmail(String from, String subject, String to, String messageTemplate,
      Map<String, Object> context) throws IOException {

    Properties props = new Properties();
    props.setProperty("mail.smtp.host", System.getenv("SMTP_SERVER"));
    props.setProperty("mail.smtp.port", System.getenv("SMTP_PORT")); // 587 for TLS; 465 for SSL; 25 without (uncommon)
    props.setProperty("mail.smtp.auth", System.getenv("SMTP_ENABLE_AUTH")); // Use lowercase true/false
    
    Session session = Session.getInstance(props,
    new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(System.getenv("SMTP_USER"), System.getenv("SMTP_PASSWORD"));
}
    });

    Jinjava jinjava = new Jinjava();

    String renderedTemplate = jinjava.render(messageTemplate, context);

    try {
      MimeMessage msg = new MimeMessage(session);
      msg.setFrom(new InternetAddress(from));
      msg.setRecipients(MimeMessage.RecipientType.TO, to);
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
  public static int sendSendgridEmail(String from, String subject, String to, String messageTemplate,
      Map<String, Object> context) throws IOException {

    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    Jinjava jinjava = new Jinjava();
    String renderedTemplate = jinjava.render(messageTemplate, context);

    Mail mail = new Mail(new Email(from), subject, new Email(to), new Content("text/plain", renderedTemplate));

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
  public static String sendSms(String to, String messageTemplate, HashMap<String, Object> context) {
    Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
    String from = System.getenv("TWILIO_SENDING_NUMBER");
    Jinjava jinjava = new Jinjava();
    String renderedTemplate = jinjava.render(messageTemplate, context);

    Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), renderedTemplate).create();

    return message.getSid();
  }

  public static boolean isValidEmail(String email) {
    return true;
  }

  public static boolean isValidPhoneNumber(String phoneNumber) {
    return true;
  }
  // TODO: maybe allow multiple services?
  // private SendTwilioSMS
  // private SendSendgridEmail

  // in EFSPServer.java, we load various configurations. That would choose the
  // parameters that are set in the classes.
  // No overloading of the method parameters--always require the type

}
