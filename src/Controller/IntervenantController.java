package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import metier.IMetier;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.net.URL;
import java.util.ResourceBundle;

public class IntervenantController implements Initializable {

    @FXML
    private TableView<OrdreTravail> tableOts;
    @FXML
    private TableColumn<OrdreTravail,String> otService;
    @FXML
    private TableColumn<OrdreTravail,String> otDescription;
    @FXML
    private TableColumn<OrdreTravail,Integer> otPriorite;
    @FXML
    private TableColumn<OrdreTravail,String> otEtat;
    @FXML
    private TableColumn<OrdreTravail,String> otEntreprise;
    @FXML
    private TableColumn<OrdreTravail,String> otResponsable;

    ObservableList<OrdreTravail> liste= FXCollections.observableArrayList();
    private IMetier metier;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        otService.setCellValueFactory(new PropertyValueFactory<>("typeService"));
        otDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        otPriorite.setCellValueFactory(new PropertyValueFactory<>("priorite"));
        otEtat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        otEntreprise.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
        otResponsable.setCellValueFactory(new PropertyValueFactory<>("responsable"));

        metier = new MetierImpl();
        liste.addAll(metier.getAllOrdreTravail());
        tableOts.setItems(liste);

    }

    public void modifierEtat(){

    }
}
