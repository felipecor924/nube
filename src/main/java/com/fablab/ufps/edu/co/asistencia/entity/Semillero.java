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
@Table(name = "semillero")
@NamedQueries({
    @NamedQuery(name = "Semillero.findAll", query = "SELECT s FROM Semillero s"),
    @NamedQuery(name = "Semillero.findById", query = "SELECT s FROM Semillero s WHERE s.id = :id"),
    @NamedQuery(name = "Semillero.findByNombre", query = "SELECT s FROM Semillero s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "Semillero.findBySigla", query = "SELECT s FROM Semillero s WHERE s.sigla = :sigla")})
public class Semillero implements Serializable {

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
    @Column(name = "sigla")
    private String sigla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSemillero")
    private List<VisitaSemillero> visitaSemilleroList;
    @OneToMany(mappedBy = "idSemillero")
    private List<VisitaGrabacion> visitaGrabacionList;

    public Semillero() {
    }

    public Semillero(Integer id) {
        this.id = id;
    }

    public Semillero(Integer id, String nombre, String sigla) {
        this.id = id;
        this.nombre = nombre;
        this.sigla = sigla;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public List<VisitaSemillero> getVisitaSemilleroList() {
        return visitaSemilleroList;
    }

    public void setVisitaSemilleroList(List<VisitaSemillero> visitaSemilleroList) {
        this.visitaSemilleroList = visitaSemilleroList;
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
        if (!(object instanceof Semillero)) {
            return false;
        }
        Semillero other = (Semillero) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.Semillero[ id=" + id + " ]";
    }
    
}
