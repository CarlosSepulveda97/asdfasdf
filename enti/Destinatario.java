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
public class Destinatario implements Serializable {

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
    @Column(name = "DESTRAZONSOCIAL")
    private String razonSocialDestinatario;
    @Column(name = "DESTNOMBRECONTACTO")
    private String nombreContactoDestinatario;
    @Column(name = "CODIGOCOMUNADESTINATARIO")
    private Integer codigoComunaDestinatario;
    @Column(name = "COMUNADESTINATARIO")
    private String nombreComunaDestinatario;
    //adiciones
    

    public Integer getRutDestinatario() {
        return rutDestinatario;
    }

    public void setRutDestinatario(Integer rutDestinatario) {
        this.rutDestinatario = rutDestinatario;
    }

    public String getDigitoVerificadorDestinatario() {
        return digitoVerificadorDestinatario;
    }

    public void setDigitoVerificadorDestinatario(String digitoVerificadorDestinatario) {
        this.digitoVerificadorDestinatario = digitoVerificadorDestinatario;
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

    public String getTelefonoDestinatario() {
        return telefonoDestinatario;
    }

    public void setTelefonoDestinatario(String telefonoDestinatario) {
        this.telefonoDestinatario = telefonoDestinatario;
    }

    public String getRazonSocialDestinatario() {
        return razonSocialDestinatario;
    }

    public void setRazonSocialDestinatario(String razonSocialDestinatario) {
        this.razonSocialDestinatario = razonSocialDestinatario;
    }

    public String getNombreContactoDestinatario() {
        return nombreContactoDestinatario;
    }

    public void setNombreContactoDestinatario(String nombreContactoDestinatario) {
        this.nombreContactoDestinatario = nombreContactoDestinatario;
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

    @Override
    public String toString() {
        return "Destinatario{" + "rutDestinatario=" + rutDestinatario + ", digitoVerificadorDestinatario=" + digitoVerificadorDestinatario + ", nombresDestinatario=" + nombresDestinatario + ", apellidoPaternoDestinatario=" + apellidoPaternoDestinatario + ", apellidoMaternoDestinatario=" + apellidoMaternoDestinatario + ", telefonoDestinatario=" + telefonoDestinatario + ", razonSocialDestinatario=" + razonSocialDestinatario + ", nombreContactoDestinatario=" + nombreContactoDestinatario + ", codigoComunaDestinatario=" + codigoComunaDestinatario + ", nombreComunaDestinatario=" + nombreComunaDestinatario + '}';
    }
}
