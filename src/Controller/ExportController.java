package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ExportController {

    @FXML
    private TableColumn<?, ?> ClDate;

    @FXML
    private TableColumn<?, ?> ClIntervenant;

    @FXML
    private TableColumn<?, ?> ClMontant;

    @FXML
    private TableColumn<?, ?> ClOrdre;

    @FXML
    private ComboBox<?> comboEntreprise;

    @FXML
    private TableView<?> tableFacture;

    @FXML
    private Label total;

}
