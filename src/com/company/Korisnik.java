package com.company;
import java.util.ArrayList;
import java.util.List;

public class Korisnik extends Osoba {
    private List<Racun> racuni;

    public Korisnik(String im,String prez) {
        super(im, prez);
        racuni = new ArrayList<>();
    }
    public void dodajRacun(Racun racun) {
        racuni.add(racun);
    }
}
