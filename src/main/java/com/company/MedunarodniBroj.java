package com.company;
import java.util.Objects;
/* klasa za medjunarodni broj korisnika izvedena iz apstraktne klase TelefonskiBroj */

public class MedunarodniBroj extends TelefonskiBroj {
    private String drzava;
    private String broj;

    public MedunarodniBroj(String drzava,String broj) {
        this.drzava=drzava;
        this.broj=broj;
    }
    @Override
    public String ispisi() {
        if(broj==null || drzava==null)
            return null;
        return drzava+broj; //+387?
    }
    @Override
    public int hashCode() {
        return Objects.hash(drzava,broj);
    }
}
