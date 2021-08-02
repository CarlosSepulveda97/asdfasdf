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
 * @author egt
 */
@Entity
@Table(name = "ResumeTracking")
@XmlRootElement
public class ResumeTrackingResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ODFLCODIGO")
    private Integer of;
    @Column(name = "ODFLFECHEMICORTA")
    private Date fechaEmision;
    @Column(name = "ODFLFECHENTREST")
    private Date fechaCompromiso;
    @Column(name = "REMIRUT")
    private Integer rutRemitente;
    @Column(name = "REMINOMBRES")
    private String nombresRemitente;
    @Column(name = "REMIAPELLIDOP")
    private String apellidoPaternoRemitente;
    @Column(name = "REMIAPELLIDOM")
    private String apellidoMaternoRemitente;
    @Column(name = "REMIRAZONSOCIAL")
    private String razonSocialRemitente;
    @Column(name = "REMIRUTEMPRESA")
    private String remiRutEmpresa;
    @Column(name = "DESTRUT")
    private Integer rutDestinatario;
    @Column(name = "DESTNOMBRES")
    private String nombresDestinatario;
    @Column(name = "DESTAPELLIDOP")
    private String apellidoPaternoDestinatario;
    @Column(name = "DESTAPELLIDOM")
    private String apellidoMaternoDestinatario;
    @Column(name = "DESTRAZONSOCIAL")
    private String razonSocialDestinatario;
    @Column(name = "CODIGOCIUDADORIGEN")
    private String codigoCiudadOrigen;
    @Column(name = "CIUDORIGEN")
    private String ciudadOrigen;
    @Column(name = "CODIGOCIUDADDESTINO")
    private String codigoCiudadDestino;
    @Column(name = "CIUDDESTINO")
    private String ciudadDestino;
    @Column(name = "TENTCODIGO")
    private String codigoTipoEntrega;
    @Column(name = "TENTNOMBRE")
    private String tipoEntrega;
    @Column(name = "EPROCODIGO")
    private String codigoEstado;
    @Column(name = "EPRODESCRIPCION")
    private String estado;
    @Column(name = "RECLFOLIO")
    private Integer reclamo;
    @Column(name = "SOLICODIGO")
    private String redestinacion;
    @Column(name = "DCTOADJUNTO")
    private String dctoAdjunto;
    @Column(name = "DCTOADJUNTOSINENC")
    private String dctoAdjuntoSinEnc;
    @Column(name = "NUMEROCTACTE")
    private String numctacte;
    @Column(name = "DVCTACTE")
    private String dvdCtaCte;
    
    public Integer getOf() {
        return of;
    }

    public void setOf(Integer of) {
        this.of = of;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCompromiso() {
        return fechaCompromiso;
    }

    public void setFechaCompromiso(Date fechaCompromiso) {
        this.fechaCompromiso = fechaCompromiso;
    }

    public Integer getRutRemitente() {
        return rutRemitente;
    }

    public void setRutRemitente(Integer rutRemitente) {
        this.rutRemitente = rutRemitente;
    }

    public String getNombresRemitente() {
        return nombresRemitente;
    }

    public void setNombresRemitente(String nombresRemitente) {
        this.nombresRemitente = nombresRemitente;
    }

    public String getApellidoPaternoRemitente() {
        return apellidoPaternoRemitente;
    }

    public void setApellidoPaternoRemitente(String apellidoPaternoRemitente) {
        this.apellidoPaternoRemitente = apellidoPaternoRemitente;
    }

    public String getApellidoMaternoRemitente() {
        return apellidoMaternoRemitente;
    }

    public void setApellidoMaternoRemitente(String apellidoMaternoRemitente) {
        this.apellidoMaternoRemitente = apellidoMaternoRemitente;
    }

    public String getRazonSocialRemitente() {
        return razonSocialRemitente;
    }

    public void setRazonSocialRemitente(String razonSocialRemitente) {
        this.razonSocialRemitente = razonSocialRemitente;
    }

    public Integer getRutDestinatario() {
        return rutDestinatario;
    }

    public void setRutDestinatario(Integer rutDestinatario) {
        this.rutDestinatario = rutDestinatario;
    }

    public String getNombresDestinatario() {
        return nombresDestinatario;
    }

    public void setNombresDestinatario(String nombresDestinatario) {
        this.nombresDestinatario = nombresDestinatario;
    }

    public String getApellidoPaternoDestinatario() {
        return apellidoPaternoDestinatario;
    }

    public void setApellidoPaternoDestinatario(String apellidoPaternoDestinatario) {
        this.apellidoPaternoDestinatario = apellidoPaternoDestinatario;
    }

    public String getApellidoMaternoDestinatario() {
        return apellidoMaternoDestinatario;
    }

    public void setApellidoMaternoDestinatario(String apellidoMaternoDestinatario) {
        this.apellidoMaternoDestinatario = apellidoMaternoDestinatario;
    }

    public String getRazonSocialDestinatario() {
        return razonSocialDestinatario;
    }

    public void setRazonSocialDestinatario(String razonSocialDestinatario) {
        this.razonSocialDestinatario = razonSocialDestinatario;
    }

    public String getCodigoCiudadOrigen() {
        return codigoCiudadOrigen;
    }

    public void setCodigoCiudadOrigen(String codigoCiudadOrigen) {
        this.codigoCiudadOrigen = codigoCiudadOrigen;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCodigoCiudadDestino() {
        return codigoCiudadDestino;
    }

    public void setCodigoCiudadDestino(String codigoCiudadDestino) {
        this.codigoCiudadDestino = codigoCiudadDestino;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getCodigoTipoEntrega() {
        return codigoTipoEntrega;
    }

    public void setCodigoTipoEntrega(String codigoTipoEntrega) {
        this.codigoTipoEntrega = codigoTipoEntrega;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getReclamo() {
        return reclamo;
    }

    public void setReclamo(Integer reclamo) {
        this.reclamo = reclamo;
    }

    public String getRedestinacion() {
        return redestinacion;
    }

    public void setRedestinacion(String redestinacion) {
        this.redestinacion = redestinacion;
    }
    
    public String getRemiRutEmpresa() {
        return this.remiRutEmpresa;
    }
    
    public void setRemiRutEmpresa(String remiRutEmpresa) {
        this.remiRutEmpresa = remiRutEmpresa;
    }
    
    public String getDctoAdjunto() {
        return this.dctoAdjunto;
    }
    
    public void setDctoAdjunto(String dctoAdjunto) {
        this.dctoAdjunto = dctoAdjunto;
    }
    
    public String getDctoAdjuntoSinEnc() {
        return this.dctoAdjuntoSinEnc;
    }
    
    public void setDctoAdjuntoSinEnc(String dctoAdjuntoSinEnc) {
        this.dctoAdjuntoSinEnc = dctoAdjuntoSinEnc;
    }
    
    public String getNumctacte() {
        return this.numctacte;
    }
    
    public void setNumctacte(String numctacte) {
        this.numctacte = numctacte;
    }
    
    public String getDvdCtaCte() {
        return this.dvdCtaCte;
    }
    
    public void setDvdCtaCte(String dvdCtaCte) {
        this.dvdCtaCte = dvdCtaCte;
    }

    @Override
    public String toString() {
        return "ResumeTrackingResponse{" + "of=" + of + ", fechaEmision=" + fechaEmision + ", fechaCompromiso=" + fechaCompromiso + ", rutRemitente=" + rutRemitente + ", nombresRemitente=" + nombresRemitente + ", apellidoPaternoRemitente=" + apellidoPaternoRemitente + ", apellidoMaternoRemitente=" + apellidoMaternoRemitente + ", razonSocialRemitente=" + razonSocialRemitente + ", remiRutEmpresa=" + remiRutEmpresa + ", rutDestinatario=" + rutDestinatario + ", nombresDestinatario=" + nombresDestinatario + ", apellidoPaternoDestinatario=" + apellidoPaternoDestinatario + ", apellidoMaternoDestinatario=" + apellidoMaternoDestinatario + ", razonSocialDestinatario=" + razonSocialDestinatario + ", codigoCiudadOrigen=" + codigoCiudadOrigen + ", ciudadOrigen=" + ciudadOrigen + ", codigoCiudadDestino=" + codigoCiudadDestino + ", ciudadDestino=" + ciudadDestino + ", codigoTipoEntrega=" + codigoTipoEntrega + ", tipoEntrega=" + tipoEntrega + ", codigoEstado=" + codigoEstado + ", estado=" + estado + ", reclamo=" + reclamo + ", redestinacion=" + redestinacion + ", dctoAdjunto=" + dctoAdjunto + ", dctoAdjuntoSinEnc=" + dctoAdjuntoSinEnc + ", numctacte=" + numctacte + ", dvdCtaCte=" + dvdCtaCte + '}';
    }
}
