/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.dto;

import com.fablab.ufps.edu.co.asistencia.entity.Persona;
import com.fablab.ufps.edu.co.asistencia.entity.ProgramaAcademico;
import com.fablab.ufps.edu.co.asistencia.entity.Semillero;
import com.fablab.ufps.edu.co.asistencia.entity.Universidad;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jerson
 */
@Getter
@Setter
public class VisitaSemilleroDTO {

    private Integer id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd", timezone = "UTC")
    private Date fecha;

    private String otroPrograma;

    private int idPersona;

    private int idProgramaAcademico;

    private int idSemillero;

    private int idUniversidad;
}
