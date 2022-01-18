package Controller;

import metier.EnvoiMail;
import metier.MetierImpl;
import metier.Responsable;

import javax.mail.MessagingException;

public class Application   {
    public  static  void main(String []args){

        //Responsable rep=new Responsable("kaf","bertrand","email","telephone", "adresse", "password");

       // MetierImpl imp=new MetierImpl();

        //imp.supprimerResponsable(imp.getResponsable());
        //System.out.println(imp.getResponsable());
        try {
            EnvoiMail.sendMail("maintenance.app00@gmail.com");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
