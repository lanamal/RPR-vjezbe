package com.company;
import java.util.Objects;
/* klasa za mobilni broj korisnika izvedena iz apstraktne klase TelefonskiBroj */

public class MobilniBroj extends TelefonskiBroj {
    private int mobilnaMreza;
    private String broj;

    public MobilniBroj(int mobilnaMreza,String broj) {
        this.mobilnaMreza=mobilnaMreza;
        this.broj=broj;
    }
    @Override
    public String ispisi() {
        if(broj==null)
            return null;

        return "0"+mobilnaMreza+"/"+broj;
    }
    @Override
    public int hashCode() {
        return Objects.hash(mobilnaMreza,broj);
    }
}
