package ba.unsa.etf.rpr;
import java.util.*;

public class KolekcijaImena {
    private List<String> listaImenaIPrezimena;

    public KolekcijaImena(List<String> imena) {
        listaImenaIPrezimena=imena;
    }
    public String getNajduzeIme() {
        if(listaImenaIPrezimena.isEmpty())
            return "Prazna";
        String najduza="";
        for(String rijec: listaImenaIPrezimena) {
            if(rijec.length()>najduza.length())
                najduza=rijec;
        }
        return najduza;
    }
}
