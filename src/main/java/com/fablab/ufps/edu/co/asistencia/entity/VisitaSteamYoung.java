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
@Table(name = "visita_steam_young")
@NamedQueries({
    @NamedQuery(name = "VisitaSteamYoung.findAll", query = "SELECT v FROM VisitaSteamYoung v"),
    @NamedQuery(name = "VisitaSteamYoung.findById", query = "SELECT v FROM VisitaSteamYoung v WHERE v.id = :id"),
    @NamedQuery(name = "VisitaSteamYoung.findByFecha", query = "SELECT v FROM VisitaSteamYoung v WHERE v.fecha = :fecha")})
public class VisitaSteamYoung implements Serializable {

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
    @JoinColumn(name = "id_colegio", referencedColumnName = "id")
    @ManyToOne
    private Colegio idColegio;
    @JoinColumn(name = "id_curso", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cursos idCurso;
    @JoinColumn(name = "id_steam_student", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SteamStudent idSteamStudent;

    public VisitaSteamYoung() {
    }

    public VisitaSteamYoung(Integer id) {
        this.id = id;
    }

    public VisitaSteamYoung(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
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

    public SteamStudent getIdSteamStudent() {
        return idSteamStudent;
    }

    public void setIdSteamStudent(SteamStudent idSteamStudent) {
        this.idSteamStudent = idSteamStudent;
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
        if (!(object instanceof VisitaSteamYoung)) {
            return false;
        }
        VisitaSteamYoung other = (VisitaSteamYoung) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.VisitaSteamYoung[ id=" + id + " ]";
    }
    
}
