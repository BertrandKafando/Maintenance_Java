package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import metier.Entreprise;
import metier.Intervenant;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

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
    @FXML private ComboBox<String > entreprise;
    @FXML private ComboBox<String > intervenant;
    @FXML private ComboBox<String > service;
    @FXML ObservableList<String> intervenants =
            FXCollections.observableArrayList();
    @FXML ObservableList<String> entreprises =
            FXCollections.observableArrayList();
    @FXML ObservableList<String> services =
            FXCollections.observableArrayList(
                    "reglage",
                    "setting",
                    "maintenance",
                    "nothing"
            );

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (Intervenant inter : metier.getAllInter()) {
            intervenants.add(inter.toString());

        }
        intervenant.setItems(intervenants);

        for (Entreprise entreprise : metier.getAllEntreprise()) {
            entreprises.add(entreprise.getNom());
        }
        entreprise.setItems(entreprises);

        service.setItems(services);
    }
    public void addEse(){
        Entreprise ese = new Entreprise(eseNom.getText(),eseTel.getText(),eseEmail.getText());
        metier.ajouterEntreprise(ese);
        updateListEntreprises();

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
        String[] name = intervenant.getValue().split("\\s+");
        //System.out.println( java.sql.Date.valueOf(date.getValue())+ service.getValue()+textDesc.getText()+ Integer.valueOf(textTemps.getText())+Double.valueOf(textBudget.getText())+Integer.valueOf(textPriority.getText())+ metier.getResponsable()+metier.nameInterToObject(name[1]));
        OrdreTravail ot = new OrdreTravail(java.sql.Date.valueOf(date.getValue()), service.getValue(), textDesc.getText(), Integer.valueOf(textTemps.getText()), Double.valueOf(textBudget.getText()), Integer.valueOf(textPriority.getText()), false, metier.getResponsable(), metier.nameInterToObject(name[0]), metier.nameEntrepriseToObject(entreprise.getValue()));
       metier.ajouterOrdreTravail(ot);
    }

}
