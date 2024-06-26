/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fablab.ufps.edu.co.asistencia.entity;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author jerson
 */
@Entity
@Table(name = "persona")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findById", query = "SELECT p FROM Persona p WHERE p.id = :id"),
    @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Persona.findByApellido", query = "SELECT p FROM Persona p WHERE p.apellido = :apellido"),
    @NamedQuery(name = "Persona.findByDocumento", query = "SELECT p FROM Persona p WHERE p.documento = :documento"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByCodigo", query = "SELECT p FROM Persona p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo")})
public class Persona implements Serializable {

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
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @JoinColumn(name = "id_poblacion_especial", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PoblacionEspecial idPoblacionEspecial;
    @JoinColumn(name = "id_tipo_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoUsuario idTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<VisitaSocializacion> visitaSocializacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<VisitaClase> visitaClaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<VisitaSemillero> visitaSemilleroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<VisitaCursoColegio> visitaCursoColegioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<VisitaSocializacionColegio> visitaSocializacionColegioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<VisitaSustentacionProyectoGrado> visitaSustentacionProyectoGradoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<AdmUser> admUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<PracticantepasanteBeca> practicantepasanteBecaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<VisitaCurso> visitaCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPersona")
    private List<VisitaGrabacion> visitaGrabacionList;

    public Persona() {
    }

    public Persona(Integer id) {
        this.id = id;
    }

    public Persona(Integer id, String nombre, String apellido, String documento, String telefono, String codigo, Date fechaNacimiento, String sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public PoblacionEspecial getIdPoblacionEspecial() {
        return idPoblacionEspecial;
    }

    public void setIdPoblacionEspecial(PoblacionEspecial idPoblacionEspecial) {
        this.idPoblacionEspecial = idPoblacionEspecial;
    }

    public TipoUsuario getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipoUsuario idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
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

    public List<VisitaSustentacionProyectoGrado> getVisitaSustentacionProyectoGradoList() {
        return visitaSustentacionProyectoGradoList;
    }

    public void setVisitaSustentacionProyectoGradoList(List<VisitaSustentacionProyectoGrado> visitaSustentacionProyectoGradoList) {
        this.visitaSustentacionProyectoGradoList = visitaSustentacionProyectoGradoList;
    }

    public List<AdmUser> getAdmUserList() {
        return admUserList;
    }

    public void setAdmUserList(List<AdmUser> admUserList) {
        this.admUserList = admUserList;
    }

    public List<PracticantepasanteBeca> getPracticantepasanteBecaList() {
        return practicantepasanteBecaList;
    }

    public void setPracticantepasanteBecaList(List<PracticantepasanteBeca> practicantepasanteBecaList) {
        this.practicantepasanteBecaList = practicantepasanteBecaList;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fablab.ufps.edu.co.asistencia.entity.Persona[ id=" + id + " ]";
    }
    
}
