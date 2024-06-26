/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.crud;


import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.TipoUsuarioDTO;
import com.fablab.ufps.edu.co.asistencia.entity.TipoUsuario;
import com.fablab.ufps.edu.co.asistencia.repository.TipoUsuarioRepository;
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
@RequestMapping("/tipo")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping()
    public ArrayList<TipoUsuarioDTO> list() {
        ArrayList<TipoUsuario> aulas = (ArrayList<TipoUsuario>) tipoUsuarioRepository.findAll();
        ArrayList<TipoUsuarioDTO> lista = new ArrayList<>();
        for (TipoUsuario x : aulas) {

            TipoUsuarioDTO a = new TipoUsuarioDTO();
            a.setId(x.getId());
            a.setTipo(x.getTipo());

            lista.add(a);
        }
        return lista;
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Optional<TipoUsuario> ou = tipoUsuarioRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }

        TipoUsuario a = ou.get();

        TipoUsuarioDTO u = new TipoUsuarioDTO();

        u.setId(a.getId());
        u.setTipo(a.getTipo());

        return ResponseEntity.ok(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody TipoUsuarioDTO input) {
        Optional<TipoUsuario> ou = tipoUsuarioRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }

        TipoUsuario u = ou.get();

        u.setId(input.getId());
        u.setTipo(input.getTipo());

        u = tipoUsuarioRepository.save(u);

        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody TipoUsuarioDTO input) {

        TipoUsuario u = new TipoUsuario();

        u.setId(input.getId());
        u.setTipo(input.getTipo());

        u = tipoUsuarioRepository.save(u);

        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {

        Optional<TipoUsuario> ou = tipoUsuarioRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            msg.setMsg("no existe");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }

        TipoUsuario u = ou.get();

        try {
            tipoUsuarioRepository.delete(u);

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
