package metier;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnvoiMailNewIntervenant {
    public static void sendMail(Intervenant it) throws MessagingException {
        System.out.println("Envoi en cours...");

        Properties properties = new Properties();

        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String monAdresseEmail = "maintenance.app00@gmail.com";
        String password = "maintenance00";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(monAdresseEmail,password);
            }
        });
        Message message = prepareMessage(session, monAdresseEmail,it);
        Transport.send(message);
        System.out.println("Message envoyé avec succès");
    }

    private static Message prepareMessage(Session session, String monAdresseEmail, Intervenant it){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(monAdresseEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(it.getEmail()));
            message.setSubject("Bienvenue à MaintenanceApp");
            message.setText("Bonjour " +it+"\n\n Nous vous souhaitons la bienvenue dans la grande famille MaintenanceAPP\n\nLe Responsable ");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(EnvoiMail.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }

}
