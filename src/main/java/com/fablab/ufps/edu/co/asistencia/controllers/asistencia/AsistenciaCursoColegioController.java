/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.asistencia;

import com.fablab.ufps.edu.co.asistencia.dto.AsistenciaCursoColegioJson;
import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.VisitaCursoColegioDTO;
import com.fablab.ufps.edu.co.asistencia.entity.Colegio;
import com.fablab.ufps.edu.co.asistencia.entity.Cursos;
import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.PoblacionEspecial;
import com.fablab.ufps.edu.co.asistencia.entity.TipoUsuario;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaCursoColegio;
import com.fablab.ufps.edu.co.asistencia.repository.PersonaRepository;
import com.fablab.ufps.edu.co.asistencia.repository.VisitaCursoColegioRepository;
import java.util.List;
import java.util.stream.Collectors;
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
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author jerson
 */
@RestController
@RequestMapping("/cursocolegio")
public class AsistenciaCursoColegioController {

    @Autowired
    private VisitaCursoColegioRepository visitaCursoColegioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping()
    public List<Object> list() {
        return visitaCursoColegioRepository
                .findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }

    @PostMapping
    public ResponseEntity post(@RequestBody AsistenciaCursoColegioJson input) {
        try {
            // Creación de objetos necesarios
            VisitaCursoColegio vst = new VisitaCursoColegio();

            vst.setFechaVisita(input.getFechaVisita());
            vst.setSesion(input.getSesion());
            vst.setIdColegio(new Colegio(input.getIdColegio()));

            vst.setIdCurso(new Cursos(input.getIdCurso()));
            vst.setIdPersona(CreatePersona(input));

            // Guardar en la base de datos
            vst = visitaCursoColegioRepository.save(vst);
            // Respuesta exitosa
            return ResponseEntity.ok(input);  // O podrías devolver un DTO específico con los datos guardados si lo deseas
        } catch (Exception e) {
            // Manejo de excepciones
            MensajeJson msg = new MensajeJson();
            e.printStackTrace();
            msg.setMsg("Error al procesar la solicitud");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

    private Persona CreatePersona(AsistenciaCursoColegioJson input) {

        try {

            Persona ud = new Persona();

            ud.setNombre(input.getNombre());
            ud.setApellido(input.getApellido());
            ud.setDocumento(input.getDocumento());
            ud.setTelefono(input.getTelefono());
            ud.setCodigo(input.getCodigo());
            ud.setFechaNacimiento(input.getFechaNacimiento());
            ud.setSexo(input.getSexo());

            ud.setIdPoblacionEspecial(new PoblacionEspecial(input.getIdPoblacionEspecial()));

            ud.setIdTipoUsuario(new TipoUsuario(input.getIdTipoUsuario()));

            return personaRepository.save(ud);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el estudiante", e);
        }
    }

    private VisitaCursoColegioDTO toDTO(VisitaCursoColegio x) {
        VisitaCursoColegioDTO a = new VisitaCursoColegioDTO();

        a.setId(x.getId());
        a.setFechaVisita(x.getFechaVisita());
        a.setSesion(x.getSesion());
        a.setIdColegio(x.getIdColegio().getId());
        a.setIdCurso(x.getIdCurso().getId());
        a.setIdPersona(x.getIdPersona().getId());

        return a;

    }

}
