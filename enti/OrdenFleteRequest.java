/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ricardo.leal
 */
public class OrdenFleteRequest {

    private Integer of;
    private String telefonoDestinatario;
    private Integer codigoTipoEntrega;
    private Integer codigoAgenciaDestino;
    @NotNull
    private String direccionDestino;
    @NotNull
    private String numeracionDestino;
    private String departamentoDestino;
    private Integer codigoComunaDestinatario;
    @NotNull
    private String nombreComunaDestinatario;
    @NotNull
    private String solicitante;
    @NotNull
    private String motivo;
    private Integer tipoSer;
    public Integer getOf() {
        return of;
    }

    public void setOf(Integer of) {
        this.of = of;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public Integer getCodigoTipoEntrega() {
        return codigoTipoEntrega;
    }

    public void setCodigoTipoEntrega(Integer codigoTipoEntrega) {
        this.codigoTipoEntrega = codigoTipoEntrega;
    }

    public Integer getCodigoAgenciaDestino() {
        return codigoAgenciaDestino;
    }

    public void setCodigoAgenciaDestino(Integer codigoAgenciaDestino) {
        this.codigoAgenciaDestino = codigoAgenciaDestino;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getNumeracionDestino() {
        return numeracionDestino;
    }

    public void setNumeracionDestino(String numeracionDestino) {
        this.numeracionDestino = numeracionDestino;
    }

    public String getDepartamentoDestino() {
        return departamentoDestino;
    }

    public void setDepartamentoDestino(String departamentoDestino) {
        this.departamentoDestino = departamentoDestino;
    }

    public Integer getCodigoComunaDestinatario() {
        return codigoComunaDestinatario;
    }

    public void setCodigoComunaDestinatario(Integer codigoComunaDestinatario) {
        this.codigoComunaDestinatario = codigoComunaDestinatario;
    }

    public String getNombreComunaDestinatario() {
        return nombreComunaDestinatario;
    }

    public void setNombreComunaDestinatario(String nombreComunaDestinatario) {
        this.nombreComunaDestinatario = nombreComunaDestinatario;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "OrdenFleteRequest{" + "of=" + of + ", telefonoDestinatario=" + telefonoDestinatario + ", codigoTipoEntrega=" + codigoTipoEntrega + ", codigoAgenciaDestino=" + codigoAgenciaDestino + ", direccionDestino=" + direccionDestino + ", numeracionDestino=" + numeracionDestino + ", departamentoDestino=" + departamentoDestino + ", codigoComunaDestinatario=" + codigoComunaDestinatario + ", nombreComunaDestinatario=" + nombreComunaDestinatario + ", solicitante=" + solicitante + ", motivo=" + motivo + ", tipoSer=" + tipoSer + '}';
    }
}
