/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.crud;

import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.PracticantepasanteBecaDTO;
import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.PracticantepasanteBeca;
import com.fablab.ufps.edu.co.asistencia.repository.PracticantepasanteBecaRepository;
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
@RequestMapping("/practicante")
public class PracticantepasanteBecaController {

    @Autowired
    private PracticantepasanteBecaRepository practicantepasanteBecaRepository;

    @GetMapping()
    public ResponseEntity list() {
        ArrayList<PracticantepasanteBeca> universidades = (ArrayList<PracticantepasanteBeca>) practicantepasanteBecaRepository.findAll();
        ArrayList<PracticantepasanteBecaDTO> lista = new ArrayList<>();
        for (PracticantepasanteBeca x : universidades) {

            PracticantepasanteBecaDTO u = toDTO(x);

            lista.add(u);
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Optional<PracticantepasanteBeca> ou = practicantepasanteBecaRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }

        PracticantepasanteBecaDTO u = toDTO(ou.get());

        return ResponseEntity.ok(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody PracticantepasanteBecaDTO input) {
        Optional<PracticantepasanteBeca> ou = practicantepasanteBecaRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        PracticantepasanteBeca ud = ou.get();

        ud.setId(input.getId());
        ud.setIdCarnet(input.getIdCarnet());
        ud.setEstado(input.isEstado());
        ud.setSemestre(input.getSemestre());

        Persona p = new Persona();
        p.setId(input.getIdPersona());
        ud.setIdPersona(p);

        ud = practicantepasanteBecaRepository.save(ud);
        
        input.setId(ud.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody PracticantepasanteBecaDTO input) {

        PracticantepasanteBeca u = toEntity(input);

        System.out.println(input);
        System.out.println(u);

        u = practicantepasanteBecaRepository.save(u);
        System.out.println(u);
        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {

        Optional<PracticantepasanteBeca> ou = practicantepasanteBecaRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            msg.setMsg("no existe");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }

        PracticantepasanteBeca u = ou.get();

        try {
            practicantepasanteBecaRepository.delete(u);

            msg.setMsg("ok");
            return new ResponseEntity(msg, HttpStatus.OK);
        } catch (Exception e) {

            msg.setMsg("no");
            return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
        }

    }

    private PracticantepasanteBecaDTO toDTO(PracticantepasanteBeca u) {
        PracticantepasanteBecaDTO ud = new PracticantepasanteBecaDTO();

        ud.setId(u.getId());
        ud.setIdCarnet(u.getIdCarnet());
        ud.setEstado(u.getEstado());
        ud.setIdPersona(u.getIdPersona().getId());
        ud.setSemestre(u.getSemestre());

        return ud;

    }

    private PracticantepasanteBeca toEntity(PracticantepasanteBecaDTO u) {
        PracticantepasanteBeca ud = new PracticantepasanteBeca();

        ud.setId(u.getId());
        ud.setIdCarnet(u.getIdCarnet());
        ud.setEstado(u.isEstado());
        ud.setSemestre(u.getSemestre());

        Persona p = new Persona();
        p.setId(u.getIdPersona());
        ud.setIdPersona(p);

        return ud;

    }
}
