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
@Table(name = "steam_student")
@NamedQueries({
    @NamedQuery(name = "SteamStudent.findAll", query = "SELECT s FROM SteamStudent s"),
    @NamedQuery(name = "SteamStudent.findById", query = "SELECT s FROM SteamStudent s WHERE s.id = :id"),
    @NamedQuery(name = "SteamStudent.findByNombre", query = "SELECT s FROM SteamStudent s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SteamStudent.findBySexo", query = "SELECT s FROM SteamStudent s WHERE s.sexo = :sexo"),
    @NamedQuery(name = "SteamStudent.findBySemestre", query = "SELECT s FROM SteamStudent s WHERE s.semestre = :semestre")})
public class SteamStudent implements Serializable {

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
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "semestre")
    private String semestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSteamStudent")
    private List<VisitaSteamSchool> visitaSteamSchoolList;
    @JoinColumn(name = "id_colegio", referencedColumnName = "id")
    @ManyToOne
    private Colegio idColegio;
    @JoinColumn(name = "id_poblacion_especial", referencedColumnName = "id")
    @ManyToOne
    private PoblacionEspecial idPoblacionEspecial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSteamStudent")
    private List<VisitaSteamYoung> visitaSteamYoungList;

    public SteamStudent() {
    }

    public SteamStudent(Integer id) {
        this.id = id;
    }

    public SteamStudent(Integer id, String nombre, String sexo, String semestre) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.semestre = semestre;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<VisitaSteamSchool> getVisitaSteamSchoolList() {
        return visitaSteamSchoolList;
    }

    public void setVisitaSteamSchoolList(List<VisitaSteamSchool> visitaSteamSchoolList) {
        this.visitaSteamSchoolList = visitaSteamSchoolList;
    }

    public Colegio getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(Colegio idColegio) {
        this.idColegio = idColegio;
    }

    public PoblacionEspecial getIdPoblacionEspecial() {
        return idPoblacionEspecial;
    }

    public void setIdPoblacionEspecial(PoblacionEspecial idPoblacionEspecial) {
        this.idPoblacionEspecial = idPoblacionEspecial;
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
        if (!(object instanceof SteamStudent)) {
            return false;
        }
        SteamStudent other = (SteamStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.SteamStudent[ id=" + id + " ]";
    }
    
}
