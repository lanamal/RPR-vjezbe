package ba.unsa.etf.rpr;
import java.util.*;

public class InformacijeONastavniku extends LicneInformacije implements MozeOcijeniti{
    private String titula;
    private List<Ocjena> ocjene=new ArrayList<>();

    public InformacijeONastavniku(String i,String p,String t) {
        super(i,p);
        titula=t;
    }
    public void setTitula(String t) {
        titula=t;
    }
    public String getTitula() {
        return titula;
    }
    public List<Ocjena> getOcjene() {
        return ocjene;
    }
    @Override
    public Ocjena ocijeni(int x) {
        Ocjena nova=new Ocjena(this,x);
        ocjene.add(nova);
        return nova;
    }
}
