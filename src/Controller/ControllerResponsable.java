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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import metier.*;

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
    @FXML
    private ImageView img;

    public static OrdreTravail ord=null;

    MetierImpl metierip =new MetierImpl();
    ObservableList<OrdreTravail>liste= FXCollections.observableArrayList();
    public  static Responsable responsableS=null;
    static OrdreTravail staticOt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        service.setCellValueFactory(new PropertyValueFactory<>("typeService"));
        des.setCellValueFactory(new PropertyValueFactory<>("description"));
        pri.setCellValueFactory(new PropertyValueFactory<>("priorite"));
        intervenant.setCellValueFactory(new PropertyValueFactory<>("intervenant"));
        entr.setCellValueFactory(new PropertyValueFactory<>("entreprise"));
        etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        tmps.setCellValueFactory(new PropertyValueFactory<>("temps"));

        Image nw=  new Image(getClass().getResourceAsStream("../image/img_81837noir.png"));
        img.setImage(nw);


        liste.addAll(metierip.getAllOrdreTravail());
        tablev.setItems(liste);



    }
    public void ajouter(ActionEvent event) {
        Stage st=new Stage();
       try {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("../Presentation/newordre.fxml"));
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
                    AnchorPane pane= FXMLLoader.load(getClass().getResource("../Presentation/modifierordre.fxml"));
                    Scene scn=new Scene(pane,1200,600);
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


    public void supprimer(ActionEvent event){
        OrdreTravail select=null;
        select=tablev.getSelectionModel().getSelectedItem();
        if(select!=null){
            metierip.supprimerOrdreTravail(select);
            liste.clear();
            liste.addAll(metierip.getAllOrdreTravail());
        }else
        {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Choisissez un ordre de travail à supprimer");
            alert.show();
        }

    }
    public  void rechercher(){

    }



    public void intervenant(ActionEvent event){
        Stage st=new Stage();
        try {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("../Presentation/gestion_intervenant.fxml"));
            Scene scn=new Scene(pane,700,500);
            st.setScene(scn);
            st.setTitle("Intervenants");
            st.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exporter(ActionEvent event){
        Stage st=new Stage();
        try {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("export.fxml"));
            Scene scn=new Scene(pane,1000,600);
            st.setScene(scn);
            st.setTitle("Exporter");
            st.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  void compte(ActionEvent event){
        Stage st=new Stage();
        try {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("../Presentation/compte.fxml"));
            Scene scn=new Scene(pane,800,600);
            st.setScene(scn);
            st.setTitle("Administrateur");
            st.initModality(Modality.WINDOW_MODAL);
            st.initOwner(
                    ((Node)event.getSource()).getScene().getWindow() );
            st.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void planification(ActionEvent event){
        Stage st=new Stage();
        try {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("../Presentation/diagramme.fxml"));
            Scene scn=new Scene(pane,1000,600);
            st.setScene(scn);
            st.setTitle("Diagramme");
            st.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  void materiel(ActionEvent event){
        Stage st=new Stage();
        try {
            AnchorPane pane= FXMLLoader.load(getClass().getResource("../Presentation/materiel.fxml"));
            Scene scn=new Scene(pane,1000,600);
            st.setScene(scn);
            st.setTitle("Ressources");
            st.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void btnAjouterMateriel(){
        Stage st=new Stage();
        staticOt = tablev.getSelectionModel().getSelectedItem();
        if(staticOt==null) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Choisissez un ordre de travail auquel ajouter du materiel");
            alert.show();
        }else{
            try {
                AnchorPane pane= FXMLLoader.load(getClass().getResource("../Presentation/ajout_materiel.fxml"));
                Scene scn=new Scene(pane);
                st.setScene(scn);
                st.setTitle("");
                st.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
