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
import com.fablab.ufps.edu.co.asistencia.entity.VisitaSocializacion;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaSteamSchool;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jerson
 */
@Repository
public interface VisitaSocializacionRepository extends JpaRepository<VisitaSocializacion, Long> {

    ArrayList<VisitaSocializacion> findByIdPersona(Persona id);

    ArrayList<VisitaSocializacion> findByIdProgramaAcademico(ProgramaAcademico id);

    ArrayList<VisitaSocializacion> findByIdUniversidad(Universidad id);
}
