package com.company;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ImenikTestz2 {
    private static Imenik imenik=new Imenik();

    @BeforeAll
    public static void setup() {
        imenik.dodaj("Lana",new MobilniBroj(61,"034-133"));
        imenik.dodaj("Aco",new FiksniBroj(Grad.SARAJEVO,"643-067"));
        imenik.dodaj("Brunno",new MedunarodniBroj("+55","589654711"));
        imenik.dodaj("Amer",new FiksniBroj(Grad.MOSTAR,"985-990"));
    }

    @Test
    public void getBrojFound() {
        String broj=imenik.dajBroj("Lana");
        assertEquals(broj,"061/034-133");
    }

    @Test
    public void dajBrojNotFound() {
        String broj=imenik.dajBroj("Amila");
        assertNull(broj);
    }

    @Test
    public void dodajTestPositive() {
        TelefonskiBroj br=new MobilniBroj(61,"507-885");
        imenik.dodaj("Lamija",br);
        String brStr=imenik.dajBroj("Lamija");
        assertEquals(brStr,"061/507-885");
    }

    @Test
    public void dodajFiksniException() {
        //prvi nacin
        assertThrows(BrojException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null,"123-123");
            }
        });
        //ili preko lambda funkcije
        assertThrows(BrojException.class, ()->{new FiksniBroj(null,"123-123");});
    }
}