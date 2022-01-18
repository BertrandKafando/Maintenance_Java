package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import metier.MetierImpl;
import metier.Responsable;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

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
      Image nw=  new Image(getClass().getResourceAsStream("img.jpg"));
        img.setImage(nw);
      //  Responsable responsable= new Responsable("Kafando","Bertrand","kaf@gmail","tel","add","pass");
      //  imp.ajouterResponsable(responsable);
        cnm.setPromptText(imp.getResponsable().getNom());
        cpr.setPromptText(imp.getResponsable().getPrenom());
        cmail.setPromptText(imp.getResponsable().getEmail());
        ctel.setPromptText(imp.getResponsable().getTelephone());
        cadd.setPromptText(imp.getResponsable().getAdresse());

    }

    public  void changer(){
        if(anpss.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("entrez votre mot de passe");
            alert.show();
        } else  if(anpss.getText().equals(imp.getResponsable().getPassword())){
             if(noump.getText().equals("")) {
                 Alert alert=new Alert(Alert.AlertType.ERROR);
                 alert.setContentText("entrez un nouveau mot de passe");
                 alert.show();
             }else{
                 Responsable responsable=imp.getResponsable();
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
