package ba.unsa.etf.rpr;

public class InformacijeOStudentu extends LicneInformacije{
    private String godinaStudija;
    private String brojIndexa;

    public InformacijeOStudentu(String i,String p,String gS,String brI) {
        super(i,p);
        godinaStudija=gS; brojIndexa=brI;
    }
    public void setGodinaStudija(String gS) {
        godinaStudija=gS;
    }
    public void setBrojIndexa(String brI) {
        brojIndexa=brI;
    }
    public String getGodinaStudija() {
        return godinaStudija;
    }
    public String getBrojIndexa() {
        return brojIndexa;
    }
}
