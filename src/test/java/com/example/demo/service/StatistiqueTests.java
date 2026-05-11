package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;



@SpringBootTest
public class StatistiqueTests {

    StatistiqueImpl statistiqueImpl;
    Voiture voiture;

    @BeforeEach
    void setUp()
    {
        statistiqueImpl = new StatistiqueImpl();
        voiture = new Voiture();
    }

    @Test
    void ajouterVoiture()
    {        
        statistiqueImpl.ajouter(voiture);
        assertDoesNotThrow(() -> statistiqueImpl.prixMoyen());
    }

    @Test
    void prixMoyenCalcul()
    {
        Voiture v2 = new Voiture();

        voiture.setPrix(1000);
        v2.setPrix(2000);

        statistiqueImpl.ajouter(voiture);
        statistiqueImpl.ajouter(v2);

        Echantillon resultat = statistiqueImpl.prixMoyen();

        assertEquals(2,resultat.getNombreDeVoitures(), "Le résultat doit être égal à 2");
        assertEquals(1500,resultat.getPrixMoyen(), "Le prix moyen doit être de 1500");
    }

    @Test
    void testException()
    {
        assertThrows(ArithmeticException.class,()->{statistiqueImpl.prixMoyen();});
    }

}
