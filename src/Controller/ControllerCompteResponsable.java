package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import metier.*;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import static metier.MetierImpl.StaticResponsable;

public class ControllerCompteResponsable implements Initializable {

    @FXML
    private TextField cnm;
    @FXML
    private TextField cpr;
    @FXML
    private TextField cmail;
    @FXML
    private TextField ctel;
    @FXML
    private TextField cadd;

    @FXML
    private PasswordField anpss;
    @FXML
    private TextField noump;
    @FXML
    private TextField anmp;
    @FXML
    private ImageView img;

MetierImpl imp =new MetierImpl();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      Image nw=  new Image(getClass().getResourceAsStream("../image/img.jpg"));
        img.setImage(nw);
      /*  Responsable responsable= new Responsable("Kafando","Bertrand","kaf@gmail","tel","add","pass");
       imp.ajouterResponsable(responsable);
        Intervenant inter=new Intervenant("diallo","assimi","mail","tele","add","pass");
        Intervenant inter1=new Intervenant("mochine","mochine","mail","tele","add","pass");
        imp.AddInter(inter); imp.AddInter(inter1);

       */
      /* Entreprise ent1= new Entreprise("enset","tel","mail");
       Entreprise ent2= new Entreprise("enset.com","tel","mail");
     imp.ajouterEntreprise(ent1); imp.ajouterEntreprise(ent2);

       */
/*
       OrdreTravail ord1=new OrdreTravail(new Date(),"type2","descipt",10, 2000,5, false, imp.getResponsable(),imp.getAllInter().get(0),
       imp.getEntreprises().get(0));
        OrdreTravail ord2=new OrdreTravail(new Date(),"type1","des",20, 2000,5, false, imp.getResponsable(),imp.getAllInter().get(0),
                imp.getEntreprises().get(1));
              OrdreTravail or1=new OrdreTravail(new Date(),"type1","descript",10, 2000,5, false, imp.getResponsable(),imp.getAllInter().get(1), imp.getEntreprises().get(0)
               );
        OrdreTravail or2=new OrdreTravail(new Date(),"type2","des",5, 2000,5, false, imp.getResponsable(),imp.getAllInter().get(1),
                imp.getEntreprises().get(1));

        imp.ajouterOrdreTravail(or1);imp.ajouterOrdreTravail(or2);imp.ajouterOrdreTravail(ord1);imp.ajouterOrdreTravail(ord2);

*/


        cnm.setPromptText(StaticResponsable.getNom());
        cpr.setPromptText(StaticResponsable.getPrenom());
        cmail.setPromptText(StaticResponsable.getEmail());
        ctel.setPromptText(StaticResponsable.getTelephone());
        cadd.setPromptText(StaticResponsable.getAdresse());

    }

    public  void changer(){
        if(anpss.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("entrez votre mot de passe");
            alert.show();
        } else if(!anpss.getText().equals(StaticResponsable.getPassword())){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText(" votre mot de passe erronée");
            alert.show();
        }
        else  if(anpss.getText().equals(StaticResponsable.getPassword())){
             if(noump.getText().equals("")) {
                 Alert alert=new Alert(Alert.AlertType.ERROR);
                 alert.setContentText("entrez un nouveau mot de passe");
                 alert.show();
             }else{
                 Responsable responsable=StaticResponsable;
                 responsable.setPassword(noump.getText());
                 imp.modifierlesinformations(responsable);
                 Alert alert=new Alert(Alert.AlertType.INFORMATION);
                 alert.setContentText("nouveau mot de passe :"+noump.getText());
                 alert.show();
             }
        }


    }

    public  void cmodifier(){
        String nom=cnm.getText();
        String prenom=cpr.getText();
        String mail=cmail.getText();
        String tel=ctel.getText();
        String add=cadd.getText();

        Responsable responsable=imp.getResponsable();
         if(!nom.equals(""))  responsable.setNom(nom);
        System.out.println(nom);
        if(!prenom.equals(""))  responsable.setPrenom(prenom);
        if(!mail.equals("")) responsable.setEmail(mail);
        if(!tel.equals("")) responsable.setTelephone(tel);
        if(!cadd.getText().equals("")) responsable.setAdresse(add);
        imp.modifierlesinformations(responsable);

        cnm.setPromptText(imp.getResponsable().getNom());
        cpr.setPromptText(imp.getResponsable().getPrenom());
        cmail.setPromptText(imp.getResponsable().getEmail());
        ctel.setPromptText(imp.getResponsable().getTelephone());
        cadd.setPromptText(imp.getResponsable().getAdresse());

    }
}
