package com.example;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static String ispisiGradove()  {
        GeografijaDAO dao= null;
        try {
            dao = GeografijaDAO.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String rez="";
        for(Grad grad: dao.gradovi())
            rez+=grad.getNaziv()+" ("+grad.getDrzava().getNaziv()+") - "+grad.getBrojStanovnika()+"\n";
        return rez;
    }
    public static void glavniGrad()  {
        GeografijaDAO dao= null;
        try {
            dao = GeografijaDAO.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Scanner sc=new Scanner(System.in);
        System.out.println("Unesite naziv drzave: ");
        String naziv=sc.nextLine();
        Grad grad=dao.glavniGrad(naziv);
        if(grad==null)
            System.out.println("Nepostojeca drzava");
        else
            System.out.println("Glavni grad drzave "+naziv+" je "+grad.getNaziv());
    }
    public static void main( String[] args )  {
        System.out.println("Gradovi su:\n" + ispisiGradove());
        glavniGrad();
    }
}
