package com.company;
import java.util.ArrayList;
import java.util.List;

public class Banka {
    protected List<Korisnik> korisnici;
    protected List<Uposlenik> uposlenici;
    private long brojRacunaCounter;

    public Banka() {
        korisnici=new ArrayList<>();
        uposlenici=new ArrayList<>();
        brojRacunaCounter=1;
    }

    public Korisnik kreirajNovogKorisnika(String im,String prez) {
        Korisnik korisnik=new Korisnik(im, prez);
        korisnici.add(korisnik);
        return korisnik;
    }

    public Uposlenik kreirajNovogUposlenika(String im,String prez) {
        Uposlenik uposlenik=new Uposlenik(im, prez);
        uposlenici.add(uposlenik);
        return uposlenik;
    }

    public Racun kreirajRacunZaKorisnika(Korisnik korisnik) {
        Racun racun=new Racun(brojRacunaCounter++, korisnik);
        korisnik.dodajRacun(racun);
        return racun;
    }
}
