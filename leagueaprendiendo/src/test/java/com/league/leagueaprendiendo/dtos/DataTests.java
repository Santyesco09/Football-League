package com.league.leagueaprendiendo.dtos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.league.leagueaprendiendo.dtos_learning_spring.Data;

public class DataTests {
    @Test
    public void checkConstructorSinParametros(){
        Data dato = new Data("", 0L);
        assertNotNull(dato);
        assertEquals(dato.getId(), 0L, "El ID debería ser 0L");
        assertEquals(dato.getCadena(), "", "La cadena debería ser ''");
    }
    
    @Test
    public void checkConstructorConParametros(){
        Data dato = new Data("Test", 1L);

        assertNotNull(dato);
        
        // assertEquals(valorEsperado, valorReal, mensajeDeError);
        assertEquals(dato.getId(), 1L, "El ID debería ser 1L");
        assertEquals(dato.getCadena(), "Test", "La cadena debería ser 'Test'");

        System.out.println("Dato: " + dato);
    }
}
