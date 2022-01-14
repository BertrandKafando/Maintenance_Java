package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import metier.Entreprise;
import metier.Intervenant;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerResponsable  implements Initializable {
    @FXML
    private TableView<OrdreTravail> tablev;
    @FXML
    private TableColumn<OrdreTravail,String>service;
    @FXML
    private TableColumn<OrdreTravail,String>des;
    @FXML
    private TableColumn<OrdreTravail,Integer> pri;
    @FXML
    private TableColumn<Intervenant,String> intervenant;
    @FXML
    private TableColumn<Entreprise,String>entr;
    @FXML
    private TableColumn<OrdreTravail,Boolean>etat;
    @FXML
    private TableColumn<OrdreTravail, Integer>tmps;



    MetierImpl metier=new MetierImpl();
    ObservableList<OrdreTravail>liste= FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        service.setCellValueFactory(new PropertyValueFactory<>("typeService"));
        des.setCellValueFactory(new PropertyValueFactory<>("typeService"));
        pri.setCellValueFactory(new PropertyValueFactory<>("priorite"));
        intervenant.setCellValueFactory(new PropertyValueFactory<>("intervenant"));
        entr.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tmps.setCellValueFactory(new PropertyValueFactory<>("temps"));


        liste.addAll(metier.getAllOrdreTravail());
        tablev.setItems(liste);



    }
}
