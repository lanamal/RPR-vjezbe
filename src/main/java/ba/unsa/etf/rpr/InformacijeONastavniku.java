package ba.unsa.etf.rpr;

public class InformacijeONastavniku extends LicneInformacije {
    private String titula;

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
}
