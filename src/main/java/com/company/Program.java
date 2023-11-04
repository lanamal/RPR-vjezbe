package com.company;
import java.util.Scanner;
import java.util.Set;
/* glavni program za demonstraciju svih napisanih klasa */

public class Program {
    public static Scanner ulaz=new Scanner(System.in);
    public static Imenik imenik=new Imenik();

    private static void izGradaBrojevi() {
        System.out.println("Unesite ime grada:");
        String grad=ulaz.nextLine();
        try {
            Grad g=Grad.valueOf(grad);
            Set<TelefonskiBroj> brojevi=imenik.izGradaBrojevi(g);
            for(TelefonskiBroj br: brojevi)
                System.out.println(br.ispisi());
        }
        catch (Exception e) {
            System.out.println("Pogresan grad!");
            return;
        }
    }
    private static void izGrada() {
        System.out.println("Unesite ime grada:");
        String grad=ulaz.nextLine();
        try {
            Grad g=Grad.valueOf(grad);
            Set<String> gradovi=imenik.izGrada(g);
        }
        catch(Exception e) {
            System.out.println("Pogresan grad!");
            return;
        }
    }
    private static void naSlovo() {
        System.out.println("Unesite prvo slovo imena:");
        String slovo=ulaz.nextLine();
        String sl=imenik.naSlovo(slovo.toCharArray()[0]);
        System.out.println(sl);
    }
    private static void dajIme() {
        TelefonskiBroj br=unesiBrojTelefona();
        String ime=imenik.dajIme(br);
        if(ime==null)
            System.out.println("Ime ne postoji u imeniku!");
        else
            System.out.println("Vlasnik broja "+br.ispisi()+" je "+ime+".");
    }
    private static TelefonskiBroj unesiBrojTelefona() {
        System.out.println("Unesite tip broja (fiksni,mobilni,medunarodni):");
        String tip=ulaz.nextLine();
        switch(tip) {
            case "fiksni":
                System.out.println("Unesite pozivni:");
                String pozivni=ulaz.nextLine();
                System.out.println("Unesite broj:");
                String broj=ulaz.nextLine();
                return new FiksniBroj(Grad.izPozivnog(pozivni),broj);
            case "mobilni":
                System.out.println("Unesite mrezu:");
                int mreza=ulaz.nextInt();
                System.out.println("Unesite broj:");
                String mob=ulaz.nextLine();
                return new MobilniBroj(mreza,mob);
            case "medunarodni":
                System.out.println("Unesite domenu drzave (npr +387):");
                String domena=ulaz.nextLine();
                System.out.println("Unesite broj:");
                String medunar=ulaz.nextLine();
                return new MedunarodniBroj(domena,medunar);
            default:
                System.out.println("Pogresan tip!");
        }
        return null;
    }
    private static void dodajBroj() {
        System.out.println("Unesite ime:");
        String im=ulaz.nextLine();
        TelefonskiBroj br=unesiBrojTelefona();
        imenik.dodaj(im,br);
    }
    private static void ispisiImenik() {
        System.out.println(imenik.toString());
    }
    private static void dajBroj() {
        System.out.println("Unesite ime:");
        String ime=ulaz.nextLine();
        String izImenika=imenik.dajBroj(ime);
        if(izImenika==null)
            System.out.println("Nema u imeniku");
        else
            System.out.println(izImenika);
    }
    private static void popuniPodatke() {
        imenik.dodaj("Lana",new MobilniBroj(61,"034-133"));
        imenik.dodaj("Aco",new FiksniBroj(Grad.SARAJEVO,"643-067"));
        imenik.dodaj("Brunno",new MedunarodniBroj("+55","589654711"));
        imenik.dodaj("Amer",new FiksniBroj(Grad.MOSTAR,"985-990"));
    }

    public static void main(String[] args) {
        popuniPodatke();
        while(true) {
            System.out.println("Unesite komandu (dodaj,dajBroj,dajIme,naSlovo,izGrada,izGradaBrojevi,imenik,izlaz):");
            String komanda = ulaz.nextLine();
            switch (komanda) {
                case "dodaj":
                    dodajBroj();
                    break;
                case "dajBroj":
                    dajBroj();
                    break;
                case "dajIme":
                    dajIme();
                    break;
                case "naSlovo":
                    naSlovo();
                    break;
                case "izGrada":
                    izGrada();
                    break;
                case "izGradaBrojevi":
                    izGradaBrojevi();
                    break;
                case "imenik":
                    ispisiImenik();
                    break;
                case "izlaz":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pogresna komanda");
            }
        }
    }
}
