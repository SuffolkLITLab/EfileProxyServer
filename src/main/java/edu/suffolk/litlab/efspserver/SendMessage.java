package edu.suffolk.litlab.efspserver;

import java.io.IOException;
import com.twilio.*;
import com.sendgrid.*;


public class SendMessage {
  
  public static void SendEmail(String from, String subject, string to, String message_template, Map<String, Object> context) throws IOException {

    SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
    Request request = new Request();
    Jinjava jinjava = new Jinjava();
    String renderedTemplate = jinjava.render(message_template, context);

    Mail mail = new Mail(new Email(from), subject, new Email(to), Content("text/plain", renderedTemplate) );

    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
    
  }

  public static void SendSMS() {

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
