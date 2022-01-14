package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML private TextField textMail;
    @FXML private TextField textPassword;
    @FXML  private ComboBox<String > comboBoxPassword;
    ObservableList<String> profession =
            FXCollections.observableArrayList(
                    "responsable",
                    "intervenant"
            );
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxPassword.setItems(profession);
    }

}
