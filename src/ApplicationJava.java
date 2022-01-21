import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ApplicationJava extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Presentation/mainview.fxml"));
        Scene sc=new Scene(pane);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
