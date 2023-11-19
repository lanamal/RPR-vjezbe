package ba.unsa.etf.rpr;

public class Ocjena {
    private LicneInformacije osoba;
    private int ocjena;

    public Ocjena(LicneInformacije os, int ocjena) {
        osoba=os; setOcjena(ocjena);
    }
    public void setOcjena(int br) {
        if(br>0 && br<10)
            ocjena=br;
    }
    //za main dodano
    public LicneInformacije getOsoba() {
        return osoba;
    }
    public int getOcjena() {
        return ocjena;
    }
}
