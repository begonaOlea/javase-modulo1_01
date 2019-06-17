
package com.bolsa.dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.PreUpdate;
/**
 *
 * @author begonaolea
 */
@Entity
@Table(name = "ACCIONISTAS")
@NamedQueries({
    @NamedQuery(name = "Accionista.findAll", query = "SELECT a FROM Accionista a")
    , @NamedQuery(name = "Accionista.findByIdAccionista", query = "SELECT a FROM Accionista a WHERE a.idAccionista = :idAccionista")
    , @NamedQuery(name = "Accionista.findByNombre", query = "SELECT a FROM Accionista a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Accionista.findByFechaCreacion", query = "SELECT a FROM Accionista a WHERE a.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Accionista.findByFechaModificacion", query = "SELECT a FROM Accionista a WHERE a.fechaModificacion = :fechaModificacion")})
public class Accionista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ACCIONISTA")
    private Integer idAccionista;
    
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    @Size(min = 1, max = 20)
    private String nombre;
    
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAccionista")
    private Collection<Compra> compraCollection;

    public Accionista() {
    }

    public Accionista(Integer idAccionista) {
        this.idAccionista = idAccionista;
    }

    public Accionista(Integer idAccionista, String nombre) {
        this.idAccionista = idAccionista;
        this.nombre = nombre;
    }

    public Integer getIdAccionista() {
        return idAccionista;
    }

    public void setIdAccionista(Integer idAccionista) {
        this.idAccionista = idAccionista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccionista != null ? idAccionista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accionista)) {
            return false;
        }
        Accionista other = (Accionista) object;
        if ((this.idAccionista == null && other.idAccionista != null) || (this.idAccionista != null && !this.idAccionista.equals(other.idAccionista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bolsa.dominio.Accionista[ idAccionista=" + idAccionista + " ]";
    }
    
    @PrePersist
    public void alCrear(){
        this.setFechaCreacion(new Date());
        this.setFechaModificacion(new Date());
    }
    
    @PreUpdate
    public void alModificar(){
         this.setFechaModificacion(new Date());
    }
    
    
    
}
