package ba.unsa.etf.rpr;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LicneInformacije osoba1=new LicneInformacije("Lana","Malinov");
        System.out.println("Ime "+osoba1.getIme()+",prezime "+osoba1.getPrezime());

        LicneInformacije osoba2=new InformacijeOStudentu("Lamija","Setic","2. godina","19050");
        LicneInformacije osoba3=new InformacijeONastavniku("Alisa","Ramic","master");

        List<Informacije> listaInfo= List.of(osoba1,osoba2,osoba3);
        KolekcijaPoruka poruke=new KolekcijaPoruka(listaInfo);
        List<String> porukeIzKolekcije=poruke.getPoruke();
        System.out.println("Sve informacije:");
        for(String poruka: porukeIzKolekcije)
            System.out.println(poruka);
    }
}
