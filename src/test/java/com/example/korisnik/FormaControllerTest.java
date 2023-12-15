package com.example.korisnik;
import com.example.korisnik.FormaController;
import com.example.korisnik.KorisniciModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class FormaControllerTest {
    @Start
    public void start(Stage stage) throws IOException {
        KorisniciModel model=new KorisniciModel();
        model.napuni();
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("forma.fxml"));
        fxmlLoader.setController(new FormaController(model));
        Scene scene=new Scene(fxmlLoader.load(), 620, 400);
        stage.setTitle("Korisnici");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void provjeriKorisnika(FxRobot robot) {
        robot.clickOn("Lana Malinov");
        assertEquals("Lana", robot.lookup("#imeField").queryAs(TextField.class).getText());
        assertEquals("Malinov", robot.lookup("#prezimeField").queryAs(TextField.class).getText());
        assertEquals("lmalinov1@etf.unsa.ba", robot.lookup("#emailField").queryAs(TextField.class).getText());
        assertEquals("lanamal", robot.lookup("#korImeField").queryAs(TextField.class).getText());
        assertEquals("5488Kmll", robot.lookup("#lozinkaField").queryAs(PasswordField.class).getText());
    }
    @Test
    public void krajButton(FxRobot robot) {
        robot.clickOn("#krajButton");
        assertTrue(robot.lookup("#imeField").tryQuery().isEmpty());
    }
}