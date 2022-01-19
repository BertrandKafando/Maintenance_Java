package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import metier.IMetier;
import metier.MailToResponsable;
import metier.MetierImpl;
import metier.Responsable;


import javax.mail.MessagingException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static metier.MetierImpl.StaticIntervenant;

public class MailToResponsableController implements Initializable {
    @FXML
    private TextField mail_objet;
    @FXML
    private TextArea mail_corps;
    @FXML
    private ComboBox<Responsable> combobox = new ComboBox<>();
    private IMetier metier = new MetierImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Responsable> resps = metier.getResponsables();
        combobox.getItems().addAll(resps);
    }

    public void envoyer() throws MessagingException {
        String objet = mail_objet.getText();
        String corps = mail_corps.getText();
        Responsable resp = combobox.getSelectionModel().getSelectedItem();
        MailToResponsable.sendMail(resp,objet,corps,StaticIntervenant);

        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Votre mail a été envoyé avec succès");
        alert.show();
    }

}
