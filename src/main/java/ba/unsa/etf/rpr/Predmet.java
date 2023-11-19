package ba.unsa.etf.rpr;
import java.util.*;

public class Predmet {
    private String naziv;
    private String opis;
    private List<Ocjena> ocjene=new ArrayList<>();

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
    public void dodajOcjenu(Ocjena ocjena) {
        ocjene.add(ocjena);
    }
    public List<Ocjena> getOcjene() {
        return ocjene;
    }
}
