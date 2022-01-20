package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import metier.IMetier;
import metier.MaterielQte;
import metier.MetierImpl;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static Controller.IntervenantController.st;
import static Controller.IntervenantController.staticOt3;

public class DetailsOrdreController implements Initializable {
    @FXML
    private TextField tfservice;

    @FXML
    private TextArea tfdescription;

    @FXML
    private TextField tfdate;

    @FXML
    private TextField tfpriorite;

    @FXML
    private TextArea tfentreprise;

    @FXML
    private TextArea tfmateriel;

    private IMetier metier = new MetierImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tfservice.setText(staticOt3.getTypeService());

     tfdescription.setText(staticOt3.getDescription());

     tfdate.setText(String.valueOf(staticOt3.getDate()));

     tfpriorite.setText(Integer.toString(staticOt3.getPriorite()));

     tfentreprise.setText("Nom : "+staticOt3.getEntreprise().getNom()+"\n"+"Téléphone : "+staticOt3.getEntreprise().getTelephone()+"\n"
     +"Email : "+staticOt3.getEntreprise().getEmail()+"\n"+"Adresse : "+staticOt3.getEntreprise().getAdresse());

        List<MaterielQte> mqs = metier.getMaterielsbyordres(staticOt3);
        String texxxt="";
        for(MaterielQte mq:mqs){
            texxxt += " - "+mq.getMateriel()+"  quantité : "+mq.getQuantite()+ "\n";
        }

        tfmateriel.setText(texxxt);
    }

    public  void quitter(){
        st.close();
    }
}
