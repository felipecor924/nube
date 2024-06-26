/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.crud;

import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.UniversidadDTO;
import com.fablab.ufps.edu.co.asistencia.entity.Universidad;
import com.fablab.ufps.edu.co.asistencia.repository.UniversidadRepository;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jerson
 */
@RestController
@RequestMapping("/universidad")
@CrossOrigin
public class UniversidadController {

    @Autowired
    private UniversidadRepository universidadRepository;

    /*
     public List<Object> list() {
    
     */
    @GetMapping("")
    public ResponseEntity list() {

        ArrayList<Universidad> universidades = (ArrayList<Universidad>) universidadRepository.findAll();
        ArrayList<UniversidadDTO> lista = new ArrayList<>();
        for (Universidad x : universidades) {

            UniversidadDTO u = universidadToDTO(x);

            lista.add(u);
        }
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {

        Optional<Universidad> ou = universidadRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }

        UniversidadDTO u = universidadToDTO(ou.get());

        return ResponseEntity.ok(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody UniversidadDTO input) {

        Optional<Universidad> ou = universidadRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Universidad u = ou.get();
        u.setNombre(input.getNombre());
        u.setDireccion(input.getDireccion());
        u.setTelContacto(input.getTelContacto());

        u = universidadRepository.save(u);

        input.setId(u.getId());
        
        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody UniversidadDTO input) {

        Universidad u = new Universidad();
        u.setNombre(input.getNombre());
        u.setDireccion(input.getDireccion());
        u.setTelContacto(input.getTelContacto());
        System.out.println(input);
        System.out.println(u);
        u = universidadRepository.save(u);
        System.out.println(u);
        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {

        Optional<Universidad> ou = universidadRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            msg.setMsg("no existe");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }

        Universidad u = ou.get();

        try {
            universidadRepository.delete(u);

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

    private UniversidadDTO universidadToDTO(Universidad u) {
        UniversidadDTO ud = new UniversidadDTO();

        ud.setId(u.getId());
        ud.setNombre(u.getNombre());
        ud.setDireccion(u.getDireccion());
        ud.setTelContacto(u.getTelContacto());

        return ud;

    }

}