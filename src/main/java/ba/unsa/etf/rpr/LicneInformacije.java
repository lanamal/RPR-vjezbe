package ba.unsa.etf.rpr;

public class LicneInformacije implements Informacije {
    private String ime;
    private String prezime;

    public LicneInformacije(String ime,String prezime) {
        this.ime=ime; this.prezime=prezime;
    }
    public void setIme(String i) {
        ime=i;
    }
    public void setPrezime(String p) {
        prezime=p;
    }
    public String getIme() {
        return ime;
    }
    public String getPrezime() {
        return prezime;
    }
}
