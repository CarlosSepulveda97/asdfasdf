/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.egt.apirest.entity;

/**
 *
 * @author ricardo.leal
 */
public class OrdenFlete {
   private int ofcodigo;
   private int codigoRespuestaJson; 
   private String descRespuestaJson;

    public int getOfcodigo() {
        return ofcodigo;
    }

    public void setOfcodigo(int ofcodigo) {
        this.ofcodigo = ofcodigo;
    }

    public int getCodigoRespuestaJson() {
        return codigoRespuestaJson;
    }

    public void setCodigoRespuestaJson(int codigoRespuestaJson) {
        this.codigoRespuestaJson = codigoRespuestaJson;
    }

    public String getDescRespuestaJson() {
        return descRespuestaJson;
    }

    public void setDescRespuestaJson(String descRespuestaJson) {
        this.descRespuestaJson = descRespuestaJson;
    }
   
    
}
