package Utils;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Mail {
    public Boolean mail(String email) {
        String to = email; // to address. It can be any like gmail, hotmail etc.
        final String from = "gwnbank@gmail.com"; // from address. As this is using Gmail SMTP.
        final String password = "mhvzkukywtrkimcz"; // password for from mail address. 
        
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
        });
        
        try {
        
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Verify to create a GWN Bank account");

            
            Random verificationCode = new Random();
            int minimum = 10000;
            int maximum = 99999;
            Defaults.verificationCode = verificationCode.nextInt(minimum, maximum);

            int code = Defaults.verificationCode;
                
            String msg = "To verify your email address, please use the following One Time Password (OTP): <br><br>";
            String msgTwo = code + "</p> <br><br>";
            String msgThree = "Do not share this OTP with anyone. GWN Bank takes your account security very seriously. GWN Bank Customer Service will never ask you to disclose or verify your GWN Bank password, OTP, credit card, or banking account number. If you receive a suspicious email with a link to update your account information, do not click on the link-instead, report the email to GWN Bank for investigation<br><br>";
            String msgFour = "Thank you, <br>The GWN Bank Team";  

            String fullMsg = msg + msgTwo + msgThree + msgFour;

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(fullMsg, "text/html");
                
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
                
            /* Dont need
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File("E://Tools//Screenshot.JPG"));
            multipart.addBodyPart(attachmentBodyPart);
            */

            message.setContent(multipart);
            
            Transport.send(message);
        
        } catch (MessagingException e) {
            System.out.println("Invalid Email Address");
            return false;
        } 
        return true;
    }
}
