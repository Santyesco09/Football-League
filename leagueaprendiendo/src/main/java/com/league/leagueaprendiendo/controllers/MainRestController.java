package com.league.leagueaprendiendo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @RequestMapping("/apimain")
    public String getString(){
        return "Buenas";
    }
}
