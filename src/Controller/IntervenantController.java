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
import java.util.List;
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
        otEntreprise.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
        otResponsable.setCellValueFactory(new PropertyValueFactory<>("responsable"));

        metier = new MetierImpl();
        liste.addAll(metier.getAllOrdreTravail());
        tableOts.setItems(liste);

    }

    public void modifierEtat(){
        int indice=tableOts.getSelectionModel().getSelectedIndex();
        OrdreTravail ot = tableOts.getSelectionModel().getSelectedItem();
        if(indice>=0) {
        OrdreTravail ot1 = new OrdreTravail(ot.getNumOrdreTravail(),ot.getDate(),ot.getTypeService(),ot.getDescription(),ot.getTemps(),ot.getBudget(),ot.getPriorite(),true,ot.getResponsable(),ot.getIntervenant(),ot.getEntreprise());
        //metier = new MetierImpl();
            //System.out.println(ot);
        metier.modifierOrdreTravail(ot1);
           // System.out.println(ot1);
        }else{
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Veuillez sélectionner un ordre de travail à modifier ");
            alert.show();
        }
    }

    public void actualiser(){
        List<OrdreTravail> ots=metier.getAllOrdreTravail();
        liste.clear();
        liste.addAll(ots);
    }
}
