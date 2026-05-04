package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.BeforeEach;



@SpringBootTest
public class VoitureTest {

    private Voiture voitureTest;
    private Voiture voitureVide;

    @BeforeEach
    public void init()
    {
        this.voitureTest = new Voiture("test",1);
        this.voitureVide = new Voiture();
    }


    @Test
    void creerVoiture()
    {
        assertEquals(this.voitureTest.getMarque(),"test");
        assertEquals(this.voitureTest.getPrix(),1);
        assertNotEquals(this.voitureTest.getId(),1);
        assertEquals(this.voitureTest.toString(),"Car{marque='test', prix=1, id=0}");
    }

    @Test
    void creerVoitureVide()
    {
        assertNull(this.voitureVide.getMarque());
        assertEquals(this.voitureVide.getPrix(),0);
        assertEquals(this.voitureVide.getId(),0);
    }

}
