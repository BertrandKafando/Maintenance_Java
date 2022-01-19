package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import metier.EnvoiMailNewIntervenant;
import metier.IMetier;
import metier.Intervenant;
import metier.MetierImpl;

import javax.mail.MessagingException;

import static Controller.GestionIntervenantController.listeIts;

public class AjouterIntervenantController {
    @FXML
    private TextField fieldNom;
    @FXML
    private TextField fieldPrenom;
    @FXML
    private TextField fieldAdresse;
    @FXML
    private TextField fieldTelephone;
    @FXML
    private TextField fieldEmail;
    @FXML
    private TextField fieldMdp;

    private IMetier metier = new MetierImpl();


    public void ajouterIntervenant(){

        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        String adr = fieldAdresse.getText();
        String tel = fieldTelephone.getText();
        String email = fieldEmail.getText();
        String mdp = fieldMdp.getText();

        Intervenant it = new Intervenant(nom,prenom,adr,tel,email,mdp);
        metier.AddInter(it);
        listeIts.clear();
        listeIts.addAll(metier.getAllInter());

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("L'intervenant a été ajouté avec succès");
        alert.show();

        try {
            EnvoiMailNewIntervenant.sendMail(it);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
