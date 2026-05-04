package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    private final Voiture voitureTest = new Voiture("test",1);

    @Test
    void creerVoiture()
    {
        assertEquals(voitureTest.getMarque(),"test");
        assertEquals(voitureTest.getPrix(),1);
        assertNotEquals(voitureTest.getId(),1);
    }

}
