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
@Table(name = "poblacion_especial")
@NamedQueries({
    @NamedQuery(name = "PoblacionEspecial.findAll", query = "SELECT p FROM PoblacionEspecial p"),
    @NamedQuery(name = "PoblacionEspecial.findById", query = "SELECT p FROM PoblacionEspecial p WHERE p.id = :id"),
    @NamedQuery(name = "PoblacionEspecial.findByNombre", query = "SELECT p FROM PoblacionEspecial p WHERE p.nombre = :nombre")})
public class PoblacionEspecial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPoblacionEspecial")
    private List<Persona> personaList;
    @OneToMany(mappedBy = "idPoblacionEspecial")
    private List<SteamStudent> steamStudentList;

    public PoblacionEspecial() {
    }

    public PoblacionEspecial(Integer id) {
        this.id = id;
    }

    public PoblacionEspecial(Integer id, String nombre) {
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

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public List<SteamStudent> getSteamStudentList() {
        return steamStudentList;
    }

    public void setSteamStudentList(List<SteamStudent> steamStudentList) {
        this.steamStudentList = steamStudentList;
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
        if (!(object instanceof PoblacionEspecial)) {
            return false;
        }
        PoblacionEspecial other = (PoblacionEspecial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.PoblacionEspecial[ id=" + id + " ]";
    }
    
}
