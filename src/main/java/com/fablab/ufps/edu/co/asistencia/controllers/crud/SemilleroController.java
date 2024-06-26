/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.crud;

import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.SemilleroDTO;
import com.fablab.ufps.edu.co.asistencia.entity.Semillero;
import com.fablab.ufps.edu.co.asistencia.repository.SemilleroRepository;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author jerson
 */
@RestController
@RequestMapping("/semillero")
public class SemilleroController {
    
    @Autowired
    private SemilleroRepository semilleroRepository;
    
    @GetMapping()
    public ResponseEntity list() {
        ArrayList<Semillero> universidades = (ArrayList<Semillero>) semilleroRepository.findAll();
        ArrayList<SemilleroDTO> lista = new ArrayList<>();
        for (Semillero x : universidades) {
            
            SemilleroDTO u = toDTO(x);
            
            lista.add(u);
        }
        return ResponseEntity.ok(lista);
    }
    
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Optional<Semillero> ou = semilleroRepository.findById(Integer.valueOf(id));
        
        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            
            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }
        
        SemilleroDTO u = toDTO(ou.get());
        
        return ResponseEntity.ok(u);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody SemilleroDTO input) {
        Optional<Semillero> ou = semilleroRepository.findById(Integer.valueOf(id));
        
        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            
            msg.setMsg("no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        
        Semillero u = ou.get();
        u.setNombre(input.getNombre());
        u.setSigla(input.getSigla());
        
        u = semilleroRepository.save(u);
        
        input.setId(u.getId());
        
        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }
    
    @PostMapping
    public ResponseEntity post(@RequestBody SemilleroDTO input) {
        
        Semillero u = toEntity(input);
        
        System.out.println(input);
        System.out.println(u);
        u = semilleroRepository.save(u);
        System.out.println(u);
        input.setId(u.getId());
        
        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        Optional<Semillero> ou = semilleroRepository.findById(Integer.valueOf(id));
        
        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            msg.setMsg("no existe");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }
        
        Semillero u = ou.get();
        
        try {
            semilleroRepository.delete(u);
            
            msg.setMsg("ok");
            return new ResponseEntity(msg, HttpStatus.OK);
        } catch (Exception e) {
            
            msg.setMsg("no");
            return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
        }
    }
    
    private SemilleroDTO toDTO(Semillero u) {
        SemilleroDTO ud = new SemilleroDTO();
        
        ud.setId(u.getId());
        ud.setNombre(u.getNombre());
        ud.setSigla(u.getSigla());
        
        return ud;
        
    }
    
    private Semillero toEntity(SemilleroDTO u) {
        Semillero ud = new Semillero();
        
        ud.setId(u.getId());
        ud.setNombre(u.getNombre());
        ud.setSigla(u.getSigla());
        
        return ud;
        
    }
    
}
