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
import javax.persistence.Table;

/**
 *
 * @author ricardo.leal
 */
@Entity(name = "mv_observacion_of")
@Table(name = "mv_observacion_of")
public class DireccionamientoSorter implements Serializable {

    @Id
    private Integer soexcodigo;
    private Integer usuacodigo;
    private Date soexfechahora;
    private String soexexcepcion;
    private String soexextension;
    private Integer soexactivo;
    private String soexcodigobarra;
    private String soexobservacion;
    private Integer soexisnoalterable;
    private Integer soexperiodovigencia;
    private String soexrangovigencia;

    public Integer getSoexcodigo() {
        return soexcodigo;
    }

    public void setSoexcodigo(Integer soexcodigo) {
        this.soexcodigo = soexcodigo;
    }

    public Integer getUsuacodigo() {
        return usuacodigo;
    }

    public void setUsuacodigo(Integer usuacodigo) {
        this.usuacodigo = usuacodigo;
    }

    public Date getSoexfechahora() {
        return soexfechahora;
    }

    public void setSoexfechahora(Date soexfechahora) {
        this.soexfechahora = soexfechahora;
    }

    public String getSoexexcepcion() {
        return soexexcepcion;
    }

    public void setSoexexcepcion(String soexexcepcion) {
        this.soexexcepcion = soexexcepcion;
    }

    public String getSoexextension() {
        return soexextension;
    }

    public void setSoexextension(String soexextension) {
        this.soexextension = soexextension;
    }

    public Integer getSoexactivo() {
        return soexactivo;
    }

    public void setSoexactivo(Integer soexactivo) {
        this.soexactivo = soexactivo;
    }

    public String getSoexcodigobarra() {
        return soexcodigobarra;
    }

    public void setSoexcodigobarra(String soexcodigobarra) {
        this.soexcodigobarra = soexcodigobarra;
    }

    public String getSoexobservacion() {
        return soexobservacion;
    }

    public void setSoexobservacion(String soexobservacion) {
        this.soexobservacion = soexobservacion;
    }

    public Integer getSoexisnoalterable() {
        return soexisnoalterable;
    }

    public void setSoexisnoalterable(Integer soexisnoalterable) {
        this.soexisnoalterable = soexisnoalterable;
    }

    public Integer getSoexperiodovigencia() {
        return soexperiodovigencia;
    }

    public void setSoexperiodovigencia(Integer soexperiodovigencia) {
        this.soexperiodovigencia = soexperiodovigencia;
    }

    public String getSoexrangovigencia() {
        return soexrangovigencia;
    }

    public void setSoexrangovigencia(String soexrangovigencia) {
        this.soexrangovigencia = soexrangovigencia;
    }
    
    
    
}
