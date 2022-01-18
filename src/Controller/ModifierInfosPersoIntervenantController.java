package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import metier.IMetier;
import metier.Intervenant;
import metier.MetierImpl;

public class ModifierInfosPersoIntervenantController {
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
        Intervenant it = new Intervenant(1,nom,prenom,email,telephone,adresse,mdp);

        metier.updateInter(it);


        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Vos informations ont été mises à jour avec succès");
        alert.show();
    }
}
