package com.company;
import java.util.Scanner;

public class ZajednickiDjelilac {
    public static int sumaCifara(int broj) {
        int suma=0;
        while(broj!=0) {
            suma+=(broj%10);
            broj/=10;
        }
        return suma;
    }

    public static void main(String[] args) {
	    int broj;
        Scanner ulaz = new Scanner(System.in);
        System.out.println("Unesite broj n: ");
        broj = ulaz.nextInt();
        System.out.println("Brojevi su: ");
        for(int i=1; i<=broj; i++) {
            if(i%sumaCifara(i)==0)
                System.out.println(i);
        }
    }
}
