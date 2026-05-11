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

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // @Autowired 
    // private StatistiqueController statistiqueController;

    // @Test
    // void testGetStatistique() throws PasDeVoitureException
    // {
    //     Echantillon mockEchantillon = new Echantillon(5,20000);

    //     when(statistiqueImpl.prixMoyen()).thenReturn(mockEchantillon);

    //     Echantillon resultat = statistiqueController.getStatistiques();
    //     assertEquals(20000,resultat.getPrixMoyen());
    //     verify(statistiqueImpl).prixMoyen();
    // }

    // @Test
    // void testException()
    // {
    //     when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());
    //     assertThrows(PasDeVoitureException.class,()-> {statistiqueController.getStatistiques();});
    // }

    // @Test
    // void testCreerVoiture()
    // {
    //     Voiture v = new Voiture("BMW", 20000);
    //     statistiqueController.creerVoiture(v);
    //     verify(statistiqueImpl,times(1)).ajouter(v);
    // }


    //Test avec MockMVC

    @Test
    void testGetStatistique() throws Exception 
    {
        Echantillon echantillon = new Echantillon(2,15000);
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        mockMvc.perform(get("/statistique")).andExpect(status().isOk());
    }

    @Test
    void testException() throws Exception
    {
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());
        mockMvc.perform(get("/statistique")).andExpect(status().isBadRequest());
    }

    @Test
    void testCreerVoiture() throws Exception
    {
        Voiture v = new Voiture("BMW", 20000);
        mockMvc.perform(post("/voiture").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(v))).andExpect(status().isOk());
        verify(statistiqueImpl,times(1)).ajouter(any(Voiture.class));
    }
        //test

}
