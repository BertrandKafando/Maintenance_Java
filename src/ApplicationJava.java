import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ApplicationJava extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Presentation/responsableMain.fxml"));
        Scene sc=new Scene(pane,1400,800);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
