/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.controllers.asistencia;

import com.fablab.ufps.edu.co.asistencia.dto.AsistenciaSteamJson;
import com.fablab.ufps.edu.co.asistencia.dto.MensajeJson;
import com.fablab.ufps.edu.co.asistencia.dto.VisitaSteamSchoolDTO;
import com.fablab.ufps.edu.co.asistencia.entity.Colegio;
import com.fablab.ufps.edu.co.asistencia.entity.Cursos;
import com.fablab.ufps.edu.co.asistencia.entity.PoblacionEspecial;
import com.fablab.ufps.edu.co.asistencia.entity.SteamStudent;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaSteamSchool;
import com.fablab.ufps.edu.co.asistencia.repository.ColegioRepository;
import com.fablab.ufps.edu.co.asistencia.repository.CursosRepository;
import com.fablab.ufps.edu.co.asistencia.repository.PoblacionEspecialRepository;
import com.fablab.ufps.edu.co.asistencia.repository.SteamStudentRepository;
import com.fablab.ufps.edu.co.asistencia.repository.VisitaSteamSchoolRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author jerson
 */
@RestController
@RequestMapping("/steam")
public class AsistenciaSteamSchoolController {

    @Autowired
    private SteamStudentRepository steamStudentRepository;


    @Autowired
    private ColegioRepository colegioRepository;

    @Autowired
    private VisitaSteamSchoolRepository visitaSteamSchoolRepository;

    @Autowired
    private PoblacionEspecialRepository poblacionEspecialRepository;

    @GetMapping()
    public List<VisitaSteamSchoolDTO> list() {

        return visitaSteamSchoolRepository.findAll()
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
    public ResponseEntity post(@RequestBody AsistenciaSteamJson input) {

        try {
            // Creación de objetos necesarios
            VisitaSteamSchool vst = new VisitaSteamSchool();
            vst.setFecha(input.getFecha());
            vst.setIdColegio(new Colegio(input.getIdColegio()));
            vst.setIdCurso(new Cursos(input.getIdCursos()));
            vst.setIdSteamStudent(CreateStudent(input));

            // Guardar en la base de datos
            vst = visitaSteamSchoolRepository.save(vst);

            // Respuesta exitosa
            return ResponseEntity.ok(input);  // O podrías devolver un DTO específico con los datos guardados si lo deseas
        } catch (Exception e) {
            // Manejo de excepciones
            MensajeJson msg = new MensajeJson();
            msg.setMsg("Error al procesar la solicitud");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msg);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

    private SteamStudent CreateStudent(AsistenciaSteamJson input) {

        try {
            SteamStudent st = new SteamStudent();
            st.setNombre(input.getNombre());
            st.setSemestre(input.getSemestre());
            st.setSexo(input.getSexo());

            // Creación de Colegio y Cursos (asumiendo que ya existen en la base de datos)
            Colegio c = colegioRepository.findById(input.getIdColegio())
                    .orElseThrow(() -> new EntityNotFoundException("Colegio no encontrado con ID: " + input.getIdColegio()));
            st.setIdColegio(c);

            PoblacionEspecial pp = poblacionEspecialRepository.findById(input.getIdPoblacionEspecial())
                    .orElseThrow(() -> new EntityNotFoundException("PoblacionEspecial no encontrada con ID: " + input.getIdPoblacionEspecial()));
            st.setIdPoblacionEspecial(pp);

            return steamStudentRepository.save(st);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear el estudiante", e);
        }
    }

    private VisitaSteamSchoolDTO toDTO(VisitaSteamSchool x) {
        VisitaSteamSchoolDTO a = new VisitaSteamSchoolDTO();

        a.setIdColegio(x.getIdColegio().getId());
        a.setIdCurso(x.getIdCurso().getId());
        a.setIdSteamStudent(x.getIdSteamStudent().getId());
        a.setFecha(x.getFecha());
        a.setId(x.getId());
        return a;

    }

}
