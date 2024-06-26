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
@Table(name = "visita_clase")
@NamedQueries({
    @NamedQuery(name = "VisitaClase.findAll", query = "SELECT v FROM VisitaClase v"),
    @NamedQuery(name = "VisitaClase.findById", query = "SELECT v FROM VisitaClase v WHERE v.id = :id"),
    @NamedQuery(name = "VisitaClase.findByFecha", query = "SELECT v FROM VisitaClase v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "VisitaClase.findByOtroPrograma", query = "SELECT v FROM VisitaClase v WHERE v.otroPrograma = :otroPrograma"),
    @NamedQuery(name = "VisitaClase.findByOtroUniversidad", query = "SELECT v FROM VisitaClase v WHERE v.otroUniversidad = :otroUniversidad"),
    @NamedQuery(name = "VisitaClase.findByCodigoCarrera", query = "SELECT v FROM VisitaClase v WHERE v.codigoCarrera = :codigoCarrera"),
    @NamedQuery(name = "VisitaClase.findByNombreMateria", query = "SELECT v FROM VisitaClase v WHERE v.nombreMateria = :nombreMateria"),
    @NamedQuery(name = "VisitaClase.findByNombreDocente", query = "SELECT v FROM VisitaClase v WHERE v.nombreDocente = :nombreDocente")})
public class VisitaClase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "otro_programa")
    private String otroPrograma;
    @Column(name = "otro_universidad")
    private String otroUniversidad;
    @Basic(optional = false)
    @Column(name = "codigo_carrera")
    private String codigoCarrera;
    @Basic(optional = false)
    @Column(name = "nombre_materia")
    private String nombreMateria;
    @Column(name = "nombre_docente")
    private String nombreDocente;
    @JoinColumn(name = "id_aula", referencedColumnName = "id")
    @ManyToOne
    private Aula idAula;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_programa_academico", referencedColumnName = "id")
    @ManyToOne
    private ProgramaAcademico idProgramaAcademico;
    @JoinColumn(name = "id_universidad", referencedColumnName = "id")
    @ManyToOne
    private Universidad idUniversidad;

    public VisitaClase() {
    }

    public VisitaClase(Integer id) {
        this.id = id;
    }

    public VisitaClase(Integer id, Date fecha, String codigoCarrera, String nombreMateria) {
        this.id = id;
        this.fecha = fecha;
        this.codigoCarrera = codigoCarrera;
        this.nombreMateria = nombreMateria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOtroPrograma() {
        return otroPrograma;
    }

    public void setOtroPrograma(String otroPrograma) {
        this.otroPrograma = otroPrograma;
    }

    public String getOtroUniversidad() {
        return otroUniversidad;
    }

    public void setOtroUniversidad(String otroUniversidad) {
        this.otroUniversidad = otroUniversidad;
    }

    public String getCodigoCarrera() {
        return codigoCarrera;
    }

    public void setCodigoCarrera(String codigoCarrera) {
        this.codigoCarrera = codigoCarrera;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public Aula getIdAula() {
        return idAula;
    }

    public void setIdAula(Aula idAula) {
        this.idAula = idAula;
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
        if (!(object instanceof VisitaClase)) {
            return false;
        }
        VisitaClase other = (VisitaClase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.VisitaClase[ id=" + id + " ]";
    }
    
}
