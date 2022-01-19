package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import metier.IMetier;
import metier.Intervenant;
import metier.MetierImpl;

import java.net.URL;
import java.util.ResourceBundle;

import static Controller.GestionIntervenantController.listeIts;
import static Controller.GestionIntervenantController.staticIt;
import static metier.MetierImpl.StaticIntervenant;


public class ModifierIntervenantController implements Initializable {

    @FXML
    private TextField fieldNom;
    @FXML
    private TextField fieldPrenom;
    @FXML
    private TextField fieldMdp;
    @FXML
    private TextField fieldAdresse;
    @FXML
    private TextField fieldTelephone;
    @FXML
    private TextField fieldEmail;
    private IMetier metier = new MetierImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fieldNom.setText(staticIt.getNom());
        fieldPrenom.setText(staticIt.getPrenom());
        fieldAdresse.setText(staticIt.getAdresse());
        fieldTelephone.setText(staticIt.getTel());
        fieldEmail.setText(staticIt.getEmail());
        fieldMdp.setText(staticIt.getPassword());
    }

    public void modifierIntervenant(){
        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        String adresse = fieldAdresse.getText();
        String telephone = fieldTelephone.getText();
        String email = fieldEmail.getText();
        String mdp = fieldMdp.getText();

        Intervenant it = new Intervenant(staticIt.getId_intervenant(),nom,prenom,email,telephone,adresse,mdp);
        metier.updateInter(it);

        listeIts.clear();
        listeIts.addAll(metier.getAllInter());

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Les informations ont été mises à jour avec succès");
        alert.show();
    }
}
