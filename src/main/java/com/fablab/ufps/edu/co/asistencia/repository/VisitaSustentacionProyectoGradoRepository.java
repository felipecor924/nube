/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.repository;

import com.fablab.ufps.edu.co.asistencia.entity.VisitaSteamYoung;
import com.fablab.ufps.edu.co.asistencia.entity.VisitaSustentacionProyectoGrado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jerson
 */
@Repository
public interface VisitaSustentacionProyectoGradoRepository extends JpaRepository<VisitaSustentacionProyectoGrado, Integer> {
    
}
