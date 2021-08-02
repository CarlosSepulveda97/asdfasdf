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
public class OrdenFleteObservacionRequest {

    private int ordenFlete;
    private String detalleObservacion;
    private int tipoObservacion;
    private String usuarioCrea;
    private int obsTipoObsProceso; 
    
    public int getOrdenFlete() {
        return ordenFlete;
    }

    public void setOrdenFlete(int ordenFlete) {
        this.ordenFlete = ordenFlete;
    }

    public String getDetalleObservacion() {
        return detalleObservacion;
    }

    public void setDetalleObservacion(String detalleObservacion) {
        this.detalleObservacion = detalleObservacion;
    }


    /*public String getHoraObservacion() {
        return horaObservacion;
    }

    public void setHoraObservacion(String horaObservacion) {
        this.horaObservacion = horaObservacion;
    }*/
    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
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

}
