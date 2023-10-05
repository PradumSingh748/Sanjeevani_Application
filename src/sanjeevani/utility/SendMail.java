
package sanjeevani.utility;


import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

class MyAuthenticator extends Authenticator{
    private String username,password;
    public MyAuthenticator(String username,String password){
        this.username=username;
        this.password=password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        PasswordAuthentication pwdAuth=new PasswordAuthentication(this.username,this.password);        
        return pwdAuth;
    }
    
}
public class SendMail implements Sender{
    @Override
    public boolean send(String email, String data) throws Exception {
       
        boolean isSend=false;
   
        final String username = "pradumsingh748@gmail.com";
        final String password = "gyemdibctwkgkcam";
        // Step 1
        Properties prop = new Properties();
	prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        MyAuthenticator myAuth=new MyAuthenticator(username,password);        
        Session session = Session.getInstance(prop,myAuth);                

        try {

            Message message = new MimeMessage(session);
            InternetAddress[]recipients=InternetAddress.parse(email);
            message.setRecipients(
                    Message.RecipientType.TO,
                    recipients
            );
            message.setSubject("Appointment Confirmed!");
            message.setText(data);

            Transport.send(message);

            System.out.println("Mail Sent Successfully!");
            isSend=true;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return isSend;
    }
    
    
}

