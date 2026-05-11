package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    // @Autowired
    // MockMvc mockMvc;

    @Autowired 
    private StatistiqueController statistiqueController;

    @Test
    void testGetStatistique() throws PasDeVoitureException
    {
        Echantillon mockEchantillon = new Echantillon(5,20000);

        when(statistiqueImpl.prixMoyen()).thenReturn(mockEchantillon);

        Echantillon resultat = statistiqueController.getStatistiques();
        assertEquals(20000,resultat.getPrixMoyen());
        verify(statistiqueImpl).prixMoyen();
    }

    @Test
    void testException()
    {
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());
        assertThrows(PasDeVoitureException.class,()-> {statistiqueController.getStatistiques();});
    }

    @Test
    void testCreerVoiture()
    {
        Voiture v = new Voiture("BMW", 20000);
        statistiqueController.creerVoiture(v);
        verify(statistiqueImpl,times(1)).ajouter(v);
    }

    
}
