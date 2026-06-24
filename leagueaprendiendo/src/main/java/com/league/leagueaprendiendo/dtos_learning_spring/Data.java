package com.league.leagueaprendiendo.dtos_learning_spring;

public class Data {
    private Long id;
    private String cadena;

    // Constructor (Sirve para inicializar el objeto con datos)
    public Data(String cadena, Long id) {
        this.cadena = cadena; // "this.cadena" se refiere al atributo de arriba
        this.id = id;     // "id" es el parámetro que recibe este constructor
    }

    // Getters (Sirven para OBTENER el valor de los atributos privados)
    public String getCadena() {
        return cadena;
    }

    public Long getId() {
        return id;
    }
    
    // Setters (Sirven para MODIFICAR el valor de los atributos privados)
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
