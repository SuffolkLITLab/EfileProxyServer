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
import java.util.HashMap;
import java.util.Map;

public class SendMessage {

  /** Main just for testing. */
  public static void main(String[] args) throws IOException {
    HashMap<String, Object> context = new HashMap<String, Object>();
    context.put("name", "Suffolk LIT Lab Test");
    // sendEmail("test@example.com", "Test email", "massaccess@suffolk.edu", 
    //    "Hello, {{ name }}. message body", context);
    //sendSms("+1.........", "Hello {{ name }}", context);
  }
  
  /**
   * Send an email, currently using the SendGrid API. Depends on the env variable SENDGRID_API_KEY.
   * which should be a valid API key for Twilio SendGrid.
   *
   * @param from The email "from" address
   * @param subject The email subject
   * @param to The email recipient
   * @param messageTemplate A string with optional Jinja2 template variables.
   *        Will be rendered as plain text.
   * @param context A HashMap containing variables that will be substituted in the message_template
   * @throws IOException If there's a network error talking to sendgrid
   */
  public static int sendEmail(String from, String subject, String to, 
      String messageTemplate, Map<String, Object> context) throws IOException {
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    Jinjava jinjava = new Jinjava();
    String renderedTemplate = jinjava.render(messageTemplate, context);

    Mail mail = new Mail(new Email(from), subject, new Email(to), 
        new Content("text/plain", renderedTemplate));

    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
      return response.getStatusCode();
    } catch (IOException ex) {
      throw ex;
    }
  }

  /**
   * Send an SMS Message, currently using Twilio SMS API. Depends on env variables 
   * - TWILIO_ACCOUNT_SID.
   * - TWILIO_AUTH_TOKEN, and 
   * - TWILIO_SENDING_NUMBER. 
   *
   * @param to a valid phone number for SMS messaging, in ISO format.
   * @param messageTemplate A string with Jinja2 template variables. 
   *        Will be rendered as plain text.
   * @param context a HashMap with variables that will be substituted into the message_template
   */
  public static String sendSms(String to, 
      String messageTemplate, HashMap<String, Object> context) {
    Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
    String from = System.getenv("TWILIO_SENDING_NUMBER");
    Jinjava jinjava = new Jinjava();
    String renderedTemplate = jinjava.render(messageTemplate, context);

    Message message = Message.creator(new PhoneNumber(to), 
        new PhoneNumber(from),
        renderedTemplate).create();
    
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
