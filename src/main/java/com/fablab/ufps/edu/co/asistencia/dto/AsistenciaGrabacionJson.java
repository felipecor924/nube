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
public class AsistenciaGrabacionJson {

    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd", timezone = "UTC")
    private Date fecha;

    private String externo;

    private String otroPrograma;

    private int idProgramaAcademico;

    private int idSemillero;

    private int idUniversidad;

    private int idPersona;

    private int razonGrabacion;

    //persona datos
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

    @Override
    public String toString() {
        return "AsistenciaGrabacionJson{" + "id=" + id + ", fecha=" + fecha + ", externo=" + externo + ", otroPrograma=" + otroPrograma + ", idProgramaAcademico=" + idProgramaAcademico + ", idSemillero=" + idSemillero + ", idUniversidad=" + idUniversidad + ", idPersona=" + idPersona + ", razonGrabacion=" + razonGrabacion + ", nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", telefono=" + telefono + ", codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", idPoblacionEspecial=" + idPoblacionEspecial + ", idTipoUsuario=" + idTipoUsuario + '}';
    }

}
