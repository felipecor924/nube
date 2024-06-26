/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.repository;

import com.fablab.ufps.edu.co.asistencia.entity.Cursos;
import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.ProgramaAcademico;
import com.fablab.ufps.edu.co.asistencia.entity.Universidad;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaCurso;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jerson
 */
@Repository
public interface VisitaCursoRepository extends JpaRepository<VisitaCurso, Integer> {

    ArrayList<VisitaCurso> findByIdCurso(Cursos id);

    ArrayList<VisitaCurso> findByIdPersona(Persona id);

    ArrayList<VisitaCurso> findByIdProgramaAcademico(ProgramaAcademico id);

    ArrayList<VisitaCurso> findByIdUniversidad(Universidad id);
}
