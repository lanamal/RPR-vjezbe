package ba.unsa.etf.rpr;
import java.util.*;

public class KolekcijaImenaIPrezimena {
    private List<String> listaImena;
    private List<String> listaPrezimena;

    public KolekcijaImenaIPrezimena(List<String> ime, List<String> prezime) {
        listaImena=ime;
        listaPrezimena=prezime;
    }
    public int getIndexNajduzegPara() {
        int najduziIndex=0, maxduzina=0;
        for(int i=0; i<listaImena.size(); i++) {
            String trenutiPar=listaImena.get(i)+listaPrezimena.get(i);
            if(trenutiPar.length()>maxduzina) {
                maxduzina=trenutiPar.length();
                najduziIndex=i;
            }
        }
        return najduziIndex;
    }
    public String getImeiPrezime(int i) {
        return listaImena.get(i)+" "+listaPrezimena.get(i);
    }
}
