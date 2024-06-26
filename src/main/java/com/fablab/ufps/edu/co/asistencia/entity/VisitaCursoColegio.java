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
@Table(name = "visita_curso_colegio")
@NamedQueries({
    @NamedQuery(name = "VisitaCursoColegio.findAll", query = "SELECT v FROM VisitaCursoColegio v"),
    @NamedQuery(name = "VisitaCursoColegio.findById", query = "SELECT v FROM VisitaCursoColegio v WHERE v.id = :id"),
    @NamedQuery(name = "VisitaCursoColegio.findByFechaVisita", query = "SELECT v FROM VisitaCursoColegio v WHERE v.fechaVisita = :fechaVisita"),
    @NamedQuery(name = "VisitaCursoColegio.findBySesion", query = "SELECT v FROM VisitaCursoColegio v WHERE v.sesion = :sesion")})
public class VisitaCursoColegio implements Serializable {

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
    @JoinColumn(name = "id_colegio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Colegio idColegio;
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cursos idCurso;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public VisitaCursoColegio() {
    }

    public VisitaCursoColegio(Integer id) {
        this.id = id;
    }

    public VisitaCursoColegio(Integer id, Date fechaVisita, int sesion) {
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

    public Colegio getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(Colegio idColegio) {
        this.idColegio = idColegio;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaCursoColegio)) {
            return false;
        }
        VisitaCursoColegio other = (VisitaCursoColegio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.VisitaCursoColegio[ id=" + id + " ]";
    }
    
}
