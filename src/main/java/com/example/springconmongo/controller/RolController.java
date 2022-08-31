/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springconmongo.controller;

import com.example.springconmongo.model.Persona;
import com.example.springconmongo.model.Rol;
import com.example.springconmongo.service.PersonaService;
import com.example.springconmongo.service.RolService;
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
 @RequestMapping("/api/rol")
public class RolController {
    @Autowired
    RolService rolservice;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Rol>> listar() {
       
        return new ResponseEntity<>(rolservice.findByAll(), HttpStatus.OK);
    }
    
     @PostMapping("/crear")
    public ResponseEntity<Rol> crear(@RequestBody Rol c) {
        return new ResponseEntity<>(rolservice.save(c), HttpStatus.CREATED);
    }
    
     @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Persona> eliminar(@PathVariable Long id) {
       rolservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
     @GetMapping("/buscar/{id}")
    public ResponseEntity<Rol> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(rolservice.findById(id), HttpStatus.OK);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Rol> actualizar(@PathVariable Long id, @RequestBody Rol u) {
        Rol rol = buscarpersona(id);
        if (rol == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {
            try {
               
                rol.setNombre(u.getNombre());
                rol.setDescripcion(u.getDescripcion());
                rol.setEstado(u.getEstado());
                
               
                
                return new ResponseEntity<>(rolservice.save(u), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
           
        }

    }
    
    
    
      public Rol buscarpersona(@PathVariable Long id) {
        return rolservice.findById(id);
    }
}
