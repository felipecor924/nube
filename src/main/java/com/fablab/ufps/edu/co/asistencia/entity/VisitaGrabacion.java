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
@Table(name = "visita_grabacion")
@NamedQueries({
    @NamedQuery(name = "VisitaGrabacion.findAll", query = "SELECT v FROM VisitaGrabacion v"),
    @NamedQuery(name = "VisitaGrabacion.findById", query = "SELECT v FROM VisitaGrabacion v WHERE v.id = :id"),
    @NamedQuery(name = "VisitaGrabacion.findByFecha", query = "SELECT v FROM VisitaGrabacion v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "VisitaGrabacion.findByExterno", query = "SELECT v FROM VisitaGrabacion v WHERE v.externo = :externo"),
    @NamedQuery(name = "VisitaGrabacion.findByOtroPrograma", query = "SELECT v FROM VisitaGrabacion v WHERE v.otroPrograma = :otroPrograma"),
    @NamedQuery(name = "VisitaGrabacion.findByRazonGrabacion", query = "SELECT v FROM VisitaGrabacion v WHERE v.razonGrabacion = :razonGrabacion")})
public class VisitaGrabacion implements Serializable {

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
    @Column(name = "externo")
    private String externo;
    @Column(name = "otro_programa")
    private String otroPrograma;
    @Basic(optional = false)
    @Column(name = "razon_grabacion")
    private int razonGrabacion;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona idPersona;
    @JoinColumn(name = "id_programa_academico", referencedColumnName = "id")
    @ManyToOne
    private ProgramaAcademico idProgramaAcademico;
    @JoinColumn(name = "id_semillero", referencedColumnName = "id")
    @ManyToOne
    private Semillero idSemillero;
    @JoinColumn(name = "id_universidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Universidad idUniversidad;

    public VisitaGrabacion() {
    }

    public VisitaGrabacion(Integer id) {
        this.id = id;
    }

    public VisitaGrabacion(Integer id, Date fecha, int razonGrabacion) {
        this.id = id;
        this.fecha = fecha;
        this.razonGrabacion = razonGrabacion;
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

    public String getExterno() {
        return externo;
    }

    public void setExterno(String externo) {
        this.externo = externo;
    }

    public String getOtroPrograma() {
        return otroPrograma;
    }

    public void setOtroPrograma(String otroPrograma) {
        this.otroPrograma = otroPrograma;
    }

    public int getRazonGrabacion() {
        return razonGrabacion;
    }

    public void setRazonGrabacion(int razonGrabacion) {
        this.razonGrabacion = razonGrabacion;
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

    public Semillero getIdSemillero() {
        return idSemillero;
    }

    public void setIdSemillero(Semillero idSemillero) {
        this.idSemillero = idSemillero;
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
        if (!(object instanceof VisitaGrabacion)) {
            return false;
        }
        VisitaGrabacion other = (VisitaGrabacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.VisitaGrabacion[ id=" + id + " ]";
    }
    
}
