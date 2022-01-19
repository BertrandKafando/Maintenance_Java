package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.IMetier;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static metier.MetierImpl.StaticIntervenant;

public class IntervenantController implements Initializable {

    @FXML
    private TableView<OrdreTravail> tableOts;
    @FXML
    private TableView<OrdreTravail> tableOts2;
    @FXML
    private TableColumn<OrdreTravail,String> otService;
    @FXML
    private TableColumn<OrdreTravail,String> otDescription;
    @FXML
    private TableColumn<OrdreTravail,Integer> otPriorite;
    @FXML
    private TableColumn<OrdreTravail,String> otEntreprise;
    @FXML
    private TableColumn<OrdreTravail,String> otResponsable;
    @FXML
    private TableColumn<OrdreTravail,String> otService2;
    @FXML
    private TableColumn<OrdreTravail,String> otDescription2;
    @FXML
    private TableColumn<OrdreTravail,Integer> otPriorite2;
    @FXML
    private TableColumn<OrdreTravail,String> otEntreprise2;
    @FXML
    private TableColumn<OrdreTravail,String> otResponsable2;

    @FXML
    private Label labelBienvenue;

    ObservableList<OrdreTravail> liste= FXCollections.observableArrayList();
    ObservableList<OrdreTravail> liste2= FXCollections.observableArrayList();
    private IMetier metier;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        otService.setCellValueFactory(new PropertyValueFactory<>("typeService"));
        otDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        otPriorite.setCellValueFactory(new PropertyValueFactory<>("priorite"));
        otEntreprise.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
        otResponsable.setCellValueFactory(new PropertyValueFactory<>("responsable"));

        otService2.setCellValueFactory(new PropertyValueFactory<>("typeService"));
        otDescription2.setCellValueFactory(new PropertyValueFactory<>("description"));
        otPriorite2.setCellValueFactory(new PropertyValueFactory<>("priorite"));
        otEntreprise2.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
        otResponsable2.setCellValueFactory(new PropertyValueFactory<>("responsable"));
        metier = new MetierImpl();
        labelBienvenue.setText(labelBienvenue.getText()+" "+StaticIntervenant);



        List<OrdreTravail> ots = metier.getOrdreTravailIntervenant(StaticIntervenant);
        List<OrdreTravail> ots1 = new ArrayList<>(); List<OrdreTravail> ots2 = new ArrayList<>();
        for(OrdreTravail ot : ots){
            if(ot.isEtat()) {
                ots2.add(ot);
            }
            else{
                ots1.add(ot);
            }
        }

        liste.addAll(ots1);
        tableOts.setItems(liste);

        liste2.addAll(ots2);
        tableOts2.setItems(liste2);

    }

    public void actualiser(){
        List<OrdreTravail> ots = metier.getOrdreTravailIntervenant(StaticIntervenant);
        List<OrdreTravail> ots1 = new ArrayList<>(); List<OrdreTravail> ots2 = new ArrayList<>();
        for(OrdreTravail otr : ots){
            if(otr.isEtat()) {
                ots2.add(otr);
            }
            else{
                ots1.add(otr);
            }
        }

        liste2.clear();
        liste2.addAll(ots2);

        liste.clear();
        liste.addAll(ots1);
    }

    public void modifierEtat(){
        int indice=tableOts.getSelectionModel().getSelectedIndex();
        OrdreTravail ot = tableOts.getSelectionModel().getSelectedItem();
        if(indice>=0) {

        OrdreTravail ot1 = new OrdreTravail(ot.getNumOrdreTravail(),ot.getDate(),ot.getTypeService(),ot.getDescription(),ot.getTemps(),ot.getBudget(),ot.getPriorite(),true,ot.getResponsable(),ot.getIntervenant(),ot.getEntreprise());
       // metier = new MetierImpl();
        metier.modifierOrdreTravail(ot1);
        actualiser();

        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un ordre de travail non terminé  ");
            alert.show();
        }
    }



    public  void modifierEtat2(){
        int indice=tableOts2.getSelectionModel().getSelectedIndex();
        OrdreTravail ot = tableOts2.getSelectionModel().getSelectedItem();
        if(indice>=0) {
            OrdreTravail ot1 = new OrdreTravail(ot.getNumOrdreTravail(),ot.getDate(),ot.getTypeService(),ot.getDescription(),ot.getTemps(),ot.getBudget(),ot.getPriorite(),false,ot.getResponsable(),ot.getIntervenant(),ot.getEntreprise());
            //metier = new MetierImpl();
            metier.modifierOrdreTravail(ot1);
            actualiser();
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un ordre de travail terminé ");
            alert.show();
        }
    }

    public void modifierInfosPerso(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(LoginController.class.getResource("../Presentation/modif_infos_perso_intervenant.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.show();

    }

    public void mailbtn(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(IntervenantController.class.getResource("../presentation/mail_to_responsable.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.show();
    }


}
