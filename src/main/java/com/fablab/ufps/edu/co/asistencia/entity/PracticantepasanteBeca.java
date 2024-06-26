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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author jerson
 */
@Entity
@Table(name = "practicante_pasante_Beca")
@NamedQueries({
    @NamedQuery(name = "PracticantepasanteBeca.findAll", query = "SELECT p FROM PracticantepasanteBeca p"),
    @NamedQuery(name = "PracticantepasanteBeca.findById", query = "SELECT p FROM PracticantepasanteBeca p WHERE p.id = :id"),
    @NamedQuery(name = "PracticantepasanteBeca.findByIdCarnet", query = "SELECT p FROM PracticantepasanteBeca p WHERE p.idCarnet = :idCarnet"),
    @NamedQuery(name = "PracticantepasanteBeca.findBySemestre", query = "SELECT p FROM PracticantepasanteBeca p WHERE p.semestre = :semestre"),
    @NamedQuery(name = "PracticantepasanteBeca.findByEstado", query = "SELECT p FROM PracticantepasanteBeca p WHERE p.estado = :estado")})
public class PracticantepasanteBeca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_carnet")
    private int idCarnet;
    @Basic(optional = false)
    @Column(name = "semestre")
    private String semestre;
    @Basic(optional = false)
    @Column(name = "estado")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPracticante")
    private List<IngresoSalidaPersonal> ingresoSalidaPersonalList;
    @JoinColumn(name = "id_persona", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persona idPersona;

    public PracticantepasanteBeca() {
    }

    public PracticantepasanteBeca(Integer id) {
        this.id = id;
    }

    public PracticantepasanteBeca(Integer id, int idCarnet, String semestre, Boolean estado) {
        this.id = id;
        this.idCarnet = idCarnet;
        this.semestre = semestre;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdCarnet() {
        return idCarnet;
    }

    public void setIdCarnet(int idCarnet) {
        this.idCarnet = idCarnet;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<IngresoSalidaPersonal> getIngresoSalidaPersonalList() {
        return ingresoSalidaPersonalList;
    }

    public void setIngresoSalidaPersonalList(List<IngresoSalidaPersonal> ingresoSalidaPersonalList) {
        this.ingresoSalidaPersonalList = ingresoSalidaPersonalList;
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
        if (!(object instanceof PracticantepasanteBeca)) {
            return false;
        }
        PracticantepasanteBeca other = (PracticantepasanteBeca) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.PracticantepasanteBeca[ id=" + id + " ]";
    }
    
}
