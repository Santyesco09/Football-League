package com.league.leagueaprendiendo.controllers_learning_spring;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.league.leagueaprendiendo.dtos_learning_spring.Data;

@RestController
@RequestMapping("/api/v1/data")
public class ApiController {
    public List<Data> listado = new LinkedList<>();
    public Long lastId = 0L;

    /*
        Constructor (Sirve para inicializar el objeto con datos)
    */
    public ApiController() {
        this.listado.add(new Data("Hola, cómo vas?", 1L));
        this.listado.add(new Data("Hace tiempo no se de ti", 2L));
        this.lastId = 2L;
    }

    @GetMapping("/")
    List<Data> index(){
        return this.listado;
    }

    @PostMapping("/")
    Data create(@RequestBody Data data){
        this.lastId++;
        data.setId(this.lastId);
        this.listado.add(data);
        return data;
    }

    @GetMapping("/{id}")
    Data show(@PathVariable("id") Long id){
        return this.listado
                .stream() // Convierte la lista en un flujo de datos (stream) para poder aplicar operaciones funcionales
                .filter(data -> data.getId().equals(id)) // Filtra los datos para encontrar el que tenga el ID igual al proporcionado
                .findFirst().orElse(new Data(null, id)); // Devuelve el primer elemento que cumpla la condición o un nuevo objeto Data con cadena nula y el ID proporcionado si no se encuentra ninguno
    }

    @PatchMapping("/{id}")
    Data update(@PathVariable("id") Long id, @RequestBody Data data){
        return this.listado
                .stream()
                .filter(dataGuardada -> dataGuardada.getId().equals(id))
                .findFirst()
                .map(dataGuardada -> { // Si se encuentra un elemento con el ID proporcionado, se ejecuta este bloque de código
                    dataGuardada.setCadena(data.getCadena());
                    return dataGuardada;
                }).orElse(new Data(null, id));
    }

    @DeleteMapping("/{id}")
    Data delete(@PathVariable("id") Long id){
        // Elimina el primer elemento que tenga el ID igual al proporcionado y devuelve ese elemento eliminado. Si no se encuentra ningún elemento con ese ID, devuelve un nuevo objeto Data con cadena nula y el ID proporcionado.
        return this.listado
                .stream()
                .filter(dataGuardada -> dataGuardada.getId().equals(id))
                .findFirst()
                .map(dataGuardada -> { // Si se encuentra un elemento con el ID proporcionado, se ejecuta este bloque de código
                    this.listado.remove(dataGuardada);
                    return dataGuardada;
                }).orElse(new Data(null, id));
    }
}
