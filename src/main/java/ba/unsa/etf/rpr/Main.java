package ba.unsa.etf.rpr;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Primjer sa KolekcijaImena
        List<String> nazivi=new ArrayList<>();
        nazivi.add("Lana Malinov");
        nazivi.add("Lamija Setic");
        KolekcijaImena kolekcija=new KolekcijaImena(nazivi);
        Pobjednik pob1=new Pobjednik(kolekcija);

        System.out.println("Osoba 1:");
        System.out.println("Ime: "+pob1.getIme());
        System.out.println("Prezime: "+pob1.getPrezime());
        System.out.println("Duzina imena: "+pob1.getBrojZnakova());

        //Primjer sa KolekcijaImenaIPrezimena
        List<String> imena=new ArrayList<>();
        imena.add("Sara");
        imena.add("Alekandar");

        List<String> prezimena=new ArrayList<>();
        prezimena.add("Filipovic");
        prezimena.add("Malinov");

        KolekcijaImenaIPrezimena kolekcija2=new KolekcijaImenaIPrezimena(imena,prezimena);
        int index=kolekcija2.getIndexNajduzegPara();
        System.out.println("\nIndex najduzeg para: "+index);
        Pobjednik pob2 =new Pobjednik(new KolekcijaImena(List.of(kolekcija2.getImeiPrezime(index))));

        System.out.println("\nOsoba 2:");
        System.out.println("Ime: "+pob2.getIme());
        System.out.println("Prezime: "+pob2.getPrezime());
        System.out.println("Duzina imena: "+pob2.getBrojZnakova());
    }
}
