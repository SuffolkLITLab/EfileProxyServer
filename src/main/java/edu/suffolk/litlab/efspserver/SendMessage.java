package edu.suffolk.litlab.efspserver;

import java.io.IOException;
import java.util.HashMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.hubspot.jinjava.Jinjava;


public class SendMessage {

  public static void main(String[] args) throws IOException {
    HashMap<String, Object> context = new HashMap();
    context.put("name", "Suffolk LIT Lab Test");
    // SendEmail("test@example.com", "Test email", "massaccess@suffolk.edu", "Hello, {{ name }}. message body", context);

    SendSMS("+16073514615", "Hello {{ name }}", context);
  }
  
  /**
   * Send an email, currently using the SendGrid API. Depends on the environment variable SENDGRID_API_KEY
   * which should be a valid API key for Twilio SendGrid.
   * @param from The email "from" address
   * @param subject The email subject
   * @param to The email recipient
   * @param message_template A string with optional Jinja2 template variables. Will be rendered as plain text.
   * @param context A HashMap containing variables that will be substituted in the message_template
   * @throws IOException
   */
  public static Integer SendEmail(String from, String subject, String to, String message_template, HashMap<String, Object> context) throws IOException {
    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    Jinjava jinjava = new Jinjava();
    String rendered_template = jinjava.render(message_template, context);

    Mail mail = new Mail(new Email(from), subject, new Email(to), new Content("text/plain", rendered_template) );

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
   * Send an SMS Message, currently using Twilio SMS API. Depends on environment variables TWILIO_ACCOUNT_SID,
   * TWILIO_AUTH_TOKEN, and TWILIO_SENDING_NUMBER. 
   * @param to a valid phone number for SMS messaging, in ISO format.
   * @param message_template A string with Jinja2 template variables. Will be rendered as plain text.
   * @param context a HashMap with variables that will be substituted into the message_template
   * @throws IOException
   */
  public static String SendSMS(String to, String message_template, HashMap<String, Object> context) throws IOException {

    Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
    String from = System.getenv("TWILIO_SENDING_NUMBER");
    Jinjava jinjava = new Jinjava();
    String rendered_template = jinjava.render(message_template, context);

    Message message = Message.creator(new PhoneNumber(to), 
        new PhoneNumber(from),
        rendered_template).create();
    
    return message.getSid();
  }

  public static boolean isValidEmail() {
    return true;
  }

  public static boolean isValidPhoneNumber() {
    return true;
  }
  // SendSMS
  // SendEmail
  // private SendTwilioSMS
  // private SendSendgridEmail

  // in EFSPServer.java, we load various configurations. That would choose the
  // parameters that are set in the classes. No overloading of the method parameters--always require the type

}
