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
import java.util.ResourceBundle;

public class ControllerModifierOrdreTravail  implements Initializable {
    @FXML
    private TextField textDesc;
    @FXML private DatePicker date;
    @FXML private TextField textTemps;
    @FXML private TextField textBudget;
    @FXML private TextField textPriority;
    @FXML private ComboBox<String > entreprise;
    @FXML private ComboBox<String > intervenant;
    @FXML private ComboBox<String > service;
    @FXML
    ObservableList<String> intervenants =
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
    MetierImpl metier =new MetierImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        OrdreTravail ord=ControllerResponsable.ord;

        for (Intervenant inter : metier.getAllInter()) {
            intervenants.add(inter.toString());

        }
        intervenant.setItems(intervenants);

        for (Entreprise entreprise : metier.getAllEntreprise()) {
            entreprises.add(entreprise.getNom());
        }
        entreprise.setItems(entreprises);

        service.setItems(services);
        intervenant.setValue(ord.getIntervenant().getNom());
        entreprise.setValue(ord.getEntreprise().getNom());
        service.setValue(ord.getTypeService());

        date.setPromptText(ord.getDate().toString());
        textBudget.setPromptText(Double.toString(ord.getBudget()));
        textDesc.setPromptText(ord.getDescription());
        textTemps.setPromptText(Integer.toString(ord.getTemps()));
        textPriority.setPromptText(Integer.toString(ord.getPriorite()));

    }


    public  void modifOrdreTravail(){

    }
}

