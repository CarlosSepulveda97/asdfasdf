/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egt
 */
@Entity
@Table(name = "ReclamoDetalleTracking")
@XmlRootElement
public class ReclamoDetalleTracking implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
@Column(name = "CODIGORECLAMO")
    private Integer codigoReclamo;
    @Column(name = "FOLIORECLAMO")
    private Integer folioReclamo;
    @Column(name = "CODIGOESTADORECLAMO")
    private Integer codigoEstadoreclamo;
    @Column(name = "NOMBREESTADORECLAMO")
    private String nombreEstadoReclamo;
    @Column(name = "RECLMONTO")
    private Integer montoReclamo;

    public Integer getCodigoReclamo() {
        return codigoReclamo;
    }

    public void setCodigoReclamo(Integer codigoReclamo) {
        this.codigoReclamo = codigoReclamo;
    }

    public Integer getFolioReclamo() {
        return folioReclamo;
    }

    public void setFolioReclamo(Integer folioReclamo) {
        this.folioReclamo = folioReclamo;
    }

    public Integer getCodigoEstadoreclamo() {
        return codigoEstadoreclamo;
    }

    public void setCodigoEstadoreclamo(Integer codigoEstadoreclamo) {
        this.codigoEstadoreclamo = codigoEstadoreclamo;
    }

    public String getNombreEstadoReclamo() {
        return nombreEstadoReclamo;
    }

    public void setNombreEstadoReclamo(String nombreEstadoReclamo) {
        this.nombreEstadoReclamo = nombreEstadoReclamo;
    }

    public Integer getMontoReclamo() {
        return montoReclamo;
    }

    public void setMontoReclamo(Integer montoReclamo) {
        this.montoReclamo = montoReclamo;
    }

    @Override
    public String toString() {
        return "ReclamoDetalleTracking{" + "codigoReclamo=" + codigoReclamo + ", folioReclamo=" + folioReclamo + ", codigoEstadoreclamo=" + codigoEstadoreclamo + ", nombreEstadoReclamo=" + nombreEstadoReclamo + ", montoReclamo=" + montoReclamo + '}';
    }
}
