package Presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ApplicationJavaFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("responsableMain.fxml"));
        Scene sc=new Scene(pane,1400,700);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
