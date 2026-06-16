package com.league.leagueaprendiendo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apisaludos")

public class SaludosController {
    @GetMapping("/hola")
    
    public String holaMundo(){
        return "Hola Mundo!, es mi primera API REST con Spring Boot";
    }

    @GetMapping("/holanombre/{nombre}/{edad}")
    public String holaMundoNombre(@PathVariable String nombre, @PathVariable int edad){
        return "Hola Mundo! " + nombre + " tu edad es: " + edad;
    }

}
