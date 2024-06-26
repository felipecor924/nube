/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.repository;

import com.fablab.ufps.edu.co.asistencia.entity.Aula;
import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.ProgramaAcademico;
import com.fablab.ufps.edu.co.asistencia.entity.Universidad;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaClase;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jerson
 */
@Repository
public interface VisitaClaseRepository extends JpaRepository<VisitaClase, Integer> {

    ArrayList<VisitaClase> findByIdAula(Aula id);

    ArrayList<VisitaClase> findByIdPersona(Persona id);

    ArrayList<VisitaClase> findByIdProgramaAcademico(ProgramaAcademico id);

    ArrayList<VisitaClase> findByIdUniversidad(Universidad id);
}
