/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.repository;

import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.ProgramaAcademico;
import com.fablab.ufps.edu.co.asistencia.entity.Semillero;
import com.fablab.ufps.edu.co.asistencia.entity.Universidad;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaGrabacion;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jerson
 */
@Repository
public interface VisitaGrabacionRepository extends JpaRepository<VisitaGrabacion, Integer> {

    ArrayList<VisitaGrabacion> findByIdPersona(Persona id);

    ArrayList<VisitaGrabacion> findByIdProgramaAcademico(ProgramaAcademico id);

    ArrayList<VisitaGrabacion> findByIdSemillero(Semillero id);

    ArrayList<VisitaGrabacion> findByIdUniversidad(Universidad id);
}
