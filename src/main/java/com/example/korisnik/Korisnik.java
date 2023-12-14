package com.example.korisnik;

import javafx.beans.property.*;

public class Korisnik {
    private SimpleStringProperty ime;
    private SimpleStringProperty prezime;
    private SimpleStringProperty email;
    private SimpleStringProperty korisnickoIme;
    private SimpleStringProperty lozinka;

    public Korisnik() {
        this.ime=new SimpleStringProperty();
        this.prezime=new SimpleStringProperty();
        this.email=new SimpleStringProperty();
        this.korisnickoIme=new SimpleStringProperty();
        this.lozinka=new SimpleStringProperty();
    }

    public Korisnik(String i, String p, String e, String ki, String l) {
        this.ime=new SimpleStringProperty(i);
        this.prezime=new SimpleStringProperty(p);
        this.email=new SimpleStringProperty(e);
        this.korisnickoIme=new SimpleStringProperty(ki);
        this.lozinka=new SimpleStringProperty(l);
    }
    public String getIme() {
        return ime.get();
    }
    public SimpleStringProperty imeProperty() {
        return ime;
    }
    public void setIme(String ime) {
        this.ime.set(ime);
    }
    public String getPrezime() {
        return prezime.get();
    }
    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }
    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }
    public String getEmail() {
        return email.get();
    }
    public SimpleStringProperty emailProperty() {
        return email;
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public String getKorisnickoIme() {
        return korisnickoIme.get();
    }
    public SimpleStringProperty korisnickoImeProperty() {
        return korisnickoIme;
    }
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme.set(korisnickoIme);
    }
    public String getLozinka() {
        return lozinka.get();
    }
    public SimpleStringProperty lozinkaProperty() {
        return lozinka;
    }
    public void setLozinka(String lozinka) {
        this.lozinka.set(lozinka);
    }
    @Override
    public String toString(){
        return getIme() + " " + getPrezime();
    }
}
