package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class CompteRenponsable implements Initializable {

    @FXML
    private TextField cnm;
    @FXML
    private TextField cpr;
    @FXML
    private TextField cmail;
    @FXML
    private TextField ctel;
    @FXML
    private TextField cadd;

    @FXML
    private TextField noump;
    @FXML
    private TextField anmp;
    @FXML
    private ImageView img;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
      Image nw=  new Image(getClass().getResourceAsStream("img.jpg"));
        img.setImage(nw);

    }

    public  void changer(){

    }

    public  void cmodifier(){

    }
}
