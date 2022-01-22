package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import metier.Entreprise;
import metier.Intervenant;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ControllerModifierOrdreTravail  implements Initializable {
    @FXML
    private TextField textDesc;
    @FXML private DatePicker date;
    @FXML private TextField textTemps;
    @FXML private TextField textBudget;
    @FXML private TextField textPriority;
    @FXML private ComboBox<Entreprise> entreprise;
    @FXML private ComboBox<Intervenant> intervenant;
    @FXML private ComboBox<String > service;
    @FXML
    ObservableList<Intervenant> intervenants =
            FXCollections.observableArrayList();
    @FXML
    ObservableList<Entreprise> entreprises =FXCollections.observableArrayList();
    @FXML ObservableList<String> services = FXCollections.observableArrayList(
                    "reglage",
                    "setting",
                    "maintenance",
                    "nothing"
            );

    MetierImpl metier =new MetierImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrdreTravail ord=ControllerResponsable.ord;

        for (Intervenant inter : metier.getAllInter()) {
            intervenants.add(inter);

        }
        intervenant.setItems(intervenants);

        for (Entreprise entreprise : metier.getAllEntreprise()) {
            entreprises.add(entreprise);
        }
        entreprise.setItems(entreprises);

        service.setItems(services);
        intervenant.setValue(ord.getIntervenant());
        entreprise.setValue(ord.getEntreprise());
        service.setValue(ord.getTypeService());

        date.setValue(ord.getDate().toLocalDate());
        textBudget.setText(Double.toString(ord.getBudget()));
        textDesc.setText(ord.getDescription());
        textTemps.setText(Integer.toString(ord.getTemps()));
        textPriority.setText(Integer.toString(ord.getPriorite()));

    }


    public  void enregistrer(){
        String des=textDesc.getText();
        Date dte= java.sql.Date.valueOf(date.getValue());
        int tmps=Integer.valueOf(textTemps.getText() );
        double buget=Double.valueOf((textBudget.getText()) );
        int prty = Integer.valueOf(textPriority.getText());
        Entreprise ent=entreprise.getSelectionModel().getSelectedItem();
        Intervenant it=intervenant.getSelectionModel().getSelectedItem();
        String  srv=service.getSelectionModel().getSelectedItem().toString();

        OrdreTravail ord=ControllerResponsable.ord;
        ord.setDescription(des);ord.setDate(dte);ord.setTemps(tmps);ord.setBudget(buget);ord.setPriorite(prty);
        ord.setEtat(ControllerResponsable.ord.isEtat());
        ord.setEntreprise(ent); ord.setIntervenant(it); ord.setTypeService(srv);
        metier.modifierOrdreTravail(ord);


        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Vos informations ont été mises à jour avec succès");
        alert.show();

    }

    public  void ajoutMateriel(){

    }
}

