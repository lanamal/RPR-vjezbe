package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int broj1;
        Scanner ulaz1 = new Scanner(System.in);
        System.out.println("Unesite prvi broj: ");
        broj1 = ulaz1.nextInt();
        int broj2;
        Scanner ulaz2 = new Scanner(System.in);
        System.out.println("Unesite drugi broj: ");
        broj2 = ulaz2.nextInt();
        System.out.println("Prvi broj = " + broj1);
        System.out.println("Drugi broj = " + broj2);
    }
}
