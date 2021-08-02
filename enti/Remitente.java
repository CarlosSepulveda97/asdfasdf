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
@Table(name = "Remitente")
@XmlRootElement
public class Remitente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "REMIRUT")
    private Integer rutRemitente;
    @Column(name = "REMIDV")
    private String digitoVerificadorRemitente;
    @Column(name = "REMINOMBRES")
    private String nombresRemitente;
    @Column(name = "REMIAPELLIDOP")
    private String apellidoPaternoRemitente;
    @Column(name = "REMIAPELLIDOM")
    private String apellidoMaternoRemitente;
    @Column(name = "REMITELEFONO")
    private String telefonoRemitente;
    @Column(name = "REMIDIRECCION")
    private String direccionRemitente;
    @Column(name = "REMINUMERACION")
    private String numeracionRemitente;
    @Column(name = "REMIEMAIL")
    private String emailRemitente;
    @Column(name = "REMIDEPARTAMENTO")
    private String departamentoRemitente;
    @Column(name = "REMIRAZONSOCIAL")
    private String razonSocialRemitente;
    @Column(name = "REMIRUTEMPRESA")
    private Integer rutEmpresaRemitente;
    @Column(name = "CODIGOCOMUNAREMITENTE")
    private Integer codigoComunaRemitente;
    @Column(name = "COMUNAREMITENTE")
    private String nombreComunaRemitente;
    @Column(name = "CIUDCODIGO")
    private Integer codigoCiudadRemitente;
    @Column(name = "CIUDNOMBRE")
    private String nombreCiudadRemitente;

    public Integer getRutRemitente() {
        return rutRemitente;
    }

    public void setRutRemitente(Integer rutRemitente) {
        this.rutRemitente = rutRemitente;
    }

    public String getDigitoVerificadorRemitente() {
        return digitoVerificadorRemitente;
    }

    public void setDigitoVerificadorRemitente(String digitoVerificadorRemitente) {
        this.digitoVerificadorRemitente = digitoVerificadorRemitente;
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

    public String getTelefonoRemitente() {
        return telefonoRemitente;
    }

    public void setTelefonoRemitente(String telefonoRemitente) {
        this.telefonoRemitente = telefonoRemitente;
    }

    public String getDireccionRemitente() {
        return direccionRemitente;
    }

    public void setDireccionRemitente(String direccionRemitente) {
        this.direccionRemitente = direccionRemitente;
    }

    public String getNumeracionRemitente() {
        return numeracionRemitente;
    }

    public void setNumeracionRemitente(String numeracionRemitente) {
        this.numeracionRemitente = numeracionRemitente;
    }

    public String getEmailRemitente() {
        return emailRemitente;
    }

    public void setEmailRemitente(String emailRemitente) {
        this.emailRemitente = emailRemitente;
    }

    public String getDepartamentoRemitente() {
        return departamentoRemitente;
    }

    public void setDepartamentoRemitente(String departamentoRemitente) {
        this.departamentoRemitente = departamentoRemitente;
    }

    public String getRazonSocialRemitente() {
        return razonSocialRemitente;
    }

    public void setRazonSocialRemitente(String razonSocialRemitente) {
        this.razonSocialRemitente = razonSocialRemitente;
    }

    public Integer getRutEmpresaRemitente() {
        return rutEmpresaRemitente;
    }

    public void setRutEmpresaRemitente(Integer rutEmpresaRemitente) {
        this.rutEmpresaRemitente = rutEmpresaRemitente;
    }

    public Integer getCodigoComunaRemitente() {
        return codigoComunaRemitente;
    }

    public void setCodigoComunaRemitente(Integer codigoComunaRemitente) {
        this.codigoComunaRemitente = codigoComunaRemitente;
    }

    public String getNombreComunaRemitente() {
        return nombreComunaRemitente;
    }

    public void setNombreComunaRemitente(String nombreComunaRemitente) {
        this.nombreComunaRemitente = nombreComunaRemitente;
    }

    public Integer getCodigoCiudadRemitente() {
        return codigoCiudadRemitente;
    }

    public void setCodigoCiudadRemitente(Integer codigoCiudadRemitente) {
        this.codigoCiudadRemitente = codigoCiudadRemitente;
    }

    public String getNombreCiudadRemitente() {
        return nombreCiudadRemitente;
    }

    public void setNombreCiudadRemitente(String nombreCiudadRemitente) {
        this.nombreCiudadRemitente = nombreCiudadRemitente;
    }

    @Override
    public String toString() {
        return "Remitente{" + "rutRemitente=" + rutRemitente + ", digitoVerificadorRemitente=" + digitoVerificadorRemitente + ", nombresRemitente=" + nombresRemitente + ", apellidoPaternoRemitente=" + apellidoPaternoRemitente + ", apellidoMaternoRemitente=" + apellidoMaternoRemitente + ", telefonoRemitente=" + telefonoRemitente + ", direccionRemitente=" + direccionRemitente + ", numeracionRemitente=" + numeracionRemitente + ", emailRemitente=" + emailRemitente + ", departamentoRemitente=" + departamentoRemitente + ", razonSocialRemitente=" + razonSocialRemitente + ", rutEmpresaRemitente=" + rutEmpresaRemitente + ", codigoComunaRemitente=" + codigoComunaRemitente + ", nombreComunaRemitente=" + nombreComunaRemitente + ", codigoCiudadRemitente=" + codigoCiudadRemitente + ", nombreCiudadRemitente=" + nombreCiudadRemitente + '}';
    }
}
