package com.example.lv10_lv11;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance;
    private Connection conn;
    private PreparedStatement glavniGradUpit, dajDrzavuUpit, obrisiDrzavuUpit, obrisiGradoveZaDrzavu, nadjiDrzavuUpit,
            dajGradoveUpit, dodajGradUpit, odrediIdGradUpit, dodajDrzavuUpit, odrediIdDrzaveUpit, promijeniGradUpit, dajGradUpit;
    public static GeografijaDAO getInstance(){
        if(instance==null) instance= new GeografijaDAO();
        return instance;
    }
    private GeografijaDAO(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            glavniGradUpit = conn.prepareStatement("SELECT grad.id, grad.naziv, grad.broj_stanovnika, grad.drzava FROM grad, drzava WHERE grad.drzava=drzava.id AND drzava.naziv=?");
        } catch (SQLException e) {
            regenerisiBazu();
            try {
                glavniGradUpit = conn.prepareStatement("SELECT grad.id, grad.naziv, grad.broj_stanovnika, grad.drzava FROM grad, drzava WHERE grad.drzava=drzava.id AND drzava.naziv=?");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        try {
            dajDrzavuUpit = conn.prepareStatement("SELECT * FROM drzava WHERE id=?");
            obrisiDrzavuUpit = conn.prepareStatement("DELETE FROM drzava WHERE naziv=?");
            obrisiGradoveZaDrzavu = conn.prepareStatement("DELETE FROM grad WHERE drzava=?");
            nadjiDrzavuUpit = conn.prepareStatement("SELECT * FROM drzava WHERE naziv=?");
            dajGradoveUpit = conn.prepareStatement("SELECT * FROM grad ORDER BY broj_stanovnika DESC");
            dodajGradUpit = conn.prepareStatement("INSERT INTO grad VALUES(?,?,?,?)");
            odrediIdGradUpit = conn.prepareStatement("SELECT MAX(id)+1 FROM grad");
            dodajDrzavuUpit = conn.prepareStatement("INSERT INTO drzava VALUES(?,?,?)");
            odrediIdDrzaveUpit = conn.prepareStatement("SELECT MAX(id)+1 FROM drzava");
            promijeniGradUpit = conn.prepareStatement("UPDATE grad SET naziv=?, broj_stanovnika=?, drzava=?, WHERE id=?");
            dajGradUpit = conn.prepareStatement("SELECT * from grad WHERE id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void regenerisiBazu() {
        Scanner ulaz = null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
            String sqlUpit = "";
            while(ulaz.hasNext()){
                String line = ulaz.nextLine();
                sqlUpit +=ulaz.nextLine();
                if(sqlUpit.charAt( sqlUpit.length()-1 ) == ';'){
                    try {
                        Statement statement = conn.createStatement();
                        statement.execute(sqlUpit);
                        sqlUpit = "";
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public Grad glavniGrad(String drzava){
        try {
            glavniGradUpit.setString(1,drzava);
            ResultSet res = glavniGradUpit.executeQuery();
            if(!res.next()) return null;
            return dajGradIzResultSeta(res);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Grad dajGradIzResultSeta(ResultSet res) throws SQLException{
        Grad grad = new Grad(res.getInt(1), res.getString(2),res.getInt(3),null);
        grad.setDrzava(dajDrzavu(res.getInt(4), grad));
        return grad;
    }
    private Drzava dajDrzavu(int id, Grad grad) {
        try {
            dajDrzavuUpit.setInt(1,id);
            ResultSet res = dajDrzavuUpit.executeQuery();
            if(!res.next()) return null;
            return dajDrzavuIzResultSeta(res, grad);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Grad dajGrad(int id) {
        try {
            dajGradUpit.setInt(1,id);
            ResultSet res = dajGradUpit.executeQuery();
            if(!res.next()) return null;
            return dajGradIzResultSeta(res);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Drzava dajDrzavuIzResultSeta(ResultSet res, Grad grad) throws SQLException {
        return new Drzava(res.getInt(1),res.getString(2),grad);
    }
    public void obrisiDrzavu(String nazivDrzave){
        try {
            nadjiDrzavuUpit.setString(1, nazivDrzave);
            ResultSet res = nadjiDrzavuUpit.executeQuery();
            if(!res.next()) return;
            Drzava drzava = dajDrzavuIzResultSeta(res, null);

            obrisiGradoveZaDrzavu.setInt(1,drzava.getId());
            obrisiGradoveZaDrzavu.executeQuery();
            obrisiDrzavuUpit.setInt(1, drzava.getId());
            obrisiDrzavuUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Grad> gradovi(){
        ArrayList<Grad> rezultat = new ArrayList();
        try {
            ResultSet res = dajGradoveUpit.executeQuery();
            while(!res.next()){
                Grad grad = dajGradIzResultSeta(res);
                rezultat.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    public void dodajGrad(Grad grad){
        try {
            ResultSet res = odrediIdGradUpit.executeQuery();
            int id = 1;
            if(res.next()){
                id = res.getInt(1);
            }
            dodajGradUpit.setInt(1,id);
            dodajGradUpit.setString(2,grad.getNaziv());
            dodajGradUpit.setInt(3, grad.getBrojStanovnika());
            dodajGradUpit.setInt(4, grad.getDrzava().getId());
            dodajGradUpit.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dodajDrzavu(Drzava drzava){
        try {
            ResultSet res = odrediIdDrzaveUpit.executeQuery();
            int id = 1;
            if(res.next()){
                id = res.getInt(1);
            }
            dodajDrzavuUpit.setInt(1,id);
            dodajDrzavuUpit.setString(2,drzava.getNaziv());
            dodajDrzavuUpit.setInt(3, drzava.getGlavniGrad().getId());
            dodajDrzavuUpit.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void removeInstance(){
        if(instance == null) return;
        instance.close();
        instance = null;
    }
    public void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void izmijeniGrad(Grad grad){
        try {
            promijeniGradUpit.setString(1,grad.getNaziv());
            promijeniGradUpit.setInt(2,grad.getBrojStanovnika());
            promijeniGradUpit.setInt(3, grad.getDrzava().getId());
            promijeniGradUpit.setInt(4, grad.getId());
            promijeniGradUpit.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Drzava nadjiDrzavu(String nazivDrzave){
        try {
            nadjiDrzavuUpit.setString(1,nazivDrzave);
            ResultSet res = nadjiDrzavuUpit.executeQuery();
            if(!res.next()) return null;
            return dajDrzavuIzResultSeta(res,dajGrad(res.getInt(3)));

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

