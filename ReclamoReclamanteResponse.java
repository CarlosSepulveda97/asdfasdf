/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

 
import java.util.Date;
import cl.egt.apirest.service.ReclamoPasoDosService;

/**
 *
 * @author ricardo.leal
 */
public class ReclamoReclamanteResponse  extends DatosReclamanteBean    {

    
    private int codRespuesta;
    private String DescRespuesta;

    private Integer folio;
    private Date fecha;
    private Integer codMotivo;
    private Integer ordenFlete;
    private long monto; 

    public Date getdFecha() {
        return fecha;
    }

    public void setdFecha(Date dFecha) {
        this.fecha = dFecha;
    }

    public int getCodRespuesta() {
        return codRespuesta;
    }

    public String getDescRespuesta() {
        return DescRespuesta;
    }

    public Integer getFolio() {
        return folio;
    }

 

    public Integer getCodMotivo() {
        return codMotivo;
    }

    public Integer getOrdenFlete() {
        return ordenFlete;
    }

   
    public long getMonto() {
        return monto;
    }

    public Integer getReclamante() {
        return reclamante;
    }

    public Integer getPersonaEmmpresa() {
        return personaEmmpresa;
    }

    public Integer getRutReclamante() {
        return rutReclamante;
    }

    public String getDvReclamante() {
        return dvReclamante;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getCodCiudad() {
        return codCiudad;
    }

    public Integer getCodComuna() {
        return codComuna;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getEmail() {
        return email;
    }

    public Integer getReclamoSernac() {
        return reclamoSernac;
    }

    public void setCodRespuesta(int codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public void setDescRespuesta(String DescRespuesta) {
        this.DescRespuesta = DescRespuesta;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

  

    public void setCodMotivo(Integer codMotivo) {
        this.codMotivo = codMotivo;
    }

    public void setOrdenFlete(Integer ordenFlete) {
        this.ordenFlete = ordenFlete;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public void setReclamante(Integer reclamante) {
        this.reclamante = reclamante;
    }

    public void setPersonaEmmpresa(Integer personaEmmpresa) {
        this.personaEmmpresa = personaEmmpresa;
    }

    public void setRutReclamante(Integer rutReclamante) {
        this.rutReclamante = rutReclamante;
    }

    public void setDvReclamante(String dvReclamante) {
        this.dvReclamante = dvReclamante;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodCiudad(Integer codCiudad) {
        this.codCiudad = codCiudad;
    }

    public void setCodComuna(Integer codComuna) {
        this.codComuna = codComuna;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setReclamoSernac(Integer reclamoSernac) {
        this.reclamoSernac = reclamoSernac;
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
        return "ReclamoReclamanteResponse{" + "codRespuesta=" + codRespuesta + ", DescRespuesta=" + DescRespuesta + ", folio=" + folio + ", fecha=" + fecha + ", codMotivo=" + codMotivo + ", ordenFlete=" + ordenFlete + ", monto=" + monto + '}';
    }
}
