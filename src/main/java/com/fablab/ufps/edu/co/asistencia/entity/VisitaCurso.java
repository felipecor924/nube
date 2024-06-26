/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author jerson
 */
@Entity
@Table(name = "visita_curso")
@NamedQueries({
    @NamedQuery(name = "VisitaCurso.findAll", query = "SELECT v FROM VisitaCurso v"),
    @NamedQuery(name = "VisitaCurso.findById", query = "SELECT v FROM VisitaCurso v WHERE v.id = :id"),
    @NamedQuery(name = "VisitaCurso.findByFechaVisita", query = "SELECT v FROM VisitaCurso v WHERE v.fechaVisita = :fechaVisita"),
    @NamedQuery(name = "VisitaCurso.findBySesion", query = "SELECT v FROM VisitaCurso v WHERE v.sesion = :sesion"),
    @NamedQuery(name = "VisitaCurso.findByOtroPrograma", query = "SELECT v FROM VisitaCurso v WHERE v.otroPrograma = :otroPrograma")})
public class VisitaCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha_visita")
    @Temporal(TemporalType.DATE)
    private Date fechaVisita;
    @Basic(optional = false)
    @Column(name = "sesion")
    private int sesion;
    @Column(name = "otro_programa")
    private String otroPrograma;
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cursos idCurso;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_programa_academico", referencedColumnName = "id")
    @ManyToOne
    private ProgramaAcademico idProgramaAcademico;
    @JoinColumn(name = "id_universidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Universidad idUniversidad;

    public VisitaCurso() {
    }

    public VisitaCurso(Integer id) {
        this.id = id;
    }

    public VisitaCurso(Integer id, Date fechaVisita, int sesion) {
        this.id = id;
        this.fechaVisita = fechaVisita;
        this.sesion = sesion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public int getSesion() {
        return sesion;
    }

    public void setSesion(int sesion) {
        this.sesion = sesion;
    }

    public String getOtroPrograma() {
        return otroPrograma;
    }

    public void setOtroPrograma(String otroPrograma) {
        this.otroPrograma = otroPrograma;
    }

    public Cursos getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Cursos idCurso) {
        this.idCurso = idCurso;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public ProgramaAcademico getIdProgramaAcademico() {
        return idProgramaAcademico;
    }

    public void setIdProgramaAcademico(ProgramaAcademico idProgramaAcademico) {
        this.idProgramaAcademico = idProgramaAcademico;
    }

    public Universidad getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Universidad idUniversidad) {
        this.idUniversidad = idUniversidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaCurso)) {
            return false;
        }
        VisitaCurso other = (VisitaCurso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.VisitaCurso[ id=" + id + " ]";
    }
    
}
