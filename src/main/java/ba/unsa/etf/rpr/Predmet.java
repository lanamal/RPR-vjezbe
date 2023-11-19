package ba.unsa.etf.rpr;

public class Predmet {
    private String naziv;
    private String opis;

    public Predmet(String n,String o) {
        naziv=n; opis=o;
    }
    public void setNaziv(String n) {
        naziv=n;
    }
    public void setOpis(String o) {
        opis=o;
    }
    public String getNaziv() {
        return naziv;
    }
    public String getOpis() {
        return opis;
    }
}
