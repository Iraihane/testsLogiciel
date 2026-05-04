package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
public class VoitureTest {

    private final Voiture voitureTest = new Voiture("test",1);
    private final Voiture voitureVide = new Voiture();

    @Test
    void creerVoiture()
    {
        assertEquals(voitureTest.getMarque(),"test");
        assertEquals(voitureTest.getPrix(),1);
        assertNotEquals(voitureTest.getId(),1);
        assertEquals(voitureTest.toString(),"Car{marque='test', prix=1, id=0}");
    }

    @Test
    void creerVoitureVide()
    {
        assertNull(voitureVide.getMarque());
        assertEquals(voitureVide.getPrix(),0);
        assertEquals(voitureVide.getId(),0);
    }

}
