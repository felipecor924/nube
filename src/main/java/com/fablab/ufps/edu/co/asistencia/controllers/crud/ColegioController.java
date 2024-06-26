/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.crud;

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
import org.springframework.beans.factory.annotation.Autowired;
import com.fablab.ufps.edu.co.asistencia.entity.Colegio;
import com.fablab.ufps.edu.co.asistencia.dto.ColegioDTO;
import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.SteamStudentDTO;
import com.fablab.ufps.edu.co.asistencia.entity.SteamStudent;
import com.fablab.ufps.edu.co.asistencia.repository.ColegioRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author jerson
 */
@RestController
@RequestMapping("/colegio")
public class ColegioController {

    @Autowired
    private ColegioRepository colegioRepository;

    @GetMapping()
    public ResponseEntity list() {
        List<Colegio> colegios = colegioRepository.findAll();

        List<ColegioDTO> lista = colegios.stream()
                .map(this::colegioToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        Optional<Colegio> ou = colegioRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return ResponseEntity.ok(msg);
        }

        ColegioDTO u = colegioToDTO(ou.get());

        return ResponseEntity.ok(u);
    }
/*
    @GetMapping("/steam/{id}")
    public ResponseEntity<Object> getSteam(@PathVariable Integer id) {
        try {

            List<SteamStudentDTO> lista = colegioRepository.findById(id)
                    .map(Colegio::getSteamStudentList)
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(this::SteamStudentToDTO)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(lista);
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir la traza de la excepción en los registros
            MensajeJson errorMsg = new MensajeJson();
            errorMsg.setMsg("Error interno del servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMsg);
        }
    }
*/
    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable String id, @RequestBody ColegioDTO input) {

        Optional<Colegio> ou = colegioRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {

            msg.setMsg("no existe");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Colegio u = ou.get();
        u.setNombre(input.getNombre());
        u.setDireccion(input.getDireccion());
        u.setTelContacto(input.getTelContacto());

        u = colegioRepository.save(u);

        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ColegioDTO input) {
        Colegio u = new Colegio();

        u.setNombre(input.getNombre());
        u.setDireccion(input.getDireccion());
        u.setTelContacto(input.getTelContacto());

        u = colegioRepository.save(u);

        input.setId(u.getId());

        return new ResponseEntity(input, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        Optional<Colegio> ou = colegioRepository.findById(Integer.valueOf(id));

        MensajeJson msg = new MensajeJson();
        if (ou.isEmpty()) {
            msg.setMsg("no existe");
            return new ResponseEntity(msg, HttpStatus.NOT_FOUND);
        }

        Colegio u = ou.get();

        try {
            colegioRepository.delete(u);

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

    private ColegioDTO colegioToDTO(Colegio u) {
        ColegioDTO ud = new ColegioDTO();

        ud.setId(u.getId());
        ud.setNombre(u.getNombre());
        ud.setDireccion(u.getDireccion());
        ud.setTelContacto(u.getTelContacto());

        return ud;

    }

    private SteamStudentDTO SteamStudentToDTO(SteamStudent u) {
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
