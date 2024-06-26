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
@Table(name = "ingreso_salida_personal")
@NamedQueries({
    @NamedQuery(name = "IngresoSalidaPersonal.findAll", query = "SELECT i FROM IngresoSalidaPersonal i"),
    @NamedQuery(name = "IngresoSalidaPersonal.findById", query = "SELECT i FROM IngresoSalidaPersonal i WHERE i.id = :id"),
    @NamedQuery(name = "IngresoSalidaPersonal.findByHora", query = "SELECT i FROM IngresoSalidaPersonal i WHERE i.hora = :hora"),
    @NamedQuery(name = "IngresoSalidaPersonal.findByFechaIngreso", query = "SELECT i FROM IngresoSalidaPersonal i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "IngresoSalidaPersonal.findByFechaRegistro", query = "SELECT i FROM IngresoSalidaPersonal i WHERE i.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "IngresoSalidaPersonal.findByEntradaSalida", query = "SELECT i FROM IngresoSalidaPersonal i WHERE i.entradaSalida = :entradaSalida")})
public class IngresoSalidaPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.DATE)
    private Date hora;
    @Basic(optional = false)
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "entrada_salida")
    private Boolean entradaSalida;
    @JoinColumn(name = "id_practicante", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PracticantepasanteBeca idPracticante;

    public IngresoSalidaPersonal() {
    }

    public IngresoSalidaPersonal(Integer id) {
        this.id = id;
    }

    public IngresoSalidaPersonal(Integer id, Date hora, Date fechaIngreso, Date fechaRegistro, Boolean entradaSalida) {
        this.id = id;
        this.hora = hora;
        this.fechaIngreso = fechaIngreso;
        this.fechaRegistro = fechaRegistro;
        this.entradaSalida = entradaSalida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getEntradaSalida() {
        return entradaSalida;
    }

    public void setEntradaSalida(Boolean entradaSalida) {
        this.entradaSalida = entradaSalida;
    }

    public PracticantepasanteBeca getIdPracticante() {
        return idPracticante;
    }

    public void setIdPracticante(PracticantepasanteBeca idPracticante) {
        this.idPracticante = idPracticante;
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
        if (!(object instanceof IngresoSalidaPersonal)) {
            return false;
        }
        IngresoSalidaPersonal other = (IngresoSalidaPersonal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.IngresoSalidaPersonal[ id=" + id + " ]";
    }
    
}
