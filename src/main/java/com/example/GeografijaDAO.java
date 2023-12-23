package com.example;
import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GeografijaDAO {
    private static GeografijaDAO instance; //jer pise da treba biti singleton klasa
    private Connection conn;

    private PreparedStatement glavniGradUpit, dajDrzavuUpit, obrisiDrzavuUpit, obrisiGradoveZaDrzavu, nadjiDrzavuUpit, dajGradoveUpit, dodajGradUpit, odrediIdGradaUpit, dodajDrzavuUpit, odrediIdDrzaveUpit, promijeniGradUpit, dajGradUpit;

    public static GeografijaDAO getInstance() throws SQLException {
        if(instance==null)
            instance=new GeografijaDAO();
        return instance;
    }
    private GeografijaDAO() {
        try {
            conn= DriverManager.getConnection("jdbc:sqlite:baza.db");
        } catch(SQLException e) {
            e.printStackTrace();
        }
        try {
            glavniGradUpit=conn.prepareStatement("SELECT grad.id, grad.naziv, grad.broj_stanovnika, grad.drzava FROM grad, drzava WHERE grad.drzava=drzava.id AND drzava.naziv=?");
        } catch(SQLException e) {
            regenerisiBazu();
            try {
                glavniGradUpit=conn.prepareStatement("SELECT grad.id, grad.naziv, grad.broj_stanovnika, grad.drzava FROM grad, drzava WHERE grad.drzava=drzava.id AND drzava.naziv=?");
            } catch(SQLException e1) {
                e1.printStackTrace();
            }
        }
        try {
            dajDrzavuUpit=conn.prepareStatement("SELECT * FROM drzava WHERE id=?");
            dajGradUpit=conn.prepareStatement("SELECT * FROM grad WHERE id=?");
            obrisiGradoveZaDrzavu=conn.prepareStatement("DELETE FROM grad WHERE drzava=?");
            obrisiDrzavuUpit=conn.prepareStatement("DELETE FROM drzava WHERE naziv=?");
            nadjiDrzavuUpit=conn.prepareStatement("SELECT * FROM drzava WHERE naziv=?");
            dajGradoveUpit=conn.prepareStatement("SELECT * FROM grad ORDER BY broj_stanovnika DESC");

            dodajGradUpit=conn.prepareStatement("INSERT INTO grad VALUES(?,?,?,?)");
            odrediIdGradaUpit=conn.prepareStatement("SELECT MAX(id)+1 FROM grad");
            dodajDrzavuUpit=conn.prepareStatement("INSERT INTO drzava VALUES(?,?,?)");
            odrediIdDrzaveUpit=conn.prepareStatement("SELECT MAX(id)+1 FROM drzava");
            promijeniGradUpit=conn.prepareStatement("UPDATE grad SET naziv=?, broj_stanovnika=?, drzava=? WHERE id=?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void regenerisiBazu() {
        Scanner ulaz= null;
        try {
            ulaz = new Scanner(new FileInputStream("baza.db.sql"));
            String sqlUpit="";
            while(ulaz.hasNext()) {
                sqlUpit+=ulaz.nextLine();
                if(sqlUpit.charAt(sqlUpit.length()-1)==';') {
                    try {
                        Statement stmt=conn.createStatement();
                        stmt.execute(sqlUpit);
                        sqlUpit="";
                    } catch(SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            ulaz.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Grad glavniGrad(String drzava) {
        try {
            glavniGradUpit.setString(1,drzava);
            ResultSet rez=glavniGradUpit.executeQuery();
            if(!rez.next())
                return null;
            return dajGradIzResultSeta(rez);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Grad dajGradIzResultSeta(ResultSet rez) throws SQLException {
        Grad grad=new Grad(rez.getInt(1),rez.getString(2),rez.getInt(3), null);
        grad.setDrzava(dajDrzavu(rez.getInt(4), grad));
        return grad;
    }
    private Drzava dajDrzavu(int id, Grad grad) {
        try {
            dajDrzavuUpit.setInt(1,id);
            ResultSet rez=dajDrzavuUpit.executeQuery();
            if(!rez.next())
                return null;
            return dajDrzavuResultSeta(rez, grad);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Grad dajGrad(int id) {
        try {
            dajGradUpit.setInt(1,id);
            ResultSet rez=dajGradUpit.executeQuery();
            if(!rez.next())
                return null;
            return dajGradIzResultSeta(rez);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Drzava dajDrzavuResultSeta(ResultSet rez, Grad grad) throws SQLException {
        return new Drzava(rez.getInt(1),rez.getString(2),grad);
    }
    public void obrisiDrzavu(String nazivDrzave) {
        try {
            nadjiDrzavuUpit.setString(1,nazivDrzave);
            ResultSet rez=nadjiDrzavuUpit.executeQuery();
            if(!rez.next())
                return;
            Drzava drzava=dajDrzavuResultSeta(rez,null);

            obrisiGradoveZaDrzavu.setInt(1,drzava.getId());
            obrisiGradoveZaDrzavu.executeQuery();

            obrisiDrzavuUpit.setInt(1,drzava.getId());
            obrisiDrzavuUpit.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Grad> gradovi() {
        ArrayList<Grad> rezultat=new ArrayList();
        try {
            ResultSet rez=dajGradoveUpit.executeQuery();
            while(rez.next()) {
                Grad grad=dajGradIzResultSeta(rez);
                rezultat.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezultat;
    }
    public void dodajGrad(Grad grad) {
        try {
            ResultSet rez=odrediIdGradaUpit.executeQuery();
            int id=1;
            if(rez.next()) {
                id=rez.getInt(1);
            }
            dodajGradUpit.setInt(1,id);
            dodajGradUpit.setString(2,grad.getNaziv());
            dodajGradUpit.setInt(3,grad.getBrojStanovnika());
            dodajGradUpit.setInt(4,grad.getDrzava().getId());
            dodajGradUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dodajDrzavu(Drzava drzava) {
        try {
            ResultSet rez=odrediIdDrzaveUpit.executeQuery();
            int id=1;
            if(rez.next()) {
                id=rez.getInt(1);
            }
            dodajDrzavuUpit.setInt(1,id);
            dodajDrzavuUpit.setString(2, drzava.getNaziv());
            dodajDrzavuUpit.setInt(3,drzava.getGlavniGrad().getId());
            dodajDrzavuUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void izmijeniGrad(Grad grad) {
        try {
            promijeniGradUpit.setString(1,grad.getNaziv());
            promijeniGradUpit.setInt(2,grad.getBrojStanovnika());
            promijeniGradUpit.setInt(3,grad.getDrzava().getId());
            promijeniGradUpit.setInt(4,grad.getId());
            promijeniGradUpit.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Drzava nadjiDrzavu(String nazivDrzave) {
        try {
            nadjiDrzavuUpit.setString(1,nazivDrzave);
            ResultSet rez=nadjiDrzavuUpit.executeQuery();
            if(!rez.next())
                return null;
            return dajDrzavuResultSeta(rez,dajGrad(rez.getInt(3)));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
