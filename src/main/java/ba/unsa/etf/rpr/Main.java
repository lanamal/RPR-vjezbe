package ba.unsa.etf.rpr;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite 1 za ocjenjivanje predmeta ili 2 za ocjenjivanje nastavnika:");
        int izbor=ulaz.nextInt();

        switch (izbor) {
            case 1:
                //Unos informacija o predmetu
                System.out.println("Unesite naziv predmeta:");
                String nazivPredmeta=ulaz.next();
                ulaz.nextLine();
                System.out.println("Unesite opis predmeta:");
                String opisPredmeta=ulaz.nextLine();

                Predmet predmet=new Predmet(nazivPredmeta, opisPredmeta);

                //Unos ocjene za predmet
                System.out.println("Unesite ocjenu za predmet (1-9):");
                int ocjenaPredmeta=ulaz.nextInt();
                ulaz.nextLine();

                //Ocjena za predmet od strane studenta
                System.out.println("Unesite svoj status (1 za studenta, 2 za nastavnika):");
                int statusPredmeta=ulaz.nextInt();
                ulaz.nextLine();

                if (statusPredmeta==1) {
                    System.out.println("Unesite ime studenta:");
                    String imeStudenta=ulaz.nextLine();
                    System.out.println("Unesite prezime studenta:");
                    String prezimeStudenta=ulaz.nextLine();
                    System.out.println("Unesite godinu studija studenta:");
                    String godinaStudija=ulaz.nextLine();
                    System.out.println("Unesite broj indexa studenta:");
                    String brojIndexa=ulaz.nextLine();

                    InformacijeOStudentu student=new InformacijeOStudentu(imeStudenta, prezimeStudenta, godinaStudija, brojIndexa);

                    System.out.println("Student "+student.getIme()+" "+student.getPrezime()+" je ocijenio predmet sa ocjenom: "+ocjenaPredmeta);
                } else if (statusPredmeta==2) {
                    System.out.println("Unesite ime nastavnika:");
                    String imeNastavnika=ulaz.nextLine();
                    System.out.println("Unesite prezime nastavnika:");
                    String prezimeNastavnika=ulaz.nextLine();
                    System.out.println("Unesite titulu nastavnika:");
                    String titulaNastavnika=ulaz.nextLine();

                    InformacijeONastavniku nastavnik=new InformacijeONastavniku(imeNastavnika, prezimeNastavnika, titulaNastavnika);
                    Ocjena ocjenaZaPredmet=nastavnik.ocijeni(ocjenaPredmeta);
                    predmet.dodajOcjenu(ocjenaZaPredmet);
                    System.out.println("Nastavnik: "+nastavnik.getIme()+" "+nastavnik.getPrezime()+" je ocijenio predmet sa ocjenom: "+ ocjenaZaPredmet.getOcjena());
                }
                else {
                    System.out.println("Nepoznat izbor.");
                }
                break;

            case 2:
                //Unos informacija o nastavniku
                System.out.println("Unesite ime nastavnika:");
                String imeNastavnika=ulaz.next();
                System.out.println("Unesite prezime nastavnika:");
                String prezimeNastavnika=ulaz.next();
                System.out.println("Unesite titulu nastavnika:");
                String titulaNastavnika=ulaz.next();

                InformacijeONastavniku nastavnik=new InformacijeONastavniku(imeNastavnika, prezimeNastavnika, titulaNastavnika);

                //Ocjena za nastavnika od strane studenta
                System.out.println("Unesite svoj status (1 za studenta):");
                int statusNastavnika=ulaz.nextInt();
                ulaz.nextLine();

                if (statusNastavnika==1) {
                    System.out.println("Unesite ime studenta:");
                    String imeStudenta=ulaz.nextLine();
                    System.out.println("Unesite prezime studenta:");
                    String prezimeStudenta=ulaz.nextLine();
                    System.out.println("Unesite godinu studija studenta:");
                    String godinaStudija=ulaz.nextLine();
                    System.out.println("Unesite broj indexa studenta:");
                    String brojIndexa=ulaz.nextLine();

                    InformacijeOStudentu student=new InformacijeOStudentu(imeStudenta, prezimeStudenta, godinaStudija, brojIndexa);

                    //Ocjena za nastavnika od strane studenta
                    System.out.println("Unesite ocjenu za nastavnika (1-9):");
                    int ocjenaNastavnika=ulaz.nextInt();
                    ulaz.nextLine();

                    System.out.println("Student "+student.getIme()+" "+student.getPrezime()+" je ocijenio nastavnika sa ocjenom: "+ocjenaNastavnika);
                } else {
                    System.out.println("Nastavnici ne mogu ocijeniti sami sebe.");
                }
                break;

            default:
                System.out.println("Nepoznat izbor.");
                break;
        }
    }
}
