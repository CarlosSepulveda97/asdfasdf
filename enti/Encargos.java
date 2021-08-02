/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author egt
 */
@Entity(name = "Encargos")
@Table(name = "Encargos")
public class Encargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ENCACODIGO")
    private Integer encargoCodigo;
    @Column(name = "ENCACODIGOBARRA")
    private String encargoCodigoBarra;
    @Column(name = "TENCCODIGO")
    private int tipoEncargoCodigo;
    @Column(name = "TENCNOMBRE")
    private String tipoEncargoNombre;
    @Column(name = "EPRODESCRIPCION")
    private String estadoProceso;
    @Column(name = "ENCAKGS")
    private Integer kilosEncargo;
    @Column(name = "ENCAALTO")
    private Integer altoEncargo;
    @Column(name = "ENCAANCHO")
    private Integer anchoEncargo;
    @Column(name = "ENCALARGO")
    private Integer largoEncargo;
    @Column(name = "ENCACLASIFSORTER")
    private Integer clasificacion;

    public Integer getEncargoCodigo() {
        return encargoCodigo;
    }

    public void setEncargoCodigo(Integer encargoCodigo) {
        this.encargoCodigo = encargoCodigo;
    }

    public String getEncargoCodigoBarra() {
        return encargoCodigoBarra;
    }

    public void setEncargoCodigoBarra(String encargoCodigoBarra) {
        this.encargoCodigoBarra = encargoCodigoBarra;
    }

    public int getTipoEncargoCodigo() {
        return tipoEncargoCodigo;
    }

    public void setTipoEncargoCodigo(int tipoEncargoCodigo) {
        this.tipoEncargoCodigo = tipoEncargoCodigo;
    }
    
    public String getTipoEncargoNombre() {
        return tipoEncargoNombre;
    }

    public void setTipoEncargoNombre(String tipoEncargoNombre) {
        this.tipoEncargoNombre = tipoEncargoNombre;
    }

    public String getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(String estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    public Integer getKilosEncargo() {
        return kilosEncargo;
    }

    public void setKilosEncargo(Integer kilosEncargo) {
        this.kilosEncargo = kilosEncargo;
    }

    public Integer getAltoEncargo() {
        return altoEncargo;
    }

    public void setAltoEncargo(Integer altoEncargo) {
        this.altoEncargo = altoEncargo;
    }

    public Integer getAnchoEncargo() {
        return anchoEncargo;
    }

    public void setAnchoEncargo(Integer anchoEncargo) {
        this.anchoEncargo = anchoEncargo;
    }

    public Integer getLargoEncargo() {
        return largoEncargo;
    }

    public void setLargoEncargo(Integer largoEncargo) {
        this.largoEncargo = largoEncargo;
    }

    public Integer getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }

    @Override
    public String toString() {
        return "Encargos{" + "encargoCodigo=" + encargoCodigo + ", encargoCodigoBarra=" + encargoCodigoBarra + ", tipoEncargoCodigo=" + tipoEncargoCodigo + ", tipoEncargoNombre=" + tipoEncargoNombre + ", estadoProceso=" + estadoProceso + ", kilosEncargo=" + kilosEncargo + ", altoEncargo=" + altoEncargo + ", anchoEncargo=" + anchoEncargo + ", largoEncargo=" + largoEncargo + ", clasificacion=" + clasificacion + '}';
    }
}
