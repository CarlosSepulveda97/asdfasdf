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
public class DatosReclamanteBean extends IngresoReclamoBean {

    Integer reclamante; // 0 remitente 1 destinatario
    Integer personaEmmpresa; //0 persona 1 empresa
    Integer rutReclamante;
    String dvReclamante;
    String nombres;
    String apellidoPaterno;
    String apellidoMaterno;
    String direccion;
    Integer codCiudad;
    Integer codComuna;
    String Telefono;
    String email;
    Integer reclamoSernac;
    String informeComplementario;
    String imagenUrl;

    public Integer getReclamante() {
        return reclamante;
    }

    public void setReclamante(Integer reclamante) {
        this.reclamante = reclamante;
    }

    public Integer getPersonaEmmpresa() {
        return personaEmmpresa;
    }

    public void setPersonaEmmpresa(Integer personaEmmpresa) {
        this.personaEmmpresa = personaEmmpresa;
    }

    public Integer getRutReclamante() {
        return rutReclamante;
    }

    public void setRutReclamante(Integer rutReclamante) {
        this.rutReclamante = rutReclamante;
    }

    public String getDvReclamante() {
        return dvReclamante;
    }

    public void setDvReclamante(String dvReclamante) {
        this.dvReclamante = dvReclamante;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }

    public Integer getCodComuna() {
        return codComuna;
    }

    public void setCodComuna(Integer codComuna) {
        this.codComuna = codComuna;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getReclamoSernac() {
        return reclamoSernac;
    }

    public void setReclamoSernac(Integer reclamoSernac) {
        this.reclamoSernac = reclamoSernac;
    }

    @Override
    public void setMonto(long monto) {
        super.setMonto(monto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getMonto() {
        return super.getMonto(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setOrdenFlete(Integer ordenFlete) {
        super.setOrdenFlete(ordenFlete); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getOrdenFlete() {
        return super.getOrdenFlete(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCodMotivo(Integer codMotivo) {
        super.setCodMotivo(codMotivo); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getCodMotivo() {
        return super.getCodMotivo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFecha(String fecha) {
        super.setFecha(fecha); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFecha() {
        return super.getFecha(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFolio(Integer folio) {
        super.setFolio(folio); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getFolio() {
        return super.getFolio(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getInformeComplementario() {
        return informeComplementario;
    }

    public void setInformeComplementario(String informeComplementario) {
        this.informeComplementario = informeComplementario;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    @Override
    public String toString() {
        return "DatosReclamanteBean{" + "reclamante=" + reclamante + ", personaEmmpresa=" + personaEmmpresa + ", rutReclamante=" + rutReclamante + ", dvReclamante=" + dvReclamante + ", nombres=" + nombres + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", direccion=" + direccion + ", codCiudad=" + codCiudad + ", codComuna=" + codComuna + ", Telefono=" + Telefono + ", email=" + email + ", reclamoSernac=" + reclamoSernac + ", informeComplementario=" + informeComplementario + ", imagenUrl=" + imagenUrl + '}';
    }
}
