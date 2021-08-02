/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.util.Date;
 

/**
 *
 * @author ricardo.leal
 */
public class IngresoReclamoBean {

     
    private Integer folio;
    private String fecha;
    private Integer codMotivo;
    private Integer ordenFlete;
    private long monto;

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCodMotivo() {
        return codMotivo;
    }

    public void setCodMotivo(Integer codMotivo) {
        this.codMotivo = codMotivo;
    }

    public Integer getOrdenFlete() {
        return ordenFlete;
    }

    public void setOrdenFlete(Integer ordenFlete) {
        this.ordenFlete = ordenFlete;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "IngresoReclamoBean{" + "folio=" + folio + ", fecha=" + fecha + ", codMotivo=" + codMotivo + ", ordenFlete=" + ordenFlete + ", monto=" + monto + '}';
    }
}
