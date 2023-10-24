package com.company;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

public class Vjerovatnoca {

    public static void main(String[] args) {
        List<Double> niz=new ArrayList();
        Scanner ulaz=new Scanner(System.in);

        while(true) {
            System.out.println("Unesite broj ili rijec-stop za kraj unosa: ");
            String unos=ulaz.nextLine();
            if (unos.equalsIgnoreCase("stop")) {
                if (niz.isEmpty()) {
                    System.out.println("Niste unijeli broj!");
                } else {
                    double min=(Double)Collections.min(niz);
                    double max=(Double)Collections.max(niz);
                    double suma=0.0;

                    double broj1;
                    for(Iterator it=niz.iterator();it.hasNext();suma+=broj1)
                        broj1=(Double)it.next();

                    double srednjaVri=suma/(double)niz.size();

                    double suma2=0.0;
                    double broj2;
                    for(Iterator it=niz.iterator();it.hasNext();suma2+=Math.pow(broj2-srednjaVri, 2.0)) {
                        broj2=(Double)it.next();
                    }

                    double standardnaDev = Math.sqrt(suma2/(double)niz.size());
                    System.out.println("Minimum iznosi " +min);
                    System.out.println("Maksimum iznosi " +max);
                    System.out.println("Srednja vrijednost iznosi " +srednjaVri);
                    System.out.println("Standardna devijacija iznosi " +standardnaDev);
                }
                return;
            }
            try {
                niz.add(Double.parseDouble(unos));
            } catch (NumberFormatException var17) {
                System.out.println("Niste unijeli ispravan broj! Molim vas pokušajte ponovno.");
            }
        }
    }
}
