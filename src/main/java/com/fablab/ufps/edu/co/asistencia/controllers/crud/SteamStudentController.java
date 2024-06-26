/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.crud;

import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.SteamStudentDTO;
import com.fablab.ufps.edu.co.asistencia.entity.Colegio;
import com.fablab.ufps.edu.co.asistencia.entity.PoblacionEspecial;
import com.fablab.ufps.edu.co.asistencia.entity.SteamStudent;
import com.fablab.ufps.edu.co.asistencia.repository.SteamStudentRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jerson
 */
@RestController
@RequestMapping("/steamstudent")
public class SteamStudentController {

    @Autowired
    private SteamStudentRepository steamStudentRepository;

    @GetMapping("")
    public ResponseEntity list() {

        ArrayList<SteamStudent> universidades = (ArrayList<SteamStudent>) steamStudentRepository.findAll();
        ArrayList<SteamStudentDTO> lista = new ArrayList<>();
        for (SteamStudent x : universidades) {

            SteamStudentDTO u = toDTO(x);

            lista.add(u);
        }
        return ResponseEntity.ok(lista);

    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {

        Optional<SteamStudent> ou = steamStudentRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }

        SteamStudentDTO u = toDTO(ou.get());

        return ResponseEntity.ok(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody SteamStudentDTO input) {

        Optional<SteamStudent> ou = steamStudentRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        SteamStudent u = ou.get();
        u.setNombre(input.getNombre());
        u.setSemestre(input.getSemestre());
        u.setSexo(input.getSexo());

        Colegio c = new Colegio();
        c.setId(input.getIdColegio());

        u.setIdColegio(c);

        PoblacionEspecial pe = new PoblacionEspecial();
        pe.setId(input.getIdPoblacionEspecial());

        u.setIdPoblacionEspecial(pe);

        u = steamStudentRepository.save(u);

        input.setId(u.getId());
        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody SteamStudentDTO input) {

        SteamStudent u = new SteamStudent();
        u.setNombre(input.getNombre());
        u.setSemestre(input.getSemestre());
        u.setSexo(input.getSexo());

        Colegio c = new Colegio();
        c.setId(input.getIdColegio());

        u.setIdColegio(c);

        PoblacionEspecial pe = new PoblacionEspecial();
        pe.setId(input.getIdPoblacionEspecial());

        u.setIdPoblacionEspecial(pe);

        System.out.println(input);
        System.out.println(u);
        u = steamStudentRepository.save(u);
        System.out.println(u);
        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {

        Optional<SteamStudent> ou = steamStudentRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            msg.setMsg("no existe");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }

        SteamStudent u = ou.get();

        try {
            steamStudentRepository.delete(u);

            msg.setMsg("ok");
            return new ResponseEntity(msg, HttpStatus.OK);
        } catch (Exception e) {

            msg.setMsg("no");
            return new ResponseEntity(msg, HttpStatus.BAD_REQUEST);
        }

    }

    private SteamStudentDTO toDTO(SteamStudent u) {
        SteamStudentDTO ud = new SteamStudentDTO();

        ud.setId(u.getId());
        ud.setNombre(u.getNombre());
        ud.setSexo(u.getSexo());
        ud.setSemestre(u.getSemestre());
        ud.setIdPoblacionEspecial(u.getIdPoblacionEspecial().getId());
        ud.setIdColegio(u.getIdColegio().getId());

        return ud;

    }
}
