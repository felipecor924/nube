/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.repository;

import com.fablab.ufps.edu.co.asistencia.entity.Colegio;
import com.fablab.ufps.edu.co.asistencia.entity.Cursos;
import com.fablab.ufps.edu.co.asistencia.entity.SteamStudent;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaSteamSchool;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jerson
 */
@Repository
public interface VisitaSteamSchoolRepository extends JpaRepository<VisitaSteamSchool, Long> {

    ArrayList<VisitaSteamSchool> findByIdColegio(Colegio id);

    ArrayList<VisitaSteamSchool> findByIdCurso(Cursos id);

    ArrayList<VisitaSteamSchool> findByIdSteamStudent(SteamStudent id);

}
