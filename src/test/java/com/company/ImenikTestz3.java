package com.company;

import com.company.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ImenikTestz3 {
    private static Imenik imenik=new Imenik();

    @BeforeAll
    public static void setup() {
        imenik.dodaj("Lana",new MobilniBroj(61,"034-133"));
        imenik.dodaj("Aco",new FiksniBroj(Grad.SARAJEVO,"643-067"));
        imenik.dodaj("Brunno",new MedunarodniBroj("+55","589654711"));
        imenik.dodaj("Amer",new FiksniBroj(Grad.MOSTAR,"985-990"));
    }

    @Test
    public void testMockExternal() {
        Imenik im=Mockito.mock(Imenik.class);
        Mockito.when(im.dajBroj("Lana")).thenReturn("Nema nista");

        String test=im.dajBroj("Lana");
        assertEquals(test,"Nema nista");
    }

    @Test
    public void testMockInternal() {
        Map<String,TelefonskiBroj> mapa=Mockito.mock(Map.class);
        Mockito.when(mapa.get("Aco")).thenReturn(new FiksniBroj(Grad.MOSTAR,"643-067"));
        imenik.setBrojevi(mapa);

        String br=imenik.dajBroj("Aco");
        assertNotEquals(br,"033/643-067");
        assertEquals(br,"036/643-067");
    }
}