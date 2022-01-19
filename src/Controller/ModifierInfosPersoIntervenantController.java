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

import static metier.MetierImpl.StaticIntervenant;

public class ModifierInfosPersoIntervenantController implements Initializable {
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
    private IMetier metier;

    public void modifierInfos(){

        String nom = fieldNom.getText();
        String prenom = fieldPrenom.getText();
        String adresse = fieldAdresse.getText();
        String telephone = fieldTelephone.getText();
        String email = fieldEmail.getText();
        String mdp = fieldMdp.getText();

        metier = new MetierImpl();
        Intervenant it = new Intervenant(StaticIntervenant.getId_intervenant(),nom,prenom,email,telephone,adresse,mdp);
        metier.updateInter(it);


        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Vos informations ont été mises à jour avec succès");
        alert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fieldNom.setText(StaticIntervenant.getNom());
        fieldPrenom.setText(StaticIntervenant.getPrenom());
        fieldAdresse.setText(StaticIntervenant.getAdresse());
        fieldTelephone.setText(StaticIntervenant.getTel());
        fieldEmail.setText(StaticIntervenant.getEmail());
        fieldMdp.setText(StaticIntervenant.getPassword());

    }
}
