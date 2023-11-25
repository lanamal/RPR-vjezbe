package ba.unsa.etf.rpr;

public class Pobjednik {
    private String ime;
    private String prezime;
    private int brojZnakova;

    public Pobjednik(KolekcijaImena kolekcija) {
        String najduzeIme=kolekcija.getNajduzeIme();
        String[] dijeloviImena=najduzeIme.split(" ");
        ime=dijeloviImena[0];
        prezime=dijeloviImena[1];
        brojZnakova=ime.length();
    }
    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }
    public int getBrojZnakova() {
        return brojZnakova;
    }
}
