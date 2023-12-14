package com.company.korisnik;
import com.example.korisnik.Korisnik;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
class KorisnikTest{
    @Start
    public void start(Stage stage) throws Exception {
        //po potrebi
    }
    @Test
    public void testSetIme(FxRobot robot) {
        Korisnik korisnik=new Korisnik();
        robot.interact(()->korisnik.setIme("Lana"));
        assertEquals("Lana",korisnik.imeProperty().get());
    }
    @Test
    public void testSetPrezime(FxRobot robot) {
        Korisnik korisnik=new Korisnik();
        robot.interact(()->korisnik.setPrezime("Malinov"));
        assertEquals("Malinov",korisnik.prezimeProperty().get());
    }
    @Test
    public void testToString(FxRobot robot) {
        Korisnik korisnik=new Korisnik("John", "Doe", "john.doe@example.com", "johndoe", "password");
        assertEquals("John Doe", korisnik.toString());
    }
}