/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author luis.flores
 */
public class Reclamo {

    private int reccodigo;
    private int erecodigo;
    private int mrecodigo;
    private int recfolio;
    private Date recfechacreacion;
    private Date recfechamodificacion;
    private double recmonto;
    private int recsernac;
    private int ofcodigo;
    private int emprecodigo;
    private int recacuso;
    private int recrechazado;
    private int reccontactopend;
    private int rectomado;
    private String usuariocrea;
    private String usuariomodifica;
    private int rectiporesolucion;
    private int recversion;
    private int codigoEstadoReclamo; //0-NO TIENE RECLAMO 1-OF TIENE RECLAMO
    private String descEstadoReclamo;
    
    public int getReccodigo() {
        return reccodigo;
    }

    public void setReccodigo(int reccodigo) {
        this.reccodigo = reccodigo;
    }

    public int getErecodigo() {
        return erecodigo;
    }

    public void setErecodigo(int erecodigo) {
        this.erecodigo = erecodigo;
    }

    public int getMrecodigo() {
        return mrecodigo;
    }

    public void setMrecodigo(int mrecodigo) {
        this.mrecodigo = mrecodigo;
    }

    public int getRecfolio() {
        return recfolio;
    }

    public void setRecfolio(int recfolio) {
        this.recfolio = recfolio;
    }

    public Date getRecfechacreacion() {
        return recfechacreacion;
    }

    public void setRecfechacreacion(Date recfechacreacion) {
        this.recfechacreacion = recfechacreacion;
    }

    public Date getRecfechamodificacion() {
        return recfechamodificacion;
    }

    public void setRecfechamodificacion(Date recfechamodificacion) {
        this.recfechamodificacion = recfechamodificacion;
    }

    public double getRecmonto() {
        return recmonto;
    }

    public void setRecmonto(double recmonto) {
        this.recmonto = recmonto;
    }

    public int getRecsernac() {
        return recsernac;
    }

    public void setRecsernac(int recsernac) {
        this.recsernac = recsernac;
    }

    public int getOfcodigo() {
        return ofcodigo;
    }

    public void setOfcodigo(int ofcodigo) {
        this.ofcodigo = ofcodigo;
    }

    public int getEmprecodigo() {
        return emprecodigo;
    }

    public void setEmprecodigo(int emprecodigo) {
        this.emprecodigo = emprecodigo;
    }

    public int getRecacuso() {
        return recacuso;
    }

    public void setRecacuso(int recacuso) {
        this.recacuso = recacuso;
    }

    public int getRecrechazado() {
        return recrechazado;
    }

    public void setRecrechazado(int recrechazado) {
        this.recrechazado = recrechazado;
    }

    public int getReccontactopend() {
        return reccontactopend;
    }

    public void setReccontactopend(int reccontactopend) {
        this.reccontactopend = reccontactopend;
    }

    public int getRectomado() {
        return rectomado;
    }

    public void setRectomado(int rectomado) {
        this.rectomado = rectomado;
    }

    public String getUsuariocrea() {
        return usuariocrea;
    }

    public void setUsuariocrea(String usuariocrea) {
        this.usuariocrea = usuariocrea;
    }

    public String getUsuariomodifica() {
        return usuariomodifica;
    }

    public void setUsuariomodifica(String usuariomodifica) {
        this.usuariomodifica = usuariomodifica;
    }

    public int getRectiporesolucion() {
        return rectiporesolucion;
    }

    public void setRectiporesolucion(int rectiporesolucion) {
        this.rectiporesolucion = rectiporesolucion;
    }

    public int getRecversion() {
        return recversion;
    }

    public void setRecversion(int recversion) {
        this.recversion = recversion;
    }

    public int getCodigoEstadoReclamo() {
        return codigoEstadoReclamo;
    }

    public void setCodigoEstadoReclamo(int codigoEstadoReclamo) {
        this.codigoEstadoReclamo = codigoEstadoReclamo;
    }

    public String getDescEstadoReclamo() {
        return descEstadoReclamo;
    }

    public void setDescEstadoReclamo(String descEstadoReclamo) {
        this.descEstadoReclamo = descEstadoReclamo;
    }
    
    

}
