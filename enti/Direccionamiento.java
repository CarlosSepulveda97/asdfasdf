// 
// Decompiled by Procyon v0.5.36
// 

package cl.egt.apirest.entity;

import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity(name = "mv_direccionamiento_sorter")
public class Direccionamiento
{
    @Id
    @Column(name = "DISODESDE")
    private String direccionamientoDesde;
    @Column(name = "DISOHASTA")
    private String direccionamientoHasta;
    @Column(name = "DISOSORTER")
    private String salidaSorter;
    @Column(name = "DISOITL")
    private String salidaITL;
    @Column(name = "DISOACTUALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActualizacion;
    @Column(name = "DISOLINEA")
    private String lineaRegistro;
    @Column(name = "DISOTCARGADESDE")
    private int tipoCargaDesde;
    @Column(name = "DISOTCARGAHASTA")
    private int tipoCargaHasta;
    @Column(name = "DISOTSERVICIODESDE")
    private int tipoServicioDesde;
    @Column(name = "DISOTSERVICIOHASTA")
    private int tipoServicioHasta;
    @Column(name = "DISOAGENCIADESDE")
    private int agenciaDesde;
    @Column(name = "DISOAGENCIAHASTA")
    private int agenciaHasta;
    @Column(name = "DISOTENTREGADESDE")
    private int tipoEntregaDesde;
    @Column(name = "DISOTENTREGAHASTA")
    private int tipoEntregaHasta;
    
    public String getDireccionamientoDesde() {
        return this.direccionamientoDesde;
    }
    
    public String getDireccionamientoHasta() {
        return this.direccionamientoHasta;
    }
    
    public String getSalidaSorter() {
        return this.salidaSorter;
    }
    
    public String getSalidaITL() {
        return this.salidaITL;
    }
    
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public String getLineaRegistro() {
        return this.lineaRegistro;
    }
    
    public int getTipoCargaDesde() {
        return this.tipoCargaDesde;
    }
    
    public int getTipoCargaHasta() {
        return this.tipoCargaHasta;
    }
    
    public int getTipoServicioDesde() {
        return this.tipoServicioDesde;
    }
    
    public int getTipoServicioHasta() {
        return this.tipoServicioHasta;
    }
    
    public int getAgenciaDesde() {
        return this.agenciaDesde;
    }
    
    public int getAgenciaHasta() {
        return this.agenciaHasta;
    }
    
    public int getTipoEntregaDesde() {
        return this.tipoEntregaDesde;
    }
    
    public int getTipoEntregaHasta() {
        return this.tipoEntregaHasta;
    }
    
    public void setDireccionamientoDesde(String direccionamientoDesde) {
        this.direccionamientoDesde = direccionamientoDesde;
    }
    
    public void setDireccionamientoHasta(String direccionamientoHasta) {
        this.direccionamientoHasta = direccionamientoHasta;
    }
    
    public void setSalidaSorter(String salidaSorter) {
        this.salidaSorter = salidaSorter;
    }
    
    public void setSalidaITL(String salidaITL) {
        this.salidaITL = salidaITL;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    
    public void setLineaRegistro(String lineaRegistro) {
        this.lineaRegistro = lineaRegistro;
    }
    
    public void setTipoCargaDesde(int tipoCargaDesde) {
        this.tipoCargaDesde = tipoCargaDesde;
    }
    
    public void setTipoCargaHasta(int tipoCargaHasta) {
        this.tipoCargaHasta = tipoCargaHasta;
    }
    
    public void setTipoServicioDesde(int tipoServicioDesde) {
        this.tipoServicioDesde = tipoServicioDesde;
    }
    
    public void setTipoServicioHasta(int tipoServicioHasta) {
        this.tipoServicioHasta = tipoServicioHasta;
    }
    
    public void setAgenciaDesde(int agenciaDesde) {
        this.agenciaDesde = agenciaDesde;
    }
    
    public void setAgenciaHasta(int agenciaHasta) {
        this.agenciaHasta = agenciaHasta;
    }
    
    public void setTipoEntregaDesde(int tipoEntregaDesde) {
        this.tipoEntregaDesde = tipoEntregaDesde;
    }
    
    public void setTipoEntregaHasta(int tipoEntregaHasta) {
        this.tipoEntregaHasta = tipoEntregaHasta;
    }
}
