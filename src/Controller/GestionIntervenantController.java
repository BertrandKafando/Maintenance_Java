package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.IMetier;
import metier.Intervenant;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GestionIntervenantController implements Initializable {

    @FXML
    private TableView<Intervenant> tableIts;
    @FXML
    private TableColumn<Intervenant,String> itNom;
    @FXML
    private TableColumn<Intervenant,String> itPrenom;
    @FXML
    private TableColumn<Intervenant,String> itTel;
    @FXML
    private TableColumn<Intervenant,String> itMail;
    @FXML
    private TableColumn<Intervenant,String> itAdresse;
    @FXML
    private TableColumn<Intervenant,String> itMdp;

    ObservableList<Intervenant> listeIts= FXCollections.observableArrayList();
    private IMetier metier;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        itPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        itTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        itMail.setCellValueFactory(new PropertyValueFactory<>("email"));
        itAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        itMdp.setCellValueFactory(new PropertyValueFactory<>("password"));

        metier = new MetierImpl();

        listeIts.addAll(metier.getAllInter());
        tableIts.setItems(listeIts);
    }

    public void ajouter(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(GestionIntervenantController.class.getResource("../presentation/ajouter_intervenant.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.show();
    }

    public void modifier(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(GestionIntervenantController.class.getResource("../presentation/modif_intervenant.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.show();
    }

    public void supprimer(){

    }


}
