package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import metier.IMetier;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

        List<OrdreTravail> ots = metier.getAllOrdreTravail(); List<OrdreTravail> ots1 = new ArrayList<>(); List<OrdreTravail> ots2 = new ArrayList<>();
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

    public void modifierEtat(){
        int indice=tableOts.getSelectionModel().getSelectedIndex();
        OrdreTravail ot = tableOts.getSelectionModel().getSelectedItem();
        if(indice>=0) {
        OrdreTravail ot1 = new OrdreTravail(ot.getNumOrdreTravail(),ot.getDate(),ot.getTypeService(),ot.getDescription(),ot.getTemps(),ot.getBudget(),ot.getPriorite(),true,ot.getResponsable(),ot.getIntervenant(),ot.getEntreprise());
        //metier = new MetierImpl();
        metier.modifierOrdreTravail(ot1);

        List<OrdreTravail> ots = metier.getAllOrdreTravail(); List<OrdreTravail> ots1 = new ArrayList<>(); List<OrdreTravail> ots2 = new ArrayList<>();
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

            List<OrdreTravail> ots = metier.getAllOrdreTravail(); List<OrdreTravail> ots1 = new ArrayList<>(); List<OrdreTravail> ots2 = new ArrayList<>();
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
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un ordre de travail terminé ");
            alert.show();
        }
    }


}
