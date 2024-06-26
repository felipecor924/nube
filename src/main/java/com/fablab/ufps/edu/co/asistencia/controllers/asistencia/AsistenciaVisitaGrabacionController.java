/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.asistencia;

import com.fablab.ufps.edu.co.asistencia.dto.AsistenciaGrabacionJson;
import com.fablab.ufps.edu.co.asistencia.dto.VisitaGrabacionDTO;
import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.PoblacionEspecial;
import com.fablab.ufps.edu.co.asistencia.entity.ProgramaAcademico;
import com.fablab.ufps.edu.co.asistencia.entity.Semillero;
import com.fablab.ufps.edu.co.asistencia.entity.TipoUsuario;
import com.fablab.ufps.edu.co.asistencia.entity.Universidad;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaGrabacion;
import com.fablab.ufps.edu.co.asistencia.repository.PersonaRepository;
import com.fablab.ufps.edu.co.asistencia.repository.VisitaGrabacionRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/grabacion")
public class AsistenciaVisitaGrabacionController {

    @Autowired
    private VisitaGrabacionRepository visitaGrabacionRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping()
    public List<Object> list() {
        return visitaGrabacionRepository
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
    public ResponseEntity post(@RequestBody AsistenciaGrabacionJson input) {
        System.out.println(input.toString());

        VisitaGrabacion ag = new VisitaGrabacion();

        switch (input.getRazonGrabacion()) {
            case 2:
                ag.setExterno(input.getExterno());
                break;
            case 3:
                ag.setIdSemillero(new Semillero(input.getIdSemillero()));
                break;
        }

        if (input.getOtroPrograma() != null && !input.getOtroPrograma().isBlank()) {
            ag.setOtroPrograma(input.getOtroPrograma());
            ag.setIdProgramaAcademico(null); // Asegurar que idProgramaAcademico sea null si otroPrograma está presente
        } else if (input.getIdProgramaAcademico() > 0) {
            ag.setIdProgramaAcademico(new ProgramaAcademico(input.getIdProgramaAcademico()));
            ag.setOtroPrograma(null); // Asegurar que otroPrograma sea null si idProgramaAcademico está presente
        } else {
            return ResponseEntity.badRequest().body("Debe especificar un programa académico válido o proporcionar otro programa");
        }

        ag.setRazonGrabacion(input.getRazonGrabacion());
        ag.setIdUniversidad(new Universidad(input.getIdUniversidad()));
        ag.setIdPersona(CreatePerson(input));
        ag.setFecha(input.getFecha());

        ag = visitaGrabacionRepository.save(ag);

        input.setId(ag.getId());

        return ResponseEntity.ok(input);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

    private Persona CreatePerson(AsistenciaGrabacionJson input) {

        Persona ud = new Persona();

        ud.setNombre(input.getNombre());
        ud.setApellido(input.getApellido());
        ud.setDocumento(input.getDocumento());
        ud.setTelefono(input.getTelefono());
        ud.setCodigo(input.getCodigo());
        ud.setFechaNacimiento(input.getFechaNacimiento());
        ud.setSexo(input.getSexo());
        PoblacionEspecial pe = new PoblacionEspecial();

        pe.setId(input.getIdPoblacionEspecial());

        ud.setIdPoblacionEspecial(pe);

        TipoUsuario tu = new TipoUsuario();

        tu.setId(input.getIdTipoUsuario());
        ud.setIdTipoUsuario(tu);

        ud = personaRepository.save(ud);

        return ud;

    }

    private VisitaGrabacionDTO toDTO(VisitaGrabacion x) {
        VisitaGrabacionDTO a = new VisitaGrabacionDTO();
        System.out.println(x.toString());

        a.setId(x.getId());
        a.setFecha(x.getFecha());
        a.setIdPersona(x.getIdPersona().getId());

        if (x.getIdSemillero() != null) {

            a.setIdSemillero(x.getIdSemillero().getId());
        }

        a.setExterno(x.getExterno());
        a.setOtroPrograma(x.getOtroPrograma());
        a.setRazonGrabacion(x.getRazonGrabacion());

        if (x.getIdProgramaAcademico() != null) {
            a.setIdProgramaAcademico(x.getIdProgramaAcademico().getId());

        }

        a.setIdUniversidad(x.getIdUniversidad().getId());

        return a;

    }

}
