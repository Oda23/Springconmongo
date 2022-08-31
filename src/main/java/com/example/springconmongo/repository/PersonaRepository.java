/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.springconmongo.repository;

import com.example.springconmongo.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ISTA
 */
public interface PersonaRepository extends MongoRepository<Persona, Long>{
    
}
