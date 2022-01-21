package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.control.Alert;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;

import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements Initializable {
    metier.MetierImpl metier= new  metier.MetierImpl();
    @FXML private TextField mail;
    @FXML private TextField password;  // = new JPasswordField(20);
    @FXML  private ComboBox<String > comboBox;
    ObservableList<String> profession =
            FXCollections.observableArrayList(
                    "Responsable",
                    "Intervenant"
            );
    static Stage stage2 ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBox.setItems(profession);

    }
    public void login() throws IOException {
        //EmailValidator validator = EmailValidator.getInstance();
        //Regular Expression
        String regex = "^(.+)@(.+)$";
        //Compile regular expression to get the pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mail.getText());
        if(comboBox.getValue()==null){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention!");
            //alert.setHeaderText("Results:");
            alert.setContentText("la choix de la profession est obligatoire");
            alert.showAndWait();
        }
        else if( metier.login(comboBox.getValue(), mail.getText(), password.getText())==0 || !matcher.matches() )
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid email");
            //alert.setHeaderText("Results:");
            alert.setContentText("email invalid");
            alert.showAndWait();
        }
        else if(metier.login(comboBox.getValue(), mail.getText(), password.getText())==-1)
        {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mot de passe incorrect");
            //alert.setHeaderText("Results:");
            alert.setContentText("Mot de passe incorrect");
            alert.showAndWait();
        }
        else{
             if(comboBox.getValue()=="Intervenant")
             {

                 stage2 = new Stage();
                 Parent root = FXMLLoader.load(LoginController.class.getResource("../Presentation/pp_intervenant.fxml"));
                 stage2.setScene(new Scene(root));
                 stage2.setTitle("");
                 stage2.initModality(Modality.WINDOW_MODAL);
                // stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
                 stage2.show();
                 mail.clear();
                 password.clear();


             }
             else{

                 Stage stage = new Stage();
                 Parent root = FXMLLoader.load(LoginController.class.getResource("../Presentation/responsableMain.fxml"));
                 stage.setScene(new Scene(root));
                 stage.setTitle("");
                 stage.initModality(Modality.WINDOW_MODAL);
                 // stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
                 stage.show();

             }
        }
    }

   /* public void ouvrirEmploye(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(LoginController.class.getResource("../Presentation/pp_intervenant.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.show();

    }*/

}
