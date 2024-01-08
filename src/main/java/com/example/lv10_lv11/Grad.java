package com.example.lv10_lv11;
import javafx.beans.property.*;
import java.util.ArrayList;
import java.util.List;

public class Grad {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty naziv = new SimpleStringProperty();
    private final IntegerProperty brojStanovnika = new SimpleIntegerProperty();
    private final ObjectProperty<Drzava> drzava = new SimpleObjectProperty<>();
    private static final List<Grad> gradList = new ArrayList<>();
    static {
        new Grad(1, "London", 8825000, new Drzava(1, "Velika Britanija", null));
        new Grad(2, "Pariz", 2206488, new Drzava(2, "Francuska", null));
        new Grad(3, "Bec", 1899055, new Drzava(3, "Austrija", null));
        new Grad(4, "Manchester", 545500, new Drzava(1, "Velika Britanija", null));
        new Grad(5, "Graz", 280200, new Drzava(3, "Austrija", null));
    }
    public Grad(int id, String naziv, int brojStanovnika, Drzava drzava){
        setId(id);
        setNaziv(naziv);
        setBrojStanovnika(brojStanovnika);
        setDrzava(drzava);
        gradList.add(this);
        System.out.println("Dodan");
        System.out.println(gradList.size());
    }
    public Grad(){}
    public int getId() {
        return id.get();
    }
    public String getNaziv() {
        return naziv.get();
    }
    public int getBrojStanovnika() {
        return brojStanovnika.get();
    }
    public Drzava getDrzava() {
        return drzava.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }
    public void setBrojStanovnika(int brojStanovnika) {
        this.brojStanovnika.set(brojStanovnika);
    }
    public void setDrzava(Drzava drzava) {
        this.drzava.set(drzava);
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public StringProperty nazivProperty() {
        return naziv;
    }
    public IntegerProperty brojStanovnikaProperty() {
        return brojStanovnika;
    }
    public ObjectProperty<Drzava> drzavaProperty() {
        return drzava;
    }
    public static List<Grad> getGradList() {
        return gradList;
    }
    @Override
    public String toString() {
        return getNaziv();
    }
}
