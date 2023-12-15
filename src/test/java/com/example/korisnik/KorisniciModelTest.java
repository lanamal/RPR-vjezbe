package com.example.korisnik;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {
    private KorisniciModel korisniciModel;

    @BeforeEach
    void setUp() {
        korisniciModel = new KorisniciModel();
        korisniciModel.napuni();
    }

    @Test
    void testGetKorisnici() {
        ObservableList<Korisnik> korisnici = korisniciModel.getKorisnici();
        assertNotNull(korisnici);
        assertEquals(5, korisnici.size());
    }
    @Test
    void testGetTrenutniKorisnik() {
        Korisnik trenutni = korisniciModel.getTrenutniKorisnik();
        assertNotNull(trenutni);
        assertEquals("", trenutni.getIme());
        assertEquals("", trenutni.getPrezime());
        assertEquals("", trenutni.getEmail());
        assertEquals("", trenutni.getKorisnickoIme());
        assertEquals("", trenutni.getLozinka());
    }
    @Test
    void testTrenutniKorisnikProperty() {
        assertNotNull(korisniciModel.trenutniKorisnikProperty());
    }
    @Test
    void testSetTrenutniKorisnik() {
        Korisnik noviKorisnik = new Korisnik("Test", "Testic", "test@test.com", "test", "test123");
        korisniciModel.setTrenutniKorisnik(noviKorisnik);
        assertEquals(noviKorisnik, korisniciModel.getTrenutniKorisnik());
    }
    @Test
    void testDodajNovogKorisnika() {
        Korisnik noviKorisnik = new Korisnik("Selma", "Habul", "sh@gmail.com", "shab", "12556");
        korisniciModel.dodajNovogKorisnika(noviKorisnik);
        assertTrue(korisniciModel.getKorisnici().contains(noviKorisnik));
    }
}