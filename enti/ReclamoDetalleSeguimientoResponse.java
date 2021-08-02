/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ricardo.leal
 */
@Entity
@Table(name="ReclamoSeguimientoDetalleResponse")
@XmlRootElement
public class ReclamoDetalleSeguimientoResponse implements Serializable{
         private static final long serialVersionUID = 1L;
    @Id
    @Column(name="sreccodigo")
    private Integer sreccodigo;
    @Column(name="reclcodigo")
    private Integer reclcodigo;
    @Column(name="ereccodigo")
    private Integer ereccodigo;
    @Column(name="srecfecha")
    private Date srecfecha;
    @Column(name="srechora")
    private Date srechora;
    @Column(name="ubifcodigo")
    private Integer ubifcodigo;
    @Column(name="ubifdescripcion")
    private String ubifdescripcion;
    @Column(name="srecobservacion")
    private String srecobservacion;
    @Column(name="usuacodigo")
    private Integer usuacodigo;
    @Column(name="usuausuario")
    private String usuausuario;

    public Integer getSreccodigo() {
        return sreccodigo;
    }

    public void setSreccodigo(Integer sreccodigo) {
        this.sreccodigo = sreccodigo;
    }

    public Integer getReclcodigo() {
        return reclcodigo;
    }

    public void setReclcodigo(Integer reclcodigo) {
        this.reclcodigo = reclcodigo;
    }

    public Integer getEreccodigo() {
        return ereccodigo;
    }

    public void setEreccodigo(Integer ereccodigo) {
        this.ereccodigo = ereccodigo;
    }

    public Date getSrecfecha() {
        return srecfecha;
    }

    public void setSrecfecha(Date srecfecha) {
        this.srecfecha = srecfecha;
    }

    public Date getSrechora() {
        return srechora;
    }

    public void setSrechora(Date srechora) {
        this.srechora = srechora;
    }

    public Integer getUbifcodigo() {
        return ubifcodigo;
    }

    public void setUbifcodigo(Integer ubifcodigo) {
        this.ubifcodigo = ubifcodigo;
    }

    public String getUbifdescripcion() {
        return ubifdescripcion;
    }

    public void setUbifdescripcion(String ubifdescripcion) {
        this.ubifdescripcion = ubifdescripcion;
    }

    public String getSrecobservacion() {
        return srecobservacion;
    }

    public void setSrecobservacion(String srecobservacion) {
        this.srecobservacion = srecobservacion;
    }

    public Integer getUsuacodigo() {
        return usuacodigo;
    }

    public void setUsuacodigo(Integer usuacodigo) {
        this.usuacodigo = usuacodigo;
    }

    public String getUsuausuario() {
        return usuausuario;
    }

    public void setUsuausuario(String usuausuario) {
        this.usuausuario = usuausuario;
    }

    @Override
    public String toString() {
        return "ReclamoDetalleSeguimientoResponse{" + "sreccodigo=" + sreccodigo + ", reclcodigo=" + reclcodigo + ", ereccodigo=" + ereccodigo + ", srecfecha=" + srecfecha + ", srechora=" + srechora + ", ubifcodigo=" + ubifcodigo + ", ubifdescripcion=" + ubifdescripcion + ", srecobservacion=" + srecobservacion + ", usuacodigo=" + usuacodigo + ", usuausuario=" + usuausuario + '}';
    }
 
}
