/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author jerson
 */
@Entity
@Table(name = "programa_academico")
@NamedQueries({
    @NamedQuery(name = "ProgramaAcademico.findAll", query = "SELECT p FROM ProgramaAcademico p"),
    @NamedQuery(name = "ProgramaAcademico.findById", query = "SELECT p FROM ProgramaAcademico p WHERE p.id = :id"),
    @NamedQuery(name = "ProgramaAcademico.findByNombre", query = "SELECT p FROM ProgramaAcademico p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProgramaAcademico.findByDescripcion", query = "SELECT p FROM ProgramaAcademico p WHERE p.descripcion = :descripcion")})
public class ProgramaAcademico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idProgramaAcademico")
    private List<VisitaSocializacion> visitaSocializacionList;
    @OneToMany(mappedBy = "idProgramaAcademico")
    private List<VisitaClase> visitaClaseList;
    @OneToMany(mappedBy = "idProgramaAcademico")
    private List<VisitaSemillero> visitaSemilleroList;
    @OneToMany(mappedBy = "idProgramaAcademico")
    private List<VisitaSustentacionProyectoGrado> visitaSustentacionProyectoGradoList;
    @OneToMany(mappedBy = "idProgramaAcademico")
    private List<VisitaCurso> visitaCursoList;
    @OneToMany(mappedBy = "idProgramaAcademico")
    private List<VisitaGrabacion> visitaGrabacionList;

    public ProgramaAcademico() {
    }

    public ProgramaAcademico(Integer id) {
        this.id = id;
    }

    public ProgramaAcademico(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<VisitaSocializacion> getVisitaSocializacionList() {
        return visitaSocializacionList;
    }

    public void setVisitaSocializacionList(List<VisitaSocializacion> visitaSocializacionList) {
        this.visitaSocializacionList = visitaSocializacionList;
    }

    public List<VisitaClase> getVisitaClaseList() {
        return visitaClaseList;
    }

    public void setVisitaClaseList(List<VisitaClase> visitaClaseList) {
        this.visitaClaseList = visitaClaseList;
    }

    public List<VisitaSemillero> getVisitaSemilleroList() {
        return visitaSemilleroList;
    }

    public void setVisitaSemilleroList(List<VisitaSemillero> visitaSemilleroList) {
        this.visitaSemilleroList = visitaSemilleroList;
    }

    public List<VisitaSustentacionProyectoGrado> getVisitaSustentacionProyectoGradoList() {
        return visitaSustentacionProyectoGradoList;
    }

    public void setVisitaSustentacionProyectoGradoList(List<VisitaSustentacionProyectoGrado> visitaSustentacionProyectoGradoList) {
        this.visitaSustentacionProyectoGradoList = visitaSustentacionProyectoGradoList;
    }

    public List<VisitaCurso> getVisitaCursoList() {
        return visitaCursoList;
    }

    public void setVisitaCursoList(List<VisitaCurso> visitaCursoList) {
        this.visitaCursoList = visitaCursoList;
    }

    public List<VisitaGrabacion> getVisitaGrabacionList() {
        return visitaGrabacionList;
    }

    public void setVisitaGrabacionList(List<VisitaGrabacion> visitaGrabacionList) {
        this.visitaGrabacionList = visitaGrabacionList;
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
        if (!(object instanceof ProgramaAcademico)) {
            return false;
        }
        ProgramaAcademico other = (ProgramaAcademico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.ProgramaAcademico[ id=" + id + " ]";
    }
    
}
