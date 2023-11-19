package ba.unsa.etf.rpr;
import java.util.*;

public class KolekcijaPoruka {
    private List<String> poruke=new ArrayList<String>();

    public KolekcijaPoruka(List<? extends Informacije> listaInfo) {
        for(Informacije info: listaInfo)
            poruke.add(info.getIme()+" "+info.getPrezime());
    }
    public List<String> getPoruke() {
        return this.poruke;
    }
}
