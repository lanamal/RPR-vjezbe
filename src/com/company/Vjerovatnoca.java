package com.company;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import static java.lang.Math.*;
import static java.util.Collections.*;

public class Vjerovatnoca {

    public static void main(String[] args) {
        List<Integer> lista=new ArrayList<>();
        Scanner ulaz=new Scanner(System.in);
        System.out.println("Unesite brojeve (stop za prekid, slovo za nastavak):");
        while(ulaz.hasNext()) {
            if(ulaz.hasNextInt()) {
                int broj=ulaz.nextInt();
                lista.add(broj);
            }
            else {
                String string=ulaz.next();
                if(string.equals("stop"))
                    break;
            }
        }

        int maksimum= (int) max(lista), minimum=(int) min(lista), suma=0;
        double mean;
        for(int i=0; i<lista.size(); i++)
            suma+=lista.get(i);
        mean=(double)suma/lista.size();
        double sumaDev=0;
        for(int i=0; i<lista.size(); i++)
            sumaDev+=pow(lista.get(i)-mean,2);
        double standDev=(double)sqrt(sumaDev/lista.size());
        System.out.println("Max = "+maksimum+"\nMin = "+minimum+"\nMean = "+mean+"\nDevijacija = "+standDev);
    }
}
