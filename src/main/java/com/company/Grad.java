package com.company;

/* enum za gradove koje cemo koristiti u drugim klasama */

public enum Grad {
    TRAVNIK("030"),
    ODZAK("031"),
    ZENICA("032"),
    SARAJEVO("033"),
    LIVNO("034"),
    TUZLA("035"),
    MOSTAR("036"),
    BIHAC("037"),
    GORAZDE("038"),
    GRUDE("039"),
    BRCKO("049"),
    MRKONJIC_GRAD("050"),
    BANJA_LUKA("051"),
    PRIJEDOR("052"),
    DOBOJ("053"),
    BOSANSKI_SAMAC("054"),
    BIJELJINA("055"),
    ZVORNIK("056"),
    PALE("057"),
    VISEGRAD("058"),
    TREBINJE("059");

    private String pozivniBroj;

    Grad(String pozivni) {
        pozivniBroj=pozivni;
    }
    public static Grad izPozivnog(String pozivni) {
        for(Grad grad: Grad.values()) {
            if(grad.getPozivniBroj().equals(pozivni))
                return grad;
        }
        return null;
    }
    public String getPozivniBroj() {
        return pozivniBroj;
    }
}