/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.repository;

import com.fablab.ufps.edu.co.asistencia.entity.Colegio;
import com.fablab.ufps.edu.co.asistencia.entity.Cursos;
import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaCursoColegio;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jerson
 */
@Repository
public interface VisitaCursoColegioRepository extends JpaRepository<VisitaCursoColegio, Integer> {

    ArrayList<VisitaCursoColegio> findByIdCurso(Cursos id);

    ArrayList<VisitaCursoColegio> findByIdPersona(Persona id);

    ArrayList<VisitaCursoColegio> findByIdColegio(Colegio id);
}
