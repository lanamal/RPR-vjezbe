package com.company;

public class Osoba {
    protected String ime;
    protected String prezime;

    public Osoba(String im, String prez){
        ime=im; prezime=prez;
    }
    @Override
    public String toString(){
        return ime+" "+prezime;
    }
}
