/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers;

import com.fablab.ufps.edu.co.asistencia.dto.AdmUserDTO;
import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.entity.AdmUser;
import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.repository.AdmUserRepository;
import com.fablab.ufps.edu.co.asistencia.repository.PersonaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jerson
 */
@RestController
@RequestMapping("/adm")
public class AdmUserController {

    @Autowired
    private AdmUserRepository admUserRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping()
    public ArrayList<AdmUserDTO> list() {
        ArrayList<AdmUser> aulas = (ArrayList<AdmUser>) admUserRepository.findAll();
        ArrayList<AdmUserDTO> lista = new ArrayList<>();
        for (AdmUser x : aulas) {

            AdmUserDTO a = new AdmUserDTO();
            a.setId(x.getId());
            a.setIdPersona(x.getIdPersona().getId());

            lista.add(a);
        }
        return lista;
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Optional<AdmUser> ou = admUserRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }

        AdmUser a = ou.get();

        AdmUserDTO u = new AdmUserDTO();

        u.setId(a.getId());
        u.setIdPersona(a.getIdPersona().getId());

        return ResponseEntity.ok(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody AdmUserDTO input) {
        Optional<AdmUser> ou = admUserRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }

        AdmUser u = ou.get();

        u.setPassword(input.getPassword());

        u = admUserRepository.save(u);

        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody AdmUserDTO input) {

        AdmUser u = new AdmUser();

        Optional<Persona> ou = personaRepository.findById(input.getIdPersona());

        u.setIdPersona(ou.get());
        u.setPassword(input.getPassword());

        u = admUserRepository.save(u);

        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<AdmUser> ou = admUserRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            msg.setMsg("no existe");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }

        AdmUser u = ou.get();

        try {
            admUserRepository.delete(u);

            msg.setMsg("ok");
            return new ResponseEntity(msg, HttpStatus.OK);
        } catch (Exception e) {

            msg.setMsg("no");
            return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }

}
