/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springconmongo.service;

import com.example.springconmongo.model.Persona;
import com.example.springconmongo.repository.PersonaRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISTA
 */
@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService{

    @Autowired
    PersonaRepository personarepository;
    
    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personarepository;
    }
    
}
