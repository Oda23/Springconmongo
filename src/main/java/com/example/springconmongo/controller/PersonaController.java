/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springconmongo.controller;

import com.example.springconmongo.model.Persona;
import com.example.springconmongo.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ISTA
 */
 @RestController
 @RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    PersonaService personaservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> listar() {
       
        return new ResponseEntity<>(personaservice.findByAll(), HttpStatus.OK);
    }
    
     @PostMapping("/crear")
    public ResponseEntity<Persona> crear(@RequestBody Persona c) {
        return new ResponseEntity<>(personaservice.save(c), HttpStatus.CREATED);
    }
    
     @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminar(@PathVariable Long id) {
       personaservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
     @GetMapping("/buscar/{id}")
    public ResponseEntity<Persona> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(personaservice.findById(id), HttpStatus.OK);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizar(@PathVariable Long id, @RequestBody Persona u) {
        Persona persona = buscarpersona(id);
        if (persona == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            try {
                persona.setApellido(u.getApellido());
                persona.setNombre(u.getNombre());
                persona.setDireccion(u.getDireccion());
                
               
                
                return new ResponseEntity<>(personaservice.save(u), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
           
        }

    }
    
    
    
      public Persona buscarpersona(@PathVariable Long id) {
        return personaservice.findById(id);
    }
   
}
