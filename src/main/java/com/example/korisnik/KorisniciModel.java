package com.example.korisnik;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class KorisniciModel {
    private ObservableList<Korisnik> korisnici=FXCollections.observableArrayList();
    private SimpleObjectProperty<Korisnik> trenutniKorisnik=new SimpleObjectProperty<>();

    public ObservableList<Korisnik> getKorisnici() {
        return korisnici;
    }
    public void setKorisnici(ObservableList<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik.get();
    }
    public SimpleObjectProperty<Korisnik> trenutniKorisnikProperty() {
        return trenutniKorisnik;
    }
    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik.set(trenutniKorisnik);
    }
    public void napuni(){
        korisnici.add(new Korisnik("Lana", "Malinov", "lmalinov1@etf.unsa.ba", "lanamal", "5488Kmll"));
        korisnici.add(new Korisnik("Lamija", "Setic", "lamijaset@gmail.com", "setic", "125llK"));
        korisnici.add(new Korisnik("Merjem", "Tancica", "merjemt@gmail.com", "tanca", "8pOO41"));
        korisnici.add(new Korisnik("Imran", "Kadic", "ikadic@gmail.com", "imrank", "89ppppEE"));
        korisnici.add(new Korisnik("Nadja", "Kovacevic", "nkovacevic1@etf.unsa.ba", "nadjakov", "nk5148"));
        trenutniKorisnik = new SimpleObjectProperty<>(new Korisnik("", "", "", "", ""));
    }
    public void dodajNovogKorisnika(Korisnik k){
        korisnici.add(k);
    }
}
