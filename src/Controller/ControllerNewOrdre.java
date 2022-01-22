package Controller;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class ControllerNewOrdre extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../presentation/newordre.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Ajout d'un nouvel ordre de travail");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
