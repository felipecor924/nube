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
@Table(name = "colegio")
@NamedQueries({
    @NamedQuery(name = "Colegio.findAll", query = "SELECT c FROM Colegio c"),
    @NamedQuery(name = "Colegio.findById", query = "SELECT c FROM Colegio c WHERE c.id = :id"),
    @NamedQuery(name = "Colegio.findByNombre", query = "SELECT c FROM Colegio c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Colegio.findByDireccion", query = "SELECT c FROM Colegio c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Colegio.findByTelContacto", query = "SELECT c FROM Colegio c WHERE c.telContacto = :telContacto")})
public class Colegio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "tel_contacto")
    private String telContacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColegio")
    private List<VisitaCursoColegio> visitaCursoColegioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColegio")
    private List<VisitaSocializacionColegio> visitaSocializacionColegioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColegio")
    private List<VisitaSteamSchool> visitaSteamSchoolList;
    @OneToMany(mappedBy = "idColegio")
    private List<SteamStudent> steamStudentList;
    @OneToMany(mappedBy = "idColegio")
    private List<VisitaSteamYoung> visitaSteamYoungList;

    public Colegio() {
    }

    public Colegio(Integer id) {
        this.id = id;
    }

    public Colegio(Integer id, String nombre) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelContacto() {
        return telContacto;
    }

    public void setTelContacto(String telContacto) {
        this.telContacto = telContacto;
    }

    public List<VisitaCursoColegio> getVisitaCursoColegioList() {
        return visitaCursoColegioList;
    }

    public void setVisitaCursoColegioList(List<VisitaCursoColegio> visitaCursoColegioList) {
        this.visitaCursoColegioList = visitaCursoColegioList;
    }

    public List<VisitaSocializacionColegio> getVisitaSocializacionColegioList() {
        return visitaSocializacionColegioList;
    }

    public void setVisitaSocializacionColegioList(List<VisitaSocializacionColegio> visitaSocializacionColegioList) {
        this.visitaSocializacionColegioList = visitaSocializacionColegioList;
    }

    public List<VisitaSteamSchool> getVisitaSteamSchoolList() {
        return visitaSteamSchoolList;
    }

    public void setVisitaSteamSchoolList(List<VisitaSteamSchool> visitaSteamSchoolList) {
        this.visitaSteamSchoolList = visitaSteamSchoolList;
    }

    public List<SteamStudent> getSteamStudentList() {
        return steamStudentList;
    }

    public void setSteamStudentList(List<SteamStudent> steamStudentList) {
        this.steamStudentList = steamStudentList;
    }

    public List<VisitaSteamYoung> getVisitaSteamYoungList() {
        return visitaSteamYoungList;
    }

    public void setVisitaSteamYoungList(List<VisitaSteamYoung> visitaSteamYoungList) {
        this.visitaSteamYoungList = visitaSteamYoungList;
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
        if (!(object instanceof Colegio)) {
            return false;
        }
        Colegio other = (Colegio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.Colegio[ id=" + id + " ]";
    }
    
}
