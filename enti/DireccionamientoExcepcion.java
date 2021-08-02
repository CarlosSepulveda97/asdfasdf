/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ricardo.leal
 */
@Entity(name = "mv_sorter_excepcion")
public class DireccionamientoExcepcion implements Serializable {

    public static final String RANGO_PERIDO_DIARIO = "D";
    public static final String RANGO_PERIDO_SEMANAL = "S";
    public static final String RANGO_PERIDO_MENSUAL = "M";
    public static final String RANGO_PERIDO_ANUAL = "A";
    @Id
    private long codigo;
    private long codigoUsuario;
    private Date fechaHoraRegistro;
    private String excepcion;
    private int isActivo;
    private String extensionArchivo;
    private String codigoBarra;
    private String observacion;
    private int isNoAlterable;
    private int periodoVigencia;
    private String rangoVigencia;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Date getFechaHoraRegistro() {
        return fechaHoraRegistro;
    }

    public void setFechaHoraRegistro(Date fechaHoraRegistro) {
        this.fechaHoraRegistro = fechaHoraRegistro;
    }

    public String getExcepcion() {
        return excepcion;
    }

    public void setExcepcion(String excepcion) {
        this.excepcion = excepcion;
    }

    public int getIsActivo() {
        return isActivo;
    }

    public void setIsActivo(int isActivo) {
        this.isActivo = isActivo;
    }

    public String getExtensionArchivo() {
        return extensionArchivo;
    }

    public void setExtensionArchivo(String extensionArchivo) {
        this.extensionArchivo = extensionArchivo;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIsNoAlterable() {
        return isNoAlterable;
    }

    public void setIsNoAlterable(int isNoAlterable) {
        this.isNoAlterable = isNoAlterable;
    }

    public int getPeriodoVigencia() {
        return periodoVigencia;
    }

    public void setPeriodoVigencia(int periodoVigencia) {
        this.periodoVigencia = periodoVigencia;
    }

    public String getRangoVigencia() {
        return rangoVigencia;
    }

    public void setRangoVigencia(String rangoVigencia) {
        this.rangoVigencia = rangoVigencia;
    }

   
}
