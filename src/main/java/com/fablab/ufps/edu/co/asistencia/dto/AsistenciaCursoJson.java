/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.dto;

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
public class AsistenciaCursoJson {

    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd", timezone = "UTC")
    private Date fechaVisita;

    private int sesion;

    private String otroPrograma;

    private int idCurso;

    private int idPersona;

    private int idProgramaAcademico;

    private int idUniversidad;

    //p data
    private String nombre;

    private String apellido;

    private String documento;

    private String telefono;

    private String codigo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd", timezone = "UTC")
    private Date fechaNacimiento;

    private String sexo;

    private int idPoblacionEspecial;

    private int idTipoUsuario;

}
