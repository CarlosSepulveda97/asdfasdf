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
@Table(name = "OrdenFleteDetalleTracking")
@XmlRootElement
public class OrdenFleteDetalleTracking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ODFLCODIGO")
    private Integer of;
    @Column(name = "ODFLFECHEMICORTA")
    private Date fechaEmision;
    @Column(name = "ODFLFECHENTREST")
    private Date fechaCompromiso;

    @Column(name = "CODIGOCIUDADORIGEN")
    private Integer codigoCiudadOrigen;
    @Column(name = "CIUDADORIGEN")
    private String ciudadOrigen;
    @Column(name = "CODIGOAGENCIAORIGEN")
    private Integer codigoAgenciaOrigen;
    @Column(name = "AGENORIGENDESCRIPCION")
    private String descripcionAgenciaOrigen;
    @Column(name = "CODIGOCIUDADDESTINO")
    private Integer codigoCiudadDestino;
    @Column(name = "CIUDADDESTINO")
    private String ciudadDestino;
    @Column(name = "CODIGOAGENCIADESTINO")
    private Integer codigoAgenciaDestino;
    @Column(name = "AGENDESTINODESCRIPCION")
    private String descripcionAgenciaDestino;
    @Column(name = "TENTCODIGO")
    private Integer codigoTipoEntrega;
    @Column(name = "TENTNOMBRE")
    private String tipoEntrega;
    @Column(name = "TEMICODIGO")
    private Integer codigoTipoEmision;
    @Column(name = "TEMINOMBRE")
    private String nombreTipoEmision;
    @Column(name = "DESTDIRECCION")
    private String direccionDestino;
    @Column(name = "DESTNUMERACION")
    private String numeracionDestino;
    @Column(name = "DESTEMAIL")
    private String emailDestino;
    @Column(name = "DESTDEPARTAMENTO")
    private String departamentoDestino;
    @Column(name = "TPAGCODIGO")
    private int codigoTipoPago;
    @Column(name = "TPAGNOMBRE")
    private String nombreTipoPago;
    @Column(name = "ODFLTOTALOF")
    private Integer totalFlete;
    @Column(name = "CANTIDADBULTOS")
    private Integer totalEncargosOrdenFlete;
    @Column(name = "TSERCODIGO")
    private String codigoTipoServicio;
    @Column(name = "TSERNOMBRE")
    private String nombreTipoServicio;
    @Column(name = "FECHAENTREGA")
    private Date fechaEntrega;
    @Column(name = "HORAENTREGA")
    private Date horaEntrega;
    @Column(name = "NOMBRERECIBE")
    private String nombreRecepcion;
    @Column(name = "APEPRECIBE")
    private String apellidoPaternoRecepcion;
    @Column(name = "APEMRECIBE")
    private String apellidoMaternoRecepcion;
    @Column(name = "CCORCODIGO")
    private Integer codigoCuentaCorriente;
    @Column(name = "CCORNUMERO")
    private Integer numeroCuentaCorriente;
    @Column(name = "CCORDV")
    private String digitoVerificadorCuentaCorriente;
    @Column(name = "CTARUTEMPRESA")
    private Integer rutEmpresaCuentaCorriente;
    @Column(name = "CENTROCOSTO")
    private String centroCosto;
    @Column(name = "OFANTIGUA")
    private String ordenFleteAntigua;
    @Column(name = "OFNUEVA")
    private String ordenFleteNueva;
    @Column(name = "RUTRECIBE")
    private Integer rutRecepcion;
    @Column(name = "DVRECIBE")
    private String digitoVerificadorRecepcion;
    @Column(name = "EPROCODIGO")
    private Integer codigoEstado;
    @Column(name = "EPRODESCRIPCION")
    private String estado;

    @Column(name = "CODIGOREDESTINACION")
    private Integer redestinacion;

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Date horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getNombreRecepcion() {
        return nombreRecepcion;
    }

    public void setNombreRecepcion(String nombreRecepcion) {
        this.nombreRecepcion = nombreRecepcion;
    }

    public String getApellidoPaternoRecepcion() {
        return apellidoPaternoRecepcion;
    }

    public void setApellidoPaternoRecepcion(String apellidoPaternoRecepcion) {
        this.apellidoPaternoRecepcion = apellidoPaternoRecepcion;
    }

    public String getApellidoMaternoRecepcion() {
        return apellidoMaternoRecepcion;
    }

    public void setApellidoMaternoRecepcion(String apellidoMaternoRecepcion) {
        this.apellidoMaternoRecepcion = apellidoMaternoRecepcion;
    }

    public String getNombreTipoPago() {
        return nombreTipoPago;
    }

    public void setNombreTipoPago(String nombreTipoPago) {
        this.nombreTipoPago = nombreTipoPago;
    }

    public Integer getTotalEncargosOrdenFlete() {
        return totalEncargosOrdenFlete;
    }

    public void setTotalEncargosOrdenFlete(Integer totalEncargosOrdenFlete) {
        this.totalEncargosOrdenFlete = totalEncargosOrdenFlete;
    }

    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }

    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(String tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
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

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDescripcionAgenciaOrigen() {
        return descripcionAgenciaOrigen;
    }

    public void setDescripcionAgenciaOrigen(String descripcionAgenciaOrigen) {
        this.descripcionAgenciaOrigen = descripcionAgenciaOrigen;
    }

    public Integer getCodigoCiudadOrigen() {
        return codigoCiudadOrigen;
    }

    public void setCodigoCiudadOrigen(Integer codigoCiudadOrigen) {
        this.codigoCiudadOrigen = codigoCiudadOrigen;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

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

    public int getCodigoTipoPago() {
        return codigoTipoPago;
    }

    public void setCodigoTipoPago(int codigoTipoPago) {
        this.codigoTipoPago = codigoTipoPago;
    }

    public Integer getTotalFlete() {
        return totalFlete;
    }

    public void setTotalFlete(Integer totalFlete) {
        this.totalFlete = totalFlete;
    }

    public String getNombreTipoEmision() {
        return nombreTipoEmision;
    }

    public void setNombreTipoEmision(String nombreTipoEmision) {
        this.nombreTipoEmision = nombreTipoEmision;
    }

    public String getCodigoTipoServicio() {
        return codigoTipoServicio;
    }

    public void setCodigoTipoServicio(String codigoTipoServicio) {
        this.codigoTipoServicio = codigoTipoServicio;
    }

    public Integer getCodigoCuentaCorriente() {
        return codigoCuentaCorriente;
    }

    public void setCodigoCuentaCorriente(Integer codigoCuentaCorriente) {
        this.codigoCuentaCorriente = codigoCuentaCorriente;
    }

    public Integer getNumeroCuentaCorriente() {
        return numeroCuentaCorriente;
    }

    public void setNumeroCuentaCorriente(Integer numeroCuentaCorriente) {
        this.numeroCuentaCorriente = numeroCuentaCorriente;
    }

    public String getDigitoVerificadorCuentaCorriente() {
        return digitoVerificadorCuentaCorriente;
    }

    public void setDigitoVerificadorCuentaCorriente(String digitoVerificadorCuentaCorriente) {
        this.digitoVerificadorCuentaCorriente = digitoVerificadorCuentaCorriente;
    }

    public Integer getRutEmpresaCuentaCorriente() {
        return rutEmpresaCuentaCorriente;
    }

    public void setRutEmpresaCuentaCorriente(Integer rutEmpresaCuentaCorriente) {
        this.rutEmpresaCuentaCorriente = rutEmpresaCuentaCorriente;
    }

    public String getCentroCosto() {
        return centroCosto;
    }

    public void setCentroCosto(String centroCosto) {
        this.centroCosto = centroCosto;
    }

    public String getOrdenFleteAntigua() {
        return ordenFleteAntigua;
    }

    public void setOrdenFleteAntigua(String ordenFleteAntigua) {
        this.ordenFleteAntigua = ordenFleteAntigua;
    }

    public String getOrdenFleteNueva() {
        return ordenFleteNueva;
    }

    public void setOrdenFleteNueva(String ordenFleteNueva) {
        this.ordenFleteNueva = ordenFleteNueva;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public void setEmailDestino(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    public String getDescripcionAgenciaDestino() {
        return descripcionAgenciaDestino;
    }

    public void setDescripcionAgenciaDestino(String descripcionAgenciaDestino) {
        this.descripcionAgenciaDestino = descripcionAgenciaDestino;
    }

    public Integer getRutRecepcion() {
        return rutRecepcion;
    }

    public void setRutRecepcion(Integer rutRecepcion) {
        this.rutRecepcion = rutRecepcion;
    }

    public String getDigitoVerificadorRecepcion() {
        return digitoVerificadorRecepcion;
    }

    public void setDigitoVerificadorRecepcion(String digitoVerificadorRecepcion) {
        this.digitoVerificadorRecepcion = digitoVerificadorRecepcion;
    }

    public Integer getCodigoAgenciaOrigen() {
        return codigoAgenciaOrigen;
    }

    public void setCodigoAgenciaOrigen(Integer codigoAgenciaOrigen) {
        this.codigoAgenciaOrigen = codigoAgenciaOrigen;
    }

    public Integer getCodigoCiudadDestino() {
        return codigoCiudadDestino;
    }

    public void setCodigoCiudadDestino(Integer codigoCiudadDestino) {
        this.codigoCiudadDestino = codigoCiudadDestino;
    }

    public Integer getCodigoAgenciaDestino() {
        return codigoAgenciaDestino;
    }

    public void setCodigoAgenciaDestino(Integer codigoAgenciaDestino) {
        this.codigoAgenciaDestino = codigoAgenciaDestino;
    }

    public Integer getCodigoTipoEntrega() {
        return codigoTipoEntrega;
    }

    public void setCodigoTipoEntrega(Integer codigoTipoEntrega) {
        this.codigoTipoEntrega = codigoTipoEntrega;
    }

    public Integer getCodigoTipoEmision() {
        return codigoTipoEmision;
    }

    public void setCodigoTipoEmision(Integer codigoTipoEmision) {
        this.codigoTipoEmision = codigoTipoEmision;
    }

    public Integer getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Integer codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public Integer getRedestinacion() {
        return redestinacion;
    }

    public void setRedestinacion(Integer redestinacion) {
        this.redestinacion = redestinacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "OrdenFleteDetalleTracking{" + "of=" + of + ", fechaEmision=" + fechaEmision + ", fechaCompromiso=" + fechaCompromiso + ", codigoCiudadOrigen=" + codigoCiudadOrigen + ", ciudadOrigen=" + ciudadOrigen + ", codigoAgenciaOrigen=" + codigoAgenciaOrigen + ", descripcionAgenciaOrigen=" + descripcionAgenciaOrigen + ", codigoCiudadDestino=" + codigoCiudadDestino + ", ciudadDestino=" + ciudadDestino + ", codigoAgenciaDestino=" + codigoAgenciaDestino + ", descripcionAgenciaDestino=" + descripcionAgenciaDestino + ", codigoTipoEntrega=" + codigoTipoEntrega + ", tipoEntrega=" + tipoEntrega + ", codigoTipoEmision=" + codigoTipoEmision + ", nombreTipoEmision=" + nombreTipoEmision + ", direccionDestino=" + direccionDestino + ", numeracionDestino=" + numeracionDestino + ", emailDestino=" + emailDestino + ", departamentoDestino=" + departamentoDestino + ", codigoTipoPago=" + codigoTipoPago + ", nombreTipoPago=" + nombreTipoPago + ", totalFlete=" + totalFlete + ", totalEncargosOrdenFlete=" + totalEncargosOrdenFlete + ", codigoTipoServicio=" + codigoTipoServicio + ", nombreTipoServicio=" + nombreTipoServicio + ", fechaEntrega=" + fechaEntrega + ", horaEntrega=" + horaEntrega + ", nombreRecepcion=" + nombreRecepcion + ", apellidoPaternoRecepcion=" + apellidoPaternoRecepcion + ", apellidoMaternoRecepcion=" + apellidoMaternoRecepcion + ", codigoCuentaCorriente=" + codigoCuentaCorriente + ", numeroCuentaCorriente=" + numeroCuentaCorriente + ", digitoVerificadorCuentaCorriente=" + digitoVerificadorCuentaCorriente + ", rutEmpresaCuentaCorriente=" + rutEmpresaCuentaCorriente + ", centroCosto=" + centroCosto + ", ordenFleteAntigua=" + ordenFleteAntigua + ", ordenFleteNueva=" + ordenFleteNueva + ", rutRecepcion=" + rutRecepcion + ", digitoVerificadorRecepcion=" + digitoVerificadorRecepcion + ", codigoEstado=" + codigoEstado + ", estado=" + estado + ", redestinacion=" + redestinacion + '}';
    }
}
