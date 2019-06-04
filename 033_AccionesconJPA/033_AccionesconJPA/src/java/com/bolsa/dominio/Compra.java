/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsa.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author begonaolea
 */
@Entity
@Table(name = "COMPRAS_ACCIONES")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
    , @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra")
    , @NamedQuery(name = "Compra.findByCantidad", query = "SELECT c FROM Compra c WHERE c.cantidad = :cantidad")
    , @NamedQuery(name = "Compra.findByValor", query = "SELECT c FROM Compra c WHERE c.valor = :valor")
    , @NamedQuery(name = "Compra.findByFechaCreacion", query = "SELECT c FROM Compra c WHERE c.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Compra.findByFechaModificacion", query = "SELECT c FROM Compra c WHERE c.fechaModificacion = :fechaModificacion")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMPRA")
    private Integer idCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private int valor;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @JoinColumn(name = "ID_ACCION", referencedColumnName = "ID_ACCION")
    @ManyToOne(optional = false)
    private Accion idAccion;
    @JoinColumn(name = "ID_ACCIONISTA", referencedColumnName = "ID_ACCIONISTA")
    @ManyToOne(optional = false)
    private Accionista idAccionista;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(Integer idCompra, int cantidad, int valor) {
        this.idCompra = idCompra;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
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

    public Accion getIdAccion() {
        return idAccion;
    }

    public void setIdAccion(Accion idAccion) {
        this.idAccion = idAccion;
    }

    public Accionista getIdAccionista() {
        return idAccionista;
    }

    public void setIdAccionista(Accionista idAccionista) {
        this.idAccionista = idAccionista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bolsa.dominio.Compra[ idCompra=" + idCompra + " ]";
    }
    
}
