package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.Entreprise;
import metier.Intervenant;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.io.IOException;
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

    public static OrdreTravail ord=null;

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
    public void ajouter(ActionEvent event) {
        Stage st=new Stage();
       try {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("src/Presentation/newordre.fxml"));
            Scene scn=new Scene(pane,800,600);
            st.setScene(scn);
            st.setTitle("remplir");
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(
                    ((Node)event.getSource()).getScene().getWindow() );
            st.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void modifier(ActionEvent event){
        ord=tablev.getSelectionModel().getSelectedItem();
        if(ord==null){
            Alert alert=new Alert(Alert.AlertType.WARNING); alert.setContentText("selectionner la ligne");
            alert.show();
        }else{
           Stage st=new Stage();
                try {
                    AnchorPane pane= FXMLLoader.load(getClass().getResource("src/Presentation/newordre.fxml"));
                    Scene scn=new Scene(pane,800,600);
                    st.setScene(scn);
                    st.setTitle("remplir");
                    st.initModality(Modality.WINDOW_MODAL);
                    st.initOwner(
                            ((Node)event.getSource()).getScene().getWindow() );
                    st.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


    public void supprimer(){

    }
    public  void rechercher(){

    }



    public void intervenant(){

    }

    public void exporter(){

    }
    public  void compte(){

    }

    public  void planification(){

    }
    public  void materiel(){

    }

}
