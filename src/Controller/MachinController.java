package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import metier.IMetier;
import metier.Materiel;
import metier.MetierImpl;


import java.net.URL;
import java.util.ResourceBundle;

public class MachinController implements Initializable {
    @FXML private TableView<Materiel> tabeMateriel;
    @FXML private TableColumn<Materiel, Integer> ClId;
    @FXML private TableColumn<Materiel, String> ClDesignation;
    ObservableList<Materiel> list= FXCollections.observableArrayList();
    @FXML private TextField designation;
    private IMetier metier;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ClId.setCellValueFactory(new PropertyValueFactory<Materiel, Integer>("id_materiel"));
        ClDesignation.setCellValueFactory(new PropertyValueFactory<Materiel, String>("designation"));
        metier=new MetierImpl();
        list.addAll(metier.getAllMateriel());
        tabeMateriel.setItems(list);
    }

    public void addMateriel(){
        metier.ajouterMateriel(new Materiel(designation.getText()));
        list.clear();
        list.addAll(metier.getAllMateriel());
        tabeMateriel.setItems(list);
    }

    public void deleteMateriel(){
        Materiel mat = tabeMateriel.getSelectionModel().getSelectedItem();
        metier.supprimerMateriel(mat);
        list.clear();
        list.addAll(metier.getAllMateriel());
        tabeMateriel.setItems(list);
    }

}
