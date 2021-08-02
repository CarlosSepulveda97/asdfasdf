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
public class ReclamoObservacionRequest {

    private int folio;
    private String detalleObservacion;
    private int ordenFlete;
    private int tipoObservacion;
    private int obsTipoObsProceso;
    private String usuarioCrea;

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getDetalleObservacion() {
        return detalleObservacion;
    }

    public void setDetalleObservacion(String detalleObservacion) {
        this.detalleObservacion = detalleObservacion;
    }

    public int getOrdenFlete() {
        return ordenFlete;
    }

    public void setOrdenFlete(int ordenFlete) {
        this.ordenFlete = ordenFlete;
    }

    public int getTipoObservacion() {
        return tipoObservacion;
    }

    public void setTipoObservacion(int tipoObservacion) {
        this.tipoObservacion = tipoObservacion;
    }

    public int getObsTipoObsProceso() {
        return obsTipoObsProceso;
    }

    public void setObsTipoObsProceso(int obsTipoObsProceso) {
        this.obsTipoObsProceso = obsTipoObsProceso;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    @Override
    public String toString() {
        return "ReclamoObservacionRequest{" + "folio=" + folio + ", detalleObservacion=" + detalleObservacion + ", ordenFlete=" + ordenFlete + ", tipoObservacion=" + tipoObservacion + ", obsTipoObsProceso=" + obsTipoObsProceso + ", usuarioCrea=" + usuarioCrea + '}';
    }

}
