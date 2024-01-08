package com.example.lv10_lv11;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GeografijaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(GeografijaApplication.class.getResource("glavna.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        GlavnaController controller = loader.getController();
        stage.setTitle("Gradovi svijeta");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}