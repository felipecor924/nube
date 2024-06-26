/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.asistencia;

import com.fablab.ufps.edu.co.asistencia.dto.AsistenciaClaseJson;
import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.VisitaClaseDTO;
import com.fablab.ufps.edu.co.asistencia.entity.Aula;
import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.PoblacionEspecial;
import com.fablab.ufps.edu.co.asistencia.entity.ProgramaAcademico;
import com.fablab.ufps.edu.co.asistencia.entity.TipoUsuario;
import com.fablab.ufps.edu.co.asistencia.entity.Universidad;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaClase;
import com.fablab.ufps.edu.co.asistencia.repository.PersonaRepository;
import com.fablab.ufps.edu.co.asistencia.repository.VisitaClaseRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author jerson
 */
@RestController
@RequestMapping("/clase")
public class AsistenciaClaseController {

    @Autowired
    private VisitaClaseRepository visitaClaseRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping()
    public List<Object> list() {
        return visitaClaseRepository
                .findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity post(@RequestBody AsistenciaClaseJson input) {

        try {
            // Creación de objetos necesarios
            VisitaClase vst = new VisitaClase();

            if (input.getOtroPrograma() != null && !input.getOtroPrograma().isBlank()) {
                vst.setOtroPrograma(input.getOtroPrograma());
                vst.setIdProgramaAcademico(null); // Asegurar que idProgramaAcademico sea null si otroPrograma está presente
            } else if (input.getIdProgramaAcademico() > 0) {
                vst.setIdProgramaAcademico(new ProgramaAcademico(input.getIdProgramaAcademico()));
                vst.setOtroPrograma(null); // Asegurar que otroPrograma sea null si idProgramaAcademico está presente
            } else {
                return ResponseEntity.badRequest().body("Debe especificar un programa académico válido o proporcionar otro programa");
            }

            vst.setFecha(input.getFecha());
            vst.setCodigoCarrera(input.getCodigoCarrera());

            vst.setCodigoCarrera(input.getCodigoCarrera());
            vst.setNombreMateria(input.getNombreMateria());
            vst.setNombreDocente(input.getNombreDocente());

            vst.setIdAula(new Aula(input.getIdAula()));
            vst.setIdUniversidad(new Universidad(input.getIdUniversidad()));
            vst.setIdPersona(CreatePersona(input));

            // Guardar en la base de datos
            vst = visitaClaseRepository.save(vst);
            
            input.setId(vst.getId());

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

    private Persona CreatePersona(AsistenciaClaseJson input) {

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

    private VisitaClaseDTO toDTO(VisitaClase x) {
        VisitaClaseDTO a = new VisitaClaseDTO();

        a.setId(x.getId());
        a.setIdPersona(x.getIdPersona().getId());
        a.setIdAula(x.getIdAula().getId());
        a.setIdUniversidad(x.getIdUniversidad().getId());
        if (x.getIdProgramaAcademico() != null) {
            a.setIdProgramaAcademico(x.getIdProgramaAcademico().getId());

        }
        a.setFecha(x.getFecha());
        a.setOtroPrograma(x.getOtroPrograma());
        a.setOtroUniversidad(x.getOtroUniversidad());
        a.setCodigoCarrera(x.getCodigoCarrera());
        a.setNombreMateria(x.getNombreMateria());
        a.setNombreDocente(x.getNombreDocente());

        return a;

    }

}
