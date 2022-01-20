package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import metier.IMetier;
import metier.Materiel;
import metier.MetierImpl;
import metier.Responsable;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static Controller.ControllerResponsable.staticOt;

public class AjouterMaterielController implements Initializable {

    @FXML
    private TextField tfquantite;
    @FXML
    private ComboBox<Materiel> combobox = new ComboBox<>();
    private IMetier metier = new MetierImpl();

    public void ajouterMateriel(){
        Materiel mat = combobox.getSelectionModel().getSelectedItem();
        metier.ajouterMaterielAOrdreTravail(staticOt,mat,Integer.valueOf(tfquantite.getText()));
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Le matériel a été ajouté avec succès");
        alert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Materiel> materiels = metier.getAllMateriel();
        combobox.getItems().addAll(materiels);
    }
}
