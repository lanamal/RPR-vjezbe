package com.company;
import java.util.*;
/* klasa za pretrazivanje brojeva koristeci HashMap */

public class Imenik {
    private Map<String,TelefonskiBroj> brojevi;
    private boolean jeliIzGrada(TelefonskiBroj broj,Grad g) {
        if(broj instanceof FiksniBroj)
            return g.equals(((FiksniBroj) broj).getGrad());
        else
            return false;
    }

    public Imenik() {
        this.brojevi=new HashMap<String,TelefonskiBroj>();
    }
    public Map<String,TelefonskiBroj>getBrojevi() {
        return brojevi;
    }
    public void setBrojevi(Map<String,TelefonskiBroj> brojevi) {
        this.brojevi=brojevi;
    }
    public void dodaj(String ime,TelefonskiBroj broj) {
        this.brojevi.put(ime,broj);
    }
    public String dajBroj(String ime) {
        TelefonskiBroj broj=this.brojevi.get(ime);
        if(broj==null)
            return null;
        return broj.ispisi();
    }
    public String dajIme(TelefonskiBroj broj) {
        for(Map.Entry<String,TelefonskiBroj> unos: this.brojevi.entrySet()) {
            if(unos.getValue().ispisi().equals(broj.ispisi()))
                return unos.getKey();
        }
        return null;
    }
    public String naSlovo(char s) {
        StringBuilder builder=new StringBuilder();
        int brojac=1;
        for(Map.Entry<String,TelefonskiBroj> unos: this.brojevi.entrySet()) {
            if(unos.getKey().startsWith(String.valueOf(s))) {
                builder.append(brojac)
                        .append(". ")
                        .append(unos.getKey())
                        .append(" - ")
                        .append(unos.getValue().ispisi())
                        .append(System.lineSeparator());
            }
            brojac++;
        }
        return builder.toString();
    }
    public Set<String> izGrada(Grad g) {
        Set<String> rezultat=new TreeSet<String>(); //sortiranje abecedno uz pomoc TreeSet-a
        for(Map.Entry<String,TelefonskiBroj> unos: this.brojevi.entrySet()) {
            if(jeliIzGrada(unos.getValue(),g))
                rezultat.add(unos.getKey());
        }
        return rezultat;
    }
    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> rezultat=new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1,TelefonskiBroj o2) {
                return o1.ispisi().compareTo(o2.ispisi());
            }
        });
        for(Map.Entry<String,TelefonskiBroj> unos: this.brojevi.entrySet()) {
            if(jeliIzGrada(unos.getValue(),g))
                rezultat.add(unos.getValue());
        }
        return rezultat;
    }
    //za ispis svih korisnika iz imenika
    @Override
    public String toString() {
        StringBuilder builder=new StringBuilder();
        int brojac=1;
        for(Map.Entry<String,TelefonskiBroj> unos: this.brojevi.entrySet()) {
            builder.append(brojac)
                    .append(". ")
                    .append(unos.getKey())
                    .append(" - ")
                    .append(unos.getValue().ispisi())
                    .append(System.lineSeparator());
            brojac++;
        }
        return builder.toString();
    }
}
