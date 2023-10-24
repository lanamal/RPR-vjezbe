package com.company;//package com.company;

public class Main{
    public Main() {
    }
    public static void main(String[] args) {
        if (args.length!=1) {
            System.out.println("Unesite tačno jedan broj za argument.");
        } else {
            try {
                Kalkulator kalk = new Kalkulator();
                double sinus = kalk.Sin(Double.parseDouble(args[0]));
                long fact = kalk.Fact((int)Double.parseDouble(args[0]));
                System.out.println("sin(" + Double.parseDouble(args[0]) + ") je " + sinus);
                System.out.println((int)Double.parseDouble(args[0]) + "! je " + fact);
            } catch (NumberFormatException var6) {
                System.out.println("Uneseni argument nije validan.");
            }

        }
    }
}
