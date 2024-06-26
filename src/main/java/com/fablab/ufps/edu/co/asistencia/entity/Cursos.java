/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.entity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
@Table(name = "cursos")
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findById", query = "SELECT c FROM Cursos c WHERE c.id = :id"),
    @NamedQuery(name = "Cursos.findByNombre", query = "SELECT c FROM Cursos c WHERE c.nombre = :nombre")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private List<VisitaCursoColegio> visitaCursoColegioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private List<VisitaSteamSchool> visitaSteamSchoolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private List<VisitaSteamYoung> visitaSteamYoungList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private List<VisitaCurso> visitaCursoList;

    public Cursos() {
    }

    public Cursos(Integer id) {
        this.id = id;
    }

    public Cursos(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public List<VisitaCursoColegio> getVisitaCursoColegioList() {
        return visitaCursoColegioList;
    }

    public void setVisitaCursoColegioList(List<VisitaCursoColegio> visitaCursoColegioList) {
        this.visitaCursoColegioList = visitaCursoColegioList;
    }

    public List<VisitaSteamSchool> getVisitaSteamSchoolList() {
        return visitaSteamSchoolList;
    }

    public void setVisitaSteamSchoolList(List<VisitaSteamSchool> visitaSteamSchoolList) {
        this.visitaSteamSchoolList = visitaSteamSchoolList;
    }

    public List<VisitaSteamYoung> getVisitaSteamYoungList() {
        return visitaSteamYoungList;
    }

    public void setVisitaSteamYoungList(List<VisitaSteamYoung> visitaSteamYoungList) {
        this.visitaSteamYoungList = visitaSteamYoungList;
    }

    public List<VisitaCurso> getVisitaCursoList() {
        return visitaCursoList;
    }

    public void setVisitaCursoList(List<VisitaCurso> visitaCursoList) {
        this.visitaCursoList = visitaCursoList;
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
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.Cursos[ id=" + id + " ]";
    }
    
}
