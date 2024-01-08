package com.example.lv10_lv11;
import javafx.beans.property.*;
import java.util.ArrayList;
import java.util.List;

public class Drzava {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty naziv = new SimpleStringProperty();
    private final ObjectProperty<Grad> glavniGrad = new SimpleObjectProperty<>();
    private static final List<Drzava> drzavaList = new ArrayList<>();
    public Drzava(int id, String naziv, Grad glavniGrad) {
        setId(id);
        setNaziv(naziv);
        setGlavniGrad(glavniGrad);
        drzavaList.add(this);
        System.out.println("Dodana");
        System.out.println(drzavaList.size());
    }
    public Drzava() {
    }
    public int getId() {
        return id.get();
    }
    public String getNaziv() {
        return naziv.get();
    }
    public Grad getGlavniGrad() {
        return glavniGrad.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public void setNaziv(String naziv) {
        this.naziv.set(naziv);
    }
    public void setGlavniGrad(Grad glavniGrad) {
        this.glavniGrad.set(glavniGrad);
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public StringProperty nazivProperty() {
        return naziv;
    }
    public ObjectProperty<Grad> glavniGradProperty() {
        return glavniGrad;
    }
    public static List<Drzava> getDrzavaList() {
        return drzavaList;
    }
    @Override
    public String toString() {
        return getNaziv();
    }
}
