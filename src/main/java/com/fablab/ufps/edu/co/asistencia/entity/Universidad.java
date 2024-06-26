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
@Table(name = "universidad")
@NamedQueries({
    @NamedQuery(name = "Universidad.findAll", query = "SELECT u FROM Universidad u"),
    @NamedQuery(name = "Universidad.findById", query = "SELECT u FROM Universidad u WHERE u.id = :id"),
    @NamedQuery(name = "Universidad.findByNombre", query = "SELECT u FROM Universidad u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Universidad.findByDireccion", query = "SELECT u FROM Universidad u WHERE u.direccion = :direccion"),
    @NamedQuery(name = "Universidad.findByTelContacto", query = "SELECT u FROM Universidad u WHERE u.telContacto = :telContacto")})
public class Universidad implements Serializable {

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
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "tel_contacto")
    private String telContacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUniversidad")
    private List<VisitaSocializacion> visitaSocializacionList;
    @OneToMany(mappedBy = "idUniversidad")
    private List<VisitaClase> visitaClaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUniversidad")
    private List<VisitaSemillero> visitaSemilleroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUniversidad")
    private List<VisitaSustentacionProyectoGrado> visitaSustentacionProyectoGradoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUniversidad")
    private List<VisitaCurso> visitaCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUniversidad")
    private List<VisitaGrabacion> visitaGrabacionList;

    public Universidad() {
    }

    public Universidad(Integer id) {
        this.id = id;
    }

    public Universidad(Integer id, String nombre, String direccion, String telContacto) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telContacto = telContacto;
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
        if (!(object instanceof Universidad)) {
            return false;
        }
        Universidad other = (Universidad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.Universidad[ id=" + id + " ]";
    }
    
}
