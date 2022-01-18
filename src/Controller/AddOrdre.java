package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import metier.MetierImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class AddOrdre implements Initializable {
     MetierImpl metier =new MetierImpl();
    @FXML
    private ComboBox<String > service;
    private ComboBox<String > intervenant;
    ObservableList<String> services =
            FXCollections.observableArrayList(
                    "reglage",
                    "setting",
                    "maintenance",
                    "nothing"
            );
    ObservableList<String> intervenants =
            FXCollections.observableArrayList(metier.getAllInter().toString());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service.setItems(services);
    }
}
