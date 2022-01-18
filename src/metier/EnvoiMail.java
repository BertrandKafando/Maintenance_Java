package metier;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnvoiMail {

    public static void sendMail(String recepteur) throws MessagingException {
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
        Message message = prepareMessage(session, monAdresseEmail, recepteur);
        Transport.send(message);
        System.out.println("Message envoyé avec succès");
    }

    private static Message prepareMessage(Session session, String monAdresseEmail, String recepteur){
        try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(monAdresseEmail));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepteur));
        message.setSubject("Nouvel ordre de travail");
        message.setText("Bonjour,\n Un nouvel ordre de travail vous a été assigné.\n\n Veuillez vous connectez pour voir les détails.");
        return message;
        } catch (Exception ex) {
            Logger.getLogger(EnvoiMail.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
}
