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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egt
 */
@Entity
@Table(name = "Destinatario")
@XmlRootElement 
public class DestinatarioRedestinaAgencia  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "DESTRUT")
    private Integer rutDestinatario;
    @Column(name = "DESTDV")
    private String digitoVerificadorDestinatario;
    @Column(name = "DESTNOMBRES")
    private String nombresDestinatario;
    @Column(name = "DESTAPELLIDOP")
    private String apellidoPaternoDestinatario;
    @Column(name = "DESTAPELLIDOM")
    private String apellidoMaternoDestinatario;
    @Column(name = "DESTTELEFONO")
    private String telefonoDestinatario;
    
    @Column(name = "DESTDIRECCION")
    private String direccionDestinatario;
    @Column(name = "DESTNUMERACION")
    private String numeracion;
    
    @Column(name = "DESTEMAIL")
    private String email;
    
     @Column(name = "DESTDEPARTAMENTO")
    private String departamento;
    
       @Column(name = "DESTRAZONSOCIAL")
    private String razonSocialDestinatario;
 
    @Column(name = "DESTNOMBRECONTACTO")
    private String nombreContactoDestinatario;
    
    
    @Column(name = "CODIGOCOMUNADESTINATARIO")
    private Integer codigoComunaDestinatario;
    
    @Column(name = "COMUNADESTINATARIO")
    private String nombreComunaDestinatario;

    public void setRutDestinatario(Integer rutDestinatario) {
        this.rutDestinatario = rutDestinatario;
    }

    public void setDigitoVerificadorDestinatario(String digitoVerificadorDestinatario) {
        this.digitoVerificadorDestinatario = digitoVerificadorDestinatario;
    }

    public void setNombresDestinatario(String nombresDestinatario) {
        this.nombresDestinatario = nombresDestinatario;
    }

    public void setApellidoPaternoDestinatario(String apellidoPaternoDestinatario) {
        this.apellidoPaternoDestinatario = apellidoPaternoDestinatario;
    }

    public void setApellidoMaternoDestinatario(String apellidoMaternoDestinatario) {
        this.apellidoMaternoDestinatario = apellidoMaternoDestinatario;
    }

    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setRazonSocialDestinatario(String razonSocialDestinatario) {
        this.razonSocialDestinatario = razonSocialDestinatario;
    }

    public void setNombreContactoDestinatario(String nombreContactoDestinatario) {
        this.nombreContactoDestinatario = nombreContactoDestinatario;
    }

    public void setCodigoComunaDestinatario(Integer codigoComunaDestinatario) {
        this.codigoComunaDestinatario = codigoComunaDestinatario;
    }

    public void setNombreComunaDestinatario(String nombreComunaDestinatario) {
        this.nombreComunaDestinatario = nombreComunaDestinatario;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRutDestinatario() {
        return rutDestinatario;
    }

    public String getDigitoVerificadorDestinatario() {
        return digitoVerificadorDestinatario;
    }

    public String getNombresDestinatario() {
        return nombresDestinatario;
    }

    public String getApellidoPaternoDestinatario() {
        return apellidoPaternoDestinatario;
    }

    public String getApellidoMaternoDestinatario() {
        return apellidoMaternoDestinatario;
    }

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getRazonSocialDestinatario() {
        return razonSocialDestinatario;
    }

    public String getNombreContactoDestinatario() {
        return nombreContactoDestinatario;
    }

    public Integer getCodigoComunaDestinatario() {
        return codigoComunaDestinatario;
    }

    public String getNombreComunaDestinatario() {
        return nombreComunaDestinatario;
    }

    
    
}

