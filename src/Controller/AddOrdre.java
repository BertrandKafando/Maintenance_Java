package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import metier.*;

import javax.mail.MessagingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static metier.MetierImpl.StaticResponsable;

public class AddOrdre implements Initializable {
     MetierImpl metier =new MetierImpl();
     //@FXML private TextField textService;
    @FXML private TextField textDesc;
    @FXML private DatePicker date;
    @FXML private TextField textTemps;
    @FXML private TextField textBudget;
    @FXML private TextField textPriority;
    @FXML private TextField textNom;
    @FXML private TextField textTel;
    @FXML private TextField textEmail;
    @FXML private TextField eseNom;
    @FXML private TextField eseTel;
    @FXML private TextField eseEmail;
    @FXML private TextField eseAdresse;
    @FXML private ComboBox<String > entreprise;
    @FXML private ComboBox<Intervenant> intervenant = new ComboBox<>();
    @FXML private ComboBox<String > service;
    @FXML ObservableList<Intervenant> intervenants =
            FXCollections.observableArrayList();
    @FXML ObservableList<String> entreprises =
            FXCollections.observableArrayList();
    @FXML ObservableList<String> services =
            FXCollections.observableArrayList(
                    "Reglage",
                    "Setting",
                    "Maintenance",
                    "Mise à jour"
            );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        intervenants.addAll(metier.getAllInter());
        intervenant.getItems().addAll(intervenants);

        for (Entreprise entreprise : metier.getAllEntreprise()) {
            entreprises.add(entreprise.getNom());
        }
        entreprise.setItems(entreprises);

        service.setItems(services);
    }
    public void addEse(){
        Entreprise ese = new Entreprise(eseNom.getText(),eseTel.getText(),eseEmail.getText(),eseAdresse.getText());
        metier.ajouterEntreprise(ese);
        updateListEntreprises();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succès d'ajout");
        //alert.setHeaderText("Results:");
        alert.setContentText("L'entreprise " + eseNom.getText() + "a été ajoutée");
        alert.showAndWait();

    }
    public void updateListEntreprises(){
        entreprises.clear();
        for (Entreprise entreprise : metier.getAllEntreprise()) {
            entreprises.add(entreprise.getNom());
        }
        entreprise.setItems(entreprises);
    }
    public void addOrdreTravail(){
        //System.out.println(java.sql.Date.valueOf(date.getValue())+ service.getValue()+textDesc.getText()+ Integer.valueOf(textTemps.getText())+Double.valueOf(textBudget.getText())+Integer.valueOf(textPriority.getText())+false+ metier.getResponsable()+metier.nameInterToObject(textNom.getText())+metier.nameEntrepriseToObject(entreprise.getValue()));
        //System.out.println(intervenant.getValue());
        Intervenant it = intervenant.getSelectionModel().getSelectedItem();
        //System.out.println( java.sql.Date.valueOf(date.getValue())+ service.getValue()+textDesc.getText()+ Integer.valueOf(textTemps.getText())+Double.valueOf(textBudget.getText())+Integer.valueOf(textPriority.getText())+ metier.getResponsable()+metier.nameInterToObject(name[1]));
        OrdreTravail ot = new OrdreTravail(java.sql.Date.valueOf(date.getValue()), service.getValue(), textDesc.getText(), Integer.valueOf(textTemps.getText()), Double.valueOf(textBudget.getText()), Integer.valueOf(textPriority.getText()), false, StaticResponsable, it, metier.nameEntrepriseToObject(entreprise.getValue()));
        metier.ajouterOrdreTravail(ot);

        try {
            EnvoiMail.sendMail(it);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Enregistrement effectué!");
            //alert.setHeaderText("Results:");
            alert.setContentText("L'ordre de travail est bien ajouté\n Un email de notification est envoyé à l'intervenant concerné");
            alert.showAndWait();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
