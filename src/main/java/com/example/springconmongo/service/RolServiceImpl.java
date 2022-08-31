/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springconmongo.service;

import com.example.springconmongo.model.Rol;
import com.example.springconmongo.repository.PersonaRepository;
import com.example.springconmongo.repository.RolRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISTA
 */
@Service
public class RolServiceImpl extends GenericServiceImpl<Rol, Long> implements RolService {

    @Autowired
    RolRepository rolrepository;

    @Override
    public CrudRepository<Rol, Long> getDao() {
        return rolrepository;
    }

}
